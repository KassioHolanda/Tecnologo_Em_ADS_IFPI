from django import forms
from django.contrib import admin
from django.contrib.auth.models import Group
from django.core.exceptions import ValidationError
from django.core.urlresolvers import reverse
from django.utils.safestring import mark_safe
from core.models import SolicitacaoDiaria, Memorando
from user.models import User
from .forms import TutorAdminForm
from .models import Relatorio, Tutor, Viagem, Polo, Curso

from django.utils.translation import gettext_lazy as _

class RelatorioCreateForm(forms.ModelForm):

    def __init__(self, *args, **kwargs):
        super(RelatorioCreateForm, self).__init__(*args, **kwargs)

    class Meta:
        model = Relatorio
        fields = "__all__"


class ReadOnlyViagemHashField(forms.Field):

    def __init__(self, *args, **kwargs):
        kwargs.setdefault("required", False)
        super().__init__(*args, **kwargs)

    def bound_data(self, data, initial):
        # Always return initial because the widget doesn't
        # render an input field.
        return initial

    def has_changed(self, initial, data):
        return False


class RelatorioChangeForm(forms.ModelForm):
    viagem = forms.CharField(
        label=_('viagem'),
        widget=forms.TextInput(attrs={'readonly': 'readonly'})
    )

    class Meta:
        model = Relatorio
        fields = "__all__"

    def clean_viagem(self):
        return self.initial["viagem"]


# Register your models here.
@admin.register(Polo)
class PoloAdmin(admin.ModelAdmin):
    icon = '<i class="material-icons">home</i>'
    list_display = ('nome',)
    ordering = ['nome']
    fieldsets = (
        (None, {
            'fields': ('nome',)
        }),
    )


# Register your models here.
@admin.register(Curso)
class CursoAdmin(admin.ModelAdmin):
    icon = '<i class="material-icons">book</i>'
    list_display = ('nome',)
    fieldsets = (
        (None, {
            'fields': ('nome', 'image')
        }),
    )


@admin.register(Memorando)
class MemorandoAdmin(admin.ModelAdmin):
    icon = '<i class="material-icons">book</i>'
    list_display = ('numero', 'assunto', 'curso', 'memo')
    fieldsets = (
        (None, {
            'fields': ('numero', 'assunto', 'curso', 'texto', 'destinatario')
        }),
    )
    def get_number(self, obj):
        return obj.numero
    get_number.short_description = _('Numero')

    def get_queryset(self, request):
        qs = super(MemorandoAdmin, self).get_queryset(request)
        if not request.user.is_superuser:
            qs = qs.filter(curso=request.user.tutor.all()[0].curso)
        return qs

    def memo(self, memorando):
        # user = self.request.user
        # url_start = reverse('booking:booking-start', kwargs={'booking_id': booking.id})
        url_reactivate = reverse('board:memo', kwargs={'id': memorando.id})
        btn_start = '<a class="btn red white-text" href="%s" data-confirm="true">Memo</a>' % (url_reactivate,)

        # btn_reactivate = '<a href="%s">%s</a>' % (url_reactivate, _('Reactivate'))

        links = []
        links.append(btn_start)

        return mark_safe('<br />'.join(links))

    memo.short_description = 'MEMO'


@admin.register(Viagem)
class ViagemAdmin(admin.ModelAdmin):
    icon = '<i class="material-icons">train</i>'
    list_display = ('tutor', 'polo', 'ida', 'retorno',)
    change_form_template = 'core/change_viagem.html'
    ordering = ['-ida','-retorno']
    add_form_template = 'core/change_viagem.html'
    fieldsets = (
        (None, {
            'fields': ('tutor', 'is_ajuda', 'ida', 'retorno', 'origem', 'polo', 'diarias',)
        }),
    )

    def get_form(self, request, obj=None, **kwargs):
        form = super(ViagemAdmin, self).get_form(request, obj, **kwargs)
        if request.user.tutor.exists() == True:
            form.base_fields['origem'].initial = request.user.tutor.get().cidade
        return form

    def get_queryset(self, request):
        qs = super(ViagemAdmin, self).get_queryset(request)
        if not request.user.is_superuser:
            qs = qs.filter(tutor__user=request.user)
        return qs

    def formfield_for_foreignkey(self, db_field, request, **kwargs):
        if db_field.name == 'tutor':
            if not request.user.is_superuser:
                kwargs['queryset'] = Tutor.objects.filter(user=request.user)
        return super(ViagemAdmin, self).formfield_for_foreignkey(db_field, request, **kwargs)


@admin.register(Relatorio)
class RelatorioAdmin(admin.ModelAdmin):
    icon = '<i class="material-icons">folder</i>'
    list_display = ('tutor', 'get_links',)
    add_form = RelatorioCreateForm
    form = RelatorioCreateForm
    fieldsets = (
        (None, {
            'fields': (
                'viagem', 'dados_da_viagem', 'tipo', 'resultados', 'tipo_de_veiculo', 'transporte', 'nome_do_condutor',
                'placa', 'bilhete_ida',
                'bilhete_volta',
            )
        }),
    )

    def get_form(self, request, obj=None, **kwargs):
        if obj is not None:
            return RelatorioChangeForm
        return super(RelatorioAdmin, self).get_form(request, obj, **kwargs)

    def formfield_for_foreignkey(self, db_field, request, **kwargs):
        if db_field.name == 'viagem':
            qs = Viagem.objects.filter(tutor__user=request.user)
            kwargs['queryset'] = qs.filter(relatorio__isnull=True)
        return super(RelatorioAdmin, self).formfield_for_foreignkey(db_field, request, **kwargs)

    def get_queryset(self, request):
        qs = super(RelatorioAdmin, self).get_queryset(request)

        if not request.user.is_superuser:
            qs = qs.filter(viagem__tutor__user=request.user)

        return qs

    def tutor(self, relatorio):
        return "Nome do Tutor: " + relatorio.viagem.tutor.nome + "\n Destino:  " + relatorio.viagem.polo.__str__() + " Ida: " + relatorio.viagem.ida.__str__()

    def get_links(self, relatorio):
        url_reactivate = reverse('board:gerar-pdf', kwargs={'id': relatorio.id})
        btn_start = '<a class="btn red white-text" href="%s" data-confirm="true">PDF</a>' % (url_reactivate,)
        links = []
        links.append(btn_start)

        return mark_safe('<br />'.join(links))

    get_links.short_description = 'PDF'

    def save_model(self, request, obj, form, change):
        obj.save()
        obj.viagem.save()
        # obj.viagem.save()
        super(RelatorioAdmin, self).save_model(request, obj, form, change)


@admin.register(Tutor)
class TutorAdmin(admin.ModelAdmin):
    change_form_template = 'core/change_forms.html'
    icon = '<i class="material-icons">perm_identity</i>'
    search_fields = ['nome', ]
    ordering = ['nome']
    list_filter = ('polo', 'tipo')
    list_display = ('nome', 'polo', 'tipo',)
    form = TutorAdminForm

    fieldsets = (

        (None,
         {'fields': (
             'nome', 'telefone', 'cpf', ('email', 'image'), ('formacao', 'polo'), 'tipo', 'curso', 'gender', 'pais',
             ('rg', 'expedidor'),)}),
        (_('Endereço'), {'fields': ('cidade', 'estado', 'cep', 'bairro', 'logradouro', 'numero',)}),
        (_('Dados Bancarios'), {'fields': ('banco', ('agencia', 'conta'), 'tipo_conta',)}),
        (_('Conta'), {
            'fields': (('username', 'password'),)
        }
         ),
    )

    def change_view(self, request, object_id, form_url='', extra_context=None):
        return super(TutorAdmin, self).change_view(request, object_id)

    def get_queryset(self, request):
        qs = super(TutorAdmin, self).get_queryset(request)
        if not request.user.is_superuser:

            if request.user.tutor.all()[0].tipo == "CC":
                coordenador = request.user.tutor.all()[0]
                qs = qs.filter(curso=coordenador.curso)
            else:
                qs = qs.filter(user=request.user)

        return qs

    def save_model(self, request, tutor, form, change):
        username = form.cleaned_data['username']
        password = form.cleaned_data['password']

        if not hasattr(tutor, 'user'):

            try:
                user = User.objects.create_user(username=username, email=tutor.email,
                                                password=password)
                user.first_name = tutor.nome
                user.is_staff = True
                user.save()

                g = Group.objects.get(name="tutores")
                g.user_set.add(user)
                g.save()
                tutor.user = user
                tutor.save()


            except Exception as e:
                raise ValidationError(e)
        else:
            if len(password) > 0:
                tutor.user.set_password(password)
                tutor.user.save()
            else:
                password = tutor.user.password
                tutor.user.password = password
                tutor.user.save()
                tutor.save()


# admin.site.register(Tutor, TutorAdmin)


@admin.register(SolicitacaoDiaria)
class SolicitacaoDiariaAdmin(admin.ModelAdmin):
    icon = '<i class="material-icons">folder</i>'

    list_display = ('memorando', 'solicitacao_diaria')
    fieldsets = (
        (None, {
            'fields': ('memorando', 'justificativa', 'viagem',)
        }),
    )

    filter_horizontal = (_('viagem'),)

    def solicitacao_diaria(self, relatorio):
        # user = self.request.user
        # url_start = reverse('booking:booking-start', kwargs={'booking_id': booking.id})
        url_reactivate = reverse('board:diaria', kwargs={'id': relatorio.id})
        btn_start = '<a class="btn red white-text" href="%s" data-confirm="true">Diaria</a>' % (url_reactivate,)

        # btn_reactivate = '<a href="%s">%s</a>' % (url_reactivate, _('Reactivate'))

        links = []
        links.append(btn_start)

        return mark_safe('<br />'.join(links))

    solicitacao_diaria.short_description = 'SD'

    def formfield_for_manytomany(self, db_field, request, **kwargs):
        # Bahaviour for your field
        if not request.user.is_superuser:
            qs = Viagem.objects.filter(tutor__curso=request.user.tutor.all()[0].curso)
        else:
            qs = Viagem.objects.all()

        if db_field.name == 'viagem':
            if not request.user.is_superuser:
                qs = Viagem.objects.all().filter(solicitacoes__isnull=True)
            kwargs["queryset"] = qs
        # Default behaviour unchanged
        return super(SolicitacaoDiariaAdmin, self).formfield_for_manytomany(db_field, request, **kwargs)

    def save_model(self, request, obj, form, change):
        obj.save()
        super(SolicitacaoDiariaAdmin, self).save_model(request, obj, form, change)

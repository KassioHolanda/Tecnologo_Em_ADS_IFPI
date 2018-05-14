from django import forms
from django.contrib.auth.models import User
from django.core.exceptions import ValidationError
from django.utils.translation import ugettext_lazy as _

from .models import Tutor


class ColaboradorForm(forms.ModelForm):
    username = forms.CharField(label=_('Username'))
    password = forms.CharField(label=_('Senha'), widget=forms.PasswordInput)
    # telefone = forms.CharField(label=_('Telefone'))

    class Meta:
        model = Tutor
        fields = ('nome', 'telefone', 'cpf', 'email', 'formacao', 'polo', 'tipo', 'curso', 'gender', 'pais',
                  'rg', 'expedidor', 'cidade', 'estado', 'cep', 'bairro', 'logradouro', 'numero', 'banco', 'agencia',
                  'conta', 'tipo_conta',)


class TutorAdminForm(forms.ModelForm):
    username = forms.CharField(max_length=10, label=_('User'))
    password = forms.CharField(widget=forms.PasswordInput, max_length=10, label=_('Password'), required=False, )

    class Meta:
        model = Tutor
        fields = '__all__'

    def __init__(self, *args, **kwargs):
        super(TutorAdminForm, self).__init__(*args, **kwargs)

        if hasattr(self.instance, 'user'):
            self.fields['username'].initial = self.instance.user.username
            self.fields['username'].widget.attrs['readonly'] = True

        self.fields['password'].label = _('New password')

    def clean_username(self):
        username = self.cleaned_data['username']
        if not self.instance:
            if User.objects.filter(username=username).count() > 0:
                raise ValidationError(_('Username ja existe'))
        return username

from django import forms
from django.core.mail import send_mail

from config import settings
from vaga.models import Empresa, Vaga, AreaAtuacao


class RegisterCompanyForm(forms.ModelForm):
    class Meta:
        model = Empresa
        fields = '__all__'


class RegisterVacancyForm(forms.ModelForm):
    beneficios = forms.CharField(label='Beneficios', max_length=255,
                                 widget=forms.Textarea(attrs={'class': 'materialize-textarea'}),
                                 required=False)
    requisitos = forms.CharField(label='Requisitos', max_length=255,
                                 widget=forms.Textarea(attrs={'class': 'materialize-textarea'}),
                                 required=False)
    atividades = forms.CharField(label='Atividades', max_length=255,
                                 widget=forms.Textarea(attrs={'class': 'materialize-textarea'}),
                                 required=False)
    data_publicacao = forms.DateField(widget=forms.DateInput(attrs={'class': 'datepicker'}), required=False)

    class Meta:
        model = Vaga
        fields = '__all__'


class RegisterCourseForm(forms.ModelForm):
    nome = forms.CharField(max_length=200, widget=forms.TextInput(attrs={'class': 'materialize-textarea'}),
                           required=False)
    curso = forms.CharField(max_length=200, widget=forms.TextInput(attrs={'class': 'materialize-textarea'}),
                            required=False)

    class Meta:
        model = AreaAtuacao
        fields = '__all__'

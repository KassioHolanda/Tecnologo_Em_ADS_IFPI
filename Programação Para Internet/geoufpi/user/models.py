# -*- coding: utf-8 -*-
import re
from django.db import models
from django.contrib.auth.models import (AbstractBaseUser, PermissionsMixin, UserManager)
from django.core import validators
from django.utils.translation import ugettext_lazy as _



# Create your models here.
class User(AbstractBaseUser, PermissionsMixin):
    username = models.CharField(verbose_name=_('Nome do Usuário'), max_length=30, unique=True,
                                validators=[validators.RegexValidator(re.compile('^[\w.@+-]+$'),
                                                                      'O nome do usuario so pode conter letras, digitos ou os'
                                                                      'seguintes caracteres @/./+/-/_', 'invalid')])
    email = models.EmailField(_('E-mail'), unique=True)
    first_name = models.CharField(_('Nome'), max_length=100, blank=True)
    last_name = models.CharField('Nome', max_length=100, blank=True)
    is_active = models.BooleanField(_('Esta ativo'), blank=True, default=True)
    is_staff = models.BooleanField(_('E da equipe'), blank=True, default=True)
    date_joined = models.DateTimeField(_('Data de entrada'), auto_now_add=True)
    image = models.ImageField(
        upload_to='core/static/images', verbose_name='Imagem', null=False, blank=True
    )

    objects = UserManager()

    USERNAME_FIELD = 'username'
    REQUIRED_FIELDS = ['email']

    def __str__(self):
        return self.first_name or self.username

    def get_short_name(self):
        return self.username

    def get_full_name(self):
        return str(self)

    class Meta:
        verbose_name = _('Usuario')
        verbose_name_plural = _('Usuarios')

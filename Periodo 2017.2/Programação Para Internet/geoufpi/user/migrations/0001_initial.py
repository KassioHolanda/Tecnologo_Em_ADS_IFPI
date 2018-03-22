# -*- coding: utf-8 -*-
# Generated by Django 1.11 on 2017-11-26 00:59
from __future__ import unicode_literals

import django.contrib.auth.models
import django.core.validators
from django.db import migrations, models
import re


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('auth', '0008_alter_user_username_max_length'),
        ('core', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('password', models.CharField(max_length=128, verbose_name='password')),
                ('last_login', models.DateTimeField(blank=True, null=True, verbose_name='last login')),
                ('is_superuser', models.BooleanField(default=False, help_text='Designates that this user has all permissions without explicitly assigning them.', verbose_name='superuser status')),
                ('username', models.CharField(max_length=30, unique=True, validators=[django.core.validators.RegexValidator(re.compile('^[\\w.@+-]+$', 32), 'O nome do usuario so pode conter letras, digitos ou osseguintes caracteres @/./+/-/_', 'invalid')], verbose_name='Nome do Usuário')),
                ('email', models.EmailField(max_length=254, unique=True, verbose_name='E-mail')),
                ('first_name', models.CharField(blank=True, max_length=100, verbose_name='Nome')),
                ('last_name', models.CharField(blank=True, max_length=100, verbose_name='Nome')),
                ('is_active', models.BooleanField(default=True, verbose_name='Esta ativo')),
                ('is_staff', models.BooleanField(default=True, verbose_name='É da equipe')),
                ('date_joined', models.DateTimeField(auto_now_add=True, verbose_name='Data de entrada')),
                ('groups', models.ManyToManyField(blank=True, help_text='The groups this user belongs to. A user will get all permissions granted to each of their groups.', related_name='user_set', related_query_name='user', to='auth.Group', verbose_name='groups')),
                ('user_permissions', models.ManyToManyField(blank=True, help_text='Specific permissions for this user.', related_name='user_set', related_query_name='user', to='auth.Permission', verbose_name='user permissions')),
            ],
            options={
                'verbose_name': 'Usuário',
                'verbose_name_plural': 'Usuários',
            },
            managers=[
                ('objects', django.contrib.auth.models.UserManager()),
            ],
        ),
        migrations.CreateModel(
            name='SolicitacaoDiaria',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('ida', models.DateField(verbose_name='Data de Ida')),
                ('retorno', models.DateField(verbose_name='Data de retorno')),
                ('destino', models.CharField(max_length=25, verbose_name='Cidade de Destino')),
                ('diarias', models.CharField(max_length=3, validators=[django.core.validators.RegexValidator(re.compile('((0)|(1)|(2)|(3)|(4)){1}[.]((0)|(5))', 32), code='invalid', message='Informe a diaria no formato X,X exemplo: 1.5')])),
                ('viagens', models.ManyToManyField(to='core.Relatorio')),
            ],
        ),
    ]

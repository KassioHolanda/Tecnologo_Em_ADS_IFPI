# -*- coding: utf-8 -*-
# Generated by Django 1.11 on 2018-03-21 23:30
from __future__ import unicode_literals

import django.core.validators
from django.db import migrations, models
import re


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0025_auto_20180319_0859'),
    ]

    operations = [
        migrations.AlterField(
            model_name='memorando',
            name='destinatario',
            field=models.CharField(default='Diretoria do Centro de Educação Aberta e à Distância - CEAD/UFPI', max_length=80, verbose_name='Destinatario'),
        ),
        migrations.AlterField(
            model_name='memorando',
            name='numero',
            field=models.IntegerField(verbose_name='Numero'),
        ),
        migrations.AlterField(
            model_name='tutor',
            name='bairro',
            field=models.CharField(max_length=35, verbose_name='Bairro'),
        ),
        migrations.AlterField(
            model_name='tutor',
            name='cidade',
            field=models.CharField(max_length=35, verbose_name='Cidade'),
        ),
        migrations.AlterField(
            model_name='tutor',
            name='numero',
            field=models.CharField(max_length=35, verbose_name='Numero'),
        ),
        migrations.AlterField(
            model_name='tutor',
            name='pais',
            field=models.CharField(max_length=35, verbose_name='Pais'),
        ),
        migrations.AlterField(
            model_name='viagem',
            name='diarias',
            field=models.CharField(max_length=3, validators=[django.core.validators.RegexValidator(re.compile('((0)|(1)|(2)|(3)|(4)){1}[.]((0)|(5))', 32), code='invalid', message='Informe a diaria no formato X.X exemplo: 1.5')], verbose_name='Diarias'),
        ),
        migrations.AlterField(
            model_name='viagem',
            name='is_relatorio',
            field=models.BooleanField(default=False, verbose_name='È Relatorio'),
        ),
    ]

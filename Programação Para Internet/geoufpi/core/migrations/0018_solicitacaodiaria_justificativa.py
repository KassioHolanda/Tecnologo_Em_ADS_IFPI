# -*- coding: utf-8 -*-
# Generated by Django 1.11 on 2018-01-15 15:17
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0017_auto_20180114_2354'),
    ]

    operations = [
        migrations.AddField(
            model_name='solicitacaodiaria',
            name='justificativa',
            field=models.TextField(null=True, verbose_name='Justificativa'),
        ),
    ]

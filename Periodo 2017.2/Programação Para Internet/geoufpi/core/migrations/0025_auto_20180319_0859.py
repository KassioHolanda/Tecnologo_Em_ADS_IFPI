# -*- coding: utf-8 -*-
# Generated by Django 1.11 on 2018-03-19 11:59
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0024_auto_20180307_2257'),
    ]

    operations = [
        migrations.AlterField(
            model_name='viagem',
            name='is_ajuda',
            field=models.BooleanField(default=True, verbose_name='Ajuda com o transporte'),
        ),
    ]

# Generated by Django 2.0.4 on 2018-08-12 11:25

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0007_auto_20180810_1823'),
    ]

    operations = [
        migrations.AlterField(
            model_name='titulo',
            name='autor',
            field=models.CharField(max_length=255, verbose_name='Autor'),
        ),
    ]

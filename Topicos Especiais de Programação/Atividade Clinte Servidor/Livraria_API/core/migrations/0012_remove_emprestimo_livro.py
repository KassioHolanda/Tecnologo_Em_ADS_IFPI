# Generated by Django 2.0.4 on 2018-08-18 23:02

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0011_titulo_estoque'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='emprestimo',
            name='livro',
        ),
    ]

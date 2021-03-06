# Generated by Django 2.1 on 2018-08-10 14:40

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='Autor',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nome', models.CharField(max_length=255, verbose_name='Autor')),
                ('data_nascimento', models.DateField(blank=True, null=True, verbose_name='Data de Nascimento')),
            ],
        ),
        migrations.CreateModel(
            name='Categoria',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nome', models.CharField(max_length=255, verbose_name='Nome da Categoria')),
            ],
        ),
        migrations.CreateModel(
            name='Editora',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nome', models.CharField(max_length=255, verbose_name='Editora')),
            ],
        ),
        migrations.CreateModel(
            name='Emprestimo',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('quantidade_dias', models.IntegerField(default=1, verbose_name='Dias Emprestado')),
                ('data_emprestimo', models.DateField(auto_now_add=True, verbose_name='Data do Emprestimo')),
                ('data_devolucao', models.DateField(auto_now_add=True, verbose_name='Data da devolução')),
                ('devolvido', models.BooleanField(default=False, verbose_name='Emprestimo já devolvido ?')),
            ],
        ),
        migrations.CreateModel(
            name='Livro',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('numero', models.IntegerField(verbose_name='Número')),
                ('data_cadastro', models.DateField(auto_now_add=True, verbose_name='Data do Cadastro')),
            ],
        ),
        migrations.CreateModel(
            name='Reserva',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('data_reserva', models.DateField(auto_now_add=True, verbose_name='Data da Reserva')),
                ('ativa', models.BooleanField(default=False, verbose_name='Reserva Ativa ?')),
            ],
        ),
        migrations.CreateModel(
            name='Titulo',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nome', models.CharField(max_length=255, verbose_name='Nome')),
                ('descricao', models.CharField(max_length=255, verbose_name='Descrição')),
                ('isbn', models.CharField(max_length=255, verbose_name='ISBN')),
                ('preco_aluguel', models.DecimalField(decimal_places=2, max_digits=20, verbose_name='Preço do Aluguel')),
                ('estoque', models.IntegerField(default=0, verbose_name='Quantidade em Estoque')),
                ('data_cadastro', models.DateTimeField(auto_now_add=True, verbose_name='Data de Cadastro')),
                ('ano', models.IntegerField(verbose_name='Ano do Livro')),
                ('autor', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='core.Autor', verbose_name='Autor')),
                ('categoria', models.ForeignKey(max_length=255, on_delete=django.db.models.deletion.CASCADE, to='core.Categoria', verbose_name='Categoria')),
                ('editora', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='core.Editora', verbose_name='Editora')),
            ],
            options={
                'ordering': ('nome',),
            },
        ),
        migrations.AddField(
            model_name='reserva',
            name='titulo',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='reservas', to='core.Titulo', verbose_name='Título'),
        ),
        migrations.AddField(
            model_name='reserva',
            name='usuario',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='reservas', to=settings.AUTH_USER_MODEL, verbose_name='Usuário'),
        ),
        migrations.AddField(
            model_name='livro',
            name='titulo',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='core.Titulo', verbose_name='Título'),
        ),
        migrations.AddField(
            model_name='emprestimo',
            name='livro',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='emprestimos', to='core.Livro', verbose_name='Livro'),
        ),
        migrations.AddField(
            model_name='emprestimo',
            name='usuario',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='emprestimos', to=settings.AUTH_USER_MODEL, verbose_name='Usuário'),
        ),
    ]

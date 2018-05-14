import re

from django.contrib.auth import get_user_model
from django.core import validators
from django.db import models

from .utils import Extenso
from django.utils.translation import ugettext_lazy as _


# Create your models here.
User = get_user_model()


class Polo(models.Model):
    nome = models.CharField(verbose_name=_("Nome do Polo"), max_length=25)

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name =_('Polo')
        verbose_name_plural = _('Polos')


class Tutor(models.Model):
    MASCULINO, FEMININO = "M", "F"
    GENEROS = (
        (MASCULINO, _("Masculino")),
        (FEMININO, _("Feminino")),
    )
    TIPO = (
        ('T', 'Tutor'),
        ('CG', _('Coordenador Geral')),
        ('CC', _('Coordenador Curso')),
        ('CT', _('Coordenador de Tutoria')),
        ('CP', _('Coordenador de Polo')),
        ('PF', _('Professor Formador')),
        ('PC', _('Professor Conteudista')),
        ('AD', _('Assistente a Docencia')),
        ('O', _('Outros')),
    )
    FORMACAO = (
        ('D', _('Doutor')),
        ('M', _('Mestre')),
        ('E', _('Especialista')),
        ('O', _('Outros')),
    )
    TIPO_CONTA = (
        ('CC', _('Conta Corrente')),
        ('CP', _('Conta Poupança')),
    )
    UF_CHOICES = (
        ('AC', 'Acre'),
        ('AL', 'Alagoas'),
        ('AP', 'Amapá'),
        ('BA', 'Bahia'),
        ('CE', 'Ceará'),
        ('DF', 'Distrito Federal'),
        ('ES', 'Espírito Santo'),
        ('GO', 'Goiás'),
        ('MA', 'Maranão'),
        ('MG', 'Minas Gerais'),
        ('MS', 'Mato Grosso do Sul'),
        ('MT', 'Mato Grosso'),
        ('PA', 'Pará'),
        ('PB', 'Paraíba'),
        ('PE', 'Pernanbuco'),
        ('PI', 'Piauí'),
        ('PR', 'Paraná'),
        ('RJ', 'Rio de Janeiro'),
        ('RN', 'Rio Grande do Norte'),
        ('RO', 'Rondônia'),
        ('RR', 'Roraima'),
        ('RS', 'Rio Grande do Sul'),
        ('SC', 'Santa Catarina'),
        ('SE', 'Sergipe'),
        ('SP', 'São Paulo'),
        ('TO', 'Tocantins')
    )

    user = models.ForeignKey('user.User', verbose_name=_("usuario"),related_name="tutor")
    polo = models.ForeignKey('core.Polo', verbose_name=_("Polo"), related_name="tutor")
    curso = models.ForeignKey('core.Curso', verbose_name=_("Curso"), related_name="cursos", blank=False, null=True)
    nome = models.CharField(verbose_name=_("Nome Completo"), max_length=70, blank=False, null=True)
    pais = models.CharField(verbose_name=_('Pais'),blank=False, null=False, max_length=35)
    cidade = models.CharField(verbose_name=_('Cidade'),blank=False, null=False, max_length=35)
    bairro = models.CharField(verbose_name=_('Bairro'),blank=False, null=False, max_length=35)
    logradouro = models.CharField(blank=True, null=False, max_length=35)
    numero = models.CharField(verbose_name=_('Numero'),blank=False, null=False, max_length=35)
    cep = models.CharField(max_length=9, blank=False, validators=[
        validators.RegexValidator(re.compile(r"^\d{8}$|^\d{5}-\d{3}$"),
                                  message="Informe um cep valido no formato 88888888 ou 88888-888", code="invalid")])
    # estado = models.CharField(blank=False, null=False, max_length=35)
    gender = models.CharField(verbose_name="Genero", max_length=1, choices=GENEROS, blank=False, null=True)
    tipo = models.CharField(verbose_name=_("Tipo"), max_length=2, default="T", choices=TIPO, blank=False, null=True)
    formacao = models.CharField(verbose_name=_("Formacao"), max_length=2, default="O", choices=FORMACAO, blank=False,
                                null=True)
    estado = models.CharField(verbose_name=_("Estado"), max_length=2, choices=UF_CHOICES, blank=False, null=True)
    banco = models.CharField(verbose_name=_("Nome do Banco"), max_length=25)
    agencia = models.CharField(verbose_name=_("Agencia Bancaria"), max_length=12)
    conta = models.CharField(verbose_name=_("Numero da Conta"), max_length=12)
    rg = models.CharField(verbose_name="RG", max_length=15, blank=True, null=True)
    telefone = models.CharField(verbose_name=_("Telefone"), max_length=15, blank=True, null=True)
    expedidor = models.CharField(verbose_name=_("Orgao Expedidor"), max_length=15, blank=True, null=True)
    cpf = models.CharField(verbose_name="CPF", max_length=15)
    image = models.ImageField(
        upload_to='core/static/images', verbose_name=_('Imagem'), null=False, blank=True
    )
    email = models.EmailField('E-mail', blank=True, null=True)
    tipo_conta = models.CharField(verbose_name=_("Tipo de Conta"), max_length=2, choices=TIPO_CONTA, blank=False,
                                  null=True)

    def save(self, *args, **kwargs):
        self.full_clean()
        super(Tutor, self).save()
        user = self.user
        user.image = self.image
        self.nome = user.first_name
        user.save()

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name = _('Colaborador(a)')
        verbose_name_plural = _('Colaboradores')


class Viagem(models.Model):
    tutor = models.ForeignKey(Tutor, verbose_name=_("tutor"), related_name="relatorios")
    ida = models.DateField(verbose_name=_("Data de Ida"))
    retorno = models.DateField(verbose_name=_("Data de retorno"))
    origem = models.CharField(verbose_name=_("Cidade de Origem"), max_length=25)
    polo = models.ForeignKey('core.Polo', verbose_name=_("Cidade de Destino"), max_length=25)
    is_solicited = models.BooleanField(default=False)
    is_ajuda = models.BooleanField(default=True, verbose_name=_("Ajuda com o transporte"))
    is_relatorio = models.BooleanField(verbose_name=_('È Relatorio'),default=False)
    diarias = models.CharField(verbose_name=_('Diarias'),max_length=3, blank=False, validators=[
        validators.RegexValidator(re.compile(r"((0)|(1)|(2)|(3)|(4)){1}[.]((0)|(5))"),
                                  message="Informe a diaria no formato X.X exemplo: 1.5", code="invalid")])

    def __str__(self):
        return self.tutor.nome + " " + self.ida.__str__() + " " + self.retorno.__str__()

    @property
    def valor_total_str(self):
        self.valor_total
        reais, centavos = str(self.valor_total).split(".")
        if len(centavos) == 1:
            centavos = centavos + '0'
        return reais + ',' + centavos

    @property
    def ajuda_de_custo_extenso(self):
        ajuda = 95.0
        reais, centavos = str(ajuda).split(".")
        if len(centavos) == 1:
            centavos = centavos + '0'
        return Extenso(reais, centavos)

    @property
    def valor_total(self):
        valor_base = 177.00
        diarias = float(self.diarias)
        if self.is_ajuda == True:
            valor_total = diarias * valor_base
            valor_total = valor_total + 95
        else:
            valor_total = diarias * valor_base
        return valor_total

    @property
    def extenso(self):
        reais, centavos = str(self.valor_total).split(".")
        if len(centavos) == 1:
            centavos = centavos + '0'
        return Extenso(reais, centavos)

    def save(self, *args, **kwargs):
        self.full_clean()
        super(Viagem, self).save()

    class Meta:
        verbose_name = _('Viagem')
        verbose_name_plural = _('Viagens')


class Curso(models.Model):
    nome = models.CharField(verbose_name=_("Nome do Curso"), max_length=45)
    image = models.ImageField(
        upload_to='core/static/images', verbose_name=_('Imagem'), null=False, blank=False
    )

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name = _('Curso')
        verbose_name_plural = _('Cursos')


class Relatorio(models.Model):
    TIPO_DE_DIARIA = (
        ("N", _("Nacionais")),
        ("I", _("Internacionais")),
    )
    MEIO_DE_TRANSPORTE = (
        ("M", _("Moto")),
        ("C", _("Carro")),
        ("B", _("Onibus")),
        ("Z", _("Aviao")),
        ("O", _("Outros")),
    )
    TIPO_VEICULO = (
        ("O", _("Oficial")),
        ("L", _("Locado")),
        ("P", _("Proprio")),
        ("T", _("Outros")),
    )
    # viagem = models
    viagem = models.OneToOneField('core.Viagem', verbose_name=_("Viagem"), related_name="relatorio")
    dados_da_viagem = models.TextField(verbose_name=_("Dados da Viagem"))
    resultados = models.TextField(verbose_name=_("Resultados Alcançados"), )
    nome_do_condutor = models.CharField(verbose_name=_("Nome do condutor"), max_length=50, blank=True, null=True)
    placa = models.CharField(verbose_name=_("Placa do Veiculo"), max_length=8, blank=True, null=True)
    bilhete_ida = models.CharField(verbose_name=_("Bilhete de Ida"), max_length=20, blank=True, null=True)
    bilhete_volta = models.CharField(verbose_name="Bilhete de Volta", max_length=20, blank=True, null=True)
    tipo = models.CharField(verbose_name=_("Tipo de Diaria"), max_length=1, choices=TIPO_DE_DIARIA, blank=True, null=True)
    tipo_de_veiculo = models.CharField(verbose_name=_("Tipo de Veiculo"), max_length=1, choices=TIPO_VEICULO, blank=True,
                                       null=True)

    transporte = models.CharField(verbose_name=_("Meio de Transporte"), max_length=1, choices=MEIO_DE_TRANSPORTE,
                                  blank=True, null=True)

    def __str__(self):
        return self.viagem.__str__()

    @property
    def is_nacional(self):
        if self.tipo == "N":
            return True
        return False

    @property
    def is_internacional(self):
        if self.tipo == "I":
            return True
        return False

    @property
    def is_carro(self):
        if self.transporte == "C":
            return True
        return False

    @property
    def is_moto(self):
        if self.transporte == "M":
            return True
        return False

    @property
    def is_onibus(self):
        if self.transporte == "B":
            return True
        return False

    @property
    def is_aviao(self):
        if self.transporte == "Z":
            return True
        return False

    @property
    def is_oficial(self):
        if self.tipo_de_veiculo == "O":
            return True
        return False

    @property
    def is_proprio(self):
        if self.tipo_de_veiculo == "P":
            return True
        return False

    @property
    def is_outros(self):
        if self.tipo_de_veiculo == "T":
            return True
        return False

    @property
    def is_locado(self):
        if self.tipo_de_veiculo == "L":
            return True
        return False

    class Meta:
        verbose_name = _('Relatorio')
        verbose_name_plural = _('Relatorios')


class Memorando(models.Model):
    numero = models.IntegerField(verbose_name=_("Numero"))
    assunto = models.TextField(verbose_name=_("Assunto"))
    texto = models.TextField(verbose_name=_("Texto"))
    destinatario = models.CharField(verbose_name=_("Destinatario"),
                                    default=_("Diretoria do Centro de Educação Aberta e à Distância - CEAD/UFPI"),
                                    max_length=80)
    curso = models.ForeignKey(Curso, verbose_name=_("Curso"))

    @property
    def numero_str(self):
        if self.numero < 10:
            numero = "0" + str(self.numero)
            return numero
        else:
            return str(self.numero)

    def __str__(self):
        return str(self.numero) + " " + self.curso.__str__()

    class Meta:
        verbose_name = _('Memorando')
        verbose_name_plural = _('Memorandos')


class SolicitacaoDiaria(models.Model):
    memorando = models.ForeignKey(Memorando, verbose_name=_("Memorando"))
    justificativa = models.TextField(verbose_name=_("Justificativa"), null=True, blank=False)
    viagem = models.ManyToManyField('core.Viagem', related_name=_('solicitacoes'))

    @property
    def array(self):
        return self.viagem.all()

    @property
    def qtd_diarias(self):
        viagens = self.viagem.all()
        tamanho = len(viagens)
        qtd_diarias = 0
        for i in range(tamanho):
            qtd_diarias += float(viagens[i].diarias)
        return qtd_diarias

    @property
    def total(self):
        viagens = self.viagem.all()
        tamanho = len(viagens)
        valor = 0
        for i in range(tamanho):
            valor += viagens[i].valor_total
        reais, centavos = str(valor).split(".")
        if len(centavos) == 1:
            centavos = centavos + '0'
        return reais + ',' + centavos

    def __str__(self):
        return _("Memorando ") + self.memorando.__str__()

    class Meta:
        verbose_name = _('Solicitação de Diaria')
        verbose_name_plural = _('Solicitações de Diarias')

    def save(self, *args, **kwargs):
        super(SolicitacaoDiaria, self).save()

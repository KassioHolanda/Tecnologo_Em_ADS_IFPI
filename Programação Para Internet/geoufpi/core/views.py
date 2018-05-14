import datetime
from django.core.mail import EmailMessage
from django.contrib.auth.models import Group
from django.http import HttpResponse
from django.http import JsonResponse
from django.shortcuts import render, get_object_or_404, redirect
from django.template.loader import get_template
from django.views.generic import View

from core.forms import ColaboradorForm
from core.models import SolicitacaoDiaria, Curso, Memorando
from .models import Relatorio, User, Tutor
from .utils import render_to_pdf  # created in step 4


# Create your views here.

def index(request):
    template_name = 'index.html'
    context = {
        "cursos": Curso.objects.all(),

    }
    return render(request, template_name, context)


def load_tutor(request, id):
    tutor_id = request.GET.get("id")
    tutor = Tutor.objects.get(id=id)
    return JsonResponse({'cidade': tutor.cidade})


def detalhes(request, id):
    template_name = 'index.html'
    curso = get_object_or_404(Curso, id=id)

    context = {}
    context['curso'] = curso
    return render(request, template_name, context)


def Registre(request):
    template_name = "registre.html"
    if request.method == 'POST':
        form = ColaboradorForm(request.POST)

        if form.is_valid():
            user = User.objects.create(username=form['username'].value(), password=form['password'].value(),
                                       email=form['email'].value())
            user.is_staff = True
            user.set_password(form['password'].value())
            user.save()
            g = Group.objects.get(name="tutores")
            g.user_set.add(user)
            g.save()
            tutor = form.save(commit=False)
            tutor.user = user
            tutor.save()
            return redirect('admin:login')

    else:
        form = ColaboradorForm()
    context = {
        'form': form
    }
    return render(request, template_name, context)


def resetar_senha(request):
    email = EmailMessage('titulo','mensagem', to='destinatario')
    email.send()
    pass


class GeneratePdf(View):
    def get(self, request, id):
        template = get_template('relatorio_tutores.html')
        data_atual = datetime.datetime.now().date().strftime('%d/%m/%Y')
        relatorio = Relatorio.objects.get(pk=id)
        viagem = relatorio.viagem
        if viagem.ida >= datetime.date(2018, 3, 19):

            status = True
        else:
            status = False

        try:
            solicitacao = viagem.solicitacoes.all()[0]
            context = {
                "data": request.user,
                "tutor": request.user.tutor.get(),
                "relatorio": Relatorio.objects.get(pk=id),
                "data_atual": data_atual,
                "solicitacao": solicitacao,
                "status": status,

            }

        except IndexError:
            context = {
                "data": request.user,
                "tutor": request.user.tutor.get(),
                "relatorio": Relatorio.objects.get(pk=id),
                "data_atual": data_atual,
            }

        html = template.render(context)

        pdf = render_to_pdf('relatorio_tutores.html', context)
        if pdf:
            reponse = HttpResponse(pdf, content_type='application/pdf')
            filename = "relatorio_%s.pdf" % ("12341231")
            content = "inline; filename='%s'" % (filename)

            download = request.GET.get("download")
            if download:
                content = "attachement; filename='%s'" % (filename)
            reponse['Content-Disposition'] = content
            return reponse
        return HttpResponse("Not Found")


class GeneratePdfDiaria(View):
    def get(self, request, id):
        template = get_template('relatorio_diaria.html')

        context = {
            "viagem": SolicitacaoDiaria.objects.get(id=id).viagem.all().order_by("tutor__nome"),
            "solicitacao": SolicitacaoDiaria.objects.get(id=id),

        }
        html = template.render(context)

        pdf = render_to_pdf('relatorio_diaria.html', context)
        if pdf:
            reponse = HttpResponse(pdf, content_type='application/pdf')
            filename = "Diaria_%s.pdf" % ("12341231")
            content = "inline; filename='%s'" % (filename)

            download = request.GET.get("download")
            if download:
                content = "attachement; filename='%s'" % (filename)
            reponse['Content-Disposition'] = content
            return reponse
        return HttpResponse("Not Found")


class GeneratePdfMemo(View):
    def get(self, request, id):
        template = get_template('memo.html')
        data = datetime.datetime.now().date().strftime('%d/%m/%Y')

        mes_ext = {1: "Janeiro", 2: "Fevereiro", 3: "Março", 4: "Abril", 5: "Maio", 6: "Junho", 7: "Julho", 8: "Agosto",
                   9: "Setembro", 10: "Outubro", 11: "Novembro", 12: "Dezembro"}
        dia = data[:2]
        mes = data[3:5]
        ano = data[6:10]
        data_ext = " %s de %s de %s" % (dia, mes_ext[int(mes)], ano)

        context = {

            "memo": Memorando.objects.get(pk=id),
            "data": data_ext,

        }
        html = template.render(context)

        pdf = render_to_pdf('memo.html', context)
        if pdf:
            reponse = HttpResponse(pdf, content_type='application/pdf')
            filename = "Invoice_%s.pdf" % ("12341231")
            content = "inline; filename='%s'" % (filename)

            download = request.GET.get("download")
            if download:
                content = "attachement; filename='%s'" % (filename)
            reponse['Content-Disposition'] = content
            return reponse
        return HttpResponse("Not Found")

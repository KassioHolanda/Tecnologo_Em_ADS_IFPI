from rest_framework.routers import DefaultRouter

from .views import GeneratePdf, GeneratePdfDiaria, GeneratePdfMemo, load_tutor
from django.conf.urls import url
from django.conf.urls.static import static
from django.conf import settings

router = DefaultRouter()

urlpatterns = [

    url('^(?P<id>\d+)/pdf/$', GeneratePdf.as_view(), name='gerar-pdf'),
    url('^(?P<id>\d+)/pdf-diaria/$', GeneratePdfDiaria.as_view(), name='diaria'),
    url('^(?P<id>\d+)/memo/$', GeneratePdfMemo.as_view(), name='memo'),
    # url('^(?P<curso_id>\d+)/$', Index.as_view(), name='diaria'),


]
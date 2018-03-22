"""scrum URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf import settings
from django.conf.urls import url, include
from django.conf.urls.i18n import i18n_patterns
from django.conf.urls.static import static
from django.contrib import admin
from django.contrib.auth import views as auth_views
from django.utils.translation import gettext_lazy as _
from rest_framework.authtoken.views import obtain_auth_token

from core.urls import router
from core.views import index, detalhes, Registre
from core.views import load_tutor

admin.site.site_header = 'CEAD'
admin.site.site_title = 'CEAD'
# admin.site.index_title = _('Pan/el')

template = "templates/admin/login.html"

urlpatterns = i18n_patterns(
    url(r'^api/token/', obtain_auth_token, name='api-token'),
    url(r'admin/', admin.site.urls, name='admin'),
    url(r'^(?P<id>\d+)$', detalhes, name='index'),
    url(r'^$', index, name='index'),
    url(r'registre/', Registre, name='registrar'),
    url(r'^api/', include(router.urls)),
    url(r'board/', include('core.urls', namespace='board')),
    url(r'^admin/login/$', auth_views.login, {'template_name': template}, name='login'),
    url(r'^cidade/(?P<id>\d+)', load_tutor, name='cidade'),
    url(r'^password_reset/$', auth_views.password_reset, name='password_reset'),
    url(r'^password_reset/done/$', auth_views.password_reset_done, name='password_reset_done'),
    url(r'^reset/(?P<uidb64>[0-9A-Za-z_\-]+)/(?P<token>[0-9A-Za-z]{1,13}-[0-9A-Za-z]{1,20})/$',
        auth_views.password_reset_confirm, name='password_reset_confirm'),
    url(r'^reset/done/$', auth_views.password_reset_complete, name='password_reset_complete'),

) + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)

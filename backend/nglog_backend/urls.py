from django.conf.urls import url, include
from django.contrib import admin
from rest_framework.authtoken import views

urlpatterns = [
    # this means that for every url starting with "admin/",
    # django will find a corresponding view
    url(r'^admin/', admin.site.urls),
    url(r'^engine/', include('engine.urls')),
    url(r'^auth/', include('djoser.urls')),
    url(r'^auth/', include('djoser.urls.authtoken')),
    url(r'^api-token-auth/', views.obtain_auth_token),
]

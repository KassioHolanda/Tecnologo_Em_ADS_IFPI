from django.urls import path

from atividade import views

"""atividadeapi URL Configuration

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
from django.conf.urls import url
from django.contrib import admin

urlpatterns = [
    # path('admin/', admin.site.urls),

    path('', views.ApiRoot.as_view(), name=views.ApiRoot.name),
    # path('atividade/', views.PostList.as_view(), name=views.PostList.name),
    path('user/', views.UserList.as_view(), name=views.UserList.name),
    path('post/', views.PostList.as_view(), name=views.PostList.name),
    path('post/<int:pk>', views.PostDetail.as_view(), name=views.PostDetail.name),
    path('comment/', views.CommentList.as_view(), name=views.CommentList.name),
    path('comment/<int:pk>/', views.CommentDetail.as_view(), name=views.CommentDetail.name),
    path('address/', views.AdreesList.as_view(), name=views.AdreesList.name),
    path('address/<int:pk>/', views.AdreesDetail.as_view(), name=views.AdreesDetail.name),

    path('profile-posts/', views.ProfilePostsList.as_view(), name=views.ProfilePostsList.name),
    path('profile-posts/<int:pk:', views.ProfilePostsDetail.as_view(), name=views.ProfilePostsDetail.name),

    path('profiles/', views.UserPostList.as_view(), name=views.UserPostList.name),
    path('profiles/<int:pk>/', views.UserPostDetail.as_view(), name=views.UserPostDetail.name),

    path('profiles/<int:pk_user>/posts/', views.PostsOfUserList.as_view(), name='posts-list'),
    path('profiles/<int:pk_user>/posts/<int:pk_post>/', views.PostsOfUserDetail.as_view(), name='posts-detail'),

    path('profiles/<int:pk_user>/posts/<int:pk_post>/comments/', views.CommentsOfPostList.as_view(),
         name='comments-list'),
    path('profiles/<int:pk_user>/posts/<int:pk_post>/comments/<int:pk_comment>', views.CommentOfPostDetail.as_view(),
         name='comments-detail'),
    path('userdetail/', views.UserCountPostComment.as_view(), name=views.UserCountPostComment.name),

]

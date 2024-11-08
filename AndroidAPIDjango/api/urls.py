from django.urls import path
from .views import get_posts, create_post, post_detail

urlpatterns = [
    path("posts/", get_posts, name='get_posts'),
    path("posts/create", create_post, name='create_post'),
    path("posts/<int:pk>", post_detail, name='post_detail'),
]
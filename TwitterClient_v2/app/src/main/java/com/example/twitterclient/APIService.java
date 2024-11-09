package com.example.twitterclient;

import com.example.twitterclient.home_section.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/api/posts")
    Call<List<Post>> getPosts();
}
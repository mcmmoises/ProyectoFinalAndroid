package com.software.moisesc.proyfinalandroid.network;

import com.software.moisesc.proyfinalandroid.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("posts?user_id=1")
    Call<List<Post>> getPosts();
}

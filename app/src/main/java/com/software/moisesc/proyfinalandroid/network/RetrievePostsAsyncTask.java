package com.software.moisesc.proyfinalandroid.network;

import android.os.AsyncTask;

import com.software.moisesc.proyfinalandroid.PostFragment;
import com.software.moisesc.proyfinalandroid.model.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrievePostsAsyncTask extends AsyncTask<Void, Void, List<Post>> {
    private PostFragment fragment;

    public RetrievePostsAsyncTask(PostFragment postFragment) {
        this.fragment = postFragment;
    }

    @Override
    protected List<Post> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<List<Post>> call = service.getPosts();

        try {
            Response<List<Post>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<Post> posts) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(posts);
    }
}

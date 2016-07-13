package com.software.moisesc.proyfinalandroid.network;

import com.software.moisesc.proyfinalandroid.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("users.json")
    Call<List<User>> getUsers();
}

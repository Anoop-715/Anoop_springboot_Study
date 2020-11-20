package com.example.Anoop_Springboot_Study.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface UserService {

    @GET("posts/{id}")
    Call<User> getUser(@Path("id") int id);

    @GET("posts")
    Call<List<User>>getUsers();
}

package com.example.Anoop_Springboot_Study.retrofit;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubServiceGenerator {

    public static Object createService(int id){

    final String BASE_URL = "https://jsonplaceholder.typicode.com/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    UserService service = retrofit.create(UserService.class);

    Call<User> callSync = service.getUser(id);

         try {
             Response<User> response = callSync.execute();
             User apiResponse = response.body();
                  return apiResponse;
            } catch(Exception ex)
         {
             ex.printStackTrace();
         }
         return null;
    }
}

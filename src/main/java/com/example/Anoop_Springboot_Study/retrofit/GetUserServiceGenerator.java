package com.example.Anoop_Springboot_Study.retrofit;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class GetUserServiceGenerator {

    private final static String Base_url = "https://jsonplaceholder.typicode.com/";

    private static OkHttpClient.Builder httpclient = new OkHttpClient.Builder();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpclient.build())
            .build();

//    private static Retrofit.Builder builder
//            = new Retrofit.Builder()
//            .baseUrl(Base_url)
//            .addConverterFactory(GsonConverterFactory.create());
//
//    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}

package com.example.Anoop_Springboot_Study.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

@Service
public class RetrofitService {

    @Autowired
    GetUserServiceGenerator getUserServiceGenerator;

    public User getUserId(int id){

        UserService service = getUserServiceGenerator.createService(UserService.class);

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

    public List<User> getUsers(){

        UserService service = getUserServiceGenerator.createService(UserService.class);

        Call<List<User>> callSync =service.getUsers();

        try {
            Response<List<User>> response = callSync.execute();
            List<User> apiResponse = response.body();
            return apiResponse;
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;

    }
    
}

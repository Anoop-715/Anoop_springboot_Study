package com.example.Anoop_Springboot_Study.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetrofitController {

//    @Autowired
//    GitHubServiceGenerator gitHubServiceGenerator;

    @Autowired
    RetrofitService retrofitService;

    @GetMapping("users/{id}")
    public User getApiStudent(@PathVariable("id") int id){
        return retrofitService.getUserId(id);
    }

    @GetMapping("users")
    public List<User> getApiStudent(){
        return retrofitService.getUsers();
    }

}

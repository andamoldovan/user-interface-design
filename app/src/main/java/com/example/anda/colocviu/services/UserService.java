package com.example.anda.colocviu.services;

import com.example.anda.colocviu.model.Message;
import com.example.anda.colocviu.model.Messages;
import com.example.anda.colocviu.model.ReceivedUser;
import com.example.anda.colocviu.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {

    @POST("authenticate.php")
    @Headers("Content-Type: application/json")
    Call<ReceivedUser> logIn(@Body User user);

    @DELETE("logout.php")
    @Headers("content-Type: application/json")
    Call<Void> logOut(@Header("Authorization") String bearer);

    @PUT("sendmessage.php")
    @Headers("Content-Tyep: application/json")
    Call<Void> sendMessage(@Header("Authorization") String bearer, @Body Message message);

    @GET("readmessages.php")
    @Headers("Content-Type: application/json")
    Call<Messages> readMessages(@Header("Authorization") String bearer);
}

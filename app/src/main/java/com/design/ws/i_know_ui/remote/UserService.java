package com.design.ws.i_know_ui.remote;

import com.design.ws.i_know_ui.model.ResObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UserService {
    @GET("login")
    Call<ResObj> login(@Query("email") String email, @Query("password") String password);

//    @POST("/login/{email}/{password}")
//    Call<ResObj> login(@Path("email") String email, @Path("password") String password);
//    Response<List> login(@Path("username") String username, @Path("password") String password);
}


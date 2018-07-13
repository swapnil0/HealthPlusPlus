package com.design.ws.i_know_ui.remote;

public class ApiUtils {
    public static final String BASE_URL = "https://healthmy.000webhostapp.com/api/v1/";
//    public static final String BASE_URL = "http://10.0.2.2:80/hp1/api/v1/login/";
//    public static final String BASE_URL = "http://localhost/healthplusplus/api/v1/login/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
package com.design.ws.i_know_ui.remote;

import okhttp3.logging.HttpLoggingInterceptor;

public class RestClient {
    public void getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}

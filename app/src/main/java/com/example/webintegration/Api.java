package com.example.webintegration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/";

    @GET("posts.json")
    Call<Posts> getUsers();
}

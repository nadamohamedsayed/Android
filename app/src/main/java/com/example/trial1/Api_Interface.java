package com.example.trial1;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_Interface {
    @GET("posts/1")
    public Call<data> getpost();

    @POST("posts")
    public Call<data> storepost(@Body data data);

    @POST("posts")
    public Call<data> storepost(@Body HashMap<Object, Object> map);


}

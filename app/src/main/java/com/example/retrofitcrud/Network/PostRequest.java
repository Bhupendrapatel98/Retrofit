package com.example.retrofitcrud.Network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostRequest {

    @FormUrlEncoded
    @POST("RegisterAdmin.php")
    Call<JsonObject> register(@Field("username") String username, @Field("password") String password, @Field("email") String email);

}

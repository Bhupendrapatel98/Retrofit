package com.example.retrofitcrud.Network;

import com.example.retrofitcrud.model.RegisterModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostRequest {

    @FormUrlEncoded
    @POST("register")
    Call<RegisterModel> register(@Field("name") String name,
                                 @Field("username") String username,
                                 @Field("email") String email,
                                 @Field("password") String password,
                                 @Field("mobile") String mobile);

}

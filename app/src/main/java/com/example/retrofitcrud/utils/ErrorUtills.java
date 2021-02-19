package com.example.retrofitcrud.utils;

import com.example.retrofitcrud.Network.Constants;
import com.example.retrofitcrud.Network.RetrofitClint;
import com.example.retrofitcrud.model.Error;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtills {

    public static Error parseError(Response<?> response){

        Converter<ResponseBody,Error> converter = RetrofitClint.getRetrofit(Constants.BASE_URL)
                .responseBodyConverter(Error.class,new Annotation[0]);

        Error error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
           return new Error();
        }
        return error;
    }
}

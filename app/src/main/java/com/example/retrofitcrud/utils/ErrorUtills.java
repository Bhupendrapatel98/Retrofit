package com.example.retrofitcrud.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitcrud.Network.Constants;
import com.example.retrofitcrud.Network.RetrofitClint;
import com.example.retrofitcrud.model.Error;
import com.example.retrofitcrud.ui.MainActivity;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtills {

    private static final String TAG = "ErrorUtills";
   Context context;

    public ErrorUtills(Context context) {
        this.context = context;
    }

    public  Error parseError(Response<?> response){

        Converter<ResponseBody,Error> converter = RetrofitClint.getRetrofit(Constants.BASE_URL)
                .responseBodyConverter(Error.class,new Annotation[0]);

        Error error;

        try {
            error = converter.convert(response.errorBody());

            Log.d(TAG, "parseError: "+error);
            if (response.code()==400){
            if (error.getErrors().getName()!=null){
                Toast.makeText(context, error.getErrors().getName(), Toast.LENGTH_SHORT).show();
            }else  if (error.getErrors().getEmail()!=null){
                Toast.makeText(context, error.getErrors().getEmail(), Toast.LENGTH_SHORT).show();
            }else  if (error.getErrors().getMobile()!=null){
                Toast.makeText(context, error.getErrors().getMobile(), Toast.LENGTH_SHORT).show();
            }else  if (error.getErrors().getUsername()!=null){
                Toast.makeText(context, error.getErrors().getUsername(), Toast.LENGTH_SHORT).show();
            }else  if (error.getErrors().getPassword()!=null){
                Toast.makeText(context, error.getErrors().getPassword(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, error.getErrors().getMessage(), Toast.LENGTH_SHORT).show();
            }
           }
        } catch (IOException e) {
           return new Error();
        }
        return error;
    }
}

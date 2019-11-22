package com.example.retrofitcrud.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitcrud.Network.Constants;
import com.example.retrofitcrud.Network.PostRequest;
import com.example.retrofitcrud.Network.RetrofitClint;
import com.example.retrofitcrud.R;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button reg_btn;
    private EditText name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        reg_btn=findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                if (name.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                } else if (!email.getText().toString().matches(regex)) {
                    Toast.makeText(MainActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length() < 6) {
                    Toast.makeText(MainActivity.this, "Enter Password at least 6 charecter", Toast.LENGTH_SHORT).show();
                } else {
                    register();
                }

            }
        });
    }

    public void register(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(PostRequest.class)
                .register(name.getText().toString(),password.getText().toString(),email.getText().toString())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.i("dskjckbdc", "onResponse: "+response.toString());
                        Toast.makeText(MainActivity.this, "Data insert Sucessfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.i("dskjckbdc", "onResponse: "+t.toString());
                    }
                });
    }
}

package com.example.integratedagricultureapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("988b329bfa656fd142ab2c8ed635f6c4433254d2") // should correspond to APP_ID env variable
                .clientKey("8e1bb0530fe3b54c2e41483684dcb749db4de310")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://13.232.162.27:80/parse/")
                .build()
        ) ;
        if(ParseUser.getCurrentUser()!=null){
            Intent intent=new Intent(getApplicationContext(),menu.class);
            startActivity(intent);
        }
        else{
            Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
    }
}

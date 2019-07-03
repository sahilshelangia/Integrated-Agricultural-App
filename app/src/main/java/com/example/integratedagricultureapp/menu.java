package com.example.integratedagricultureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.parse.ParseUser;

public class menu extends AppCompatActivity {

    public void portal(View view){
        Intent intent=new Intent(getApplicationContext(),portal.class);
        startActivity(intent);
    }

    public void cropInfo(View view){
        Intent intent=new Intent(getApplicationContext(),CropInfo.class);
        startActivity(intent);
    }

    public void weatherInfo(View view){
        Intent intent=new Intent(getApplicationContext(),WeatherInfo.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout){
            ParseUser.logOut();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("menu");
    }
}

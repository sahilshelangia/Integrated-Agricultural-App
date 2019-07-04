package com.example.integratedagricultureapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText loginUsername,loginPassword;
    LinearLayout loginLayout;
    public void loginButton(View view){
        String username=loginUsername.getText().toString();
        String password=loginPassword.getText().toString();
        if(username.matches("")||password.matches("")){
            Toast.makeText(this,"All fields are required",Toast.LENGTH_LONG).show();
        }
        else{
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(e==null){
                        Toast.makeText(Login.this,"Login successful",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),menu.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

    }
    public void register(View view){
        Intent intent=new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        loginUsername=(EditText)findViewById(R.id.loginUsername);
        loginPassword=(EditText)findViewById(R.id.loginPassword);
        loginLayout=(LinearLayout) findViewById(R.id.loginLayout);
        loginLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}

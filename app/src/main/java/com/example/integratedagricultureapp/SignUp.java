package com.example.integratedagricultureapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    LinearLayout registerLayout;
    EditText username,name,email,password,cnfpassword;
    public void registerButton(View view){
        ParseUser user=new ParseUser();
        String Username="",Name="",Email="",Password="",CnfPassword="";
        Username=username.getText().toString();
        Name=name.getText().toString();
        Email=email.getText().toString();
        Password=password.getText().toString();
        CnfPassword=cnfpassword.getText().toString();
        if(Username.matches("")||Name.matches("")||Email.matches("")||Password.matches("")||CnfPassword.matches("")){
            Toast.makeText(this,"All fields are required",Toast.LENGTH_LONG).show();
        }
        else{
            if(Password.equals(CnfPassword)){
                user.setUsername(Username);
                user.setPassword(Password);
                user.setEmail(Email);
                user.put("name",Name);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            Toast.makeText(SignUp.this,"SignUp Successfull",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getApplicationContext(),menu.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SignUp.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
            else{
                Toast.makeText(this,"Password didn't match!",Toast.LENGTH_LONG).show();
            }
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("SignUp Form");
        name=(EditText)findViewById(R.id.registerName);
        username=(EditText)findViewById(R.id.registerUsername);
        email=(EditText)findViewById(R.id.registerEmail);
        password=(EditText)findViewById(R.id.registerPassword);
        cnfpassword=(EditText)findViewById(R.id.registerCpassword);
        registerLayout=(LinearLayout)findViewById(R.id.registerLayout);
        registerLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }

}

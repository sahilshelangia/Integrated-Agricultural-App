package com.example.integratedagricultureapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ask_question extends AppCompatActivity implements View.OnClickListener {

    LinearLayout askLayout;
    EditText question,cropName;
    public void submitQuestion(View view){
        String ques="",crpname="";
        ques=question.getText().toString();
        crpname=cropName.getText().toString();
        if(ques.matches("")||crpname.matches("")){
            Toast.makeText(this,"All fields are required!",Toast.LENGTH_LONG).show();
        }
        else{
            Log.i("message","submit question pressed");
            ParseObject quest=new ParseObject("Question");
            quest.put("cropName",crpname);
            quest.put("question",ques);
            quest.put("user",ParseUser.getCurrentUser().getUsername());
            quest.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        Toast.makeText(ask_question.this,"Submitted successfully",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),portal.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(ask_question.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
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
        setContentView(R.layout.activity_ask_question);
        setTitle("Ask your Question");
        askLayout=(LinearLayout)findViewById(R.id.askLayout);
        askLayout.setOnClickListener(this);
        cropName=(EditText)findViewById(R.id.cropName);
        question=(EditText)findViewById(R.id.question);
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}

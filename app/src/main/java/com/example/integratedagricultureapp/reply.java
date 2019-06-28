package com.example.integratedagricultureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class reply extends AppCompatActivity implements View.OnClickListener {

    TextView question;
    EditText answer;
    LinearLayout replyLayout;
    String quesId="";
    public void submitAnswer(View view){
        String ans=answer.getText().toString();
        if(ans.matches("")){
            Toast.makeText(this,"Answer can't be empty!",Toast.LENGTH_LONG).show();
        }
        else{
            ParseObject answ=new ParseObject("Answer");
            answ.put("questionId",quesId);
            answ.put("reply",answer.getText().toString());
            answ.put("user",ParseUser.getCurrentUser().getUsername());
            answ.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        Toast.makeText(reply.this,"Submitted successfully!",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),feed.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(reply.this,e.getMessage(),Toast.LENGTH_LONG).show();
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
        setContentView(R.layout.activity_reply);
        setTitle("Reply");
        question=(TextView)findViewById(R.id.question);
        answer=(EditText)findViewById(R.id.answer);
        replyLayout=(LinearLayout)findViewById(R.id.replyLayout);
        replyLayout.setOnClickListener(this);
        Intent intent=getIntent();
        question.setText(intent.getStringExtra("question"));
        quesId=intent.getStringExtra("questionId");
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}

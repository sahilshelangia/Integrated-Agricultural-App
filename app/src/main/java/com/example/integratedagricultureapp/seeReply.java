package com.example.integratedagricultureapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.ParseException;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class seeReply extends AppCompatActivity {

    TextView question;
    String questionId="";
    LinearLayout scroll;
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
        setContentView(R.layout.activity_see_reply);
        setTitle("All answers");
        question=(TextView)findViewById(R.id.question);
        scroll=(LinearLayout)findViewById(R.id.scroll);
        Intent intent=getIntent();
        question.setText(intent.getStringExtra("question"));
        questionId=intent.getStringExtra("questionId");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Answer");
        query.whereEqualTo("questionId", questionId);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    int len=objects.size();
                    for(int i=0;i<len;i++){
                        ParseObject reply=objects.get(i);
                        LinearLayout answer = new LinearLayout(seeReply.this);
                        answer.setPadding(50,50,50,50);
                        answer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        answer.setOrientation(LinearLayout.VERTICAL);
                        answer.setBackgroundColor(Color.parseColor("#e0d9d9"));
//                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) question.getLayoutParams();
//                        params.bottomMargin = 25;
                        LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT
                        );
                        paramsButton.setMargins(0, 0, 0, 10);
                        answer.setLayoutParams(paramsButton);

                        TextView textView = new TextView(seeReply.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setText("User: "+reply.getString("user"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        answer.addView(textView);

                        textView = new TextView(seeReply.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String s = formatter.format(reply.getCreatedAt());
                        textView.setText("Date: "+s);
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        answer.addView(textView);

                        textView = new TextView(seeReply.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setText("Answer:"+reply.getString("reply"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        answer.addView(textView);
                        scroll.addView(answer);
                    }
                } else {
                    Toast.makeText(seeReply.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

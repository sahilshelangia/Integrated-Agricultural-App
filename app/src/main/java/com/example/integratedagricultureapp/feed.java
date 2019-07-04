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
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

import java.util.List;

public class feed extends AppCompatActivity {

    ScrollView scrollView;
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
        setContentView(R.layout.activity_feed);
        setTitle("Feeds");
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        scroll=(LinearLayout)findViewById(R.id.scroll);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Question");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e){
                if (e == null) {
                    int len=objects.size();
                    for(int i=0;i<len;i++){
                        final ParseObject quest=objects.get(i);
                        LinearLayout question = new LinearLayout(feed.this);
                        question.setPadding(50,50,50,50);
                        question.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        question.setOrientation(LinearLayout.VERTICAL);
                        question.setBackgroundColor(Color.parseColor("#e0d9d9"));
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) question.getLayoutParams();
                        params.bottomMargin = 5;


                        TextView textView = new TextView(feed.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setText("User: "+quest.getString("user"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        question.addView(textView);

                        textView = new TextView(feed.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String s = formatter.format(quest.getCreatedAt());
                        Log.i("Date",s);

                        textView.setText("Date: "+s);
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        question.addView(textView);

                        textView = new TextView(feed.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setText("Crop: "+quest.getString("cropName"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        question.addView(textView);

                        textView = new TextView(feed.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setText(quest.getString("question"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        question.addView(textView);


                        //for adding two button as option i.e for reply or see answer

                        LinearLayout options = new LinearLayout(feed.this);
                        options.setPadding(5,5,5,5);
                        options.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        options.setOrientation(LinearLayout.HORIZONTAL);
                        options.setBackgroundColor(Color.parseColor("#e0d9d9"));

                        Button reply=new Button(feed.this);
                        reply.setText("Reply");
                        reply.setTextColor(Color.parseColor("#FFFFFF"));
                        reply.setBackgroundColor(Color.parseColor("#2f81b5"));
                        reply.setPadding(50,0,50,0);
                        LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        paramsButton.setMargins(0, 0, 10, 0);
                        reply.setLayoutParams(paramsButton);
                        reply.setOnClickListener(new View.OnClickListener() {
                            @Override public void onClick(View v) {
                                Intent intent=new Intent(getApplicationContext(),reply.class);
                                intent.putExtra("questionId",quest.getObjectId());
                                intent.putExtra("question",quest.getString("question"));
                                startActivity(intent);
                            }
                        });
                        options.addView(reply);

                        final Button seeAns=new Button(feed.this);
                        seeAns.setText("See Answers");
                        seeAns.setPadding(50,0,50,0);
                        seeAns.setTextColor(Color.parseColor("#FFFFFF"));
                        seeAns.setBackgroundColor(Color.parseColor("#2f81b5"));
                        seeAns.setOnClickListener(new View.OnClickListener() {
                              @Override public void onClick(View v) {
                                  Intent intent=new Intent(getApplicationContext(),seeReply.class);
                                  intent.putExtra("questionId",quest.getObjectId());
                                  intent.putExtra("question",quest.getString("question"));
                                  startActivity(intent);
                              }
                          });
                        options.addView(seeAns);
                        question.addView(options);
                        scroll.addView(question);
                    }
                } else {
                    Toast.makeText(feed.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

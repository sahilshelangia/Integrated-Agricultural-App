package com.example.integratedagricultureapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AllNews extends AppCompatActivity {

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
    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection;

            try {
                url = new URL(urls[0]);
                Log.i("URL", String.valueOf(url));
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();
                while (data != -1) {
                    char c = (char) data;
                    result += c;
                    data = reader.read();
                }
                Log.i("ResultGot", String.valueOf(result.length()));
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.i("Hai", "hello");
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("Hai2", "hello2");
                result += ']';
            }

            Log.i("ResultGot2",result);
            return result;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                //Delete all view of scroll
                if(scroll.getChildCount() > 0) scroll.removeAllViews();

                JSONArray arr = new JSONArray(result);

                for (int i = 0; i < arr.length(); ++i) {

                    JSONObject jsonObject = arr.getJSONObject(i);

                    //for each news
                    final LinearLayout mainBox = new LinearLayout(AllNews.this);
                    mainBox.setOrientation(LinearLayout.VERTICAL);
                    mainBox.setBackgroundColor(Color.parseColor("#ffffff"));
                    mainBox.setPadding(12,12,12,12);
                    mainBox.setTag(Integer.parseInt(jsonObject.getString("id")));
                    mainBox.setId(Integer.parseInt(jsonObject.getString("id")));
                    mainBox.setBackgroundColor(Color.parseColor("#e6ecf0"));
                    mainBox.setPadding(5,5,5,5);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(8,8,8,8);
                    mainBox.setLayoutParams(layoutParams);

                    //create TextView for Title
                    final TextView textView = new TextView(AllNews.this);
                    textView.setId((int) System.currentTimeMillis());
                    textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

//create TextView for Summary
                    final TextView textView2 = new TextView(AllNews.this);
                    textView2.setId((int) System.currentTimeMillis());
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                    if (jsonObject.getString("title") != null) {
                        textView.setText(jsonObject.getString("title"));
                        textView.setTextSize(23f);
                        textView.setTypeface(null, Typeface.BOLD);
                        textView.setTextColor(Color.parseColor("#000000"));
                        textView.setPaddingRelative(10,2,2,2);
                        mainBox.addView(textView);
                        textView.setId(Integer.parseInt(jsonObject.getString("id")));
                        textView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                textView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(getApplicationContext(),FullNews.class);
                                        String gett =  String.valueOf(textView.getId());
                                        if(gett==null||gett.isEmpty())
                                            gett = "1";
                                        intent.putExtra("id",gett);
                                        startActivity(intent);
                                        mainBox.setBackgroundColor(0xFFFFFF00);
                                    }
                                });
                                return false;
                            }
                        });
                    }


                    if (jsonObject.getString("summary") != null) {
                        textView2.setText(jsonObject.getString("summary"));
                        textView2.setTextSize(18f);
                        textView2.setPadding(1,1,1,1);
                        textView2.setTextColor(Color.parseColor("#424bf5"));
                        textView2.setPaddingRelative(10,2,2,2);
                        textView2.setTypeface(null, Typeface.ITALIC);
                        mainBox.addView(textView2);
                        textView2.setId(Integer.parseInt(jsonObject.getString("id")));
                        textView2.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                textView2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(getApplicationContext(),FullNews.class);
                                        String gett =  String.valueOf(textView2.getId());
                                        if(gett==null||gett.isEmpty())
                                            gett = "1";
                                        intent.putExtra("id",gett);
                                        startActivity(intent);
                                        mainBox.setBackgroundColor(0xFFFFFF00);
                                    }
                                });
                                return false;
                            }
                        });

                    }

                    //Add LinearLayout if some content present
                    if(mainBox.getChildCount() > 0) scroll.addView(mainBox);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_news);
        setTitle("Today's headlines");

        try {
            DownloadTask task = new DownloadTask();
            task.execute("http://192.168.33.197:8000/news/api/list-title-news/?format=json");
            scroll = findViewById(R.id.scroll);
            Log.i("Data", " Fetched!");

        } catch (Exception e) {
            Log.i("Data", " Not Fetched!");
            e.printStackTrace();
        }
    }
}

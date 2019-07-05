package com.example.integratedagricultureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class MandiPrice extends AppCompatActivity {

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
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();
                while (data != -1) {
                    char c = (char) data;
                    result += c;
                    data = reader.read();
                }

                //   Log.i("ResultGot",result);
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.i("Hai", "hello");
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("Hai2", "hello2");
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONArray list = new JSONArray(result);
                if(list!=null&&list.length()!=0){
//                list.length()
                    for (int i = 0; i < list.length(); i++) {
                    try {
                        JSONObject jsonObject = list.getJSONObject(i);
                        LinearLayout mainBox = new LinearLayout(MandiPrice.this);
                        mainBox.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        mainBox.setOrientation(LinearLayout.VERTICAL);
                        mainBox.setBackgroundColor(Color.parseColor("#2F8BD5"));
                        mainBox.setPadding(50, 25, 50, 25);
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mainBox.getLayoutParams();
                        params.bottomMargin = 5;

                        scroll.addView(mainBox);



                        //create five TextView and add them to the left box
                        TextView textView = new TextView(MandiPrice.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                        textView.setText("Market: "+jsonObject.getString("market"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#FFFFFF"));
                        mainBox.addView(textView);

                        textView = new TextView(MandiPrice.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                        textView.setText("Min Price: "+jsonObject.getString("minP"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#FFFFFF"));
                        mainBox.addView(textView);

                        textView = new TextView(MandiPrice.this);
                        textView.setId((int) System.currentTimeMillis());
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                        textView.setText("Max Price: "+jsonObject.getString("maxP"));
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                        textView.setTextColor(Color.parseColor("#FFFFFF"));
                        mainBox.addView(textView);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            else{
                Toast.makeText(MandiPrice.this,"No Market Available",Toast.LENGTH_LONG).show();
            }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandi_price);
        setTitle("Mandi Price");
        Intent intent = getIntent();
        String url = intent.getExtras().getString("url");
        Log.i("URL",url);
        scroll=(LinearLayout)findViewById(R.id.scroll);
        DownloadTask task = new DownloadTask();
        task.execute(url);
    }
}

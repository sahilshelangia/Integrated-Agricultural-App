package com.example.integratedagricultureapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;

public class CropDisease extends AppCompatActivity {

    public ArrayAdapter<String> listAdapter;
    TextView crop;
    String CropName="";

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_disease);
        setTitle("Diseases");
        Intent intent=getIntent();
        crop=(TextView)findViewById(R.id.crop_name);
        crop.setText(intent.getStringExtra("crop_name"));
        CropName=intent.getStringExtra("crop_name");


        final ListView itemList = (ListView)findViewById(R.id.disease);
        ArrayList<String> content=new ArrayList<String>();
        ParseQuery<ParseObject> query= ParseQuery.getQuery("CropInfo");
        query.whereEqualTo("crop_name",intent.getStringExtra("crop_name"));
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    ArrayList<String>content=new ArrayList<String>();
                    for(int i=0;i<objects.size();i++){
                        ParseObject crop=objects.get(i);
                        Log.i("crop_diseases",crop.getString("crop_diseases"));
                        content.add(crop.getString("crop_diseases"));
                    }

                    listAdapter = new ArrayAdapter<String>(CropDisease.this, android.R.layout.simple_list_item_1, android.R.id.text1, content);
                    itemList.setAdapter(listAdapter);
                }
            }
        });

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                makeText(getApplicationContext(), "Position " + position, LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),DiseaseDetail.class);
                String selectedFromList = (String)(itemList.getItemAtPosition(position));
                intent.putExtra("crop_name",CropName);
                intent.putExtra("disease_name",selectedFromList);
                startActivity(intent);
            }
        });


    }



}

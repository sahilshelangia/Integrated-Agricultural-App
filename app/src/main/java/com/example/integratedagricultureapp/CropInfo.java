package com.example.integratedagricultureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CropInfo extends AppCompatActivity {

    public EditText filterText;
    public ArrayAdapter<String> listAdapter;

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
        setContentView(R.layout.activity_crop_info);
        setTitle("Select Crop");

        filterText = (EditText)findViewById(R.id.editText);
        final ListView itemList = (ListView)findViewById(R.id.listView);

        ParseQuery<ParseObject> query=ParseQuery.getQuery("CropInfo");
        query.setLimit(2000);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    ArrayList<String>content=new ArrayList<String>();
                    Log.i("Object","successfully retreived");
                    for(int i=0;i<objects.size();i++){
                        ParseObject crop=objects.get(i);
                        Log.i("Crop_nmae",crop.getString("crop_name"));
                        content.add(crop.getString("crop_name"));
                    }
                    Set<String> set = new LinkedHashSet<>();
                    set.addAll(content);
                    content.clear();
                    content.addAll(set);
                    listAdapter = new ArrayAdapter<String>(CropInfo.this, android.R.layout.simple_list_item_1, android.R.id.text1, content);
                    itemList.setAdapter(listAdapter);
                }
            }
        });


        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),CropDisease.class);
                String selectedFromList = (String)(itemList.getItemAtPosition(position));
                intent.putExtra("crop_name",selectedFromList);
                startActivity(intent);
            }
        });

        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CropInfo.this.listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

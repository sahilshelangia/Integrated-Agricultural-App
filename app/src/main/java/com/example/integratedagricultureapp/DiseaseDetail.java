package com.example.integratedagricultureapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class DiseaseDetail extends AppCompatActivity {

    TextView disease,crop_cause,crop_symptom,biological_control,chemical_control,cultural_control;
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
        setContentView(R.layout.activity_disease_detail);
        setTitle("Disease detail");

        disease=(TextView)findViewById(R.id.disease_name);
        crop_cause=(TextView)findViewById(R.id.crop_cause);
        crop_symptom=(TextView)findViewById(R.id.crop_symptom);
        biological_control=(TextView)findViewById(R.id.biological_control);
        chemical_control=(TextView)findViewById(R.id.chemical_control);
        cultural_control=(TextView)findViewById(R.id.cultural_control);


        Intent intent=getIntent();
        String DiseaseName=intent.getStringExtra("disease_name");
        String CropName=intent.getStringExtra("crop_name");

        String dis="";
        boolean flag=false;
        for(int i=0;i<DiseaseName.length();i++){
            if(flag){
                dis+=DiseaseName.charAt(i);
            }
            if(DiseaseName.charAt(i)=='-') {
                flag = true;
            }
        }
        if(flag==false)
            dis=DiseaseName;
        disease.setText(dis);

        ParseQuery<ParseObject> query=ParseQuery.getQuery("CropInfo");
        query.whereEqualTo("crop_name",CropName);
        query.whereEqualTo("crop_diseases",DiseaseName);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    for(int i=0;i<objects.size();i++){
                        ParseObject crop=objects.get(i);
                        crop_cause.setText(crop.getString("crop_causes"));
                        crop_symptom.setText(crop.getString("crop_symptom"));
                        biological_control.setText(crop.getString("biological_control"));
                        chemical_control.setText(crop.getString("chemical_control"));
                        cultural_control.setText(crop.getString("cultural_control"));
                    }
                }
            }
        });
    }
}

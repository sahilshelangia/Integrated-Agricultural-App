package com.example.integratedagricultureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NearByAgriStore extends FragmentActivity implements OnMapReadyCallback {

    boolean flag=true;
    LatLng userLocation;
    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;
    Button agriStore;
    Button mandi;

    public class DownloadTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {

            String result="";
            URL url;
            HttpURLConnection urlConnection=null;

            try {
                url=new URL(strings[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();
                while (data!=-1){
                    char curr=(char)data;
                    result+=curr;
                    data=reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject=new JSONObject(s);
                JSONArray result=jsonObject.getJSONArray("results");
                mMap.clear();
                for(int i=0;i<result.length();i++){
                    JSONObject info=result.getJSONObject(i);
                    String lat=Double.toString(info.getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
                    String lng=Double.toString(info.getJSONObject("geometry").getJSONObject("location").getDouble("lng"));


                    Log.i("iteration: ",lat+" "+lng);
                    String name=info.getString("name");
                    Log.i("Name: ",name);

                    LatLng userLocation = new LatLng(info.getJSONObject("geometry").getJSONObject("location").getDouble("lat"),info.getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
                    mMap.addMarker(new MarkerOptions().position(userLocation).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,12));

                    String vicinity=info.getString("vicinity");
                    Log.i("Vicinity:",vicinity);

                    String rating=Integer.toString(info.getInt("rating"));
                    Log.i("Rating:",rating);

                }
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Current Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,12));
//                Log.i("results:",result.toString());


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public void mandi(View view){
        mandi.setBackgroundColor(Color.rgb(229,111,20));
        agriStore.setBackgroundColor(Color.rgb(28,121,194));
        String api="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=26.2183,78.1828&radius=50000&type=schools&keyword=schools&key=AIzaSyBKmNC5odM4_fN_10x-tgDRAVzmWmkQ-D8";
        DownloadTask task=new DownloadTask();
        task.execute(api);
    }

    public void agriStore(View view){
        mandi.setBackgroundColor(Color.rgb(28,121,194));
        agriStore.setBackgroundColor(Color.rgb(229,111,20));
        Log.i("Button tapp","YES");
        String api="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=26.2183,78.1828&radius=50000&type=seed&keyword=seed&key=AIzaSyBKmNC5odM4_fN_10x-tgDRAVzmWmkQ-D8";
        DownloadTask task=new DownloadTask();
        task.execute(api);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Log.i("ready","permission granted call location update");
            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER , 0, 0, locationListener);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_agri_store);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mandi=(Button)findViewById(R.id.mandi);
        agriStore=(Button)findViewById(R.id.agriStore);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        locationManager=(LocationManager)this.getSystemService(LOCATION_SERVICE);
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
//                Log.i("Location",location.toString());
//
                Log.i("ready","on location change called");
                userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                if(flag){
                    Log.i("sahil","-==============");
                    mMap.addMarker(new MarkerOptions().position(userLocation).title("Current Location"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,12));
                }
                flag=false;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            // ask for the permission
            Log.i("ready","request permission");
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else{
            Log.i("ready","already have permission");

            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER ,0,0,locationListener);
            Location lastKnownLocation=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


            LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLatitude());
//            LatLng userLocation = new LatLng(26.218287, 78.182831);

            mMap.addMarker(new MarkerOptions().position(userLocation).title("Current Location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,12));
        }
        // Add a marker in Sydney and move the camera
//
    }
}

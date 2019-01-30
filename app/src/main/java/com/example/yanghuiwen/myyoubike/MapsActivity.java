package com.example.yanghuiwen.myyoubike;

import android.os.Bundle;
import android.util.Log;

import com.example.yanghuiwen.myyoubike.model.StationResponse;
import com.example.yanghuiwen.myyoubike.model.StationResponse.Station;
import com.example.yanghuiwen.myyoubike.util.Jsonutil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import androidx.fragment.app.FragmentActivity;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Jsonutil bike_json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null)
            mapFragment.getMapAsync(this);
        bike_json=new Jsonutil();

        Log.d("test","我進去了onCreate");
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
        LatLng sydney=null;
        String jsonStr = bike_json.loadJSONFromAsset(getAssets(),"T_bike.json");
        Gson gson = new Gson();
        StationResponse station = gson.fromJson(jsonStr ,StationResponse .class);
        Map<String, Station> stations=station.getRetVal();
        Log.i("test","obj sna:" + stations.get("2001").getSna());

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
//
////        }
        Log.d("test","我進去了onMapReady");
        try {

             JSONObject all_bike_detail = bike_json.getData_JSONArray(bike_json.loadJSONFromAsset(getAssets(),"T_bike.json"));
            Log.d("test","all_bike_detail="+ all_bike_detail);
            for (int i = 2001; i < 2010; i++) {
                JSONObject bike_detail = all_bike_detail.getJSONObject(i+"");
                sydney = new LatLng(Double.valueOf(bike_detail.getString("lat")), Double.valueOf(bike_detail.getString("lng")));
                //Log.i("test","lat="+bike_detail.getString("lat"));
               // Log.i("test","lng="+bike_detail.getString("lng"));
                mMap.addMarker(new MarkerOptions().position(sydney).title(bike_detail.getString("sna")));
            }
        }catch (JSONException e){
            e.printStackTrace();
            Log.d("test","我進去了JSONException");
        }
        // Add a marker in Sydney and move the camera


       mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



}

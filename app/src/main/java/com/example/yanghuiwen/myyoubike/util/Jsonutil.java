package com.example.yanghuiwen.myyoubike.util;

import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Jsonutil {

    public  String loadJSONFromAsset(AssetManager assetManager,String jsonFileName) {
        String json ;
        try {
            InputStream is=null;
            is = assetManager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public JSONObject getData_JSONArray(String response) {
        JSONObject all_bike_detail=null;
        try {
            JSONObject jsonObject = new JSONObject(response);
            all_bike_detail = jsonObject.getJSONObject("retVal");



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return all_bike_detail;
    }

}

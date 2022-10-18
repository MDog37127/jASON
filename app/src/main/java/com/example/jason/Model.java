package com.example.jason;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    static boolean oof = false;
    public static final Map<String, GameCompany> modelMap = new HashMap<>();
    public static final List<GameCompany> modelList = new ArrayList<>();

    public void someThing(Activity ha) {
        String url = ha.getString(R.string.URLME);  // THAT should be in a strings.xml file!

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(ha);

        // Request a string response from the provided URL.
        JsonObjectRequest JSONRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject object = response.getJSONObject("record");
                            JSONArray jasonArray = object.getJSONArray("users");

                            modelList.clear();
                            modelMap.clear();
                            for (int i = 0; i < jasonArray.length(); i++) {
                                JSONObject company = jasonArray.getJSONObject(i);

                                String name = company.getString("name");
                                String year = company.getString("main");
                                String console = company.getString("description");

                                GameCompany gameCompany = new GameCompany(name, year, console);

                                modelList.add(gameCompany);
                                modelMap.put(name, gameCompany);
                            }
                            if(!oof)
                            {
                                ha.recreate();
                            }
                            oof = true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

                // Add the request to the RequestQueue.
                queue.add(JSONRequest);
    }
}

package com.nglog.nglog_android;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class TestActivity extends AppCompatActivity {

    private String login_url = "http://127.0.0.1:8000/auth/login/";
    static RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(this);
    }

    private void attemptLogin(String username, String password){

        int method = Request.Method.POST;
        StringRequest request = new StringRequest(method, login_url,

                // response listener implementation
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        //get json, get auth token, get string put it in activity
                        // if possible check that
                        // parse as json object
                        // get token (key is "auth_token")
                        // put it in intent and start next activity
                    }
                },

                // error listener implmentation
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "please try again", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // put username and password in the request
        // enqueue request
        queue.add(request);
    }

}
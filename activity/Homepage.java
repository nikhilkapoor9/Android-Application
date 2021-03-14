package com.example.form.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.form.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Homepage extends AppCompatActivity {

    TextView tv;
    String stemail;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        tv=findViewById(R.id.welcomeview);
        stemail=getIntent().getExtras().getString("useremail");
        tv.setText(stemail);



    }

    public void fetchApiAttendence(View view){
        Log.i("home page activity","now fetching api data");

        requestQueue=Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i("api data",response.getString("title"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("api data fetched"," something went wrong");

            }
        });
        requestQueue.add(jsonObjectRequest);


    }

    public void Logout(View view){
         startActivity(new Intent(Homepage.this, MainActivity.class));
         this.finish();
    }
}

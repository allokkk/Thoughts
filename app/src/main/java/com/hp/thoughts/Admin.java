package com.hp.thoughts;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Admin extends AppCompatActivity {
    EditText thoughts;
    Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        send = findViewById(R.id.send);
        send.setText("send");
        thoughts = findViewById(R.id.thought);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thoughts.getText().toString().isEmpty()) {
                    Toast.makeText(Admin.this, "please write thoughts", Toast.LENGTH_SHORT).show();
                } else {
                    datasend();
                }
            }

            private void datasend() {
                String url = "http://searchkero.com/ankita9/insert.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Admin.this,"secess",Toast.LENGTH_SHORT).show();
                        thoughts.setText("");


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> map=new HashMap<>();
                        map.put("thoughts",thoughts.getText().toString());

                        return map;


                    }
                };


                RequestQueue requestQueue = Volley.newRequestQueue(Admin.this);
                requestQueue.add(stringRequest);
            }

        });
    }
}



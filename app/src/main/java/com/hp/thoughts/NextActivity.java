package com.hp.thoughts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NextActivity extends AppCompatActivity {
    EditText name,password;
    Button login;

    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( name.getText().toString().equals("alok")&&
                        password.getText().toString().equals("password")){
                    Intent j =new Intent(NextActivity.this,Admin.class);
                    startActivity(j);
                }


            }


        });

    }
}

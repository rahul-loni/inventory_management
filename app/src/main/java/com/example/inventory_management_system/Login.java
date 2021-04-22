package com.example.inventory_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Login extends AppCompatActivity {

    Button btnlogin;
    TextView txtregister;
    TextView txtforgate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin=(Button)findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent=new Intent(Login.this,Home.class);
                startActivity(loginintent);
            }
        });

        txtregister=(TextView)findViewById(R.id.register);
        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent=new Intent(Login.this,Signup.class);
                startActivity(registerintent);

            }
        });
        txtforgate=(TextView)findViewById(R.id.forgotpassword);
        txtforgate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgateintent=new Intent(Login.this,Forgot.class);
                startActivity(forgateintent);
            }
        });


    }
}
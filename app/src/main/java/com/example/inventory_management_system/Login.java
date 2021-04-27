package com.example.inventory_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Login extends AppCompatActivity {

    Button btnlogin;
    TextView txtregister;
    TextView txtforgate;
    private EditText txt_Email,txt_Password;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_Email=(EditText)findViewById(R.id.email);
        txt_Password=(EditText)findViewById(R.id.password);


        auth=FirebaseAuth.getInstance();




        btnlogin=(Button)findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txt_Email.getText().toString().trim();
                String password=txt_Password.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),Home.class));
                                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();


                                }else {
                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }

                            }

                        });

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
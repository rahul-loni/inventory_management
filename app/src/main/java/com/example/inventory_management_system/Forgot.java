package com.example.inventory_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot extends AppCompatActivity {
    private EditText Email_txt;
    private Button send_email;

    private FirebaseAuth auth;
    private String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        Email_txt=(EditText)findViewById(R.id.txtEmailforgot);
        send_email=(Button)findViewById(R.id.btn_send_email);


        auth=FirebaseAuth.getInstance();

        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatedata();

            }
        });

    }

    private void validatedata() {
         email=Email_txt.getText().toString();
        if (email.isEmpty()){
            Email_txt.setError("Required");

        }else {
            forgetPass();
        }

    }

    private void forgetPass() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Forgot.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Forgot.this,Login.class));
                            finish();

                        }
                        else {
                            Toast.makeText(Forgot.this,
                                    "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
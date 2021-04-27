package com.example.inventory_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Signup extends AppCompatActivity {
    EditText txt_email,txt_password,txt_confirmpassword;
    Button btn_reg;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        txt_password=(EditText)findViewById(R.id.password);
        txt_email=(EditText)findViewById(R.id.email);
        txt_confirmpassword=(EditText)findViewById(R.id.confirmpassword);

        btn_reg=(Button)findViewById(R.id.regbtn);

        firebaseAuth=FirebaseAuth.getInstance();

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=txt_email.getText().toString().trim();
                String password=txt_password.getText().toString().trim();
                String conpassword=txt_confirmpassword.getText().toString().trim();
                
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(conpassword)){
                    Toast.makeText(Signup.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(Signup.this, "Password to short", Toast.LENGTH_SHORT).show();

                }
                if (password.equals(conpassword)){

                    firebaseAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        startActivity(new Intent(getApplicationContext(),Home.class));
                                        Toast.makeText(Signup.this, "Successful", Toast.LENGTH_SHORT).show();


                                    }else {
                                        Toast.makeText(Signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });


                }


            }
        });





    }
}
package com.example.inventory_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=(TextView)findViewById(R.id.text1);
        textView.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.pluse));

        button=(Button)findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.fead);
                button.startAnimation(animation);
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);

            }
        });



    }
}
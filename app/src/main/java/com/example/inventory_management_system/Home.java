package com.example.inventory_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button add_item,edit_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        add_item=(Button)findViewById(R.id.additem);
        edit_item=(Button)findViewById(R.id.edit);

        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_item_intent=new Intent(Home.this,Add_Item.class);
                startActivity(add_item_intent);
            }
        });

        edit_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_item_intent=new Intent(Home.this,Edit_Item.class);
                startActivity(add_item_intent);

            }
        });
    }
}
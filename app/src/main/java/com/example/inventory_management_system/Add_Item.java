package com.example.inventory_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Item extends AppCompatActivity {
    private EditText product_Name,product_Category,product_Price;
    private Button btn_sconBarCode,btn_Add;
    private TextView itembarcode;
    public static TextView resulttextview;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    DatabaseReference databaseReferencecat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);

        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReferencecat = FirebaseDatabase.getInstance().getReference("Users");

        product_Name=(EditText)findViewById(R.id.edit_name);
        product_Category=(EditText)findViewById(R.id.edit_category);
        product_Price=(EditText)findViewById(R.id.edit_price);

        btn_Add=(Button)findViewById(R.id.add_itembuttontodatabase);
        btn_sconBarCode=(Button)findViewById(R.id.button_scan);
        itembarcode= findViewById(R.id.bar_codeview);
        resulttextview = findViewById(R.id.bar_codeview);

        btn_sconBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ScanCodeActivity.class));
            }
        });
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additem();
            }
        });

    }

    private void additem() {
        String itemnameValue=product_Name.getText().toString();
        String itemcategoryValue=product_Category.getText().toString();
        String itempriceValue=product_Price.getText().toString();
        String itembarcodeValue=itembarcode.getText().toString();
        final FirebaseUser users=firebaseAuth.getCurrentUser();
        String finaluser=users.getEmail();
        String resultemail=finaluser.replace("","");

        if (itembarcodeValue.isEmpty()){
            itembarcode.setError("its Empty");
            itembarcode.requestFocus();
            return;

        }
        if (!TextUtils.isEmpty(itemnameValue)&&!TextUtils.isEmpty(itemcategoryValue)&&
        !TextUtils.isEmpty(itempriceValue)){
            Items items=new Items(itemnameValue,itemcategoryValue,itempriceValue,itembarcodeValue);
            databaseReference.child(resultemail).child("Items").child(itembarcodeValue).setValue(items);
            databaseReference.child(resultemail).child("ItemByCategory").child(itembarcodeValue).
                    setValue(items);
            product_Name.setText("");
            itembarcode.setText("");
            product_Price.setText("");
            itembarcode.setText("");
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
            
            
        }
        else {
            Toast.makeText(Add_Item.this,"Please Fill all the fields",Toast.LENGTH_SHORT).show();
        }

    }
}
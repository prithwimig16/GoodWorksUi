package com.admob.goodworksui;

import androidx.appcompat.app.AppCompatActivity;


import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

  CardView cardView;
  EditText etId,etName;
  String id="";
  String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = (CardView)findViewById(R.id.card);
        Button ID = (Button) findViewById(R.id.bt_ok);
        etId = (EditText)findViewById(R.id.et_id);
        etName = (EditText)findViewById(R.id.et_name);



        ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                id = etId.getText().toString();
                if(TextUtils.isEmpty(id)){
                    Toast.makeText(getApplicationContext(), "Please Enter Id",  Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(getApplicationContext(), "Please Enter name!",  Toast.LENGTH_SHORT).show();
                    return;
                }
                cardView.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                OneFragment fragOne = new OneFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                bundle.putString("name", name);
                fragOne.setArguments(bundle);
                fragmentTransaction.add(R.id.container, fragOne);
                fragmentTransaction.commit();
            }
        });

        }



}


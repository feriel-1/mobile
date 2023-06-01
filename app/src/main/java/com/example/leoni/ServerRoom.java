package com.example.leoni;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ServerRoom extends AppCompatActivity {
    Button ltn1,ltn2,ltn3;
    ImageButton nav;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_room);
        ltn1=findViewById(R.id.buttonLtn1);
        ltn2=findViewById(R.id.buttonLtn2);
        ltn3=findViewById(R.id.buttonLtn3);
        nav =findViewById(R.id.navButton );
        ltn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ltn1.class);
                startActivity(intent);
                finish();
            }
        });
        ltn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ltn2.class);
                startActivity(intent);
                finish();
            }
        });
        ltn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ltn3.class);
                startActivity(intent);
                finish();
            }
        });
      nav.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(), navBar.class);
              startActivity(intent);
              finish();
          }
      });
    }
}
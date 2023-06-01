package com.example.leoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Historique extends AppCompatActivity {
    ImageButton nav;
    Button hLtn1,hLtn2,hLtn3,hLtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        nav=findViewById(R.id.navButton);
        hLtn1=findViewById(R.id.historiqueButtonLtn1);
        hLtn2=findViewById(R.id.historiqueButtonLtn2);
        hLtn3=findViewById(R.id.historiqueButtonLtn3);
        hLtn4=findViewById(R.id.historiqueButtonLtn4);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),navBar.class);
                startActivity(intent);
                finish();
            }
        });
        hLtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoryLtn1.class);
                startActivity(intent);
                finish();

            }
        });
        hLtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoryLtn2.class);
                startActivity(intent);
                finish();
            }
        });
        hLtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HistoryLtn3.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
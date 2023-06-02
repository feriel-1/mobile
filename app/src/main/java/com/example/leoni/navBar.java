package com.example.leoni;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class navBar extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    Button LogOut,ManageB,RegisterB,ServerB,HistoryB;
    ImageButton nav;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
        LogOut = findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();
        user =auth.getCurrentUser();
        ManageB= findViewById(R.id.manageUserB);
        RegisterB=findViewById(R.id.registerB);
        ServerB=findViewById(R.id.serverRoomB);
        HistoryB=findViewById(R.id.historiqueB);
        nav=findViewById(R.id.navButton);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();

            }
        });
        RegisterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();

            }
        });
        ServerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ServerRoom.class);
                startActivity(intent);
                finish();
            }
        });
        HistoryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Historique.class);
                startActivity(intent);
                finish();
            }
        });
        ManageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ManageUser.class);
                startActivity(intent);
                finish();
            }
        });
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),navBar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
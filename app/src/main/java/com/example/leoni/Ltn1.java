package com.example.leoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ltn1 extends AppCompatActivity {
    ImageButton nav;
    TextView temperatureval , humidityvalue,   gazvalue, soundvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltn1);
        nav = findViewById(R.id.navButton);
        temperatureval = findViewById(R.id.tempValue);
        gazvalue = findViewById(R.id.gazValue);
        soundvalue = findViewById(R.id.soundValue);
        humidityvalue = findViewById(R.id.humValue);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Rooms/LTN1");

// Attach a ValueEventListener to listen for changes in data
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method will be called when the data at the specified reference changes
                String tempValue = dataSnapshot.child("Température" ).getValue(String.class);
                temperatureval.setText(tempValue); // Update the TextView with the new value
                String gazValue = dataSnapshot.child("Gaz" ).getValue(String.class);
                gazvalue.setText(gazValue);
                String humValue = dataSnapshot.child("Humidity" ).getValue(String.class);
                humidityvalue.setText(humValue);
                String soundValue = dataSnapshot.child("Son" ).getValue(String.class);
                soundvalue.setText(soundValue);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any errors that may occur
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
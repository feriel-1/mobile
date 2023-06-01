package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivityDestination extends AppCompatActivity {
    private ImageButton returnBtn;
    private ImageButton callBtn;
    private TextView affiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);


        affiche = (TextView)findViewById(R.id.textViewAffiche) ;
        Intent intent = getIntent();
        String res = intent.getStringExtra("resultat");
        affiche.setText(res);
        returnBtn = (ImageButton)findViewById(R.id.ReturnBtn);
        callBtn = (ImageButton)findViewById(R.id.CallBtn) ;
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",res);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel: 55555555"));
                startActivity(intent1);
            }
        });

    }
}
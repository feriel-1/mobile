package com.example.tp1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mEdit ;
    private RadioGroup rGroup;
    private RadioButton rButton;
    private TextView oText;
    private boolean noIntent;
    final int  LAUNCH_SECOND = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noIntent= false;
         mButton = (Button) findViewById(R.id.button2);
         mEdit = (EditText) findViewById(R.id.thextInput);
         rGroup = (RadioGroup) findViewById(R.id.RGroup);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @SuppressLint("SetTextI18n")
                    public void onClick(View view)
                    {
                        noIntent= false;
                        start(view);
                    }
                });
    }

    public void start(View view){
        noIntent= false;
        Log.v("EditText", mEdit.getText().toString());
        Editable getvalue = mEdit.getText();

        float value=0;
        if(mEdit.getText().equals(null)){
            System.out.println("error");
        }else {
            try{
                value= Float.parseFloat(mEdit.getText().toString());
            }catch(NumberFormatException exp){

                noIntent = true;
            }
        }

        int selectedId = rGroup.getCheckedRadioButtonId();
        rButton = (RadioButton) findViewById(selectedId);
        String order = rButton.getText().toString();
        System.out.println(order);

        double ETD = value * 3.2;
        double DTE = value / 3.2;
        String result;
        Intent intent = new Intent(MainActivity.this,ActivityDestination.class);

        if(order.equals("Euro -> Dinar")&&!noIntent){
            result = ETD+" DT";
        }else if(order.equals("Dinar -> Euro")&&!noIntent){
            result = DTE+" EURO";
        }else if(noIntent){
            Toast.makeText(MainActivity.this,
                    "please enter a number", Toast.LENGTH_LONG).show();
            return;
        }else{
            Toast.makeText(MainActivity.this,
                    "please choose one of the options", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra("resultat",result);
        startActivityForResult(intent,LAUNCH_SECOND);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Toast.makeText(MainActivity.this,"resultat est :"+result,Toast.LENGTH_LONG).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(MainActivity.this,"there is no result",Toast.LENGTH_LONG).show();            }
        }
    }
}
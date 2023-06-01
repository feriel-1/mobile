package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE =1 ;
    private EditText eEntry;
    private RadioButton euroDinar;
    private RadioButton dinarEuro;
    private Button bConvert;
    private TextView eResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.eEntry = (EditText)this.findViewById(R.id.e_entry);
        this.euroDinar = (RadioButton)this.findViewById(R.id.euro_dinar);
        this.dinarEuro = (RadioButton)this.findViewById(R.id.dinar_euro);
        this.bConvert = (Button)this.findViewById(R.id.b_convert);
        this.eResult = (TextView)this.findViewById(R.id.e_result );

        this.bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ch = eEntry.getText().toString();
                double result = 0;
                double nbr = Double.parseDouble(ch);

                if (euroDinar.isChecked())
                    result = nbr * 3.28;

                else
                    result = nbr / 3.28;


                eResult.setText(String.valueOf(result));
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("val", result);
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode==RESULT_OK){
                Toast.makeText(this,"resultat="+data.getDoubleExtra("return",0),Toast.LENGTH_LONG).show();
            }
        }

    }
}
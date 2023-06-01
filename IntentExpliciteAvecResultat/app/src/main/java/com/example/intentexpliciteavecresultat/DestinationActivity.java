package com.example.intentexpliciteavecresultat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.BreakIterator;

public class DestinationActivity extends AppCompatActivity {
    private EditText multiplyValue;
    private Button returnResult;
    private TextView entryText;
    int valueReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        entryText = (TextView) findViewById(R.id.entry_text);
        multiplyValue = (EditText) findViewById(R.id.multiply_value);

        int valueReceived = getIntent().getIntExtra("val", 0);
        entryText.setText("Multiply " + valueReceived + " by:");
    }
    public void retour(View v) {
        Intent returnIntent = new Intent();
        if (multiplyValue.getText() != null) {
            int result = valueReceived * Integer.valueOf(multiplyValue.getText().toString());
            returnIntent.putExtra("resultat", result);
            setResult(RESULT_OK, returnIntent);
        } else {
            setResult(RESULT_CANCELED, returnIntent);
        }
        finish();
    }
}
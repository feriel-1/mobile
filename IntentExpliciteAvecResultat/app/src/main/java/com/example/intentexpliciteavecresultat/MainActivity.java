package com.example.intentexpliciteavecresultat;

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
    private static final int REQUEST_CODE = 0;
    private EditText entryValue;
    private Button startIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.entryValue = (EditText) this.findViewById(R.id.entry_value);
        this.startIntent = (Button) this.findViewById(R.id.start_intent);
    }

    public void start(View v) {
        Intent i = new Intent(this, DestinationActivity.class);
        i.putExtra("val",Integer.valueOf(entryValue.getText().toString()));
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Resultat=" + intent.getIntExtra("result", 0), Toast.LENGTH_LONG).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Pas de Resultat !", Toast.LENGTH_LONG).show();
            }
        }
    }


}

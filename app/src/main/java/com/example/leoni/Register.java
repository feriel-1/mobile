package com.example.leoni;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    EditText UserName , Password;
    FirebaseAuth mAuth;
    Button SignUp;
    TextView Title  ;
    ProgressBar ProgressBar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        UserName =findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Title= findViewById(R.id.Leoni);
        SignUp = findViewById(R.id.signup);
        ProgressBar = findViewById(R.id.Loading);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar.setVisibility(View.VISIBLE);
                String Email , Pass;
                Email = String.valueOf(UserName.getText());
                Pass = String.valueOf(Password.getText());
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(Register.this, "enter you email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Pass)){
                    Toast.makeText(Register.this, "enter you password",Toast.LENGTH_SHORT).show();

                    return;
                }
                mAuth.createUserWithEmailAndPassword(Email, Pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                ProgressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Acount is created.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Register.this, "Creation is failed.", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
    }
}
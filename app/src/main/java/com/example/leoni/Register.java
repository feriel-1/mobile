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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText UserName, Password, Fullname, matricule;
    FirebaseAuth mAuth;
    Button SignUp;
    TextView Title;

    EditText userName , password;
    FirebaseAuth mAuth;
    Button SignUp;
    TextView Title  ;
    ImageButton nav;

    ProgressBar ProgressBar;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        matricule = findViewById(R.id.matricule);
        Fullname = findViewById(R.id.fullname);

        UserName = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Title = findViewById(R.id.Leoni);
        SignUp = findViewById(R.id.signup);
        ProgressBar = findViewById(R.id.Loading);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
        userName =findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        Title= findViewById(R.id.Leoni);
        SignUp = findViewById(R.id.signup);
        ProgressBar = findViewById(R.id.Loading);
        nav =findViewById(R.id.navButton);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),navBar.class);
                startActivity(intent);
                finish();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar.setVisibility(View.VISIBLE);

                String Email, Pass;
                Email = String.valueOf(UserName.getText());
                Pass = String.valueOf(Password.getText());
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(Register.this, "enter you email", Toast.LENGTH_SHORT).show();

                String Email , Pass;
                Email = String.valueOf(userName.getText());
                Pass = String.valueOf(password.getText());
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(Register.this, "enter you email",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(Pass)) {
                    Toast.makeText(Register.this, "enter you password", Toast.LENGTH_SHORT).show();

                    return;
                }

                mAuth.createUserWithEmailAndPassword(Email, Pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(Register.this, "Acount is created.",
                                Toast.LENGTH_SHORT).show();

                        DocumentReference df = fStore.collection("Users").document(user.getUid());
                        Map<String,Object> userInfo = new HashMap<>();
                        userInfo.put("Fullname",Fullname.getText().toString());
                        userInfo.put("Email",Email);
                        userInfo.put("matricule",matricule.getText().toString());

                mAuth.createUserWithEmailAndPassword(Email, Pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                ProgressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Register.this, "Acount is created.", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Register.this, "Creation is failed.", Toast.LENGTH_SHORT).show();


                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "Failed to create account.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}




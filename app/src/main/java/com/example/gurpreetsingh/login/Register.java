package com.example.gurpreetsingh.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText Fname, Lname, Email, Phone, Password;
    private Button Signup;
     private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Fname = (EditText) findViewById(R.id.etFname);
        Lname = (EditText) findViewById(R.id.etLname);
        Phone = (EditText) findViewById(R.id.etPhone);
        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        findViewById(R.id.btnSignup).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    private void registerUser() {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please enter a valid email");
            Email.requestFocus();
            return;

        }

        if (password.isEmpty()) {
            Password.setError("Email is required");
            Password.requestFocus();
            return;

        }

        if (password.length()<6){
            Password.setError("Minimum length of password should be 6");
            Password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"User Regisered Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }

    });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignup:
                break;
        }
    }
}

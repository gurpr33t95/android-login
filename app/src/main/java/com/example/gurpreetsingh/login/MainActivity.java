package com.example.gurpreetsingh.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Fname;
    private EditText Password;
    private Button Register;
    private Button Log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fname = (EditText) findViewById(R.id.etFname);
        Password = (EditText) findViewById(R.id.etPassword);
        Register = (Button) findViewById(R.id.btnRegister);
        Log = (Button) findViewById(R.id.btnLog);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }


}

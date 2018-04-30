package com.example.stropee2017.lokacar.dao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stropee2017.lokacar.R;

public class LoginActivity extends AppCompatActivity {

    Button boutonLogin,boutonCancel;
    EditText username,password;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        boutonLogin = (Button)findViewById(R.id.buttonLogin);
        username = (EditText)findViewById(R.id.textUsername);
        password = (EditText)findViewById(R.id.textPassword);

        boutonCancel = (Button)findViewById(R.id.buttonCancel);
        tx1 = (TextView)findViewById(R.id.nombreAttentat);
        tx1.setVisibility(View.GONE);

        boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        boutonLogin.setEnabled(false);
                    }
                }
            }
        });

        boutonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

            //correcct password
        } else {
            //wrong password
        }
    }



}
package com.example.mychatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private Button signinButton;
    private EditText username;
    private EditText passwrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.usernameId);
        passwrd=(EditText)findViewById(R.id.passwordId);
        signinButton=(Button)findViewById(R.id.signinId);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String pass=passwrd.getText().toString();
                if(!uname.equals("") || !pass.equals("")){

                    ParseUser.logInInBackground(uname, pass, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if(e==null){
                                Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LoginActivity.this,ChatActivity.class));
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Not Logged In", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter username and password",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.insorma.Model.User;
import com.example.insorma.database.Database;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText username,email,phonenumber,password;
    private Button register,signin;
    Database database;

    public static final String passwordPattern = "(?=.*[0-9])"+".{3,20}";
    public static final Pattern pattern = Pattern.compile(passwordPattern);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.usernameET);
        email = findViewById(R.id.emailET);
        phonenumber = findViewById(R.id.phoneET);
        password = findViewById(R.id.passwordET);
        register = findViewById(R.id.signupButton2);
        signin = findViewById(R.id.signupButton);


        register.setOnClickListener(v-> {
            String usernameText = username.getText().toString();
            String emailText = email.getText().toString();
            String phoneText = phonenumber.getText().toString();
            String passwordText = password.getText().toString();

            User newUser = new User(emailText,usernameText,phoneText,passwordText);

            if(!usernameText.isEmpty() && !emailText.isEmpty() && !phoneText.isEmpty() && !passwordText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches() && pattern.matcher(passwordText).matches()){
                database.getUserList().add(newUser);
                Toast.makeText(Register.this, "Register Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Register.this , Login.class);
                startActivity(intent);
            }else if(emailText.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
                email.setError("invalid email");
            }else if(phoneText.isEmpty()){
                phonenumber.setError("Phonenumber mustn't empty");
            }else if(passwordText.isEmpty()||!pattern.matcher(passwordText).matches()){
                password.setError("Invalid Password");
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signin();
            }
        });
    }

        public void Signin(){
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        }


}
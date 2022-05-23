package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.insorma.Model.User;
import com.example.insorma.database.Database;


public class Login extends AppCompatActivity {

    private EditText email, password ;
    private Button login,register;
    Database database;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.loginbtn);
        register = findViewById(R.id.buttonRegister);



        login.setOnClickListener(v ->{
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            database.setUserLogin(new User("admin","admin","admin","admin"));//Biar cepat Loginnya
            for(User s : database.getUserList()){
                if(Email.equals(s.getUserEmail()) && Password.equals(s.getUserPassword())){
                    database.setUserLogin(s);
                    Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, Home.class);
                    startActivity(intent);
                    return;
                }else{
                    Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                }
            }

        });

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Register();
           }
       });
    }

    public void Register(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

}
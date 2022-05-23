package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.insorma.Model.User;
import com.example.insorma.database.Database;

import java.util.concurrent.atomic.AtomicReference;

public class Profile extends AppCompatActivity {


    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView email,phone;
        EditText username;
        Button delete,logout;
        ImageButton rename;

        username = findViewById(R.id.ProfUsername);
        username.setText(database.getUserLogin().getUserUsername());

        email = findViewById(R.id.ProfEmail);
        email.setText(database.getUserLogin().getUserEmail());

        phone = findViewById(R.id.ProfPhone);
        phone.setText(database.getUserLogin().getUserPhonenumber());


        rename = findViewById(R.id.renameBtn);
        delete = findViewById(R.id.deleteBtn);
        logout = findViewById(R.id.Logoutbtn);

        rename.setOnClickListener(v->{

            String usernameText = username.getText().toString();


            if(!usernameText.isEmpty()){

                database.getUserLogin().setUserUsername(usernameText);
                Toast.makeText(this, "Username Successfull change", Toast.LENGTH_SHORT).show();
            }

        });




        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,MainActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }
    public void Logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
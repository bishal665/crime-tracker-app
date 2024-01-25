package com.example.project_6thsem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
    TextView nologin;
    Button btnlogin;
    EditText user, password;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.mainactivity);

        user = findViewById(R.id.edtusername);
        password = findViewById(R.id.edtpassword);
        btnlogin = findViewById(R.id.butlogin);
        nologin = findViewById(R.id.txtcreate);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password1 = password.getText().toString();
//
                Database db = new Database(getApplicationContext(), "crime_tracker", null, 1);
//                if (db.login("admin@gmail.com", "admin12345") == 1) {
//                    Toast.makeText(Login.this, "logged in ", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(Login.this, AdminPanel.class));
//                }
                if (username.length() == 0 || password1.length() == 0) {
                    Toast.makeText(Login.this, "please fill username and password", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.login(username, password1) == 1) {
                        Toast.makeText(Login.this, "logged in ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, Dashboard.class));
                    } else {
                        Toast.makeText(Login.this, "Invalid username and password", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login.this, Dashboard.class));
//            }
//        });

        nologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}

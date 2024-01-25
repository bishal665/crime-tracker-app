package com.example.project_6thsem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends Activity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.admin_login);
            EditText username=findViewById(R.id.edtusername1);
            EditText password=findViewById(R.id.edtpassword1);
            Button btn =findViewById(R.id.butlogin1);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email =username.getText().toString();
                    String password1=password.getText().toString();
                   if(email.equals("admin@gmail.com") && password1.equals("admin1234")){
                        Intent i = new Intent(AdminLogin.this,AdminPanel.class);
                        startActivity(i);
                }
            else{
                     Toast.makeText(AdminLogin.this, "you are not allowed to enter", Toast.LENGTH_SHORT).show();
              }

                }
            });
        }}



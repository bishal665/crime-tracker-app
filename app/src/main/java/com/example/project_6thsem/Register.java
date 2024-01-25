package com.example.project_6thsem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {
    EditText name,email,password,password1;
    TextView txthaveaccount;
    Button btn;
    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.register);
        name=findViewById(R.id.edtname);
        email=findViewById(R.id.edtemail);
        password=findViewById(R.id.edtpassword1);
        password1=findViewById(R.id.edtpassword2);
        txthaveaccount=findViewById(R.id.txthaveaccount);
        btn=findViewById(R.id.btnregister);

        txthaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = name.getText().toString();
                String uemail = email.getText().toString();
                String upassword = password.getText().toString();
                String upassword1 = password1.getText().toString();
                Database db = new Database(getApplicationContext(),"crime_tracker",null,1);
                if(uname.length()==0|| uemail.length()==0 || upassword.length()==0 || upassword1.length()==0 )
                {
                    Toast.makeText(Register.this, "please fill all details", Toast.LENGTH_SHORT).show();
                }
                if(upassword.compareTo(upassword1)==0)
                {
                    if(upassword.length()>8)
                    {
                        db.register(uname,uemail,upassword);
                        Toast.makeText(Register.this, "Registerd Sucessfully ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, Login.class));
                    }
                    else {
                        Toast.makeText(Register.this, "your password must contains 8 character", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Register.this, "password didn't match", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}


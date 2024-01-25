package com.example.project_6thsem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterCrime extends Activity {
    EditText description,date,time,phone;
    TextView btn;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
      setContentView(R.layout.registercrime);
        description=findViewById(R.id.edescription);
        date=findViewById(R.id.edate);
        time=findViewById(R.id.etime);
        phone=findViewById(R.id.ephone);
        btn=findViewById(R.id.btn);
        // Write a message to the database

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des=description.getText().toString();
                String dat=date.getText().toString();
                String tim=time.getText().toString();
                String phon=phone.getText().toString();
                if(des.isEmpty() && dat.isEmpty()&& tim.isEmpty()&& phon.isEmpty())
                {
                    Toast.makeText(RegisterCrime.this, "no field cannot be empty", Toast.LENGTH_SHORT).show();
                }
                insert(des,dat,tim,phon);
            }
            private void insert(String des,String date,String time,String phone)
            {
                HashMap<String,String> map=new HashMap<>();
                map.put("description",des);
                map.put("date",date);
                map.put("time",time);
                map.put("phone",phone);

                FirebaseDatabase database= FirebaseDatabase.getInstance();
                DatabaseReference myref=database.getReference("crime");
                String key= myref.push().getKey();
                map.put("key",key);

                myref.child(key).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(RegisterCrime.this,"added",Toast.LENGTH_SHORT).show();



                    }
                });

            }

        });
    }
}


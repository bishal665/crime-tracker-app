package com.example.project_6thsem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;

public class Dashboard extends Activity {
    CardView report,emergency,ambulance,safety,home,logout;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.dashboard);
        report= findViewById(R.id.regesterid);
        emergency= findViewById(R.id.emergencyid);
        ambulance=findViewById(R.id.ambulanceid);
        safety=findViewById(R.id.safetyid);
        home=findViewById(R.id.homeid);
        logout=findViewById(R.id.logoutid);

        logout.setOnClickListener(view->{
            Intent i = new Intent(Dashboard.this,Login.class);
            startActivity(i);
                }
                );
        report.setOnClickListener(view->{
                    Intent i = new Intent(Dashboard.this,RegisterCrime.class);
                    startActivity(i);
                }
        );
        emergency.setOnClickListener(view->{
                    Intent i = new Intent(Dashboard.this,SosClass.class);
                    startActivity(i);
                }
        );
        ambulance.setOnClickListener(view->{
                    Intent i = new Intent(Dashboard.this,Ambulance.class);
                    startActivity(i);
                }
        );
        safety.setOnClickListener(view->{
                    Intent i = new Intent(Dashboard.this,Safety.class);
                    startActivity(i);
                }
        );
        home.setOnClickListener(view->{
                    Intent i = new Intent(Dashboard.this,AdminLogin.class);
                    startActivity(i);
                }
        );
    }
}

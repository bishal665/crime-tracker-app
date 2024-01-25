package com.example.project_6thsem;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class SosClass extends Activity {
    private com.example.addnumber.DatabaseHelper dbHelper;
//    AddNumber addNumber= new AddNumber();
    private static final int SOS_CLICKS_REQUIRED = 3; // Change this to your desired number of clicks
    private static final long TIME_INTERVAL = 1000; // Change this to your desired time interval in milliseconds
    private static final int LOCATION_REQUEST_CODE = 1;
    private static final int SMS_PERMISSION_REQUEST_CODE = 2;

    private long lastClickTime = 0;
    private int clickCount = 0;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        Button btn=findViewById(R.id.addnumber);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SosClass.this,AddNumber.class);
                startActivity(i);
            }
        });
    }

    public void sendSOS(View view) {
        long currentTime = System.currentTimeMillis();

        // Check if clicks are within the time interval
        if (currentTime - lastClickTime < TIME_INTERVAL) {
            clickCount++;

            // Check if the required number of clicks is reached
            if (clickCount >= SOS_CLICKS_REQUIRED) {
                // Request SMS permission before sending SOS
                requestSmsPermission();
                clickCount = 0; // Reset click count
            }
        } else {
            // Reset click count if the time interval between clicks is too long
            clickCount = 1;
        }

        lastClickTime = currentTime;
    }

    private void requestSmsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SMS_PERMISSION_REQUEST_CODE);
        } else {
            // Permission already granted, get location and send SOS
            getLastLocationAndSendSOS();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SMS_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, get location and send SOS
                getLastLocationAndSendSOS();
            } else {
                Toast.makeText(this, "Permission to send SMS denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getLastLocationAndSendSOS() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();
                                sendEmergencyMessageWithLocation(latitude, longitude);
                            } else {
                                Toast.makeText(SosClass.this, "Location not available.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            // Request location permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
        }
    }

    private void sendEmergencyMessageWithLocation(double latitude, double longitude) {

        String phoneNumber = "9804964665";
        String message = "Emergency! Need help! My location: Latitude " +
                latitude + ", Longitude " + longitude;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "SOS message sent!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Failed to send SOS message.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}


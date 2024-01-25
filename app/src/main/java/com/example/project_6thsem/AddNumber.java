package com.example.project_6thsem;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AddNumber extends AppCompatActivity {
    private com.example.addnumber.DatabaseHelper dbHelper;
    private EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnumber);

        dbHelper = new com.example.addnumber.DatabaseHelper(this);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);

        Button insertButton = findViewById(R.id.insertButton);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insert the phone number from the EditText into the database
                String phoneNumber = phoneNumberEditText.getText().toString();
                insertPhoneNumber(phoneNumber);

                // Retrieve and display the phone number
                String retrievedPhoneNumber = retrievePhoneNumber();
                TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
                phoneNumberTextView.setText("Phone Number: " + retrievedPhoneNumber);
            }
        });
    }

    private void insertPhoneNumber(String phoneNumber) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(com.example.addnumber.DatabaseHelper.COLUMN_NUMBER, phoneNumber);

        // Replace the existing number if it exists
        db.delete(com.example.addnumber.DatabaseHelper.TABLE_NAME, null, null);
        db.insert(com.example.addnumber.DatabaseHelper.TABLE_NAME, null, values);

        db.close();
    }

    String retrievePhoneNumber() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = { com.example.addnumber.DatabaseHelper.COLUMN_NUMBER };

        Cursor cursor = db.query(
                com.example.addnumber.DatabaseHelper.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        String phoneNumber = "";

        if (cursor.moveToFirst()) {
            phoneNumber = cursor.getString(cursor.getColumnIndex(com.example.addnumber.DatabaseHelper.COLUMN_NUMBER));
        }

        cursor.close();
        db.close();

        return phoneNumber;
    }
}

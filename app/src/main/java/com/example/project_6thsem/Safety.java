package com.example.project_6thsem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Safety extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safety);
//        String[] name = {
//                "Always lock your doors and windows when you leave home.",
//                "Install and maintain smoke detectors in your home.",
//                "Never leave cooking unattended on the stove.",
//                "Install carbon monoxide detectors in your home.",
//                "Don't share personal information online."
//        };
        ArrayList<String> name = new ArrayList<>();


        ListView phoneNumberListView = findViewById(R.id.safety);

        // Create an ArrayList to store the phone numbers
        ArrayList<String> phoneNumbers = new ArrayList<>();

        // Populate the ArrayList with 100 phone numbers
        phoneNumbers.add("Always lock your doors and windows when you leave home");
        phoneNumbers.add("Install and maintain smoke detectors in your home.");
        phoneNumbers.add("Don't share personal information online...");
        phoneNumbers.add("Keep a first aid kit in your home and car");
        phoneNumbers.add("Avoid walking alone at night.");
        phoneNumbers.add(" Don't open the door to strangers..");
        phoneNumbers.add(" Follow proper hand hygiene to prevent the spread of illnesses");
        phoneNumbers.add("Use sunscreen and protective clothing to prevent sunburn.");

        phoneNumbers.add("Always lock your doors and windows when you leave home");
        phoneNumbers.add("Install and maintain smoke detectors in your home.");
        phoneNumbers.add("Don't share personal information online...");
        phoneNumbers.add("Keep a first aid kit in your home and car");
        phoneNumbers.add("Avoid walking alone at night.");
        phoneNumbers.add(" Don't open the door to strangers..");
        phoneNumbers.add(" Follow proper hand hygiene to prevent the spread of illnesses");
        phoneNumbers.add("Use sunscreen and protective clothing to prevent sunburn.");

        phoneNumbers.add("Always lock your doors and windows when you leave home");
        phoneNumbers.add("Install and maintain smoke detectors in your home.");
        phoneNumbers.add("Don't share personal information online...");
        phoneNumbers.add("Keep a first aid kit in your home and car");
        phoneNumbers.add("Avoid walking alone at night.");
        phoneNumbers.add(" Don't open the door to strangers..");
        phoneNumbers.add(" Follow proper hand hygiene to prevent the spread of illnesses");
        phoneNumbers.add("Use sunscreen and protective clothing to prevent sunburn.");



        // Create an ArrayAdapter to display the phone numbers
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phoneNumbers);

        // Set the adapter for the ListView
        phoneNumberListView.setAdapter(adapter);
    }
}
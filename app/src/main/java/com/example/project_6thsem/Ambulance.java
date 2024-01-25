package com.example.project_6thsem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Ambulance extends AppCompatActivity {
    private String[] phoneNumbers = {
            // Add ambulance phone numbers
            "123-456-7890",
            "987-654-3210",

            "555-123-4567",
            "555-123-1233",
            "123-456-1234",
            "987-654-1235",
            "555-123-1236",
            "555-123-1237",
            "123-456-7891",
            "987-654-3292",
            "555-123-4593",
            "555-123-1294",
            "123-456-1295",
            "987-654-1296",
            "555-123-1298",
            "555-123-1299",
            "123-456-7890",
            "987-654-3210",
            "555-123-4567",
            "555-123-1233",
            "123-456-1234",
            "987-654-1235",
            "555-123-1236",
            "555-123-1237",
            "123-456-7891",
            "987-654-3292",
            "555-123-4593",
            "555-123-1294",
            "123-456-1295",
            "987-654-1296",
            "555-123-1298",
            "555-123-1299",
    };

    private String[] cities = {
            // Add city names (not necessarily sorted)
            "Kathmandu",
            "Pokhara",
            "Lalitpur",
            "Bhaktapur",
            "Biratnagar",
            "Birgunj",
            "Butwal",
            "Dharan",
            "Nepalgunj",
            "Hetauda",
            "Itahari",
            "Dhangadhi",
            "Birendranagar",
            "Damak",
            "Bharatpur",
            "Janakpur",
            "Dhankuta",
            "Ghorahi",
            "Rajbiraj",
            "Tulsipur",
            "Lahan",
            "Siddharthanagar",
            "Gulariya",
            "Panauti",
            "Tansen",
            "Ilam",
            "Siraha",
            "Jaleswar",
            "Gorkha",
            "Bhadrapur"
    };

    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance);

        // Sort the cities array alphabetically
        Arrays.sort(cities);

        EditText editTextSearch = findViewById(R.id.editTextSearch);
        listView = findViewById(R.id.listView);

        adapter = new CustomAdapter(this, phoneNumbers, cities);
        listView.setAdapter(adapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String filterText = charSequence.toString().toLowerCase();
                filterCities(filterText);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void filterCities(String filterText) {
        int left = 0;
        int right = cities.length - 1;

        ArrayList<String> filteredCitiesList = new ArrayList<>();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String currentCity = cities[mid].toLowerCase();
            if (currentCity.startsWith(filterText)) {
                filteredCitiesList.add(cities[mid]);
                left = mid + 1;
            } else if (currentCity.compareTo(filterText) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Create filtered arrays
        String[] filteredPhoneNumbers = new String[filteredCitiesList.size()];
        String[] filteredCities = new String[filteredCitiesList.size()];
        for (int i = 0; i < filteredCitiesList.size(); i++) {
            int index = Arrays.binarySearch(cities, filteredCitiesList.get(i));
            filteredPhoneNumbers[i] = phoneNumbers[index];
            filteredCities[i] = filteredCitiesList.get(i);
        }

        // Update the adapter with filtered data
        CustomAdapter filteredAdapter = new CustomAdapter(Ambulance.this, filteredPhoneNumbers, filteredCities);
        listView.setAdapter(filteredAdapter);
    }
}

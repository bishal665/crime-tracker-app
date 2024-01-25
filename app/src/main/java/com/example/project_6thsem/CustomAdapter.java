package com.example.project_6thsem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] phoneNumbers;
    private String[] cities;

    public CustomAdapter(Context context, String[] phoneNumbers, String[] cities) {
        this.context = context;
        this.phoneNumbers = phoneNumbers;
        this.cities = cities;
    }

    @Override
    public int getCount() {
        return cities.length;
    }

    @Override
    public Object getItem(int position) {
        return cities[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ambulance_list, parent, false);
        }

        TextView textViewPhoneNumber = convertView.findViewById(R.id.textViewPhoneNumber);
        TextView textViewCity = convertView.findViewById(R.id.textViewCity);

        textViewPhoneNumber.setText(phoneNumbers[position]);
        textViewCity.setText(cities[position]);

        return convertView;
    }
}


package com.myapplicationdev.android.demoandroidlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<AndroidVersion> {
    Context parent_context;
    int layout_id;
    ArrayList<AndroidVersion> versionList;

    public CustomAdapter(Context context, int resource,  ArrayList<AndroidVersion> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object - Get
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row - Read
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding - Find and Bind
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvVersion = rowView.findViewById(R.id.textViewVersion);

        // Obtain the Android Version information based on the position - Find
        AndroidVersion currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information - Populate
        tvName.setText("Name: " + currentVersion.getName());
        tvVersion.setText("Version: " + currentVersion.getVersion());

        return rowView;
    }



}

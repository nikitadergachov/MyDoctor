package com.application.mydoctor.Activity.Basic;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.application.mydoctor.R;

public class VizitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizit);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
/*
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header, listView,
                false);
        listView.addHeaderView(header, null, false);

        VizitArrayAdapter arrayAdapter = new VizitArrayAdapter(this, tablet_name, count, time, time_check);
        listView.setAdapter(arrayAdapter);*/
    }
}

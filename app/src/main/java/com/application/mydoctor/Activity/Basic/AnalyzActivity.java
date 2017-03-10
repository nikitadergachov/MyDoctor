package com.application.mydoctor.Activity.Basic;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.application.mydoctor.R;

public class AnalyzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}

package com.application.mydoctor.Activity.Basic;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.application.mydoctor.Fragment.ProcedureFragment;
import com.application.mydoctor.R;

public class ProcedureActivity extends AppCompatActivity {
    private ProcedureFragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);



        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mCurrentFragment = new ProcedureFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, mCurrentFragment).commit();



    }
}

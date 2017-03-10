package com.application.mydoctor.Activity.Basic;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.application.mydoctor.Fragment.InfiniteHorizontalMedicinesFragment;
import com.application.mydoctor.R;

public class MedicinesActivity extends AppCompatActivity
{

    private InfiniteHorizontalMedicinesFragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);



        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mCurrentFragment = new InfiniteHorizontalMedicinesFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, mCurrentFragment).commit();



    }


}

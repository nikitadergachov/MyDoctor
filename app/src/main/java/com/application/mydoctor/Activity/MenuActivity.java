package com.application.mydoctor.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.application.mydoctor.Activity.Basic.AnalyzActivity;
import com.application.mydoctor.Activity.Basic.MedicinesActivity;
import com.application.mydoctor.Activity.Basic.ProcedureActivity;
import com.application.mydoctor.Activity.Basic.RecomendationActivity;
import com.application.mydoctor.Activity.Basic.SettingsActivity;
import com.application.mydoctor.Activity.Basic.VizitActivity;
import com.application.mydoctor.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       initImageView();

    }

    protected void initImageView(){
        ImageView medic = (ImageView) findViewById(R.id.medic_image_view);
        ImageView analyz = (ImageView) findViewById(R.id.analyz_image_view);
        ImageView procedure = (ImageView) findViewById(R.id.procedure_image_view);
        ImageView vizit = (ImageView) findViewById(R.id.vizit_image_view);
        ImageView settings = (ImageView) findViewById(R.id.setting_image_view);
        ImageView recomendation = (ImageView) findViewById(R.id.recomendation_image_view);

        medic.setOnClickListener(this);
        analyz.setOnClickListener(this);
        procedure.setOnClickListener(this);
        vizit.setOnClickListener(this);
        settings.setOnClickListener(this);
        recomendation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MenuActivity.this, MenuActivity.class);

        switch (v.getId()){
            case R.id.medic_image_view:
                intent = new Intent(MenuActivity.this, MedicinesActivity.class);
                break;
            case R.id.analyz_image_view:
                intent = new Intent(MenuActivity.this, AnalyzActivity.class);
                break;
            case R.id.procedure_image_view:
                intent = new Intent(MenuActivity.this, ProcedureActivity.class);
                break;
            case R.id.vizit_image_view:
                intent = new Intent(MenuActivity.this, VizitActivity.class);
                break;
            case R.id.setting_image_view:
                intent = new Intent(MenuActivity.this, SettingsActivity.class);
                break;
            case R.id.recomendation_image_view:
                intent = new Intent(MenuActivity.this, RecomendationActivity.class);
                break;
        }

        startActivity(intent);
    }

}

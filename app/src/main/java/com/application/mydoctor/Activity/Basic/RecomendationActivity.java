package com.application.mydoctor.Activity.Basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.application.mydoctor.Activity.MainActivity;
import com.application.mydoctor.R;

public class RecomendationActivity extends AppCompatActivity {

        final String[] recomendation = new String[]{
                "Пить больше жидкости", "Заниматься спортом", "Исключить алкоголь", "Правильное питание",

        };




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recomendation);

            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();


            ListView listView = (ListView) findViewById(R.id.recomend_list_view);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.recomendation, recomendation);
            listView.setAdapter(arrayAdapter);

            ImageView imageView = (ImageView) findViewById(R.id.back_menu);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(RecomendationActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });    }
    }

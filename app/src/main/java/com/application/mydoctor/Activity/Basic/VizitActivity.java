package com.application.mydoctor.Activity.Basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.application.mydoctor.Activity.MainActivity;
import com.application.mydoctor.Adapter.VizitArrayAdapter;
import com.application.mydoctor.R;

public class VizitActivity extends AppCompatActivity {

    final String[] tablet_name = new String[]{
            "Хирург", "Кардиолог", "Уролог", "Неврлог",

    };


    final String[] time = new String[]{
            "8:20", "8:20", "8:40", "9:20",

    };

    final String[] date = new String[]{
            "5 марта", "6 марта", "11 марта", "13 марта",
    };
    final boolean[] check = {true, true, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizit);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        ListView listView = (ListView) findViewById(R.id.vizit_list_view);

        VizitArrayAdapter arrayAdapter = new VizitArrayAdapter(this, tablet_name, time, date,check);
        listView.setAdapter(arrayAdapter);

        ImageView imageView = (ImageView) findViewById(R.id.back_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(VizitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });    }
}

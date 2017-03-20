package com.application.mydoctor.Activity.Basic;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.mydoctor.Model.Analyzes;
import com.application.mydoctor.R;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AnalyzDescriptionActivity extends AppCompatActivity {

    private Realm realm;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyz_description);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initRealm();

        ImageView imageView = (ImageView) findViewById(R.id.back_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnalyzDescriptionActivity.this, AnalyzActivity.class);
                startActivity(intent);
            }
        });


        TextView analyzName = (TextView) findViewById(R.id.analyz_name);
        TextView analyzDescription = (TextView) findViewById(R.id.analyz_description);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String receipt = getIntent().getStringExtra("receipt");
        final String position = getIntent().getStringExtra("position");



        analyzName.setText(name);
        analyzDescription.setText(description);

        Button button = (Button) findViewById(R.id.analyz_button);

        if(!Objects.equals(receipt, "0"))
            button.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Analyzes.setReceiptTime(Integer.parseInt(position), realm);
                Intent intent = new Intent(AnalyzDescriptionActivity.this, AnalyzActivity.class);
                startActivity(intent);

            }
        });



    }

    public void initRealm(){
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        this.realm = Realm.getInstance(config);
    }
}

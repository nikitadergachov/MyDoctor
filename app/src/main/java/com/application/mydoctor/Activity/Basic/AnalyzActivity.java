package com.application.mydoctor.Activity.Basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.application.mydoctor.Activity.MainActivity;
import com.application.mydoctor.Adapter.AnalyzesArrayAdapter;
import com.application.mydoctor.Model.Analyzes;
import com.application.mydoctor.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class AnalyzActivity extends AppCompatActivity {

    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initRealm();

        ListView listView = (ListView) findViewById(R.id.analyz_list_view);

        final RealmResults<Analyzes> realmResults = Analyzes.getAllAnalyzes(realm);
        AnalyzesArrayAdapter arrayAdapter = new AnalyzesArrayAdapter(this, realmResults);

        listView.setAdapter(arrayAdapter);


        ImageView imageView = (ImageView) findViewById(R.id.back_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnalyzActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(AnalyzActivity.this, AnalyzDescriptionActivity.class);

                        // указываем первым параметром ключ, а второе значение
                        // по ключу мы будем получать значение с Intent

                        intent.putExtra("name", realmResults.get(position).getName());
                        intent.putExtra("description", realmResults.get(position).getDescription());
                        intent.putExtra("receipt",realmResults.get(position).getReceiptOfDate()+"");
                        intent.putExtra("position", position+"");
                        startActivity(intent);



                    }
                }
        );
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

package com.danielfreeman.tareapetagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Favoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBarNoStar = (Toolbar) findViewById(R.id.miActionBar_noStar);
        setSupportActionBar(miActionBarNoStar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

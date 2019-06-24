package com.example.jcasselm.listtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getStarted = findViewById(R.id.getStarted);
        Button authors = findViewById(R.id.authors);

        getStarted.setOnClickListener((View v) ->
        {
            Intent ListPage = new Intent(MainActivity.this, ListPage.class);
                startActivity(ListPage);

        });


        authors.setOnClickListener((View v) ->
        {
            Intent AuthorPage = new Intent(MainActivity.this, AuthorPage.class);
            startActivity(AuthorPage);

        });
    }
}

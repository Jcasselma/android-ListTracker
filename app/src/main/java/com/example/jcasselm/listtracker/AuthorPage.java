package com.example.jcasselm.listtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthorPage extends MainActivity{

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.author_page);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener((View v) ->
        {
            finish();

        });

    }
}

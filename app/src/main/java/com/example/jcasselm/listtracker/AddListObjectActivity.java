package com.example.jcasselm.listtracker;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddListObjectActivity extends ListPage {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_list_object);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener((View v) ->
        {
            EditText listNameField = findViewById(R.id.listNameField);
            String name = listNameField.getText().toString();

            EditText listItem1Field = findViewById(R.id.listItem1Field);
            String item1 = listItem1Field.getText().toString();

            EditText listItem2Field = findViewById(R.id.listItem2Field);
            String item2 = listItem2Field.getText().toString();

            EditText listItem3Field = findViewById(R.id.listItem3Field);
            String item3 = listItem3Field.getText().toString();

            EditText listItem4Field = findViewById(R.id.listItem4Field);
            String item4 = listItem4Field.getText().toString();

            EditText listItem5Field = findViewById(R.id.listItem5Field);
            String item5 = listItem5Field.getText().toString();

            if (name.length() > 0 && item1.length() > 0) {
                ListObject listObject
                        = new ListObject(0, name, item1, item2, item3, item4, item5);
                ListObjectViewModel viewModel
                        = ViewModelProviders.of(this)
                        .get(ListObjectViewModel.class);
                viewModel.insert(listObject);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

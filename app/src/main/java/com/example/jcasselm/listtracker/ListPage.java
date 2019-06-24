package com.example.jcasselm.listtracker;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Objects;

public class ListPage extends MainActivity {


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page);

        Button createButton = findViewById(R.id.create_button);
        Button backButton = findViewById(R.id.back_button);
        Button clearButton = findViewById(R.id.clear_all);

        backButton.setOnClickListener((View v) ->
        {
            finish();

        });



        createButton.setOnClickListener((View view) ->
        {
            Intent intent = new Intent(ListPage.this,
                    AddListObjectActivity.class);
            startActivity(intent);
        });

        ListObjectViewModel viewModel
                = ViewModelProviders.of(this)
                .get(ListObjectViewModel.class);
        RecyclerViewAdapter.RecyclerViewOnClickListener clickListener = (view, position) ->
        {
            ListObject listObject = viewModel.getAllLists()
                    .getValue()
                    .get(position);

        };

        RecyclerViewAdapter.RecyclerViewOnLongClickListener longClickListener =
                (view, position) ->
                {
                    ListObject listObject = viewModel.getAllLists()
                            .getValue()
                            .get(position);
                    // create/show dialog to confirm delete
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListPage.this);
                    builder.setTitle("Delete Success");
                    return true;
                };
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // add a divider
        DividerItemDecoration decoration
                = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        decoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(this,
                R.drawable.divider)));
        recyclerView.addItemDecoration(decoration);
        RecyclerViewAdapter adapter
                = new RecyclerViewAdapter(clickListener, longClickListener);
        recyclerView.setAdapter(adapter);
        viewModel.getAllLists().observe(this,
                (@Nullable final List<ListObject> listObjects) ->
                {
                    adapter.setListObjects(listObjects);
                });

        clearButton.setOnClickListener((View v) ->
        {
            adapter.updateData();
        });
    }
}

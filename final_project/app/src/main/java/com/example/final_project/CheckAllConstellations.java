package com.example.final_project;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class CheckAllConstellations extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Constellations> mSportsData;
    private ConstellationAdapter mAdapter;
    private TypedArray sportsImageResources;
    private static final String BUNDLE_KEY = "Sports_data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_constellations);
        mRecyclerView = findViewById(R.id.RecycleView1);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        mSportsData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new ConstellationAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);
    }
}

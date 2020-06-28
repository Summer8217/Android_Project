package com.example.final_project;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class CheckAllConstellations extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Constellations> mConstellationsData;
    private ConstellationAdapter mAdapter;
    private TypedArray ConstellationsImageResources;
    private static final String BUNDLE_KEY = "Sports_data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_constellations);
        mRecyclerView = findViewById(R.id.RecycleView1);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        // Set the Layout Manager.
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        mConstellationsData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new ConstellationAdapter(this, mConstellationsData);
        mRecyclerView.setAdapter(mAdapter);
        initializeData();

        mRecyclerView.setLayoutManager(new GridLayoutManager(
                this, gridColumnCount));

        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                swipeDirs) {
            /**
             * Defines the drag and drop functionality.
             *
             * @param recyclerView The RecyclerView that contains the list items.
             * @param viewHolder The SportsViewHolder that is being moved.
             * @param target The SportsViewHolder that you are switching the
             *               original one with.
             * @return returns true if the item was moved, false otherwise
             */
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                // Get the from and to positions.
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                // Swap the items and notify the adapter.
                Collections.swap(mConstellationsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            /**
             * Defines the swipe to dismiss functionality.
             *
             * @param viewHolder The viewholder being swiped.
             * @param direction The direction it is swiped in.
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                // Remove the item from the dataset.
                mConstellationsData.remove(viewHolder.getAdapterPosition());
                // Notify the adapter.
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //Option Menu OnCreate
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {           //Option Menu Item OnClick
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nightMode = AppCompatDelegate.getDefaultNightMode();
                if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void initializeData() {
        // Get the resources from the XML file.
        String[] ConstellationsList = getResources()
                .getStringArray(R.array.constellations_titles);
        String[] ConstellationsInfo = getResources()
                .getStringArray(R.array.sports_info);
        String[] ConstellationDetail1 = getResources().getStringArray(R.array.constellation_info);
        // typed array allows storing array of some XML resources
        ConstellationsImageResources = getResources().obtainTypedArray(R.array.constellations_images);
        // Clear the existing data (to avoid duplication).
        mConstellationsData.clear();
        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for (int i = 0; i < ConstellationsList.length; i++) {
            mConstellationsData.add(new Constellations(ConstellationsList[i], ConstellationsInfo[i], ConstellationsImageResources.getResourceId(i, 0),ConstellationDetail1[i]));
        }
        ConstellationsImageResources.recycle();
        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initializeData();
    }

    public void SetColumnNumber (View view){
        //以對話框確認是否要關閉視窗
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_multi_column, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

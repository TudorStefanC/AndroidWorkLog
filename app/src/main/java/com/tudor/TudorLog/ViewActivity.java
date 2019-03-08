package com.tudor.TudorLog;

import androidx.room.Room;
import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    public static AppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //Implements the toolbar
        Toolbar mToolbar;
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("View shifts");
        mToolbar.setSubtitle("DATE                  START                END                  HOURS");

        //implements the Floating Action Bar
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddActivity();
            }
        });

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "database-name").allowMainThreadQueries().build();

        ArrayList<ShiftsItem> shifts_list = new ArrayList<>();
        shifts_list.add(new ShiftsItem("Date1", "Start1", "End1", "Hours1"));
        shifts_list.add(new ShiftsItem("Date2", "Start2", "End2", "Hours2"));
        shifts_list.add(new ShiftsItem("Date3", "Start3", "End3", "Hours3"));
        shifts_list.add(new ShiftsItem("Date1", "Start1", "End1", "Hours1"));
        shifts_list.add(new ShiftsItem("Date2", "Start2", "End2", "Hours2"));
        shifts_list.add(new ShiftsItem("Date3", "Start3", "End3", "Hours3"));
        shifts_list.add(new ShiftsItem("Date1", "Start1", "End1", "Hours1"));
        shifts_list.add(new ShiftsItem("Date2", "Start2", "End2", "Hours2"));
        shifts_list.add(new ShiftsItem("Date3", "Start3", "End3", "Hours3"));
        shifts_list.add(new ShiftsItem("Date1", "Start1", "End1", "Hours1"));
        shifts_list.add(new ShiftsItem("Date2", "Start2", "End2", "Hours2"));
        shifts_list.add(new ShiftsItem("Date3", "Start3", "End3", "Hours3"));

        myRecyclerView = findViewById(R.id.recycler_view);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myAdapter = new MyShiftsAdapter(shifts_list);

        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);

    }
    private void showAddActivity() {
        Intent intent = new Intent(ViewActivity.this, AddActivity.class);
        startActivity(intent);
    }

}

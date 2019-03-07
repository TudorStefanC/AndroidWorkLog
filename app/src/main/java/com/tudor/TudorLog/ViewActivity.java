package com.tudor.TudorLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Toolbar mToolbar;
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("View shifts");
        mToolbar.setSubtitle("DATE                  START                END                  HOURS");

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

}

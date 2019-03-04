package com.tudor.TudorLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Toolbar mToolbar;
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("View shifts");
        mToolbar.setSubtitle("DATE                  START                  END                  HOURS");
    }
}

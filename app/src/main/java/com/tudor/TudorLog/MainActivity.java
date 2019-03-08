package com.tudor.TudorLog;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button addButton, viewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Tudor's Work Log");
        mToolbar.setSubtitle("by Tudor S. Co.");

        addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddActivity();
            }
        });

        viewButton= findViewById(R.id.btnView);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showViewActivity();
            }
        });

    }

    private void showViewActivity() {
        Intent intent = new Intent(MainActivity.this, ViewActivity.class);
        startActivity(intent);
    }

    private void showAddActivity() {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
}

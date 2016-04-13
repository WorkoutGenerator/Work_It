package com.example.jeimmi.work_itapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class WorkItSelector extends AppCompatActivity {
    private String userID;
    private Intent incomingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_it_selector);
        incomingIntent = getIntent();
        userID = incomingIntent.getStringExtra(LogInActivity.FB_ID);
        Toast toast = Toast.makeText(getApplicationContext(), userID, Toast.LENGTH_LONG);
        toast.show();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(WorkItSelector.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

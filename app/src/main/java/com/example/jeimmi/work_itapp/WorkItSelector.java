package com.example.jeimmi.work_itapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class WorkItSelector extends AppCompatActivity {
    private String userID;
    private Intent incomingIntent;

    String[] TypeOfWorkOuts;
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
                switch (position){
                    case 0:
                        TypeOfWorkOuts[0]="Arms";
                        break;
                    case 1:
                        TypeOfWorkOuts[1]="Abs";
                        break;
                    case 2:
                        TypeOfWorkOuts[2]="Back";
                        break;
                    case 3:
                        TypeOfWorkOuts[3]="Legs";
                        break;
                }

            }
        });


        final Button button = (Button) findViewById(R.id.GenWorkOut);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });
    }
}

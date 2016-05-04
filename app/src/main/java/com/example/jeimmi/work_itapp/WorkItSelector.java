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
    protected final static String WORKOUT_TYPE="com.example.jeimmi.work_itapp.WORKOUT_TYPE";
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
                Intent workOutList = new Intent(WorkItSelector.this, ListViewWorkOut.class);
                switch (position){
                    case 0:
                        workOutList.putExtra(WORKOUT_TYPE, "ABS");

                        break;
                    case 1:
                        workOutList.putExtra(WORKOUT_TYPE,"ARMS");
                        break;
                    case 2:
                        workOutList.putExtra(WORKOUT_TYPE,"BACK");
                        break;
                    case 3:
                        workOutList.putExtra(WORKOUT_TYPE,"LEGS");
                        break;
                }
                startActivity(workOutList);

            }
        });



    }
}

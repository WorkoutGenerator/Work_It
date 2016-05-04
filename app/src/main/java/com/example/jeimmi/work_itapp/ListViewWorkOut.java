package com.example.jeimmi.work_itapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewWorkOut extends AppCompatActivity {
    private String workType;
    private Intent incomingIntent;
    private Intent outgoingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_work_out);

        start();
    }


    public void start(){
        incomingIntent = getIntent();
        workType = incomingIntent.getStringExtra(WorkItSelector.WORKOUT_TYPE);
        Toast.makeText(ListViewWorkOut.this, "" + workType,
                Toast.LENGTH_SHORT).show();
        switch (WorkItSelector.WORKOUT_TYPE){
            case "ABS":
                absWork();
                break;
            case "ARMS":
                armsWork();
                break;
            case "BACK":
                backWork();
                break;
            case "LEGS":
                legsWork();
                break;
        }
    }

    public void absWork(){
        //Set up and populate the listView
        String absWorking[]={"Double Crunches","Oblique Crunches","Side Bridge"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, absWorking);
        ListView workList = (ListView) findViewById(R.id.WorkOutList);
        workList.setAdapter(workAdapter);
    }
    public void armsWork(){
        String armsWorking[]={"Kickbacks","Push Ups","Tri Extensions"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, armsWorking);
        ListView workList = (ListView) findViewById(R.id.WorkOutList);
        workList.setAdapter(workAdapter);

    }
    public void legsWork(){
        String legsWorking[]={"Leg Swing","Heel Touch Step Up","Supine Hip"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, legsWorking);
        ListView workList = (ListView) findViewById(R.id.WorkOutList);
        workList.setAdapter(workAdapter);
    }
    public void backWork(){
        String backWorking[]={"Dead Lift","Lying Row","Single Row"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, backWorking);
        ListView workList = (ListView) findViewById(R.id.WorkOutList);
        workList.setAdapter(workAdapter);
    }



}

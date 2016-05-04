package com.example.jeimmi.work_itapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewWorkOut extends ListActivity {
    protected final static String WORKOUT_TYPE="com.example.jeimmi.work_itapp.WORKOUT_TYPE";
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
        if(workType.contentEquals("ABS")){
            absWork();

        }else if(workType.contentEquals("ARMS")){
            armsWork();

        }else if(workType.contentEquals("BACK")){
            backWork();

        }else if(workType.contentEquals("LEGS")){
            legsWork();

        }else{

            Toast.makeText(ListViewWorkOut.this, "NOOOOO BUENO",
                    Toast.LENGTH_SHORT).show();

        }
    }

    public void absWork(){
        //Set up and populate the listView
        final String[] absWorking={"Double Crunches","Oblique Crunches","Side Bridge"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, absWorking);
        ListView workList = (ListView) findViewById(android.R.id.list);
        workList.setAdapter(workAdapter);

        workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                outgoingIntent.putExtra(WORKOUT_TYPE, "ABS");
                startActivity(outgoingIntent);

            }
        });
    }
    public void armsWork(){
        String[] armsWorking={"Kickbacks","Push Ups","Tri Extensions"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, armsWorking);
        ListView workList = (ListView) findViewById(android.R.id.list);
        workList.setAdapter(workAdapter);

        workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                outgoingIntent.putExtra(WORKOUT_TYPE, "ARMS");
                startActivity(outgoingIntent);

            }
        });

    }
    public void legsWork(){
        String[] legsWorking={"Leg Swing","Heel Touch Step Up","Supine Hip"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, legsWorking);
        ListView workList = (ListView) findViewById(android.R.id.list);
        workList.setAdapter(workAdapter);

        workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                outgoingIntent.putExtra(WORKOUT_TYPE, "LEGS");
                startActivity(outgoingIntent);

            }
        });
    }
    public void backWork(){
        String[] backWorking={"Dead Lift","Lying Row","Single Row"};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, backWorking);
        ListView workList = (ListView) findViewById(android.R.id.list);
        workList.setAdapter(workAdapter);

        workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                outgoingIntent.putExtra(WORKOUT_TYPE, "BACK");
                startActivity(outgoingIntent);

            }
        });
    }



}

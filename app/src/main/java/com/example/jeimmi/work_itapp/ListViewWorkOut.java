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

        }
    }

    public void absWork(){
        //Set up and populate the listView
         final String[] absWorking={"Double Crunches","Oblique Crunches","Side Bridge"};
        final int [] images = {R.drawable.doublecrunches,R.drawable.obliquecrunches, R.drawable.sidebridge};
        ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, absWorking);
        ListView workList = (ListView) findViewById(android.R.id.list);
        workList.setAdapter(workAdapter);

        workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                //outgoingIntent.putExtra(WORKOUT_TYPE, "ABS");
                outgoingIntent.putExtra("name", absWorking[position]);
                outgoingIntent.putExtra("images", images[position]);
                startActivity(outgoingIntent);

            }
        });
    }
    public void armsWork(){
                    final String[] armsWorking={"Kickbacks","Push Ups","Tri Extensions"};
                    final int [] images = {R.drawable.kickback,R.drawable.pushup, R.drawable.tricepextension};
                    ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, armsWorking);
                    ListView workList = (ListView) findViewById(android.R.id.list);
                    workList.setAdapter(workAdapter);

                    workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                            outgoingIntent.putExtra(WORKOUT_TYPE, "ARMS");
                            outgoingIntent.putExtra("name", armsWorking[position]);
                            outgoingIntent.putExtra("images", images[position]);
                            startActivity(outgoingIntent);

                        }
                    });

                }
            public void legsWork(){
                final String[] legsWorking={"Leg Swing","Heel Touch Step Up","Supine Hip"};
                final int [] images = {R.drawable.legswing,R.drawable.heeltouch, R.drawable.supinehip};
                ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, legsWorking);
                ListView workList = (ListView) findViewById(android.R.id.list);
                workList.setAdapter(workAdapter);

                workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                        outgoingIntent.putExtra(WORKOUT_TYPE, "LEGS");
                        outgoingIntent.putExtra("name", legsWorking[position]);
                        outgoingIntent.putExtra("images", images[position]);
                        startActivity(outgoingIntent);

                    }
                });
            }
            public void backWork(){
                final String[] backWorking={"Dead Lift","Lying Row","Single Row"};
                final int [] images = {R.drawable.deadlift,R.drawable.lyingrow, R.drawable.singlerow};
                ArrayAdapter<String> workAdapter = new ArrayAdapter<String>(this, R.layout.activity_work_adapter, backWorking);
                ListView workList = (ListView) findViewById(android.R.id.list);
                workList.setAdapter(workAdapter);

                workList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        outgoingIntent = new Intent(ListViewWorkOut.this, WorkOutDetails.class);
                        outgoingIntent.putExtra(WORKOUT_TYPE, "BACK");
                outgoingIntent.putExtra("name", backWorking[position]);
                outgoingIntent.putExtra("images", images[position]);
                startActivity(outgoingIntent);

            }
        });
    }



}

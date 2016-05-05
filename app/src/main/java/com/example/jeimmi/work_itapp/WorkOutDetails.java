package com.example.jeimmi.work_itapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkOutDetails extends AppCompatActivity {
    protected final static String WORKOUT_TYPE="com.example.jeimmi.work_itapp.WORKOUT_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_details);

        ImageView image = (ImageView) findViewById(R.id.detail_image);
        TextView work_info = (TextView) findViewById(R.id.work_info);


        image.setImageResource(getIntent().getExtras().getInt("image"));
        work_info.setText(getIntent().getExtras().getString("info"));

    }
}

package com.example.jeimmi.work_itapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heroshjozavi on 4/6/16.
 */
public class UserInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Spinner1 & 2 Drop down elements
    private List<String> bodyTypes = new ArrayList<String>(){{
        add("Ectomorph");
        add("Mesomorph");
        add("Endomorph");
    }};

    private List<String> daysOfWeek = new ArrayList<String>() {{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
    }};

    private SeekBar seekB, seekB2;
    private TextView seekBView, seekBView2;
    private Spinner spinner, spinner2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        //Seek bar elements;
        seekB = (SeekBar) findViewById(R.id.seekBar);
        seekB2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBView = (TextView) findViewById(R.id.seekBarView);
        seekBView2 = (TextView) findViewById(R.id.seekBarView2);


        //TO SHOW SEEKBAR VALUES
        seekBView.setText(String.valueOf((float) seekB.getProgress()));
        seekBView2.setText(String.valueOf((float) seekB2.getProgress()));


        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                seekBView.setText(String.valueOf((float)seekB.getProgress() + "lbs"));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO AUTO-generated method stub
            }
        });

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bodyTypes);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, daysOfWeek);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

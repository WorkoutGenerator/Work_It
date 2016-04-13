package com.example.jeimmi.work_itapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heroshjozavi on 4/6/16.
 */
public class UserInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String userID;
    private Intent incomingIntent;
    private CognitoCachingCredentialsProvider credentialsProvider;
    private Users currentUser = new Users();
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
    private Button confirmInfoButton;
    private EditText HeightFtBox,HeightInBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        incomingIntent = getIntent();
        userID = incomingIntent.getStringExtra(LogInActivity.FB_ID);
        Toast toast = Toast.makeText(getApplicationContext(), userID, Toast.LENGTH_LONG);
        toast.show();
        currentUser.setUserID(userID);
        //Seek bar elements;
        seekB = (SeekBar) findViewById(R.id.seekBar);
        seekB2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBView = (TextView) findViewById(R.id.seekBarView);
        seekBView2 = (TextView) findViewById(R.id.seekBarView2);
        HeightFtBox = (EditText)findViewById(R.id.HeightFtTextBox);
        HeightInBox = (EditText)findViewById(R.id.HeightInTextBox);
        confirmInfoButton = (Button)findViewById(R.id.confirmInfoButton);

        //TO SHOW SEEKBAR VALUES
        seekBView.setText(String.valueOf((float) seekB.getProgress()));
        seekBView2.setText(String.valueOf((float) seekB2.getProgress()));


        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                seekBView.setText(String.valueOf((float) seekB.getProgress() + "lbs"));
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
        confirmInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = "";
                height = HeightFtBox.getText()+"ft"+HeightInBox.getText()+"in";

                double weight = 0.0;
                weight = (double)seekB.getProgress();
                currentUser.setHeight(height);
                currentUser.setWeight(weight);
                new upDateUserInfo().execute(currentUser);
                Toast.makeText(getApplicationContext(), "Updating Info", Toast.LENGTH_LONG).show();
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

        credentialsProvider = new CognitoCachingCredentialsProvider(
                this,"us-east-1:a0ab945b-047c-48fb-8c33-9096e0efaeea", Regions.US_EAST_1);
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


    class upDateUserInfo extends AsyncTask<Users,Void,Void> {

        @Override
        protected Void doInBackground(Users... userses) {
            AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
            DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);


            Users temp = mapper.load(Users.class,userses[0].getUserID());
            if(temp!=null){
                temp.setHeight(userses[0].getHeight());
                temp.setWeight(userses[0].getWeight());


            }else{
                temp = userses[0];
                Toast toast = Toast.makeText(getApplicationContext(), "user not in DB", Toast.LENGTH_LONG);
                toast.show();
            }
            mapper.save(temp);

            return null;
        }
    }


}

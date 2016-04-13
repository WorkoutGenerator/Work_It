package com.example.jeimmi.work_itapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.HashMap;
import java.util.Map;

public class LogInActivity extends AppCompatActivity {
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private Profile Uprofile;
    private ProfileTracker mProfileTracker;
    private Users currentUser = new Users();

    private CognitoCachingCredentialsProvider credentialsProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_log_in);
        LoginManager.getInstance().logOut();

        if(Profile.getCurrentProfile() == null) {
            mProfileTracker = new ProfileTracker() {
                @Override
                protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                    // profile2 is the new profile
                    Uprofile = profile2;
                    Log.v("facebook - profile", profile2.getFirstName());
                    mProfileTracker.stopTracking();
                    Toast toast = Toast.makeText(getApplicationContext(), Uprofile.getFirstName(), Toast.LENGTH_LONG);
                    toast.show();
                    setUserInfo();
                    Intent intent = new Intent(LogInActivity.this, WorkItSelector.class);
                    startActivity(intent);
                }
            };
            mProfileTracker.startTracking();
        }
        else {
            Profile profile = Profile.getCurrentProfile();
            Log.v("facebook - profile", profile.getFirstName());
        }

        callbackManager = CallbackManager.Factory.create();
        loginButton =(LoginButton)findViewById(R.id.login_button);
        credentialsProvider = new CognitoCachingCredentialsProvider(
                this,"us-east-1:a0ab945b-047c-48fb-8c33-9096e0efaeea", Regions.US_EAST_1);
        CreateFBCallback();

    }
    public void setUserInfo(){
        currentUser.setUserID(Uprofile.getId());
        currentUser.setFirstName(Uprofile.getFirstName());
        currentUser.setLastName(Uprofile.getLastName());
        new AddUserToDb().execute(currentUser);
    }
    private void CreateFBCallback(){
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Map<String, String> Logins = new HashMap<String, String>();
                Logins.put("graph.facebook.com", AccessToken.getCurrentAccessToken().getToken());
                credentialsProvider.setSessionDuration(86400);
                credentialsProvider.setLogins(Logins);





            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                TextView txt = (TextView) findViewById(R.id.info);
                txt.setText(error.toString());
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);



    }

    class AddUserToDb extends AsyncTask<Users,Void,Void>{

        @Override
        protected Void doInBackground(Users... userses) {
            AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
            DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);


            Users temp = mapper.load(Users.class,userses[0].getUserID());
            if(temp!=null){
                temp.setFirstName(userses[0].getFirstName());
                temp.setLastName(userses[0].getLastName());

            }else{
                temp = userses[0];
            }

            mapper.save(temp);
            return null;
        }
    }

}

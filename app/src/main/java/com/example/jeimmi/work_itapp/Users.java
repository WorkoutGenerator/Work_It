package com.example.jeimmi.work_itapp;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Jeimmi on 4/5/16.
 * This class is the Database Table of the User
 */
@DynamoDBTable(tableName = "Users")
public class Users {
    private String UserID;
    private String FirstName;
    private String LastName;


    @DynamoDBHashKey(attributeName = "UserID")
    public String getUserID() {

        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
    @DynamoDBHashKey(attributeName = "FirstName")
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    @DynamoDBHashKey(attributeName = "LastName")
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }




}

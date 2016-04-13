package com.example.jeimmi.work_itapp;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
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
    private  double Weight;
    private String Height;


    @DynamoDBHashKey(attributeName = "UserID")
    public String getUserID() {

        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
    @DynamoDBAttribute(attributeName = "FirstName")
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    @DynamoDBAttribute(attributeName = "LastName")
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @DynamoDBAttribute(attributeName = "Weight")
    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    @DynamoDBAttribute(attributeName = "Height")
    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }



}

package com.teamhortons.nwhacksapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Created by Erica on 2015-03-13.
 */
public class ActivityCreate extends Activity {

    String challengeTitle;
    String challengeDescription;
    String numPoints;

    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button submitButton = (Button) findViewById(R.id.submit_create_button);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Set Title Text
                EditText titleEditText = (EditText) findViewById(R.id.create_title_edittext);
                challengeTitle = titleEditText.getText().toString();
                //Set Description Text
                EditText descriptionEditText = (EditText) findViewById(R.id.create_description_edittext);
                challengeDescription = descriptionEditText.getText().toString();
                if (challengeDescription.isEmpty() || challengeTitle.isEmpty()) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please fill out all fields";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    // Set phone ID
                    userID = getPhoneID();

                    //Radio Button Handling
                    RadioButton numPointsOne = (RadioButton) findViewById(R.id.numPoints1);
                    RadioButton numPointsTwo = (RadioButton) findViewById(R.id.numPoints2);
                    RadioButton numPointsThree = (RadioButton) findViewById(R.id.numPoints3);
                    RadioButton numPointsFour = (RadioButton) findViewById(R.id.numPoints4);
                    if (numPointsOne.isChecked()) {
                        numPoints = numPointsOne.getText().toString();
                    } else if (numPointsTwo.isChecked()) {
                        numPoints = numPointsTwo.getText().toString();
                    } else if (numPointsThree.isChecked()) {
                        numPoints = numPointsThree.getText().toString();
                    } else if (numPointsFour.isChecked()) {
                        numPoints = numPointsFour.getText().toString();
                    } else
                        numPoints = "2";


                    //Go to _____ Page
                    String url = "http://preview.layer7tech.com:8080/hacks/v1/appstates";
                    AsyncHttpClient client = new AsyncHttpClient();
                    client.setBasicAuth("team1", "1234567");

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("appId", "team1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        jsonObject.put("userId", "user1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONArray arr = new JSONArray();
                    arr.put(userID);
                    arr.put(challengeTitle);
                    arr.put(challengeDescription);
                    arr.put(numPoints);

                    try {
                        jsonObject.put("state", arr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    StringEntity entity = null;
                    try {
                        entity = new StringEntity(jsonObject.toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    //JsonHttpResponseHandler handler = new JsonHttpResponseHandler();
                    Context currContext = getApplicationContext();
                    client.post(currContext, url, entity, "application/json", new AsyncHttpResponseHandler() {
                        @Override
                        //Reload the page
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                            Context context = getApplicationContext();
                            CharSequence text = "Challenge created!";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();


                            Intent gotoCreate = new Intent(getBaseContext(), ActivityCreate.class);
                            startActivity(gotoCreate);

                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                        }
                    });

                }
            }



        });
    }

    private String getPhoneID(){
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String deviceId = deviceUuid.toString();
        return deviceId;
    }

}



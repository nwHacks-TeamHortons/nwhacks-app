package com.teamhortons.nwhacksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                EditText titleEditText = (EditText) findViewById(R.id.create_title_edittext);
                String challenge = create_title_edittext.getText().toString();
                Intent gotoCreate = new Intent(getBaseContext(), ActivityCreate.class);
                startActivity(gotoCreate);
            }
        });
    }
}



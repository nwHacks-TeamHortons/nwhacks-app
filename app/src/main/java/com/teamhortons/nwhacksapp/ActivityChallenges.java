package com.teamhortons.nwhacksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Erica on 2015-03-13.
 */
public class ActivityChallenges extends Activity {

    private boolean shareBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        Button createButton = (Button) findViewById(R.id.shareButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change to a new activity, we do it with "Intents"
                Intent gotoCreate = new Intent(getBaseContext(), ShareDialog.class);
                startActivity(gotoCreate);
            }
        });
    }


}

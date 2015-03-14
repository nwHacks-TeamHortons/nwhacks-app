package com.teamhortons.nwhacksapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createButton = (Button) findViewById(R.id.create_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change to a new activity, we do it with "Intents"
                Intent gotoCreate = new Intent(getBaseContext(), ActivityCreate.class);
                startActivity(gotoCreate);
            }
        });

        Button findButton = (Button) findViewById(R.id.find_button);
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change to a new activity, we do it with "Intents"
                Intent gotoCreate = new Intent(getBaseContext(), ActivityFind.class);
                startActivity(gotoCreate);
            }
        });

        Button aboutButton = (Button) findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change to a new activity, we do it with "Intents"
                Intent gotoCreate = new Intent(getBaseContext(), ActivityAbout.class);
                startActivity(gotoCreate);
            }
        });
        Button challengesButton = (Button) findViewById(R.id.challenges_button);
        challengesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change to a new activity, we do it with "Intents"
                Intent gotoCreate = new Intent(getBaseContext(), ActivityChallenges.class);
                startActivity(gotoCreate);
            }
        });

    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

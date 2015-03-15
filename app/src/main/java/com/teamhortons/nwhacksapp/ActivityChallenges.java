package com.teamhortons.nwhacksapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.completedChallenges);
        ArrayList headers = new ArrayList();
        headers.add("Header 1");
        headers.add("Header 2");

        ArrayList group1 = new ArrayList();
        group1.add("Item 1");
        group1.add("Item 2");

        ArrayList group2 = new ArrayList();
        group2.add("Item 1");
        group2.add("Item 2");

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("Header 1", group1);
        map.put("Header 2", group2);

        ExpandableListAdapter listAdapter = new ExpandableListAdapter(ActivityChallenges.this, headers, map);
        listView.setAdapter(listAdapter);


    }



}

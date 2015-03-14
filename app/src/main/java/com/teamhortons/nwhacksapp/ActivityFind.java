package com.teamhortons.nwhacksapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erica on 2015-03-13.
 */
public class ActivityFind extends Activity {

    private final int DARKGREEN = Color.parseColor("#3D8766");
    private final int DARKGRY = Color.parseColor("#576866");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find);
        SwipeMenuListView listView = (SwipeMenuListView)findViewById(R.id.listView);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Task " + i);
        }
        final CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.list_item, list);
        listView.setAdapter(adapter);
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                //create an action that will be showed on swiping an item in the list

                SwipeMenuItem accept = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                accept.setBackground(new ColorDrawable(DARKGREEN));
                accept.setWidth(200);
                accept.setTitle("Accept");
                accept.setTitleSize(18);
                accept.setTitleColor(Color.WHITE);
                menu.addMenuItem(accept);
            }
        };
        //set MenuCreator
        listView.setMenuCreator(creator);
        // set SwipeListener
        listView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
                // swipe start
            }

            @Override
            public void onSwipeEnd(int position) {
                // swipe end
            }
        });

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String value = adapter.getItem(position);
                switch (index) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Action 1 for " + value, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Action 2 for "+ value , Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }});

    }
}

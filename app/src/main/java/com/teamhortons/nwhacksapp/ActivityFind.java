package com.teamhortons.nwhacksapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.teamhortons.nwhacksapp.com.teamhortons.recycler.Challenge;
import com.teamhortons.nwhacksapp.com.teamhortons.recycler.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ActivityFind extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_find);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FragmentFind())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_find, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class FragmentFind extends Fragment {

        private RecyclerView recyclerView;
        private RecyclerAdapter adapter;

        public FragmentFind() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View layout = inflater.inflate(R.layout.fragment_activity_find, container, false);

            recyclerView = (RecyclerView) layout.findViewById(R.id.challengeList);

            adapter = new RecyclerAdapter(getActivity(), getData());
            recyclerView.setAdapter(adapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            return layout;
        }

        public static List<Challenge> getData() {
            List<Challenge> data = new ArrayList<Challenge>();
            for (int i = 0; i < 20 ; i++) {
                Challenge current = new Challenge();
                current.title = "Nice " + i;
                current.iconid = R.drawable.abc_ic_menu_cut_mtrl_alpha;
                data.add(current);
            }
            return data;
        }
    }
}

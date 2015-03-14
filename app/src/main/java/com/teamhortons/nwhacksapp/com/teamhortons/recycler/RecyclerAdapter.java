package com.teamhortons.nwhacksapp.com.teamhortons.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamhortons.nwhacksapp.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Austin on 3/14/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    private LayoutInflater inflater;
    List<Challenge> data = Collections.emptyList();

    public RecyclerAdapter(Context context, List<Challenge> data) {
       inflater = LayoutInflater.from(context);
       this.data = data;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Challenge current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconid);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView icon;

        public myViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);

        }
    }
}

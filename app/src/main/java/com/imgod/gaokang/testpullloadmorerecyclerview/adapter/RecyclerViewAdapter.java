package com.imgod.gaokang.testpullloadmorerecyclerview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imgod.gaokang.testpullloadmorerecyclerview.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<String> titleList;
    public RecyclerViewAdapter(Activity activity,List<String> titleList) {
        this.activity = activity;
        this.titleList = titleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt_title.setText(titleList.get(position));
    }

    @Override
    public int getItemCount() {
        return titleList==null?0:titleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {     
        TextView txt_title;
        public ViewHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
        }
    }
}
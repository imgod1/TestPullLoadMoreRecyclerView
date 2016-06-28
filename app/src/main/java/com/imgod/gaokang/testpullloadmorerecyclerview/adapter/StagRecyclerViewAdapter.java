package com.imgod.gaokang.testpullloadmorerecyclerview.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.imgod.gaokang.testpullloadmorerecyclerview.R;
import com.imgod.gaokang.testpullloadmorerecyclerview.view.SquareTextView;

import java.util.List;

public class StagRecyclerViewAdapter extends RecyclerView.Adapter<StagRecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<Integer> imgList;
    int width;
    int height;

    public StagRecyclerViewAdapter(Activity activity, List<Integer> imgList) {
        this.activity = activity;
        this.imgList = imgList;

        Resources resources = activity.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density1 = dm.density;
        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stag_recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), imgList.get(position), options);
        int use_height = options.outHeight * width / 2 / options.outWidth;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width / 2, use_height);
//        Log.e("stagadapter","i:"+position+"\theight:"+options.outHeight+"\twidth:"+options.outWidth);
//        Log.e("stagadapter","i:"+position+"\theight:"+use_height+"\twidth:"+width / 2);
        layoutParams.setMargins(5,5,5,5);
        holder.img_main.setLayoutParams(layoutParams);
        holder.img_main.setImageResource(imgList.get(position));
    }

    @Override
    public int getItemCount() {
        return imgList == null ? 0 : imgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_main;

        public ViewHolder(View itemView) {
            super(itemView);
            img_main = (ImageView) itemView.findViewById(R.id.img_main);
        }
    }
}
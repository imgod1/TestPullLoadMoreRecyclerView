package com.imgod.gaokang.testpullloadmorerecyclerview.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.imgod.gaokang.testpullloadmorerecyclerview.R;
import com.imgod.gaokang.testpullloadmorerecyclerview.adapter.RecyclerViewAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：TestPullLoadMoreRecyclerView
 * 包名称：com.imgod.gaokang.testpullloadmorerecyclerview.fragment
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-06-28 13:46
 * 修改人：gaokang
 * 修改时间：2016-06-28 13:46
 * 修改备注：
 */
public class LinearFragment extends BaseRecyclerFragment {
    List<String> titleList;
    RecyclerViewAdapter recyclerViewAdapter;
    CommonAdapter commonAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loadData();
        }
    };
    @Override
    public void initData() {
        initView();
        titleList = new ArrayList<>();
//        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),titleList);
//        pullLoadMoreRecyclerView.setAdapter(recyclerViewAdapter);
        //下面的代码用来测试鸿扬大神的通用adapter库
        commonAdapter = new CommonAdapter<String>(getActivity(), R.layout.recycler_view_item,titleList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                TextView txt_title =  holder.getView(R.id.txt_title);
                txt_title.setText(s);
            }
        };

        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                Toast.makeText(getActivity(), "onItemClick:"+titleList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                Toast.makeText(getActivity(), "onItemLongClick:"+titleList.get(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        pullLoadMoreRecyclerView.setAdapter(commonAdapter);
        pullLoadMoreRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                pullLoadMoreRecyclerView.setRefreshing(true);
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        });
    }

    public void initView(){
        pullLoadMoreRecyclerView.setLinearLayout();
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "onRefresh", Toast.LENGTH_SHORT).show();
                page = 1;
                handler.sendEmptyMessageDelayed(0,3000);
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "onLoadMore", Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        });
    }


    int page = 1;
    private void loadData(){
        if(page==1) {
            titleList.clear();
        }
        for(int i=(page-1)*15;i<page*15;i++) {
            titleList.add("Hello Position:"+i);
        }
        page++;
        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        commonAdapter.notifyDataSetChanged();
//        recyclerViewAdapter.notifyDataSetChanged();
    }
}

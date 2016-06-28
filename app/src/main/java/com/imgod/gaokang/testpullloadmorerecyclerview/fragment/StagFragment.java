package com.imgod.gaokang.testpullloadmorerecyclerview.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.imgod.gaokang.testpullloadmorerecyclerview.R;
import com.imgod.gaokang.testpullloadmorerecyclerview.adapter.GridRecyclerViewAdapter;
import com.imgod.gaokang.testpullloadmorerecyclerview.adapter.StagRecyclerViewAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

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
public class StagFragment extends BaseRecyclerFragment {

    public int[] img_array = {R.drawable.image0, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7};

    List<Integer> titleList;
    StagRecyclerViewAdapter recyclerViewAdapter;
    private Handler handler = new Handler() {
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
        recyclerViewAdapter = new StagRecyclerViewAdapter(getActivity(), titleList);
        pullLoadMoreRecyclerView.setAdapter(recyclerViewAdapter);
        pullLoadMoreRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                pullLoadMoreRecyclerView.setRefreshing(true);
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        });
    }

    public void initView() {
        pullLoadMoreRecyclerView.setStaggeredGridLayout(2);
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "onRefresh", Toast.LENGTH_SHORT).show();
                page = 1;
                handler.sendEmptyMessageDelayed(0, 3000);
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "onLoadMore", Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        });
    }


    int page = 1;

    private void loadData() {
        if (page == 1) {
            titleList.clear();
        }
        for (int i = (page - 1) * 15; i < page * 15; i++) {
            titleList.add(img_array[i%8]);
        }
        page++;
        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        recyclerViewAdapter.notifyDataSetChanged();
    }
}

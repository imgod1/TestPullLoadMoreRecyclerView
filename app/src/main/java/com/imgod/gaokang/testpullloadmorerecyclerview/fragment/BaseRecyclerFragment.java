package com.imgod.gaokang.testpullloadmorerecyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imgod.gaokang.testpullloadmorerecyclerview.R;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

/**
 * 项目名称：TestPullLoadMoreRecyclerView
 * 包名称：com.imgod.gaokang.testpullloadmorerecyclerview.fragment
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-06-28 13:48
 * 修改人：gaokang
 * 修改时间：2016-06-28 13:48
 * 修改备注：
 */
public abstract class BaseRecyclerFragment extends Fragment {
    public View parentView;
    public PullLoadMoreRecyclerView pullLoadMoreRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_base_recycler, container, false);
        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) parentView.findViewById(R.id.pullLoadMoreRecyclerView);
        initData();
        return parentView;
    }

    public abstract void initData();
}

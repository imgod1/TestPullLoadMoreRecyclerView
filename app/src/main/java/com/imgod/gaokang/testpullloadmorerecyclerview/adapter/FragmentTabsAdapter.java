package com.imgod.gaokang.testpullloadmorerecyclerview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 项目名称：TestPullLoadMoreRecyclerView
 * 包名称：com.imgod.gaokang.testpullloadmorerecyclerview.adapter
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-06-28 11:50
 * 修改人：gaokang
 * 修改时间：2016-06-28 11:50
 * 修改备注：
 */
public class FragmentTabsAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;
    public FragmentTabsAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}

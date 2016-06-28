package com.imgod.gaokang.testpullloadmorerecyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.TextView;

import com.imgod.gaokang.testpullloadmorerecyclerview.adapter.FragmentTabsAdapter;
import com.imgod.gaokang.testpullloadmorerecyclerview.fragment.GridFragment;
import com.imgod.gaokang.testpullloadmorerecyclerview.fragment.LinearFragment;
import com.imgod.gaokang.testpullloadmorerecyclerview.fragment.StagFragment;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {
    private FragmentTabsAdapter fragmentTabsAdapter;
    private List<Fragment> fragments;
    private List<String> titles;
    private TabLayout tabs;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();

        fragments.add(new LinearFragment());
        titles.add("Linear");
        fragments.add(new GridFragment());
        titles.add("Grid");
        fragments.add(new StagFragment());
        titles.add("Stag");
        fragmentTabsAdapter = new FragmentTabsAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(fragmentTabsAdapter);
        tabs.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(5);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

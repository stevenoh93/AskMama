package com.stevenoh.reginahong.askmama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class InputPagerActivity extends FragmentActivity {
    private static final String TAG = "InputPagerActivity";
    public ViewPager mViewPager;
    private ArrayList<Fragment> pages = new ArrayList<Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pages.add(new GoalsFragment());
        pages.add(InputFragment.newInstance(1));
        pages.add(InputFragment.newInstance(2));
        pages.add(InputFragment.newInstance(3));
        pages.add(InputFragment.newInstance(4));
        pages.add(new ActiveLevelFragment());
        pages.add(new SuccessPageFragment());


//        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager_input);
        setContentView(mViewPager);

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                return pages.get(i);
            }
            @Override
            public int getCount() { return pages.size(); }
        });


        mViewPager.setCurrentItem(0);
    }
}


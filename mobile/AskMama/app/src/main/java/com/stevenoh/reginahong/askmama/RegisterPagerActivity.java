package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;

public class RegisterPagerActivity extends FragmentActivity {
    private static final String TAG = "RegisterPagerActivity";
    private ViewPager mViewPager;

    private RegisterInfoPage[] mInfos = new RegisterInfoPage[] {
            new RegisterInfoPage(-1, R.drawable.logo),
            new RegisterInfoPage(R.string.register_info_2, -1)
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setContentView(mViewPager);

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                return RegisterFragment.newInstance(i);
            }
            @Override
            public int getCount() { return mInfos.length; }
        });


        mViewPager.setCurrentItem(0);
    }
}

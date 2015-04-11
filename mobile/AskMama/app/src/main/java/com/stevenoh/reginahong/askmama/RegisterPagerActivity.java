package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class RegisterPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private RegisterInfoPage[] mInfos = new RegisterInfoPage[] {
            new RegisterInfoPage(-1, R.drawable.logo),
            new RegisterInfoPage(R.string.register_info_2, -1)
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);


    }
}

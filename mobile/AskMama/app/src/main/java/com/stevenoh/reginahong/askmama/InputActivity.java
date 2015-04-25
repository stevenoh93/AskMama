package com.stevenoh.reginahong.askmama;


import android.support.v4.app.Fragment;

public class InputActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return new InputPagerFragment();
    }
}

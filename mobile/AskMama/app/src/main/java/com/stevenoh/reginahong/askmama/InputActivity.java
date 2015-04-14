package com.stevenoh.reginahong.askmama;


import android.support.v4.app.Fragment;

public class InputActivity extends MultipleFragmentActivity {
    @Override
    protected void addInitialFragment() {
        fragments.add(new GoalsFragment());
    }
}

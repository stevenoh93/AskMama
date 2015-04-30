package com.stevenoh.reginahong.askmama;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class DashboardActivity extends SingleFragmentActivity {
    public static String CALORIE_ADDED = "nutritionmate.addCalorie";

    public Fragment createFragment() {
        Intent intent = getIntent();
        int cal = intent.getIntExtra(CALORIE_ADDED, 0);
        Log.d("DashboardActivity", "cal = " + cal);
        return DashboardFragment.newInstance(cal);
    }
}

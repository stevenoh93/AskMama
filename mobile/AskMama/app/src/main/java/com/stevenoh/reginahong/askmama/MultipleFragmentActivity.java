package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

public abstract class MultipleFragmentActivity extends FragmentActivity {
    protected ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    protected abstract void addInitialFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            addInitialFragment();
            fragment = fragments.get(0);
            manager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    public void changeFragment(int idx) {
        FragmentManager manager = getSupportFragmentManager();
        if (fragments.get(idx) != null) {
            manager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragments.get(idx))
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void addFragment(Fragment frag) {
        fragments.add(frag);
    }
}

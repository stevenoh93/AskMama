package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by stevenoh on 4/25/15.
 */
public class InputPagerFragment extends Fragment {
    private ArrayList<Fragment> pages = new ArrayList<Fragment>();
    private int mPage;
    public ViewPager viewPager;
    public LinearLayout progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pages.add(new GoalsFragment());
        pages.add(InputFragment.newInstance(1));
        pages.add(InputFragment.newInstance(2));
        pages.add(InputFragment.newInstance(3));
        pages.add(InputFragment.newInstance(4));
        pages.add(new ActiveLevelFragment());
        mPage=0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input_holder, parent, false);

        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        // Set progress bar
        progressBar = (LinearLayout) v.findViewById(R.id.progress_bar);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return pages.get(i);
            }
            @Override
            public int getCount() { return pages.size(); }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                MyUtilities.updateProgressBar(progressBar, position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);

        return v;
    }
}

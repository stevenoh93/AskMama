package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActiveLevelFragment extends Fragment {
    private static final String TAG = "ActiveLevelFragment";
    private int mPage = 5;
    private UserProfile mUser = UserProfile.get();
    private LinearLayout levels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater,parent,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_active_level_page, parent, false);

        levels = (LinearLayout) v.findViewById(R.id.active_level_choice_list);
        TextView curTextView;
        curTextView = (TextView) levels.getChildAt(0);
        curTextView.setBackgroundResource(R.color.active01);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(0);
                moveToNextPage(0);
            }
        });

        curTextView = (TextView) levels.getChildAt(1);
        curTextView.setBackgroundResource(R.color.active02);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(1);
                moveToNextPage(1);
            }
        });

        curTextView = (TextView) levels.getChildAt(2);
        curTextView.setBackgroundResource(R.color.active03);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(2);
                moveToNextPage(2);
            }
        });

        curTextView = (TextView) levels.getChildAt(3);
        curTextView.setBackgroundResource(R.color.green);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(3);
                moveToNextPage(3);
            }
        });

        return v;
    }

    private boolean validateInput() {
        Log.d(TAG, mUser.toString());
        return true;
    }

    private void moveToNextPage(int i) {
        if (validateInput()) {
            // Change clicked item color
            levels.getChildAt(i).setBackgroundResource(R.color.dark_green);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getParentFragment().getFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, new SuccessPageFragment())
                            .addToBackStack(null)
                            .commit();
                }
            }, 300);
        }
    }
}

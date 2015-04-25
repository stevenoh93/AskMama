package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater,parent,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_active_level_page, parent, false);

        LinearLayout levels = (LinearLayout) v.findViewById(R.id.active_level_choice_list);
        TextView curTextView;
        curTextView = (TextView) levels.getChildAt(0);

        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(0);
                moveToNextPage();
            }
        });

        curTextView = (TextView) levels.getChildAt(1);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(1);
                moveToNextPage();
            }
        });

        curTextView = (TextView) levels.getChildAt(2);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(2);
                moveToNextPage();
            }
        });

        curTextView = (TextView) levels.getChildAt(3);
        curTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setActiveLevel(3);
                moveToNextPage();
            }
        });

        return v;
    }

    private boolean validateInput() {
        Log.d(TAG, mUser.toString());
        return true;
    }

    private void moveToNextPage() {
        if (validateInput()) {
            getParentFragment().getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new SuccessPageFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}

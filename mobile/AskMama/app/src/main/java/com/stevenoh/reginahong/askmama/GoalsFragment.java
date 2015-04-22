package com.stevenoh.reginahong.askmama;

import android.content.Intent;
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
import android.widget.CompoundButton.OnCheckedChangeListener;


import org.w3c.dom.Text;

public class GoalsFragment extends Fragment {
    private static final String TAG = "GoalsFragment";
    private int mPage = 0;
    private int[] goalText = new int[] {
            R.string.goal_1,
            R.string.goal_2,
            R.string.goal_3,
            R.string.goal_4
    };
    private UserProfile mUser = UserProfile.get();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater,parent,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_goals_page, parent, false);

        // Set progress bar
        MyUtilities.updateProgressBar(v, mPage);

        LinearLayout goals = (LinearLayout) v.findViewById(R.id.fragment_goals_linearLayout);
        for (int i=0; i<goalText.length; i++) {
            RelativeLayout rel = (RelativeLayout) goals.getChildAt(i);
            TextView goal = (TextView) rel.findViewById(R.id.goal_list_item_textView);
            goal.setText(goalText[i]);
            CheckBox box = (CheckBox) rel.findViewById(R.id.goal_list_item_checkbox);
            box.setChecked(mUser.getGoal(i));
            box.setEnabled(true);
            box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int id = ((RelativeLayout) buttonView.getParent()).getId();
                    switch (id) {
                        case R.id.list_item_1:
                            mUser.setGoal(0, isChecked);
                            break;
                        case R.id.list_item_2:
                            mUser.setGoal(1, isChecked);
                            break;
                        case R.id.list_item_3:
                            mUser.setGoal(2, isChecked);
                            break;
                        case R.id.list_item_4:
                            mUser.setGoal(3, isChecked);
                            break;
                    }
                }
            });
        }

        Button nextButton = (Button) v.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(1);
            }
        });

        return v;
    }

    
}

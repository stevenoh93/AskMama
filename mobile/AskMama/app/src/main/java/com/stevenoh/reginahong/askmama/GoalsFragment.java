package com.stevenoh.reginahong.askmama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;



import org.w3c.dom.Text;

public class GoalsFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "GoalsFragment";
    private int mPage = 0;
    private int[] goalText = new int[] {
            R.string.goal_1,
            R.string.goal_2,
            R.string.goal_3,
            R.string.goal_4
    };
    private boolean[] selected = new boolean[] {
            true,
            false,
            false,
            false
    };
    private UserProfile mUser = UserProfile.get();
    private LinearLayout[] goals;
    private LinearLayout unGoals;
    private LinearLayout selGoals;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater,parent,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_goals_page, parent, false);

        unGoals = (LinearLayout) v.findViewById(R.id.unselected_goals_linearlayout);
        selGoals = (LinearLayout) v.findViewById(R.id.selected_goals_linearlayout);
        goals = new LinearLayout[] {
                (LinearLayout) v.findViewById(R.id.list_item_1),
                (LinearLayout) v.findViewById(R.id.list_item_2),
                (LinearLayout) v.findViewById(R.id.list_item_3),
                (LinearLayout) v.findViewById(R.id.list_item_4)
        };

        for (int i=0; i<goalText.length; i++) {
            TextView goalTextView = (TextView) goals[i].findViewById(R.id.goal_list_item_textView);
            goalTextView.setText(goalText[i]);
            ImageButton box = (ImageButton) goals[i].findViewById(R.id.goal_list_item_checkbox);

            if (i==0) {
                box.setImageResource(R.drawable.checkmark);
                goals[i].setBackgroundResource(R.drawable.goal_list_border);
            } else if (i==1) {
                goals[i].setBackgroundResource(R.drawable.goal_list_border);
            } else
                goals[i].setBackgroundResource(R.drawable.goal_list_border_bottom);
            box.setEnabled(true);
            goals[i].setOnClickListener(this);
        }

        Button nextButton = (Button) v.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i<goals.length; i++)
                    mUser.setGoal(i, selected[i]);

                ((InputPagerFragment) getParentFragment()).viewPager.setCurrentItem(1);
            }
        });

        return v;
    }

    public void onClick(View view) {
        LinearLayout parent = (LinearLayout) view;
        ImageButton addButton = (ImageButton) view.findViewById(R.id.goal_list_item_checkbox);
        int id = parent.getId();
        int index = 0;
        switch (id) {
            case R.id.list_item_1:
                index=0;
                break;
            case R.id.list_item_2:
                index=1;
                break;
            case R.id.list_item_3:
                index=2;
                break;
            case R.id.list_item_4:
                index=3;
                break;
        }
        LayoutParams params;

        if (selected[index]) {
            selected[index] = false;
            selGoals.removeView(parent);
            unGoals.addView(parent);
            parent.setBackgroundResource(R.drawable.goal_list_border_bottom);
            if (selGoals.getChildCount() > 1)
                selGoals.getChildAt(1).setBackgroundResource(R.drawable.goal_list_border);
            addButton.setImageResource(R.drawable.plus_orange);
            params = (LayoutParams) selGoals.getLayoutParams();
            params.weight -= .15;
            selGoals.setLayoutParams(params);
            params = (LayoutParams) unGoals.getLayoutParams();
            params.weight += .15;
            unGoals.setLayoutParams(params);
        } else {
            selected[index] = true;
            unGoals.removeView(parent);
            selGoals.addView(parent);
            parent.setBackgroundResource(R.drawable.goal_list_border_bottom);
            if (unGoals.getChildCount() > 1)
                unGoals.getChildAt(1).setBackgroundResource(R.drawable.goal_list_border);
            addButton.setImageResource(R.drawable.checkmark);
            params = (LayoutParams) selGoals.getLayoutParams();
            params.weight += .15;
            selGoals.setLayoutParams(params);
            params = (LayoutParams) unGoals.getLayoutParams();
            params.weight -= .15;
            unGoals.setLayoutParams(params);
        }
    }

    
}


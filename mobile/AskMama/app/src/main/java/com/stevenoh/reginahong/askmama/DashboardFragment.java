package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DashboardFragment extends Fragment{
    public static final String CALORIE_TAG = "nutritionmate.dashboardfragment.calorie";

    private ImageView daily;
    private ImageView weekly;
    private ImageView profile;
    private UserProfile mUser = UserProfile.get();
    private boolean fromSuggestion;
    private RecyclerView recList;

    private DashboardAdapter dailyda;
    private DashboardAdapter weeklyda;

    public static DashboardFragment newInstance(int cal) {
        DashboardFragment dash = new DashboardFragment();

        Bundle args = new Bundle();
        args.putInt(CALORIE_TAG, cal);
        dash.setArguments(args);
        return dash;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DashboardFragment", "Argument = " + getArguments().getInt(CALORIE_TAG));
        if (getArguments().getInt(CALORIE_TAG) > 0) {
            mUser.addCalorieConsumed(getArguments().getInt(CALORIE_TAG));
            fromSuggestion = true;
        }
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dashboard, parent, false);

        recList = (RecyclerView) v.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        dailyda = new DashboardAdapter(fromSuggestion, 0);
        recList.setAdapter(dailyda);

        daily = (ImageView) v.findViewById(R.id.daily_button);
        weekly = (ImageView) v.findViewById(R.id.weekly_button);
        profile = (ImageView) v.findViewById(R.id.profile_button);

        ((LinearLayout) daily.getParent()).setBackgroundResource(R.color.green);
        daily.setImageResource(R.drawable.icon_white_02);
        daily.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (dailyda == null)
                    dailyda = new DashboardAdapter(fromSuggestion, 0);
                recList.setAdapter(dailyda);
                daily.setImageResource(R.drawable.icon_white_02);
                weekly.setImageResource(R.drawable.icon_green_03);
                profile.setImageResource(R.drawable.icon_green_01);
                ((LinearLayout) daily.getParent()).setBackgroundResource(R.color.green);
                ((LinearLayout) weekly.getParent()).setBackgroundResource(R.color.white);
                ((LinearLayout) profile.getParent()).setBackgroundResource(R.color.white);
            }
        });
        ((LinearLayout) weekly.getParent()).setBackgroundResource(R.color.white);
        weekly.setImageResource(R.drawable.icon_green_03);
        weekly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (weeklyda == null)
                    weeklyda = new DashboardAdapter(fromSuggestion, 1);
                recList.setAdapter(weeklyda);
                daily.setImageResource(R.drawable.icon_green_02);
                weekly.setImageResource(R.drawable.icon_white_03);
                profile.setImageResource(R.drawable.icon_green_01);
                ((LinearLayout) daily.getParent()).setBackgroundResource(R.color.white);
                ((LinearLayout) weekly.getParent()).setBackgroundResource(R.color.green);
                ((LinearLayout) profile.getParent()).setBackgroundResource(R.color.white);
            }
        });
        ((LinearLayout) profile.getParent()).setBackgroundResource(R.color.white);
        profile.setImageResource(R.drawable.icon_green_01);
        return v;
    }
}


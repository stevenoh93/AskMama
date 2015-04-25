package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DashboardFragment extends Fragment{
    private ImageView daily;
    private ImageView weekly;
    private ImageView profile;
    private UserProfile mUser = UserProfile.get();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dashboard, parent, false);

        RecyclerView recList = (RecyclerView) v.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        DashboardAdapter da = new DashboardAdapter();
        recList.setAdapter(da);

        daily = (ImageView) v.findViewById(R.id.daily_button);
        weekly = (ImageView) v.findViewById(R.id.weekly_button);
        profile = (ImageView) v.findViewById(R.id.profile_button);

        daily.setBackgroundResource(R.color.green);
        daily.setImageResource(R.drawable.icon_white_02);
        weekly.setBackgroundResource(R.color.white);
        weekly.setImageResource(R.drawable.icon_green_03);
        profile.setBackgroundResource(R.color.white);
        profile.setImageResource(R.drawable.icon_green_01);
        return v;
    }
}

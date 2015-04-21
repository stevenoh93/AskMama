package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SuccessPageFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_success_page, parent, false);

        Button startButton = (Button) v.findViewById(R.id.success_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start dashboard
            }
        });

        TextView message = (TextView) v.findViewById(R.id.success_message);
        UserProfile up = UserProfile.get();
        message.setText(String.format(getResources().getString(R.string.success_message), up.getDailyNetCalorie()));

        return v;
    }
}

package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterFragment extends Fragment {
    public static final String EXTRA_INFO_PAGE = "askmama.page";
    private static final String TAG = "RegisterFragmet";
    private int mPage = 0;

    public static RegisterFragment newInstance(int idx) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_INFO_PAGE, idx);

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            mPage = getArguments().getInt(EXTRA_INFO_PAGE);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_info, parent, false);

        ImageView logo = (ImageView) v.findViewById(R.id.logo_image);
        TextView textView = (TextView) v.findViewById(R.id.register_textview);
        Button leftCircle = (Button) v.findViewById(R.id.progress_circle1);
        Button rightCircle = (Button) v.findViewById(R.id.progress_circle2);
        switch (mPage) {
            case 0:
                Log.d(TAG, "Case 0 selected");
                logo.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                leftCircle.setBackgroundResource(R.drawable.progress_circle_selected);
                rightCircle.setBackgroundResource(R.drawable.progress_circle);
                break;
            case 1:
                Log.d(TAG, "Case 1 selected");
                logo.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                leftCircle.setBackgroundResource(R.drawable.progress_circle);
                rightCircle.setBackgroundResource(R.drawable.progress_circle_selected);
                break;
        }

        return v;
    }


}

package com.stevenoh.reginahong.askmama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

public class InputFragment extends Fragment {
    private static final String EXTRA_INPUT_PAGE = "askmama.inputPage";
    private int mPage;
    private UserProfile mUser;

    private ImageView imageView;
    private Button nextButton;
    private EditText text;


    public static InputFragment newInstance(int idx) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_INPUT_PAGE, idx);
        InputFragment fragment = new InputFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(EXTRA_INPUT_PAGE);
        mUser = UserProfile.get();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input_page, parent, false);

        // set background color
        // set progress bar
        // set which image to display
        // set button color
        // set text

        MyUtilities.updateProgressBar(v, mPage);
        imageView = (ImageView) v.findViewById(R.id.input_image_view);
        nextButton = (Button) v.findViewById(R.id.input_next_button);
        text = (EditText) v.findViewById(R.id.input_edit_text);
        switch (mPage) {
            case 1:
                // Set imageview source
                text.setText(R.string.input_height);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setHeight(Double.parseDouble(text.getText().toString()));
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_height, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(2);
                    }
                });
                break;
            case 2:
                break;
            case 3:
                break;
        }

        return v;

    }
}

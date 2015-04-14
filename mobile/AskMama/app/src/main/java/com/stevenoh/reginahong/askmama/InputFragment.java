package com.stevenoh.reginahong.askmama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.zip.Inflater;

public class InputFragment extends Fragment {
    private static final String EXTRA_INPUT_PAGE = "askmama.inputPage";
    private int mPage;
    private UserProfile mUser;

    private TextView question;
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
        // set question
        // set which image to display
        // set button color
        // set text

        MyUtilities.updateProgressBar(v, mPage);
        question = (TextView) v.findViewById(R.id.input_question_textView);
        imageView = (ImageView) v.findViewById(R.id.input_image_view);
        nextButton = (Button) v.findViewById(R.id.input_next_button);
        text = (EditText) v.findViewById(R.id.input_edit_text);
        switch (mPage) {
            case 1:
                // Set imageview source
                // Set button color
                question.setText(R.string.question_height);
                text.setHint(R.string.input_height);
                text.setInputType(InputType.TYPE_CLASS_NUMBER);
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
                // Set imageview source
                // Set button color
                question.setText(R.string.question_weight);
                text.setHint(R.string.input_weight);
                text.setInputType(InputType.TYPE_CLASS_NUMBER);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setWeight(Double.parseDouble(text.getText().toString()));
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_weight, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(3);
                    }
                });
                break;
            case 3:
                // Set imageview source
                // Set button color
                // Change to date picker fragment later
                question.setText(R.string.question_dob);
                text.setHint(R.string.input_dob);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setDob(new Date(text.getText().toString()));
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_dob, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(3);
                    }
                });
                break;
        }

        return v;

    }
}

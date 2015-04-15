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

    private TextView mQuestion;
    private ImageView mImageView;
    private Button mNextButton;
    private EditText nText;


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
        mQuestion = (TextView) v.findViewById(R.id.input_question_textView);
        mImageView = (ImageView) v.findViewById(R.id.input_image_view);
        mNextButton = (Button) v.findViewById(R.id.input_next_button);
        nText = (EditText) v.findViewById(R.id.input_edit_text);
        switch (mPage) {
            case 1:
                // Set imageview source
                // Set button color
                mQuestion.setText(R.string.question_height);
                nText.setHint(R.string.input_height);
                nText.setInputType(InputType.TYPE_CLASS_NUMBER);
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setHeight(Double.parseDouble(nText.getText().toString()));
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
                mQuestion.setText(R.string.question_weight);
                nText.setHint(R.string.input_weight);
                nText.setInputType(InputType.TYPE_CLASS_NUMBER);
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setWeight(Double.parseDouble(nText.getText().toString()));
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
                mQuestion.setText(R.string.question_dob);
                nText.setHint(R.string.input_dob);
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setDob(new Date(nText.getText().toString()));
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_dob, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(4);
                    }
                });
                break;
            case 4:
                // Set male female image view source, female selected by default
                mQuestion.setText(R.string.question_sex);
                nText.setVisibility(View.GONE);
                mNextButton.setVisibility(View.GONE);
                mImageView.setVisibility(View.GONE);
                LinearLayout maleFemaleImage = (LinearLayout) v.findViewById(R.id.input_maleFemalePage_LinearLayout);
                maleFemaleImage.setVisibility(View.VISIBLE);
                // Female image
                ((ImageView) maleFemaleImage.getChildAt(0)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        mUser.setMale(false);
                        // change image to selected
                        ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(5);
                    }
                });
                // Male image
                ((ImageView) maleFemaleImage.getChildAt(1)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        mUser.setMale(true);
                        // change image to selected
                        ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(5);
                    }
                });
                break;
            case 5:
                break;
        }

        return v;

    }
}

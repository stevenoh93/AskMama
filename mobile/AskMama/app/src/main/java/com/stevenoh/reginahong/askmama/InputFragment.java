package com.stevenoh.reginahong.askmama;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;
import android.app.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;
import java.util.zip.Inflater;

public class InputFragment extends Fragment {

    private static final String EXTRA_INPUT_PAGE = "askmama.inputPage";
    private static final int DATE_PICKER_DIALOG_ID = 999;
    private static final String TAG = "InputFragment";
    private static final int DIALOG_FRAGMENT = 102;
    public static final String DOB_TAG = "nutrimate.dobtag";

    private int mPage;
    private UserProfile mUser;

    private TextView mQuestion;
    private ImageView mImageView;
    private Button mNextButton;
    private EditText mText;
    private ImageView male;
    private ImageView female;


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
        setRetainInstance(true);
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
        mText = (EditText) v.findViewById(R.id.input_edit_text);
        switch (mPage) {
            case 1:
                // Set imageview source
                // Set button color
                mQuestion.setText(R.string.question_height);
                mText.setHint(R.string.input_height);
                mText.setInputType(InputType.TYPE_CLASS_NUMBER);
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setHeight(Double.parseDouble(mText.getText().toString()));
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_height, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(2);
                    }
                });
                mImageView.setImageResource(R.drawable.gingerman_height);
                break;
            case 2:
                // Set imageview source
                // Set button color
                mQuestion.setText(R.string.question_weight);
                mText.setHint(R.string.input_weight);
                mText.setInputType(InputType.TYPE_CLASS_NUMBER);
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setWeight(Double.parseDouble(mText.getText().toString()));
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_weight, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(3);
                    }
                });
                mImageView.setImageResource(R.drawable.gingerman_weight);
                break;
            case 3:
                // Set imageview source
                // Set button color
                mQuestion.setText(R.string.question_dob);
                mText.setHint(R.string.input_dob);
                mText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DialogFragment dialog = new DatePickerFragment();
                        dialog.setTargetFragment(InputFragment.this, DIALOG_FRAGMENT);
                        dialog.show(getFragmentManager(), "DatePicker");
                    }
                });
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        boolean set = false;
                        try {
                            mUser.setDob(mText.getText().toString());
                            if (mText.length() == 0)
                                throw new Exception();
                            set = true;
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), R.string.error_dob, Toast.LENGTH_SHORT).show();
                        }
                        if (set)
                            ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(4);
                    }
                });
                mImageView.setImageResource(R.drawable.birthday);
                break;
            case 4:
                // Set male female image view source, female selected by default
                mQuestion.setText(R.string.question_sex);
                mText.setVisibility(View.GONE);
                mNextButton.setVisibility(View.GONE);
                mImageView.setVisibility(View.GONE);
                LinearLayout maleFemaleImage = (LinearLayout) v.findViewById(R.id.input_gender_linearlayout);
                maleFemaleImage.setVisibility(View.VISIBLE);
                female = (ImageView) v.findViewById(R.id.input_female_image);
                male = (ImageView) v.findViewById(R.id.input_male_image);
                // Female image
                female.setImageResource(R.drawable.female);
                female.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        mUser.setMale(false);
                        female.setBackgroundResource(R.color.gray);
                        ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(5);
                    }
                });
                // Male image
                male.setImageResource(R.drawable.male);
                male.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        mUser.setMale(true);
                        male.setBackgroundResource(R.color.gray);
                        ((InputPagerActivity) getActivity()).mViewPager.setCurrentItem(5);
                    }
                });
                break;
        }

        return v;
    }

    public void onDateChanged(String data) {
        Log.d(TAG, "ActivityResult called: " + data);
        mText.setText(data);
    }


}

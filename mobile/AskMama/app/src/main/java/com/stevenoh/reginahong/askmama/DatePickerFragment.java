package com.stevenoh.reginahong.askmama;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static final String TAG = "DatePickerFragment";

    private UserProfile mUser = UserProfile.get();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceStates) {
//        if (id == DATE_PICKER_DIALOG_ID) {
        Calendar cal = Calendar.getInstance();
        return new DatePickerDialog(getActivity(), this, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
//        }
//        return null;
    }

    @Override
    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
        String sDate = (arg2+1) + "/" + arg3 + "/" + arg1;
        mUser.setDob(sDate);
        Log.d(TAG, "DOB set to " + sDate);
        Intent i = new Intent();
        i.putExtra(InputFragment.DOB_TAG, sDate);
        ((InputFragment) getTargetFragment()).onDateChanged(sDate);
    }
}

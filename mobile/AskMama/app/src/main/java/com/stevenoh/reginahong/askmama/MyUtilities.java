package com.stevenoh.reginahong.askmama;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyUtilities {
    public static void updateProgressBar(View view, int page) {
        LinearLayout progressBar = (LinearLayout) view.findViewById(R.id.progress_bar);
        for (int i=0; i<=page; i++) {
            progressBar.getChildAt(i).setBackgroundResource(R.color.white);
        }
    }
}

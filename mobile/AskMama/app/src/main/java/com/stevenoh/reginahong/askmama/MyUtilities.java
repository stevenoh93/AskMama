package com.stevenoh.reginahong.askmama;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyUtilities {
    public static void updateProgressBar(LinearLayout progressBar, int page) {
//        LinearLayout progressBar = (LinearLayout) view.findViewById(R.id.progress_bar);
        for (int i=0; i<=page; i++) {
            progressBar.getChildAt(i).setBackgroundResource(R.drawable.progress_bar_selected);
        }
        for (int i=page+1; i<progressBar.getChildCount(); i++)
            progressBar.getChildAt(i).setBackgroundResource(R.drawable.progress_bar);
    }
}

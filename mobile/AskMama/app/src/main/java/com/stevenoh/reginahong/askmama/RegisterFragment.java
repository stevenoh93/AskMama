package com.stevenoh.reginahong.askmama;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        LinearLayout registerPage = (LinearLayout) v.findViewById(R.id.register_page);
        ImageView logoText = (ImageView) v.findViewById(R.id.logo_text);
        ImageView logo = (ImageView) v.findViewById(R.id.logo_image);
        TextView textView = (TextView) v.findViewById(R.id.register_textview);
        LinearLayout progressCircle = (LinearLayout) v.findViewById(R.id.progress_circle);
        Button registerButton = (Button) v.findViewById(R.id.register_button);
        // Change text view if more pages are to be added.
        switch (mPage) {
            case 0:
                Log.d(TAG, "Case 0 selected");
                registerPage.setBackgroundResource(R.color.white);
                logo.setVisibility(View.VISIBLE);
                logoText.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                progressCircle.setVisibility(View.GONE);
                registerButton.setBackgroundResource(R.drawable.start_red);
                break;
            case 1:
                Log.d(TAG, "Case 1 selected");
                registerPage.setBackgroundResource(R.color.green);
                logo.setVisibility(View.GONE);
                logoText.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                progressCircle.setVisibility(View.VISIBLE);
                registerButton.setBackgroundResource(R.drawable.start_white);
                break;
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InputPagerActivity.class);
                startActivity(i);
            }
        });

        // This code is for testing notification. To be removed
        Button notiButton = (Button) v.findViewById(R.id.notification_start_button);
        notiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createNotification();
            }
        });

        return v;
    }

    private void createNotification() {
        Intent intent = new Intent(getActivity(), NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);

        Uri alarmsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification noti = new Notification.Builder(getActivity())
                .setContentTitle(getResources().getString(R.string.notification_title))
                .setContentText(getResources().getString(R.string.notification_content))
                .setContentIntent(pIntent)
                .setSmallIcon(R.drawable.info)
                .setSound(alarmsound)
                .setAutoCancel(true)
                .build();

        NotificationManager notiManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
//        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notiManager.notify(0, noti);
        Log.d(TAG,"Notification pressed");
    }

}

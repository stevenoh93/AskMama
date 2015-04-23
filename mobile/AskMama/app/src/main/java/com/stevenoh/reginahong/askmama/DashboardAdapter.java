package com.stevenoh.reginahong.askmama;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DashboardCard> cards;

    public DashboardAdapter() {
        cards = new ArrayList<DashboardCard>();
        cards.add(new DashboardCard());
        cards.add(new DashboardCard());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int i) {
        DashboardCard curCard = cards.get(i);
        Log.d("DashboardAdapter", "index at onBindViewHolder is " + i);
        switch (i) {
            case 0:
                Calendar c = Calendar.getInstance();
                CardHolder0 holder = (CardHolder0) h;
                holder.headerTextView.setText(R.string.card_header_text);
                holder.month.setText(new DateFormatSymbols().getMonths()[c.get(Calendar.MONTH)]);
                holder.dayOfMonth.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
                break;
            case 1:
//                try {
                    CardHolder1 holder1 = (CardHolder1) h;
                    holder1.cardTitle.setText(R.string.second_card_title);
                    holder1.cardContent.setText(R.string.second_card_content);
                    break;
//                } catch (Exception e) {
//                    break;
//                }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = null;
        Log.d("DashboardAdapter", "index at onCreateViewHolder is " + i);
        switch (i) {
            case 0:
                itemView = LayoutInflater.
                        from(viewGroup.getContext()).
                        inflate(R.layout.dashboard_header_card, viewGroup, false);
                return new CardHolder0(itemView);
            case 1:
                itemView = LayoutInflater.
                        from(viewGroup.getContext()).
                        inflate(R.layout.general_card, viewGroup, false);
                return new CardHolder1(itemView);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class CardHolder0 extends RecyclerView.ViewHolder {
        protected TextView dayOfMonth;
        protected TextView month;
        protected TextView headerTextView;


        public CardHolder0(View v) {
            super(v);
            dayOfMonth = (TextView) v.findViewById(R.id.day_of_month);
            month = (TextView) v.findViewById(R.id.month);
            headerTextView = (TextView) v.findViewById(R.id.header_textview);


        }
    }

    public static class CardHolder1 extends RecyclerView.ViewHolder {
        protected TextView cardTitle;
        protected TextView cardContent;

        public CardHolder1(View v) {
            super(v);
            cardTitle = (TextView) v.findViewById(R.id.card_title_textview);
            cardContent = (TextView) v.findViewById(R.id.card_content_textview);
        }
    }
}

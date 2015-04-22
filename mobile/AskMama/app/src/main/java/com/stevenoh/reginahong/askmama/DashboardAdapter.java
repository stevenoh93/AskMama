package com.stevenoh.reginahong.askmama;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.CardHolder> {

    private ArrayList<DashboardCard> cards;

    public DashboardAdapter() {
        cards = new ArrayList<DashboardCard>();
        cards.add(new DashboardCard());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int i) {
        Calendar c = Calendar.getInstance();

        DashboardCard curCard = cards.get(i);
        holder.headerTextView.setText(R.string.card_header_text);
        holder.month.setText(Integer.toString(c.get(Calendar.MONTH)+1));
        holder.dayOfMonth.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                            from(viewGroup.getContext()).
                            inflate(R.layout.dashboard_header_card, viewGroup, false);

        return new CardHolder(itemView);
    }

    public static class CardHolder extends RecyclerView.ViewHolder {
        protected TextView dayOfMonth;
        protected TextView month;
        protected TextView headerTextView;

        public CardHolder(View v) {
            super(v);
            dayOfMonth = (TextView) v.findViewById(R.id.day_of_month);
            month = (TextView) v.findViewById(R.id.month);
            headerTextView = (TextView) v.findViewById(R.id.header_textview);
        }
    }
}

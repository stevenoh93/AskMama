package com.stevenoh.reginahong.askmama;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;

public class DashboardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DashboardCard> cards;
    private int suggestionIdx;
//    private static CardHolder0 holder;
//    private static CardHolder1 holder1;
//    private static CardHolder2 holder2;
    private static CardHolder3 holder3;
    private boolean fromSuggestion;
    private int page;


    public DashboardAdapter(boolean fs, int p) {
        cards = new ArrayList<DashboardCard>();
        page = p;
        switch (p) {
            case 0:
                cards.add(new DashboardCard());
                cards.add(new DashboardCard());
                cards.add(new DashboardCard());
                cards.add(new DashboardCard());
                fromSuggestion = fs;
                break;
            case 1:
                cards.add(new DashboardCard());
                cards.add(new DashboardCard());
                cards.add(new DashboardCard());
                break;
            case 2:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int i) {
        switch (page) {
            case 0:
                bindDailyDashboard(h, i);
                break;
            case 1:
                bindWeeklyDashboard(h, i);
                break;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = null;
        switch (page) {
            case 0:
                switch (i) {
                    case 0:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.dashboard_header_card, viewGroup, false);
                        return new CardHolder0(itemView);
                    case 1:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.calorie_progress_card, viewGroup, false);
                        return new CardHolder1(itemView);
                    case 2:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.general_card, viewGroup, false);
                        return new CardHolder2(itemView);
                    case 3:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.image_suggestion_card, viewGroup, false);
                        return new CardHolder3(itemView);
                }
                break;
            case 1:
                switch (i) {
                    case 0:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.dashboard_header_card, viewGroup, false);
                        return new CardHolder0(itemView);
                    case 1:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.image_card, viewGroup, false);
                        return new CardHolder(itemView);
                    case 2:
                        itemView = LayoutInflater.
                                from(viewGroup.getContext()).
                                inflate(R.layout.titled_image_card, viewGroup, false);
                        return new CardHolder(itemView);
                }
                break;
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    private void bindDailyDashboard(RecyclerView.ViewHolder h, int i) {
        switch (i) {
            case 0: // Header card
                Calendar c = Calendar.getInstance();
                CardHolder0 holder = (CardHolder0) h;
                holder.headerTextView.setText(R.string.card_header_text);
                holder.month.setText(new DateFormatSymbols().getMonths()[c.get(Calendar.MONTH)]);
                holder.dayOfMonth.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
                break;
            case 1: // Calorie counter card
                CardHolder1 holder1 = (CardHolder1) h;
                holder1.cardTitle.setText(R.string.calorie_counter_title);
                holder1.cardContent.setText(R.string.calorie_counter_content);
                if (fromSuggestion)
                    holder1.progressBar.setImageResource(R.drawable.daily_progress);
                else
                    holder1.progressBar.setImageResource(R.drawable.empty_calorie);
                holder1.addCalorie.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                    }
                });
                break;
            case 2:
                CardHolder2 holder2 = (CardHolder2) h;
                holder2.cardTitle.setText(R.string.nutrition_check_title);
                holder2.cardContent.setText(R.string.nutrition_check_content);
                break;
            case 3:
                holder3 = (CardHolder3) h;
                holder3.cardTitle.setText(R.string.suggestion_title);
//                ((BitmapDrawable)holder3.cardContent.getDrawable()).getBitmap().recycle();
                holder3.cardContent.setImageResource(R.drawable.salad_1);
                holder3.nextButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MealImageSuggestion ms = MealImageSuggestion.get();
                        ms.setCurrentIdx((ms.getCurrentIdx() + 1) % ms.getSize());
                        holder3.cardContent.setImageResource(ms.getImageResource());
                    }
                });
        }
    }

    private void bindWeeklyDashboard(RecyclerView.ViewHolder h, int i) {
        if (i == 0) {
            Calendar c = Calendar.getInstance();
            CardHolder0 holder = (CardHolder0) h;
            holder.headerTextView.setText(R.string.card_header_text);
            holder.month.setText(new DateFormatSymbols().getMonths()[c.get(Calendar.MONTH)]);
            holder.dayOfMonth.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)) + "-"
                    + Integer.toString(c.get(Calendar.DAY_OF_MONTH) + 7));
        }
    }

    public static class CardHolder extends RecyclerView.ViewHolder {
        public CardHolder(View v) {
            super(v);
        }
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
        protected ImageView progressBar;
        protected ImageButton addCalorie;

        public CardHolder1(View v) {
            super(v);
            cardTitle = (TextView) v.findViewById(R.id.card_title_textview);
            cardContent = (TextView) v.findViewById(R.id.card_content_textview);
            progressBar = (ImageView) v.findViewById(R.id.daily_progress_bar);
            addCalorie = (ImageButton) v.findViewById(R.id.add_calorie_button);
        }
    }

    public static class CardHolder2 extends RecyclerView.ViewHolder {
        protected TextView cardTitle;
        protected TextView cardContent;

        public CardHolder2(View v) {
            super(v);
            cardTitle = (TextView) v.findViewById(R.id.card_title_textview);
            cardContent = (TextView) v.findViewById(R.id.card_content_textview);
        }
    }

    public static class CardHolder3 extends RecyclerView.ViewHolder {
        protected TextView cardTitle;
        protected ImageView cardContent;
        protected ImageButton nextButton;

        public CardHolder3(View v) {
            super(v);
            cardTitle = (TextView) v.findViewById(R.id.card_title_textview);
            cardContent = (ImageView) v.findViewById(R.id.suggestion_image);
            nextButton = (ImageButton) v.findViewById(R.id.suggestion_next_button);
        }
    }

}


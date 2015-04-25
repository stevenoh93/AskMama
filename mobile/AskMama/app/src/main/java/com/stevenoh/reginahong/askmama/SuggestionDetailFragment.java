package com.stevenoh.reginahong.askmama;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SuggestionDetailFragment extends Fragment {
    public static final String ITEM_NUM = "ItemNubmerTag";
    private MenuItem item;
    private MenuSuggestion ms = MenuSuggestion.get();

    public static SuggestionDetailFragment newInstance(int i) {
        SuggestionDetailFragment frag = new SuggestionDetailFragment();

        Bundle args = new Bundle();
        args.putInt(ITEM_NUM, i);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = ms.getMenu(getArguments().getInt(ITEM_NUM));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_suggestion_page_2, parent, false);

        TextView itemName = (TextView) v.findViewById(R.id.menu_suggestion_title);
        TextView itemIng = (TextView) v.findViewById(R.id.menu_suggestion_ingredients);
        itemName.setText(item.getName());
        itemIng.setText(item.getIngredientsString());

        TextView name, amount, text;
        LinearLayout table = (LinearLayout) v.findViewById(R.id.nutrient_table);
        for (int r=0; r < table.getChildCount(); r++) {
            LinearLayout row = (LinearLayout) table.getChildAt(r);
            Nutrient nut = item.getNutrient(r);
            name = (TextView) row.findViewById(R.id.nutrient_name);
            amount = (TextView) row.findViewById(R.id.nutrient_amount);
            text = (TextView) row.findViewById(R.id.nutrient_text);

            name.setText(nut.name);
            amount.setText(nut.amount+" "+nut.unit);
            text.setText(nut.message);
        }

        ImageButton back = (ImageButton) v.findViewById(R.id.exit_suggestion_button);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        Button inc = (Button) v.findViewById(R.id.next_button);
        inc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DashboardActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}

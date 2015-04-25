package com.stevenoh.reginahong.askmama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SuggestionsFragment extends Fragment {
    private ImageButton exitButton;
    private MenuSuggestion suggestion = MenuSuggestion.get();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add menu for testing
        Nutrient fat = new Nutrient("Total Fat", 21, "g", "Study 30min");
        Nutrient sodium = new Nutrient("Sodium", 1466, "mg", "Pretty High");
        Nutrient carb = new Nutrient("Total Carbs", 42, "g", "It's ok");
        Nutrient protein = new Nutrient("Protein", 44, "g", "Good!");

        MenuItem menu = new MenuItem();
        menu.setName("Chicken Salad");
        menu.setCal(390);
        menu.setPrice(7.85);
        menu.addIngredient("Chicken"); menu.addIngredient("Fajita Vegetables");
        menu.addIngredient("Fresh Tomato Salsa"); menu.addIngredient("Guacamole");
        menu.addIngredient("Romaine Lettuce");
        menu.addNutrient(fat); menu.addNutrient(sodium); menu.addNutrient(carb); menu.addNutrient(protein);
        suggestion.addSuggestion(menu);

        menu = new MenuItem();
        menu.setName("Chicken Tacos(3)");
        menu.setCal(425);
        menu.setPrice(8.50);
        menu.addIngredient("Chicken"); menu.addIngredient("Fresh Tomato Salsa");
        menu.addIngredient("Romaine Lettuce"); menu.addIngredient("Soft Corn Tortilla");
        menu.addNutrient(fat); menu.addNutrient(sodium); menu.addNutrient(carb); menu.addNutrient(protein);
        suggestion.addSuggestion(menu);

        menu = new MenuItem();
        menu.setName("Chicken Burrito Bowl");
        menu.setCal(510);
        menu.setPrice(9.00);
        menu.addIngredient("Chicken"); menu.addIngredient("Fresh Tomato Salsa");
        menu.addIngredient("Romaine Lettuce"); menu.addIngredient("Brown Rice Beans");
        menu.addNutrient(fat); menu.addNutrient(sodium); menu.addNutrient(carb); menu.addNutrient(protein);
        menu.addIngredient("No Flour Tortilla");
        suggestion.addSuggestion(menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_suggestion_page, parent, false);

        LinearLayout item1 = (LinearLayout) v.findViewById(R.id.suggestion_item1);
        LinearLayout item2 = (LinearLayout) v.findViewById(R.id.suggestion_item2);
        LinearLayout item3 = (LinearLayout) v.findViewById(R.id.suggestion_item3);

        ArrayList<MenuItem> menus = suggestion.getMenus();
        MenuItem m = menus.get(0);
        setMenuItemView(item1, m);
        m = menus.get(1);
        setMenuItemView(item2, m);
        m = menus.get(2);
        setMenuItemView(item3, m);

        exitButton = (ImageButton) v.findViewById(R.id.exit_suggestion_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                SuggestionDetailFragment frag = null;

                Log.d("SuggestionsFragment", "view id = " + view.getId());

                switch (view.getId()) {
                    case R.id.suggestion_item1:
                        frag = SuggestionDetailFragment.newInstance(0);
                        break;
                    case R.id.suggestion_item2:
                        frag = SuggestionDetailFragment.newInstance(1);
                        break;
                    case R.id.suggestion_item3:
                        frag = SuggestionDetailFragment.newInstance(2);
                        break;
                }
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, frag)
                        .addToBackStack(null)
                        .commit();
            }
        };
        item1.setOnClickListener(listener);
        item2.setOnClickListener(listener);
        item3.setOnClickListener(listener);
        return v;
    }

    private void setMenuItemView(LinearLayout item, MenuItem m){
        ((TextView) item.findViewById(R.id.menu_suggestion_title)).setText(m.getName());
        ((TextView) item.findViewById(R.id.menu_suggestion_ingredients)).setText(m.getIngredientsString());
        ((TextView) item.findViewById(R.id.menu_suggestion_cal)).setText(m.getCal()+"");
        ((TextView) item.findViewById(R.id.menu_suggestion_price)).setText(String.format("%.2f",m.getPrice()));
    }

}

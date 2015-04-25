package com.stevenoh.reginahong.askmama;

import android.view.MenuInflater;

import java.util.ArrayList;

public class MenuSuggestion {
    private static MenuSuggestion suggestion;

    private ArrayList<MenuItem> menus;

    public static MenuSuggestion get() {
        if (suggestion == null)
            suggestion = new MenuSuggestion();

        return suggestion;
    }

    private MenuSuggestion() {
        menus = new ArrayList<MenuItem>();
    }

    public void addSuggestion(MenuItem m) {
        menus.add(m);
    }

    public ArrayList<MenuItem> getMenus() {
        return menus;
    }

    public MenuItem getMenu(int i) {
        return menus.get(i);
    }
}

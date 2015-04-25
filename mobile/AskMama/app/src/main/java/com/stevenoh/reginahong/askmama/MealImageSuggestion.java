package com.stevenoh.reginahong.askmama;

import java.util.ArrayList;

public class MealImageSuggestion {
    private static MealImageSuggestion sSuggestion;

    private ArrayList<Integer> images;
    private int currentIdx;

    public static MealImageSuggestion get(){
        if (sSuggestion == null)
            sSuggestion = new MealImageSuggestion();
        return sSuggestion;
    }

    private MealImageSuggestion() {
        images = new ArrayList<Integer>();

        images.add(R.drawable.salad_1);
        images.add(R.drawable.salad_2);
    }

    public void addImages(int newId) {
        images.add(newId);
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public int getImageResource() {
        return images.get(currentIdx);
    }

    public int getCurrentIdx() {
        return currentIdx;
    }

    public void setCurrentIdx(int i) {
        currentIdx = i;
    }

    public int getSize() {
        return images.size();
    }
}

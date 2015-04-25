package com.stevenoh.reginahong.askmama;

import java.util.ArrayList;

public class MenuItem {
    private String name;
    private ArrayList<String> ingredients;
    private int cal;
    private double price;
    private ArrayList<Nutrient> nutrients;

    public MenuItem() {
        ingredients = new ArrayList<String>();
        nutrients = new ArrayList<Nutrient>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getCal() {
        return cal;
    }

    public double getPrice() {
        return price;
    }

    public String getIngredientsString() {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<ingredients.size()-1; i++) {
            builder.append(ingredients.get(i));
            builder.append(", ");
        }
        builder.append(ingredients.get(ingredients.size()-1));
        return builder.toString();
    }

    public Nutrient getNutrient(int i) {
        return nutrients.get(i);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIngredient(String ing) {
        ingredients.add(ing);
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIngredients(ArrayList<String> ing) {
        ingredients = ing;
    }

    public void addNutrient(Nutrient n) {
        nutrients.add(n);
    }
}

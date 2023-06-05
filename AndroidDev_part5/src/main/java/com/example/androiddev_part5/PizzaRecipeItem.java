package com.example.androiddev_part5;

public class PizzaRecipeItem   {


    private final int imageResourse;
    private final String title;
    private final String description;

    private final String recipe;


    public PizzaRecipeItem(int imageResourse, String title, String description,String recipe) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.description = description;
        this.recipe = recipe;
    }


    public int getImageResourse() {
        return imageResourse;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public String getRecipe() {
        return recipe;
    }

}

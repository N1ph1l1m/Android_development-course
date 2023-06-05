package com.example.androiddev_part5;

public class PizzaRecipeItem   {

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PizzaRecipeItem(int imageResourse, String title, String description) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.description = description;
    }

    private int imageResourse;
    private  String title;
    private String description;

}

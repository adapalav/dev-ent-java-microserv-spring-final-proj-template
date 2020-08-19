package com.hinkmond.finalproj;


public class AddMenuItem {
    private String dishName;
    private String dishType;
    private String description;
    private Float dishPrice;

    public String getDishName() {
        return dishName;
    }
    public void setDishNameName(String dishName) {
        this.dishName = dishName;
    }
    public String getDishType() {
        return dishType;
    }
    public void setDishType(String dishType) {
        this.dishType = dishType;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }
    public Float getDishPrice() {
        return dishPrice;
    }

}
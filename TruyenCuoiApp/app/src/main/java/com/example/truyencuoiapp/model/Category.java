package com.example.truyencuoiapp.model;

public class Category {
    private int idCategory;
    private String nameCategory;
    private int imgCategory;

    public Category() {
    }

    public Category(int idCategory, String nameCategory, int imgCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.imgCategory = imgCategory;
    }

    public int getImgCategory() {
        return imgCategory;
    }

    public void setImgCategory(int imgCategory) {
        this.imgCategory = imgCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}

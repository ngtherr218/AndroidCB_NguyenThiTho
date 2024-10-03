package com.example.truyencuoiapp.model;

public class Story {
    private int idStory;
    private int idCategory;
    private String nameStory;
    private String detailStory;

    public Story(int idStory, int idCategory, String nameStory, String detailStory) {
        this.idStory = idStory;
        this.idCategory = idCategory;
        this.nameStory = nameStory;
        this.detailStory = detailStory;
    }

    public Story() {
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public String getDetailStory() {
        return detailStory;
    }

    public void setDetailStory(String detailStory) {
        this.detailStory = detailStory;
    }
}

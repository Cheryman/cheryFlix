package com.example.cheryflix.Models;

public class Movie {

    private String title;
    private String description;
    private int thumbnail;
    private String studio;
    private String rating;
    private int coverImg;

    public Movie(String title, int thumbnail, int coverImg) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverImg = coverImg;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String title, String description, int thumbnail, String studio, String rating) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
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

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(int coverImg) {
        this.coverImg = coverImg;
    }
}
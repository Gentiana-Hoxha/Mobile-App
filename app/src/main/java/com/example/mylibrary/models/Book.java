package com.example.mylibrary.models;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String synopsis;

    public Book(String title, String author, String genre, String synopsis) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

}
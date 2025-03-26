package com.ajackus.library.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class Book {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    long bookId;
    @NotBlank(message = "Title cannot be empty")
    String title;
    @NotBlank(message = "Author cannot be empty")
    String author;
    @NotBlank(message = "Genre cannot be empty")
    String genre;
    boolean isAvailable;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.java8.training.streams;

import java.util.Objects;

public class Movie {

    private String director;

    private String title;

    private String genre;

    private int length;

    public Movie(String director, String title, String genre, int length) {
        this.director = director;
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return length == movie.length &&
                Objects.equals(director, movie.director) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, title, genre, length);
    }
}

package com.java8.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class Videotheque {

    private List<Movie> myMovies = new ArrayList<>();

    public Videotheque() {
        myMovies.add(new Movie("Eastwood", "Sur la route de Madison", "Western", 180));
        myMovies.add(new Movie("Eastwood", "Impitoyable", "Western", 240));
        myMovies.add(new Movie("Eastwood", "Million Dollar Baby", "Drama", 90));
        myMovies.add(new Movie("Tarantino", "Django Unchained", "Western", 180));
        myMovies.add(new Movie("Tarantino", "Reservoir Dogs", "Drama", 90));
        myMovies.add(new Movie("Cohen Brothers", "Burn After Reading", "Comedy", 90));
        myMovies.add(new Movie("Cameron", "Titanic", "Drama", 180));
    }

    /**
     * Returns a list of movies whose length is shorter than the given length
     * @param length
     * @return
     */
    public List<String> getMoviesWithMaxLength(int length) {
        return null;
    }

    /**
     * Returns the total length of movies for a given director
     * @param director
     * @return
     */
    public int getTotalLengthForDirector(String director) {
        return 0;
    }

    /**
     * Orders the movie collection by director name
     * @return
     */
    public Map<String, List<Movie>> sortByDirector() {
        return null;
    }

    /**
     * Returns a Map that keys film genre to a map that keys director names to a list of movi titles
     * @return
     */
    public Map<String, Map<String, List<String>>> sortByGenreAndDirector() {
       return null;
    }


}

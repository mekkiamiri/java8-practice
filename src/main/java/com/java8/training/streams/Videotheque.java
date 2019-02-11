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

    public List<String> getMoviesWithMaxLength(int length) {
        return myMovies.stream()
                .filter(movie -> movie.getLength() <= length)
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }

    public int getTotalLengthForDirector(String director) {
        return myMovies.stream()
                .filter(movie -> director.equals(movie.getDirector()))
                .mapToInt(Movie::getLength)
                .sum();
    }

    public Map<String, List<Movie>> sortByDirector() {
        return myMovies.stream()
                .collect(groupingBy(Movie::getDirector));
    }

    public Map<String, Map<String, List<String>>> sortByGenreAndDirector() {
        return myMovies
                .stream()
                .collect(
                        groupingBy(Movie::getGenre,
                                groupingBy(Movie::getDirector, mapping(Movie::getTitle, Collectors.toList())
                                )));
    }


}

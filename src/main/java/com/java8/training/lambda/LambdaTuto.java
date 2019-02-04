package com.java8.training.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaTuto {

    public List<String> sortLengthBased(List<String> source) {
        List<String> strings = new ArrayList<>(source);
        Collections.sort(strings, Comparator.comparingInt(String::length));
        return strings;
    }

    //use java function package
    //action changes only on 1 field
    public List<Person> updatePersonNames (List<Person> source) {
        List<Person> persons = new ArrayList<>(source);

        Consumer<Person> firstNameConsumer = person -> person.setFirstName(person.getFirstName().toUpperCase());
        Consumer<Person> lastNameConsumer = person -> person.setLastName(person.getLastName().toUpperCase());

        persons.forEach(firstNameConsumer.andThen(lastNameConsumer));
        return persons;
    }

    //use java function package
    //convert to list of integer: length of firstname+lastname
    public List<Integer> convertToNameLengths (List<Person> source) {
        List<Person> persons = new ArrayList<>(source);
        List<Integer> result = new ArrayList<>();

        Function<Person, String> nameFunction = person -> String.join("", person.getFirstName(), person.getLastName());
        Function<String, Integer> nameLengthFunction = String::length;

        persons.forEach(person -> result.add(nameFunction.andThen(nameLengthFunction).apply(person)));

        return result;
    }

    //use java function package
    //convert to map: firstname+lastname, age
    public Map<String, Integer> convertToMapNameAge (List<Person> source) {
        List<Person> persons = new ArrayList<>(source);
        Map<String, Integer> result = new HashMap<>();

        Function<Person, String> nameFunction = person -> String.join("", person.getFirstName(), person.getLastName());
        Function<Person, Integer> nameLengthFunction = Person::getAge;

        persons.forEach(person -> result.put(nameFunction.apply(person), nameLengthFunction.apply(person)));

        return result;
    }



}

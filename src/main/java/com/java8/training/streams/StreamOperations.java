package com.java8.training.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public StreamOperations() {

    }

    /**
     * Produces pairs (array of two elements) of all possible combinations of one element in list and one element in list2
     * @param list1
     * @param list2
     * @return
     */
    public List<int[]> makePairs(List<Integer> list1, List<Integer> list2) {
        return list1
                .stream()
                .flatMap(
                        i -> list2.stream().map(
                                j -> new int[] {i, j}
                        )
                ).collect(Collectors.toList());
    }

    /**
     * Returns the n first fibonnacci tuples of the form "(0,1), (1,1), (1,2), (2,3), (3,5) ..."
     * @param n
     * @return
     */
    public String generateNFibonnacciNumber(int n) {
        return Stream.iterate(new int[]{0,1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(n)
                .map(ints -> Arrays.toString(ints))
                .collect(Collectors.joining(","));

    }
}

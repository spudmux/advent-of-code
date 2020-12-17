package com.spudmux.aoc2020.day10;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JoltageCalculator {

    private static int total = 0;

    public static int calculateAllCombinations(List<String> input) {
        List<Integer> adaptors = input
                .stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        calc(adaptors, 0);
        return total;
    }

    private static void calc(List<Integer> input, int position) {
        if (position == input.size()) {
            total++;
        }
        for (int i = 0; i < input.size(); i++) {
            calc(input, i + 1);
        }
    }

    int[] adaptors;
    private int threeJoltDifferences;
    private int oneJoltDifferences;
    private int highestRatedAdaptor;

    public JoltageCalculator(List<String> input) {
        adaptors = input.stream().map(Integer::parseInt).mapToInt(Integer::intValue).sorted().toArray();
        oneJoltDifferences = 0;
        threeJoltDifferences = 1;
        calculate();
    }

    public int oneByThreeDifferences() {
        return oneJoltDifferences * threeJoltDifferences;
    }

    private void calculate() {
        int previousJoltageRating = 0;
        for (int adaptor : adaptors) {
            if (adaptor > highestRatedAdaptor) {
                highestRatedAdaptor = adaptor;
            }
            if (adaptor - previousJoltageRating == 1) {
                oneJoltDifferences++;
                previousJoltageRating = adaptor;
            } else if (adaptor - previousJoltageRating == 2) {
                previousJoltageRating = adaptor;
            } else if (adaptor - previousJoltageRating == 3) {
                threeJoltDifferences++;
                previousJoltageRating = adaptor;
            } else {
                throw new RuntimeException("adaptor, " + adaptor + ", out of range of previous rating: " + previousJoltageRating);
            }
        }
    }

    public int endRating() {
        return highestRatedAdaptor + 3;
    }
}

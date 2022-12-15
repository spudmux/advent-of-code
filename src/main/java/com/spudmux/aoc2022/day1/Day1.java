package com.spudmux.aoc2022.day1;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
    private final ProblemInput input;

    public Day1(ProblemInput input) {
        this.input = input;
    }

    public int solvePart1() {
        List<String> inputAsListOfLines = input.getInputAsListOfLines();
        System.out.println(inputAsListOfLines);;
        int max  = 0;
        int sum = 0;
        for (int i = 0; i < inputAsListOfLines.size(); i++) {
            var value = inputAsListOfLines.get(i);
            if (!value.isEmpty()) {
                sum += Integer.parseInt(value);
            } else {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            }
        }
        return max;
    }

    public int solvePart2() {
        List<String> inputAsListOfLines = input.getInputAsListOfLines();
        List<Integer> counts = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < inputAsListOfLines.size(); i++) {
            var value = inputAsListOfLines.get(i);
            if (!value.isEmpty()) {
                sum += Integer.parseInt(value);
            } else {
                counts.add(sum);
                sum = 0;
            }
        }
        counts.add(sum);
        counts.sort(Comparator.naturalOrder());
        System.out.println(counts);
        return counts.get(counts.size()-1)+counts.get(counts.size()-2)+counts.get(counts.size()-3);
    }

}

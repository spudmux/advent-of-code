package com.spudmux.aoc2020.day3;

import com.spudmux.aoc2020.ProblemInput;

import java.util.List;

public class TrajectoryCalculator {

    public int getNumberOfTreesEncountered(ProblemInput input) {
        return getNumberOfTreesEncountered(input, 3, 1);
    }

    public int getNumberOfTreesEncountered(ProblemInput input, int right, int down) {
        int countOfTrees = 0, countOfSpaces = 0;
        List<String> course = input.getInputAsListOfLines();
        int j = 0;
        for (int i = 0; i < course.size(); i+=down) {
            String line = course.get(i);
            char place = line.charAt(j);
            if (place == '.') { countOfSpaces++; }
            if (place == '#') { countOfTrees++; }
            j+= right;
            if (j >= line.length()) {
                j = j % line.length();
            }
        }
        return countOfTrees;
    }
}

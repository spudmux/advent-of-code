package com.spudmux.aoc2020;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemInput {

    private final Path classPathResource;
    private final String problemInput;

    public ProblemInput(String problemInput) {
        classPathResource = null;
        this.problemInput = problemInput;
    }

    public ProblemInput(Path inputFilePath) {
        this.classPathResource = inputFilePath;
        this.problemInput = null;
    }

    public int[] getInputAsIntArray() {
        return Arrays.stream(getInputAsString().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public String getInputAsString() {
        if (problemInput != null) {
            return problemInput;
        } else {
            return loadInputFromClassLoader();
        }
    }

    private String loadInputFromClassLoader() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.classPathResource.toString());
        assert inputStream != null;
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

    public List<String> getInputAsListOfLines() {
        return new ArrayList<>(Arrays.asList(getInputAsString().split("\n")));
    }

    public List<Integer> getInputAsListOfInts() {
        List<Integer> integers = this
                .getInputAsListOfLines()
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return integers;
    }

    /**
     * Gets the problem input as a 2D array of integers where each element is < 9.
     *
     * @return an array made up of each character from the input.
     */
    public int[][] getInputAs2DArray() {
        List<String> lines = this.getInputAsListOfLines();
        int[][] array = new int[lines.size()][lines.get(0).length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Arrays.stream(lines.get(i).split("")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }
}
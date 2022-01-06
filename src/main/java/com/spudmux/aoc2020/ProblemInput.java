package com.spudmux.aoc2020;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemInput {

    private String inputFileName;

    public ProblemInput() {
    }

    public ProblemInput(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getInputFileName() {
        assert inputFileName != null;
        return getInputAsString(inputFileName);
    }

    public String getInputAsString() {
        return getInputAsString(this.inputFileName);
    }

    public int[] getInputAsIntArray() {
        return Arrays.stream(getInputAsString().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public String getInputAsString(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        assert inputStream != null;
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

    public List<String> getInputAsListOfLines() {
        assert inputFileName != null;
        return getInputAsListOfLines(inputFileName);
    }

    public List<String> getInputAsListOfLines(String fileName) {
        return new ArrayList<>(Arrays.asList(getInputAsString(fileName).split("\n")));
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
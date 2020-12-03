package com.spudmux.aoc2020;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        return Arrays.asList(getInputAsString(fileName).split("\n"));
    }
}
package com.spudmux.aoc2021.day3;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    private int oxygenRating;
    private int co2Rating;
    private int gammaRate = 0;
    private int epsilonRate = 0;
    List<String> report = new ArrayList<>();
    private final int wordLength;
    private int[] onesCount;
    private int[] zerosCount;

    public Day3(ProblemInput input) {
        report = input.getInputAsListOfLines();
        wordLength = report.get(0).length();
        onesCount = new int[wordLength];
        zerosCount = new int[wordLength];
        oxygenRating = 0;
        co2Rating = 0;
    }

    public void calculatePowerRate() {
        countDigits();
        String gamma = "";
        String epsilon = "";
        for (int i = 0; i < wordLength; i++) {
            if (report.size()-onesCount[i] > onesCount[i]) {
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }
        gammaRate = Integer.parseInt(gamma, 2);
        epsilonRate = Integer.parseInt(epsilon, 2);
    }

    private void countDigits() {
        countDigits(report);
    }
    private void countDigits(List<String> report) {
        zerosCount = new int[wordLength];
        onesCount = new int[wordLength];
        for (String line : report) {
            assert line.length() == wordLength;
            for (int i = 0; i < wordLength; i++) {
                if (line.charAt(i) == '1') {
                    onesCount[i] += 1;
                }
            }
        }
        for (int i = 0; i < wordLength; i++) {
            zerosCount[i] = report.size() - onesCount[i];
        }
    }

    public int getGammaRate() {
        return gammaRate;
    }

    public int getEpsilonRate() {
        return epsilonRate;
    }

    public int getPowerConsumption() {
        return getGammaRate() * getEpsilonRate();
    }

    public int getOxygenRating() {
        return oxygenRating;
    }

    public int getCO2SRating() {
        return co2Rating;
    }

    public int getLifeSupportRating() {
        return getOxygenRating() * getCO2SRating();
    }

    public void calculateLifeSupportRating() {
        countDigits();
        oxygenRating = search(report, 0, '1', '0');
        co2Rating = search(report, 0, '0', '1');

    }

    private int search(List<String> input, int index, char c1, char c2) {
        if (input.size() == 1) {
            return Integer.parseInt(input.get(0), 2);
        }
        if (input.size() < 1 || index >= wordLength) {
            throw new RuntimeException("Unexpected Condition");
        }
        countDigits(input);
        List<String> remaining = new ArrayList<>();
        for (String line : input) {
            char c = line.charAt(index);
            if (onesCount[index] >= zerosCount[index] && c == c1) {
                remaining.add(line);
            } else if (zerosCount[index] > onesCount[index] && c == c2) {
                remaining.add(line);
            }
        }
        return search(remaining, index+1, c1, c2);
    }
}

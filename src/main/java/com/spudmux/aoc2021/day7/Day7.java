package com.spudmux.aoc2021.day7;

import com.spudmux.aoc2020.ProblemInput;

import java.util.Arrays;

public class Day7 {

    private final int[] crabs;

    public Day7(ProblemInput input) {
        crabs = input.getInputAsIntArray();
    }

    public int getLeastFuleUsageSimple() {
        int[] fules = new int[crabs.length];
        for (int i = 0; i < crabs.length; i++) {
            for (int j = 0; j < crabs.length; j++) {
                fules[i] += Math.abs(i - crabs[j]);
            }
        }
        return Arrays.stream(fules).min().getAsInt();
    }

    public int getLeastFuleUsageComplex() {
        int[] fules = new int[crabs.length];
        for (int i = 0; i < crabs.length; i++) {
            for (int j = 0; j < crabs.length; j++) {
                int amount = Math.abs(i - crabs[j]);
                fules[i] += amount * (amount+1)/2;
            }
        }
        return Arrays.stream(fules).min().getAsInt();
    }

}

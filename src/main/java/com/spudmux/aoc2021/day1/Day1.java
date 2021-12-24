package com.spudmux.aoc2021.day1;

import java.util.List;

public class Day1 {

    List<Integer> measurements;

    public Day1(List<Integer> measurements) {
        this.measurements = measurements;
    }

    public int getLargerMeasurements() {
        int result = 0;
        if (measurements.size() < 2) {
            return result;
        }

        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > measurements.get(i - 1)) {
                result++;
            }
        }
        return result;
    }

    public int getLargerPart2() {
        int result = 0;
        if (measurements.size() < 2) {
            return result;
        }

        for (int i = 1; i < measurements.size(); i++) {
            if (i+3 > measurements.size()) {
                return result;
            }
            if (measurements.get(i) + measurements.get(i+1) + measurements.get(i+2)
                    > measurements.get(i - 1) + measurements.get(i) + measurements.get(i +1)) {
                result++;
            }
        }
        return result;
    }
}

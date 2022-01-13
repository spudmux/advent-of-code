package com.spudmux.aoc2021.day1;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class Day1Test {

    @Test
    public void testDay1Part1Sample() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day1-sample-input.txt"));
        int larger = new Day1(input.getInputAsListOfInts()).getLargerMeasurements();
        assertEquals(7, larger);
    }

    @Test
    public void testDay1Part1() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day1-input.txt"));
        int larger = new Day1(input.getInputAsListOfInts()).getLargerMeasurements();
        assertEquals(1832, larger);
    }

    @Test
    public void testDay1Part2Sample() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day1-sample-input.txt"));
        int larger = new Day1(input.getInputAsListOfInts()).getLargerPart2();
        assertEquals(5, larger);
    }


    @Test
    public void testDay1Part2() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day1-input.txt"));
        int larger = new Day1(input.getInputAsListOfInts()).getLargerPart2();
        assertEquals(1858, larger);
    }
}
package com.spudmux.aoc2021.day4;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;


public class Day4Test {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void testDay4Part1Sample() {
        Day4 day4 = new Day4(new ProblemInput("aoc2021/day4-part1-sample-input.txt"));
        day4.calculate();
        softly.assertThat(day4.getFinalScore()).isEqualTo(4512);
    }

    @Test
    public void testDay4Part1() {
        Day4 day4 = new Day4(new ProblemInput("aoc2021/day4-part1-input.txt"));
        day4.calculate();
        softly.assertThat(day4.getFinalScore()).isEqualTo(8442);
    }

    @Test
    public void testDay4Part2Sample() {
        Day4 day4 = new Day4(new ProblemInput("aoc2021/day4-part1-sample-input.txt"));
        day4.calculatePart2();
        softly.assertThat(day4.getFinalScore()).isEqualTo(1924);
    }

    @Test
    public void testDay4Part2() {
        Day4 day4 = new Day4(new ProblemInput("aoc2021/day4-part1-input.txt"));
        day4.calculatePart2();
        softly.assertThat(day4.getFinalScore()).isEqualTo(4590);
    }
}
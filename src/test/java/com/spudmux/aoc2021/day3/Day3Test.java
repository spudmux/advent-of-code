package com.spudmux.aoc2021.day3;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day3Test {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void testDay3Part1Sample() {
        Day3 day3 = new Day3(new ProblemInput("aoc2021/day3-part1-sample-input.txt"));
        day3.calculatePowerRate();
        assertEquals(22, day3.getGammaRate());
        assertEquals(9, day3.getEpsilonRate());
        assertEquals(198, day3.getPowerConsumption());
    }

    @Test
    public void testDay3Part1() {
        Day3 day3 = new Day3(new ProblemInput("aoc2021/day3-part1-input.txt"));
        day3.calculatePowerRate();
        assertEquals(3827, day3.getGammaRate());
        assertEquals(268, day3.getEpsilonRate());
        assertEquals(1025636, day3.getPowerConsumption());
    }

    @Test
    public void testDay3Part2Sample() {
        Day3 day3 = new Day3(new ProblemInput("aoc2021/day3-part1-sample-input.txt"));
        day3.calculateLifeSupportRating();
        softly.assertThat(day3.getOxygenRating()).isEqualTo(23);
        softly.assertThat(day3.getCO2SRating()).isEqualTo(10);
        softly.assertThat(day3.getLifeSupportRating()).isEqualTo(230);
    }

    @Test
    public void testDay3Part2() {
        Day3 day3 = new Day3(new ProblemInput("aoc2021/day3-part1-input.txt"));
        day3.calculateLifeSupportRating();
        softly.assertThat(day3.getOxygenRating()).isEqualTo(3089);
        softly.assertThat(day3.getCO2SRating()).isEqualTo(257);
        softly.assertThat(day3.getLifeSupportRating()).isEqualTo(793873);
    }
}
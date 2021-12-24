package com.spudmux.aoc2021.day6;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigInteger;

public class Day6Test {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void testDay6WithSampleInput() {
        ProblemInput input = new ProblemInput("aoc2021/day6-part1-sample-input.txt");
        softly.assertThat(new Day6(input, 18).getNumberOfFish()).isEqualTo(BigInteger.valueOf(26));
        softly.assertThat(new Day6(input, 80).getNumberOfFish()).isEqualTo(BigInteger.valueOf(5934));
        softly.assertThat(new Day6(input, 256).getNumberOfFish()).isEqualTo(BigInteger.valueOf(26984457539L));
    }

    @Test
    public void testDay6WithProblemInput() {
        ProblemInput input = new ProblemInput("aoc2021/day6-part1-input.txt");
        softly.assertThat(new Day6(input, 80).getNumberOfFish()).isEqualTo(BigInteger.valueOf(393019L));
    }

    @Test
    public void testDay6PartTwoWithProblemInput() {
        ProblemInput input = new ProblemInput("aoc2021/day6-part1-input.txt");
        softly.assertThat(new Day6(input, 256).getNumberOfFish()).isEqualTo(BigInteger.valueOf(1757714216975L));
    }

}

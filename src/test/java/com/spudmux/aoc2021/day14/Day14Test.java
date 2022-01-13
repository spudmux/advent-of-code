package com.spudmux.aoc2021.day14;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.file.Paths;

public class Day14Test {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void testDay14Part1WithSampleInput() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day14-part1-sample-input.txt"));
        Day14 day14 = new Day14(input);
        softly.assertThat(day14.solvePart1()).isEqualTo(1588);
    }

    @Test
    public void testDay14Part1WithProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day14-part1-input.txt"));
        Day14 day14 = new Day14(input);
        softly.assertThat(day14.solvePart1()).isEqualTo(5656);
    }

    @Test
    public void testDay14Part2WithSampleInput() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day14-part1-sample-input.txt"));
        Day14 day14 = new Day14(input);
        softly.assertThat(day14.solvePart2()).isEqualTo(BigInteger.valueOf(2188189693529L));
    }

    @Test
    public void testDay14Part2WithProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("aoc2021/day14-part1-input.txt"));
        Day14 day14 = new Day14(input);
        softly.assertThat(day14.solvePart2()).isEqualTo(BigInteger.valueOf(12271437788530L));
    }

}

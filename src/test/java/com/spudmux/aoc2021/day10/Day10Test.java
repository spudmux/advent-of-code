package com.spudmux.aoc2021.day10;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class Day10Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay10Part1WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day10-part1-sample-input.txt");
    Day10 day10 = new Day10(input);
    softly.assertThat(day10.solvePart1()).isEqualTo(26397);
  }

  @Test public void testDay10Part1WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day10-part1-input.txt");
    Day10 day10 = new Day10(input);
    softly.assertThat(day10.solvePart1()).isEqualTo(339411);
  }

  @Test public void testDay10Part2WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day10-part1-sample-input.txt");
    Day10 day10 = new Day10(input);
    softly.assertThat(day10.solvePart2()).isEqualTo(BigDecimal.valueOf(288957L));
  }

  @Test public void testDay10Part2WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day10-part1-input.txt");
    Day10 day10 = new Day10(input);
    softly.assertThat(day10.solvePart2()).isEqualTo(BigDecimal.valueOf(2289754624L));
  }

}

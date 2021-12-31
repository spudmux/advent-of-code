package com.spudmux.aoc2021.day13;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day13Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay13Part1WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day13-part1-sample-input.txt");
    Day13 day13 = new Day13(input);
    softly.assertThat(day13.solvePart1()).isEqualTo(17);
  }

  @Test public void testDay13Part1WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day13-part1-input.txt");
    Day13 day13 = new Day13(input);
    softly.assertThat(day13.solvePart1()).isEqualTo(653);
  }

  @Test public void testDay13Part2WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day13-part1-sample-input.txt");
    Day13 day13 = new Day13(input);
    softly.assertThat(day13.solvePart2()).isEqualTo(16);
  }

  @Test public void testDay13Part2WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day13-part1-input.txt");
    Day13 day13 = new Day13(input);
    softly.assertThat(day13.solvePart2()).isEqualTo(102);
  }

}

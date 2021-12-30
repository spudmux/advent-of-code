package com.spudmux.aoc2021.day12;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day12Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay12Part1WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day12-part1-sample-input.txt");
    Day12 day12 = new Day12(input);
    softly.assertThat(day12.solvePart1()).isEqualTo(19);
  }

  @Test public void testDay12Part1WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day12-part1-input.txt");
    Day12 day12 = new Day12(input);
    softly.assertThat(day12.solvePart1()).isEqualTo(5756);
  }

  @Test public void testDay12Part2WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day12-part1-sample-input.txt");
    Day12 day12 = new Day12(input);
    softly.assertThat(day12.solvePart2()).isEqualTo(103);
  }

  @Test public void testDay12Part2WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day12-part1-input.txt");
    Day12 day12 = new Day12(input);
    softly.assertThat(day12.solvePart2()).isEqualTo(144603);
  }

}

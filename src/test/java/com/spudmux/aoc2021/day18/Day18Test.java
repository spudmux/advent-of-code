package com.spudmux.aoc2021.day18;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class Day18Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay18TestInput() {
    ProblemInput input = new ProblemInput("[1,2]");
    Day18 day18 = new Day18(input);
    input = new ProblemInput("[[1,2],3]");
    day18 = new Day18(input);
    softly.assertThat(day18.solvePart1()).isEqualTo(-1);
  }

  @Test public void testDay18Part1WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day18-part1-sample-input.txt"));
    Day18 day18 = new Day18(input);
    softly.assertThat(day18.solvePart1()).isEqualTo(-1);
  }

  @Test public void testDay18Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day18-part1-input.txt"));
    Day18 day18 = new Day18(input);
    softly.assertThat(day18.solvePart1()).isEqualTo(-1);
  }

  @Test public void testDay18Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day18-part1-sample-input.txt"));
    Day18 day18 = new Day18(input);
    softly.assertThat(day18.solvePart2()).isEqualTo(-1);
  }

  @Test public void testDay18Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day18-part1-input.txt"));
    Day18 day18 = new Day18(input);
    softly.assertThat(day18.solvePart2()).isEqualTo(-1);
  }

}

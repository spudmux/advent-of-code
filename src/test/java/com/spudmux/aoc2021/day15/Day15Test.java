package com.spudmux.aoc2021.day15;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class Day15Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay15Part1WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day15-part1-sample-input.txt"));
    Day15 day15 = new Day15(input);
    softly.assertThat(day15.solvePart1()).isEqualTo(40);
  }

  @Test public void testDay15Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day15-part1-input.txt"));
    Day15 day15 = new Day15(input);
    softly.assertThat(day15.solvePart1()).isEqualTo(589);
  }

  @Test public void testDay15Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day15-part1-sample-input.txt"));
    Day15 day15 = new Day15(input);
    softly.assertThat(day15.solvePart2()).isEqualTo(315);
  }

  @Test public void testDay15Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day15-part1-input.txt"));
    Day15 day15 = new Day15(input);
    softly.assertThat(day15.solvePart2()).isEqualTo(2885);
  }

}

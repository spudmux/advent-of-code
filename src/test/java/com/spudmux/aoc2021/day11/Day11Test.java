package com.spudmux.aoc2021.day11;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.nio.file.Paths;

public class Day11Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay11Part1WithMiniSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day11-part1-mini-sample-input.txt"));
    Day11 day11 = new Day11(input);
    softly.assertThat(day11.solvePart1(2)).isEqualTo(9);
  }

  @Test public void testDay11Part1WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day11-part1-sample-input.txt"));
    Day11 day11 = new Day11(input);
    softly.assertThat(day11.solvePart1(2)).isEqualTo(35);
    day11 = new Day11(input);
    softly.assertThat(day11.solvePart1()).isEqualTo(1656);
  }

  @Test public void testDay11Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day11-part1-input.txt"));
    Day11 day11 = new Day11(input);
    softly.assertThat(day11.solvePart1()).isEqualTo(1571);
  }

  @Test public void testDay11Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day11-part1-sample-input.txt"));
    Day11 day11 = new Day11(input);
    softly.assertThat(day11.solvePart2(200)).isEqualTo(195);
  }

  @Test public void testDay11Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day11-part1-input.txt"));
    Day11 day11 = new Day11(input);
    softly.assertThat(day11.solvePart2(2000)).isEqualTo(387);
  }

}

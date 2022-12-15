package com.spudmux.aoc2022.day1;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class Day1Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay1Part1WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2022/day1-part1-sample-input.txt"));
    Day1 day1 = new Day1(input);
    softly.assertThat(day1.solvePart1()).isEqualTo(24000);
  }

  @Test public void testDay1Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2022/day1-part1-input.txt"));
    Day1 day1 = new Day1(input);
    softly.assertThat(day1.solvePart1()).isEqualTo(74198);
  }

  @Test public void testDay1Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2022/day1-part1-sample-input.txt"));
    Day1 day1 = new Day1(input);
    softly.assertThat(day1.solvePart2()).isEqualTo(45000);
  }

  @Test public void testDay1Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2022/day1-part1-input.txt"));
    Day1 day1 = new Day1(input);
    softly.assertThat(day1.solvePart2()).isEqualTo(-1);
  }

}

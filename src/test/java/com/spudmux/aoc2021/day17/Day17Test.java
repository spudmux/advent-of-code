package com.spudmux.aoc2021.day17;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

public class Day17Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay17Part1WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-sample-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.solvePart1()).isEqualTo(45);
  }

  @Test public void testDay17Part1Trajectory1() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-sample-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.hitsTarget(new Day17.Probe(7, 2))).isTrue();
  }

  @Test public void testDay17Part1Trajectory2() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-sample-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.hitsTarget(new Day17.Probe(6, 3))).isTrue();
  }

  @Test public void testDay17Part1Trajectory3() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-sample-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.hitsTarget(new Day17.Probe(9, 0))).isTrue();
  }

  @Test public void testDay17Part1Trajectory4() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-sample-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.hitsTarget(new Day17.Probe(17, -4))).isFalse();
  }

  @Test public void testDay17Part1Trajectory5() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.hitsTarget(new Day17.Probe(22, 48))).isTrue();
  }

  @Test public void testDay17Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.solvePart1()).isEqualTo(6555);
  }

  @Test public void testDay17Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-sample-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.solvePart2()).isEqualTo(112);
  }

  @Test public void testDay17Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day17-part1-input.txt"));
    Day17 day17 = new Day17(input);
    softly.assertThat(day17.solvePart2()).isEqualTo(4973);
  }

}

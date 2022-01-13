package com.spudmux.aoc2021.day7;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

public class Day7Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay7WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day7-part1-sample-input.txt"));
    Day7 day7 = new Day7(input);
    softly.assertThat(day7.getLeastFuleUsageSimple()).isEqualTo(37);

  }

  @Test public void testDay7WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day7-part1-input.txt"));
    Day7 day7 = new Day7(input);
    softly.assertThat(day7.getLeastFuleUsageSimple()).isEqualTo(355764);
  }

  @Test public void testDay7Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day7-part1-sample-input.txt"));
    Day7 day7 = new Day7(input);
    softly.assertThat(day7.getLeastFuleUsageComplex()).isEqualTo(168);

  }

  @Test public void testDay7Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day7-part1-input.txt"));
    Day7 day7 = new Day7(input);
    softly.assertThat(day7.getLeastFuleUsageComplex()).isEqualTo(99634572);
  }

}

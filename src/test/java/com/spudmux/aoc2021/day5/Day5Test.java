package com.spudmux.aoc2021.day5;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.nio.file.Paths;

public class Day5Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay5WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day5-part1-sample-input.txt"));
    Day5 day5 = new Day5(input, false);
    softly.assertThat(day5.calculateOverlaps()).isEqualTo(5);
  }

  @Test public void testDay5WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day5-part1-input.txt"));
    Day5 day5 = new Day5(input, false);
    softly.assertThat(day5.calculateOverlaps()).isEqualTo(6267);
  }

  @Test public void testDay5Part2SampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day5-part1-sample-input.txt"));
    Day5 day5 = new Day5(input, true);
    softly.assertThat(day5.calculateOverlaps()).isEqualTo(12);
  }

  @Test public void testDay5Part2Input() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day5-part1-input.txt"));
    Day5 day5 = new Day5(input, true);
    softly.assertThat(day5.calculateOverlaps()).isEqualTo(20196);
  }

}

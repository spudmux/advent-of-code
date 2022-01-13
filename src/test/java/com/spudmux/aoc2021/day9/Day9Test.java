package com.spudmux.aoc2021.day9;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class Day9Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay9WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day9-part1-sample-input.txt"));
    Day9 day9 = new Day9(input);
    softly.assertThat(day9.sumRiskLevels()).isEqualTo(15);
  }

  @Test public void testDay9WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day9-part1-input.txt"));
    Day9 day9 = new Day9(input);
    softly.assertThat(day9.sumRiskLevels()).isEqualTo(541);
  }

  @Test public void testDay9Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day9-part1-sample-input.txt"));
    Day9 day9 = new Day9(input);
    softly.assertThat(day9.sumBasins()).isEqualTo(1134);
  }

  @Test public void testDay9Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day9-part1-input.txt"));
    Day9 day9 = new Day9(input);
    softly.assertThat(day9.sumBasins()).isEqualTo(847504);
  }

}

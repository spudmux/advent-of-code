package com.spudmux.aoc2020.day10;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class JoltageCalculatorTest {

  @Test public void testJoltageCalculatorWithSmallSampleInput() {
    ProblemInput input = new ProblemInput("day10-sample-input-small.txt");
    JoltageCalculator joltageCalculator = new JoltageCalculator(input.getInputAsListOfLines());
    assertThat(joltageCalculator.oneByThreeDifferences()).isEqualTo(35);
    assertThat(joltageCalculator.endRating()).isEqualTo(22);
    assertThat(JoltageCalculator.calculateAllCombinations(input.getInputAsListOfLines())).isEqualTo(8);
  }

  @Test public void testJoltageCalculatorWithSampleInput() {
    ProblemInput input = new ProblemInput("day10-sample-input.txt");
    JoltageCalculator joltageCalculator = new JoltageCalculator(input.getInputAsListOfLines());
    assertThat(joltageCalculator.oneByThreeDifferences()).isEqualTo(220);
    assertThat(joltageCalculator.endRating()).isEqualTo(52);
    assertThat(JoltageCalculator.calculateAllCombinations(input.getInputAsListOfLines())).isEqualTo(19208);
  }

  @Test public void testJoltageCalculatorWithProblemInput() {
    ProblemInput input = new ProblemInput("day10-input.txt");
    JoltageCalculator joltageCalculator = new JoltageCalculator(input.getInputAsListOfLines());
    assertThat(joltageCalculator.oneByThreeDifferences()).isEqualTo(2346);
    assertThat(joltageCalculator.endRating()).isEqualTo(171);
    assertThat(JoltageCalculator.calculateAllCombinations(input.getInputAsListOfLines())).isEqualTo(-1);
  }

}

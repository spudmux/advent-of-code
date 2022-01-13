package com.spudmux.aoc2021.day8;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class Day8Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  private String[] output;

  @Test public void testDay8WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day8-part1-sample-input.txt"));
    Day8 day8 = new Day8(input);
    softly.assertThat(day8.countDigits()).isEqualTo(26);
  }

  @Test public void testDay8WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day8-part1-input.txt"));
    Day8 day8 = new Day8(input);
    softly.assertThat(day8.countDigits()).isEqualTo(288);
  }

  @Test public void testDay8Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day8-part1-sample-input.txt"));
    Day8 day8 = new Day8(input);
    softly.assertThat(day8.sumOutputs()).isEqualTo(61229);
  }

  @Test public void testDay8Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day8-part1-input.txt"));
    Day8 day8 = new Day8(input);
    softly.assertThat(day8.sumOutputs()).isEqualTo(940724);
  }

  @Test public void testDecodeEntry() {
    String[] observations = "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab".split("\\s+");
    output = "cdfeb fcadb cdfeb cdbaf".split("\\s+");
    Day8.Entry e = new Day8.Entry(observations, output);
    int result = e.decode();
    softly.assertThat(e.digitToSegments).containsEntry(1, "ab");
    softly.assertThat(e.digitToSegments).containsEntry(2, "gcdfa");
    softly.assertThat(e.digitToSegments).containsEntry(3, "fbcad");
    softly.assertThat(e.digitToSegments).containsEntry(4, "eafb");
    softly.assertThat(e.digitToSegments).containsEntry(5, "cdfbe");
    softly.assertThat(e.digitToSegments).containsEntry(6, "cdfgeb");
    softly.assertThat(e.digitToSegments).containsEntry(7, "dab");
    softly.assertThat(e.digitToSegments).containsEntry(8, "acedgfb");
    softly.assertThat(e.digitToSegments).containsEntry(9, "cefabd");
    softly.assertThat(e.digitToSegments).containsEntry(0, "cagedb");
    softly.assertThat(e.signalMap).containsEntry("a", "d");
    softly.assertThat(e.signalMap).containsEntry("g", "c");
    softly.assertThat(e.signalMap).containsEntry("e", "g");
    softly.assertThat(e.signalMap).containsEntry("b", "e");
    softly.assertThat(e.signalMap).containsEntry("c", "a");
    softly.assertThat(result).isEqualTo(5353);
  }

}

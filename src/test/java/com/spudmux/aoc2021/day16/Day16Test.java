package com.spudmux.aoc2021.day16;

import com.spudmux.aoc2020.ProblemInput;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.nio.file.Paths;

public class Day16Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void testDay16Part1WithSampleInput() {
    ProblemInput input = new ProblemInput("D2FE28");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(6);
  }

  @Test
  public void testOperatorPacketLengthType0() {
    //00111000000000000110111101000101001010010001001000000000
    //VVVTTTILLLLLLLLLLLLLLLAAAAAAAAAAABBBBBBBBBBBBBBBB
    ProblemInput input = new ProblemInput("38006F45291200");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(9);
  }

  @Test
  public void testOperatorPacketLengthType1() {
    //11101110000000001101010000001100100000100011000001100000
    //VVVTTTILLLLLLLLLLLAAAAAAAAAAABBBBBBBBBBBCCCCCCCCCCC
    ProblemInput input = new ProblemInput("EE00D40C823060");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(14);
  }

  @Test public void testDay16Part1WithSampleInput2() {
    ProblemInput input = new ProblemInput("8A004A801A8002F478");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(16);
  }

  @Test public void testDay16Part1WithSampleInput3() {
    ProblemInput input = new ProblemInput("620080001611562C8802118E34");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(12);
  }

  @Test public void testDay16Part1WithSampleInput4() {
    ProblemInput input = new ProblemInput("C0015000016115A2E0802F182340");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(23);
  }


  @Test public void testDay16Part1WithSampleInput5() {
    ProblemInput input = new ProblemInput("A0016C880162017C3686B18A3D4780");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(31);
  }


  @Test public void testDay16Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day16-part1-input.txt"));
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart1()).isEqualTo(979);
  }

  @Test
  public void testDay16Part2WithSampleInput() {
    // produces 1, because 1 + 3 = 2 * 2
    ProblemInput input = new ProblemInput("9C0141080250320F1802104A08");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(1);
  }

  @Test public void testDay16Part2SumOf1And2() {
    ProblemInput input = new ProblemInput("C200B40A82");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(3);
  }

  @Test public void testDay16Part2ProductOf6And9() {
    ProblemInput input = new ProblemInput("04005AC33890");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(54);
  }

  @Test public void testDay16Part2MinimumOf789() {
    ProblemInput input = new ProblemInput("880086C3E88112");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(7);
  }

  @Test public void testDay16Part2MaximumOf789() {
    ProblemInput input = new ProblemInput("CE00C43D881120");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(9);
  }

  @Test public void testDay16Part2LessThan() {
    // produces 1, because 5 is less than 15
    ProblemInput input = new ProblemInput("D8005AC2A8F0");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(1);
  }

  @Test public void testDay16Part2GreaterThan() {
    // produces 0, because 5 is not greater than 15
    ProblemInput input = new ProblemInput("F600BC2D8F");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(0);
  }

  @Test public void testDay16Part2Equal() {
    // produces 0, because 5 is not equal to 15.
    ProblemInput input = new ProblemInput("9C005AC2F8F0");
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(0);
  }

  @Test public void testDay16Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc2021/day16-part1-input.txt"));
    Day16 day16 = new Day16(input);
    softly.assertThat(day16.solvePart2()).isEqualTo(277110354175L);
  }

}

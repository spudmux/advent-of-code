package com.spudmux.aoc2021.day2;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class Day2Test {

    @Test
    public void testDay2Part1Sample() {
        Day2 day2 = new Day2(new ProblemInput(Paths.get("aoc2021/day2-part1-sample-input.txt")));
        assertEquals(6, day2.headings.size());
        day2.calculatePosition();
        assertEquals(15, day2.getHorizontalPosition());
        assertEquals(10, day2.getVerticalPosition());
        assertEquals(150, day2.getHorizontalPosition() * day2.getVerticalPosition());
    }

    @Test
    public void testDay2Part1() {
        Day2 day2 = new Day2(new ProblemInput(Paths.get("aoc2021/day2-part1-input.txt")));
        assertEquals(1000, day2.headings.size());
        day2.calculatePosition();
        assertEquals(1970, day2.getHorizontalPosition());
        assertEquals(916, day2.getVerticalPosition());
        assertEquals(1804520, day2.getHorizontalPosition() * day2.getVerticalPosition());
    }

    @Test
    public void testDay2Part2Sample() {
        Day2 day2 = new Day2(new ProblemInput(Paths.get("aoc2021/day2-part1-sample-input.txt")));
        assertEquals(6, day2.headings.size());
        day2.calculatePositionPart2();
        assertEquals(15, day2.getHorizontalPosition());
        assertEquals(60, day2.getVerticalPosition());
        assertEquals(900, day2.getHorizontalPosition() * day2.getVerticalPosition());
    }

    @Test
    public void testDay2Part2() {
        Day2 day2 = new Day2(new ProblemInput(Paths.get("aoc2021/day2-part1-input.txt")));
        assertEquals(1000, day2.headings.size());
        day2.calculatePositionPart2();
        assertEquals(1970, day2.getHorizontalPosition());
        assertEquals(1000556, day2.getVerticalPosition());
        assertEquals(1971095320, day2.getHorizontalPosition() * day2.getVerticalPosition());
    }
}
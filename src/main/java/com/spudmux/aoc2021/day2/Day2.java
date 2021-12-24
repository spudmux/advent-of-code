package com.spudmux.aoc2021.day2;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    List<Heading> headings = new ArrayList<>();
    private int horizontalPosition = 0;
    private int verticalPosition = 0;
    private int aim = 0;

    public Day2(ProblemInput input) {
        for (String line : input.getInputAsListOfLines()) {
            String[] tokens = line.split("\\s+");
            assert tokens.length == 2;
            Heading heading = new Heading();
            heading.direction = Direction.valueOf(tokens[0]);
            heading.distance = Integer.parseInt(tokens[1]);
            headings.add(heading);
        }
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public void calculatePositionPart2() {
        for (Heading heading : headings) {
            switch (heading.direction) {
                case forward:
                    horizontalPosition += heading.distance;
                    if (aim != 0) {
                        verticalPosition += aim * heading.distance;
                    }
                    break;
                case up:
                    aim -= heading.distance;
                    break;
                case down:
                    aim += heading.distance;
                    break;
            }
        }
    }

    public void calculatePosition() {
        for (Heading heading : headings) {
            switch (heading.direction) {
                case forward:
                    horizontalPosition += heading.distance;
                    break;
                case up:
                    verticalPosition -= heading.distance;
                    break;
                case down:
                    verticalPosition += heading.distance;
                    break;
            }
        }
    }

    enum Direction {
        forward, up, down
    }
    static class Heading {
        Direction direction;
        int distance;
    }
}

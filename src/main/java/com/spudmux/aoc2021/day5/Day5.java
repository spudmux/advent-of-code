package com.spudmux.aoc2021.day5;

import com.spudmux.aoc2020.ProblemInput;

import java.util.*;

public class Day5 {

    List<Line> lines = new ArrayList<>();
    int maxX = 0;
    int maxY = 0;

    public Day5(ProblemInput input, boolean includeDiagonals) {
        for (String line : input.getInputAsListOfLines()) {
            String[] points = line.split("\\s+|,");
            Line l = new Line(new Point(points[0], points[1]), new Point(points[3], points[4]));
            if (l.isHorizontal() || l.isVertical() || (includeDiagonals && l.isDiagonal())) {
                lines.add(l);
                checkForMax(l);
            }
        }
        System.out.println(maxX);
        System.out.println(maxY);
        System.out.println(lines);
    }

    private void checkForMax(Line l) {
        if (l.p1.x > maxX) {
            maxX = l.p1.x;
        }
        if (l.p2.x > maxX) {
            maxX = l.p2.x;
        }
        if (l.p1.y > maxY) {
            maxY = l.p1.y;
        }
        if (l.p2.y > maxY) {
            maxY = l.p2.y;
        }
    }

    public int calculateOverlaps() {
        Board board = new Board(maxX+1, maxY+1);
        lines.forEach(board::addLine);
        lines.forEach(line -> System.out.println(line + " Diag? " + line.isDiagonal()));
        return board.countIntersections(2);
    }

    static class Line {
        Point p1;
        Point p2;

        Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public Iterator<Point> points() {
            return new PointIterator(this);
        }

        private static class PointIterator implements Iterator<Point> {
            Point current;
            Line line;
            int xDirection;
            int yDirection;

            public PointIterator(Line line) {
                current = line.p1;
                this.line = line;
                determineDirection(line);
            }

            private void determineDirection(Line line) {
                if (line.isVertical()) {
                    if (line.p1.y > line.p2.y) {
                        yDirection = -1;
                    } else {
                        yDirection = 1;
                    }
                } else if (line.isHorizontal()) {
                    if (line.p1.x > line.p2.x) {
                        xDirection = -1;
                    } else {
                        xDirection = 1;
                    }
                } else if (line.isDiagonal()) {
                    if (line.p1.x > line.p2.x) {
                        xDirection = -1;
                    } else {
                        xDirection = 1;
                    }
                    if (line.p1.y > line.p2.y) {
                        yDirection = -1;
                    } else {
                        yDirection = 1;
                    }
                }
            }

            @Override
            public boolean hasNext() {
                if (line.isVertical()) {
                    return current.y != line.p2.y + yDirection;
                } else if (line.isHorizontal()){
                    return current.x != line.p2.x + xDirection;
                } else if (line.isDiagonal()) {
                    return current.x != line.p2.x + xDirection && current.y != line.p2.y + yDirection;
                }
                throw new RuntimeException("Line isn't horizontal or vertical or diagonal");
            }

            @Override
            public Point next() {
                Point next = current;
                if (line.isVertical()) {
                    current = new Point(current.x, current.y+yDirection);
                } else if (line.isHorizontal()) {
                    current = new Point(current.x + xDirection, current.y);
                } else if (line.isDiagonal()) {
                    current = new Point(current.x + xDirection, current.y + yDirection);
                }
                return next;
            }
        }

        @Override
        public String toString() {
            return p1 + " -> " + p2;
        }

        public boolean isVertical() {
            return p1.x == p2.x;
        }

        public boolean isHorizontal() {
            return p1.y == p2.y;
        }

        public boolean isDiagonal() {
            return Math.abs(p2.x-p1.x) == Math.abs(p2.y - p1.y);
        }

        public Point doesIntersect(Line otherLine) {
            if (isHorizontal() && otherLine.isHorizontal() || isVertical() && otherLine.isVertical()) {
                return null;
            }
            if (isVertical()) {
                return new Point(p1.x, otherLine.p1.y);
            } else {
                return new Point(otherLine.p1.x, p1.y);
            }
        }

    }

    static class Point {
        int x;
        int y;

        public Point(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static class Board {
        int[][] board;
        public Board(int maxX, int maxY) {
            board = new int[maxY][maxX];
        }

        public void addLine(Line line) {
            for (Iterator<Point> it = line.points(); it.hasNext(); ) {
                Point point = it.next();
                board[point.y][point.x] = board[point.y][point.x]+1;
            }
        }

        public int countIntersections(int limit) {
            int sum = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] >= limit) {
                        sum++;
                    }
                }
            }
            return sum;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int value = board[i][j];
                    if (value == 0) {
                        sb.append(" . ");
                    } else {
                        sb.append(" ");
                        sb.append(value);
                        sb.append(" ");
                    }
                }
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        }
    }
}

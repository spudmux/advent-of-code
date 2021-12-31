package com.spudmux.aoc2021.day13;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {

    char[][] paper;
    List<String> folds = new ArrayList<>();

    public Day13(ProblemInput input) {
        List<String> lines = input.getInputAsListOfLines();
        List<Point> points = new ArrayList<>();
        boolean dotsFinished = false;
        int maxX = 0, maxY = 0;
        for (String line : lines) {
            if (!dotsFinished) {
                if ("".equals(line)) {
                    dotsFinished = true;
                } else {
                    String[] rawPoint = line.split(",");
                    Point point = new Point(Integer.parseInt(rawPoint[1]), Integer.parseInt(rawPoint[0]));
                    points.add(point);
                    if (point.x > maxX) {
                        maxX = point.x;
                    }
                    if (point.y > maxY) {
                        maxY = point.y;
                    }
                }
            } else {
                String[] fold = line.split("\\s+");
                folds.add(fold[2]);
            }
        }
        paper = new char[maxX+1][maxY+1];
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length; j++) {
                char[] row = new char[maxY+1];
                Arrays.fill(row, '.');
                paper[i] = row;
            }
        }
        for (Point point : points) {
            paper[point.x][point.y] = '#';
        }
    }

    private int fold(List<String> folds) {
        for (String s : folds) {
            String[] fold = s.split("=");
            int foldLine = Integer.parseInt(fold[1]);
            String axis = fold[0];
            if ("x".equals(axis)) {
                char[][] newPaper = createNewArray(paper.length, foldLine);
                for (int i = 0; i < paper.length; i++) {
                    for (int j = foldLine+1; j < paper[i].length; j++) {
                        if (paper[i][j] == '#') {
                            int mirrorPos = paper[i].length - j-1;
                            newPaper[i][mirrorPos] = '#';
                        }
                    }
                }
                paper = newPaper;
            } else if ("y".equals(axis)) {
                char[][] newPaper = createNewArray(foldLine, paper[0].length);
                for (int i = foldLine + 1; i < paper.length; i++) {
                    for (int j = 0; j < paper[i].length; j++) {
                        if (paper[i][j] == '#') {
                            int mirrorPos = paper.length - i - 1;
                            newPaper[mirrorPos][j] = '#';
                        }
                    }
                }
                paper = newPaper;
            }
        }
        return countVisibleDots();
    }

    private int countVisibleDots() {
        int visible = 0;
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length; j++) {
                if (paper[i][j] == '#') {
                    visible++;
                }
            }
        }
        return visible;
    }

    private char[][] createNewArray(int iMax, int jMax) {
        char[][] array = new char[iMax][jMax];
        for (int i = 0; i < array.length; i++) {
            array[i] = new char[jMax];
            System.arraycopy(paper[i], 0, array[i], 0, array[i].length);
        }
        return array;
    }

    public int solvePart2() {
        int dotsVisible = fold(folds);
        System.out.println(this);
        return dotsVisible;
    }

    public int solvePart1() {
        return fold(folds.subList(0, 1));
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : paper) {
            for (char aChar : chars) {
                if (aChar == '#') {
                    sb.append(aChar);
                } else {
                    sb.append(' ');
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}

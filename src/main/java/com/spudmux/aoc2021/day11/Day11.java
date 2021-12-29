package com.spudmux.aoc2021.day11;

import com.spudmux.aoc2020.ProblemInput;

import java.util.Arrays;
import java.util.List;

public class Day11 {

    private static final int MAX_ENERGY = 9;
    int[][] board;
    boolean[][] flashed;

    public Day11(ProblemInput input) {
        List<String> lines = input.getInputAsListOfLines();
        board = new int[lines.size()][lines.get(0).length()];
        flashed = new boolean[lines.size()][lines.get(0).length()];
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(lines.get(i).split("")).mapToInt(Integer::parseInt).toArray();
            flashed[i] = new boolean[lines.get(i).length()];
        }
        System.out.println(this);;
    }

    public int solvePart1() {
        return solvePart1(100);
    }

    public int solvePart1(int steps) {
        int totalFlashes = 0;
        for (int step = 1; step <= steps; step++) {
            System.out.println("Step: "+step);
            totalFlashes += runStep();
        }
        return totalFlashes;
    }

    private int runStep() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]++;
            }
        }
        while (hasNines()) {
            int[][] newBoard = new int[board.length][board[0].length];
            for (int i = 0; i < newBoard.length; i++) {
                int[] ints = new int[board[i].length];
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] <= MAX_ENERGY) {
                        ints[j] = board[i][j];
                    } else {
                        ints[j] = 0;
                        flashed[i][j] = true;
                    }
                }
                newBoard[i] = ints;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] > MAX_ENERGY) {
                        increaseNeighbours(i, j, 1, newBoard);
                    }
                }
            }
            board = newBoard;
        }
        int flashes = 0;
        for (int i = 0; i < flashed.length; i++) {
            for (int j = 0; j < flashed[i].length; j++) {
                if (flashed[i][j]) {
                    flashes++;
                }
            }
            Arrays.fill(flashed[i], false);
        }
        System.out.println(flashes);
        System.out.println(this);
        return flashes;
    }

    private boolean hasNines() {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt > MAX_ENERGY) {
                    return true;
                }
            }
        }
        return false;
    }

    private void increaseNeighbours(int i, int j, int increase, int[][] newBoard) {
        if (i + 1 < newBoard.length) { // down one
            if (!flashed[i + 1][j]) {
                newBoard[i + 1][j] = newBoard[i + 1][j] + increase;
            }
            if (j - 1 >= 0 && !flashed[i + 1][j - 1]) { // diagonal down left
                newBoard[i + 1][j - 1] = newBoard[i + 1][j - 1] + increase;
            }
            if (j + 1 < newBoard[i + 1].length && !flashed[i + 1][j + 1]) { // diagonal down right
                newBoard[i + 1][j + 1] = newBoard[i + 1][j + 1] + increase;
            }
        }
        if (i-1 >= 0) { // up one
            if ( !flashed[i-1][j]) {
                newBoard[i-1][j] = newBoard[i-1][j] + increase;
            }
            if (j-1 >= 0 && !flashed[i-1][j-1]) { // diagonal up left
                newBoard[i-1][j-1] = newBoard[i-1][j-1] + increase;
            }
            if (j + 1 < newBoard[i - 1].length && !flashed[i-1][j+1]) { // diagonal up right
                newBoard[i-1][j+1] = newBoard[i-1][j+1] + increase;
            }
        }
        if (j-1 >= 0 && !flashed[i][j-1]) { // left
            newBoard[i][j-1] = newBoard[i][j-1] + increase;
        }
        if (j+1 < newBoard[i].length && !flashed[i][j+1]) { // right
            newBoard[i][j+1] = newBoard[i][j+1] + increase;
        }
    }

    public int solvePart2() {
        return solvePart2(100);
    }

    public int solvePart2(int maxSteps) {
        for (int step = 1; step <= maxSteps; step++) {
            runStep();
            if (isAllZeros()) {
                return step;
            }
        }
        return -1;
    }

    private boolean isAllZeros() {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

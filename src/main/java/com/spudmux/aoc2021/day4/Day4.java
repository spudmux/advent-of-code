package com.spudmux.aoc2021.day4;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    private int finalScore;
    List<Integer> numbers;
    List<Board> boards = new ArrayList<>();
    private Board lastBoard;
    private int lastNumber;

    public Day4(ProblemInput input) {
        List<String> lines = input.getInputAsListOfLines();
        numbers = Arrays.stream(lines.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        for (int i = 2; i < lines.size(); i += 6) {
            Board b = new Board(lines.subList(i, i + 5));
            boards.add(b);
        }
        finalScore = 0;
    }

    public void calculate() {
        for (int i : numbers) {
            for (Board b : boards) {
                b.checkAndMarkNumber(i);
                if (b.isWinner()) {
                    finalScore = b.getScore() * i;
                    return;
                }
            }
        }
    }

    public void calculatePart2() {
        for (int i : numbers) {
            for (Board b : boards) {
                b.checkAndMarkNumber(i);
                if (b.isWinner()) {
                    lastBoard = b;
                    lastNumber = i;
                }
            }
            boards.removeAll(boards.stream().filter(Board::isWinner).collect(Collectors.toSet()));
        }
        finalScore = lastNumber * lastBoard.getScore();
    }

    public int getFinalScore() {
        return finalScore;
    }


    static class Board {

        static class Cell {
            int number;
            boolean marked = false;

            Cell(String s) {
                number = Integer.parseInt(s);
            }
        }
        Cell[][] data;
        public Board(List<String> lines) {
            data = new Cell[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                String s = lines.get(i).trim();
                data[i] = Arrays.stream(s.split("\\s+")).map(Cell::new).toArray(Cell[]::new);
            }
        }
        
        public void checkAndMarkNumber(int number) {
            for (Cell[] datum : data) {
                for (Cell cell : datum) {
                    if (cell.number == number) {
                        cell.marked = true;
                    }
                }
            }
        }

        public int getScore() {
            int sum = 0;
            for (Cell[] datum : data) {
                for (Cell cell : datum) {
                    if (!cell.marked) {
                        sum += cell.number;
                    }
                }
            }
            return sum;
        }

        public boolean isWinner() {
            for (int i = 0; i < data.length; i++) {
                boolean fullLine = true;
                for (int j = 0; j < data[i].length; j++) {
                    if (!data[i][j].marked) {
                        fullLine = false;
                        break;
                    }
                }
                if (fullLine) {
                    return fullLine;
                }
            }
            for (int i = 0; i < data.length; i++) {
                boolean fullLine = true;
                for (int j = 0; j < data[i].length; j++) {
                    if (!data[j][i].marked) {
                        fullLine = false;
                        break;
                    }
                }
                if (fullLine) {
                    return fullLine;
                }
            }
            return false;
        }
    }
}

package com.spudmux.aoc2020.day5;

import com.spudmux.aoc2020.ProblemInput;

public class BoardingPassValidator {
    private int highestSeatId;
    char[][] seatingPlan = new char[128][8];

    public void process(ProblemInput validator) {
        int highestSeatId = 0;
        for (String line : validator.getInputAsListOfLines()) {
            BoardingPass pass = new BoardingPass(line);
            if (pass.seatId > highestSeatId) {
                highestSeatId = pass.seatId;
            }
            seatingPlan[pass.row][pass.column] = '-';
        }
        this.highestSeatId = highestSeatId;
    }

    private void printSeatingPlan() {
        for (int i = 0; i < 127; i++) {
            System.out.print(i+":\t");
            for (int j = 0; j < 7; j++) {
                char c = seatingPlan[i][j];
                if (c == '-') {
                    System.out.print(c);
                } else {
                    System.out.print('o');
                }

            }
            System.out.println();
        }
    }

    public int getHighestSeatId() {
        return highestSeatId;
    }

    public int getMySeatId() {
        boolean seenFirstFullSeat = false;
        for (int i = 0; i < 127; i++) {
            for (int j = 0; j < 7; j++) {
                char c = seatingPlan[i][j];
                if (c != '-' && seenFirstFullSeat) {
                    return i *8 + j;
                }
                if (c == '-') {
                    seenFirstFullSeat = true;
                }
            }
        }
        return -1;
    }


    static class BoardingPass {
        private final int seatId;
        private final int row;
        private final int column;
        public BoardingPass(String passData) {
            int low = 0;
            int high = 127;
            for (int i = 0; i < 7; i++) {
                char c = passData.charAt(i);
                if (c == 'F') {
                    high -= (high - low+1) / 2;
                } else if (c == 'B') {
                    low += (high - low+1) / 2;
                }
            }
            this.row = low;
            low = 0;
            high = 7;
            for (int i = 7; i < 10; i++) {
                char c = passData.charAt(i);
                if (c == 'L') {
                    high -= (high - low+1) / 2;
                } else if (c == 'R') {
                    low += (high - low+1) / 2;
                }
            }
            this.column = low;
            seatId = row * 8 + column;
        }

        public int getSeatId() {
            return seatId;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }
}

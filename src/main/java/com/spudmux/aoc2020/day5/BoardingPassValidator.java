package com.spudmux.aoc2020.day5;

import com.spudmux.aoc2020.ProblemInput;

public class BoardingPassValidator {
    private int highestSeatId;

    public void process(ProblemInput validator) {
        int highestSeatId = 0;
        for (String line : validator.getInputAsListOfLines()) {
            BoardingPass pass = new BoardingPass(line);
            if (pass.seatId > highestSeatId) {
                highestSeatId = pass.seatId;
            }
        }
        this.highestSeatId = highestSeatId;
    }

    public int getHighestSeatId() {
        return highestSeatId;
    }


    static class BoardingPass {
        private int seatId;
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
            int row = low;
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
            int column = low;
            seatId = row * 8 + column;
        }

        public int getSeatId() {
            return seatId;
        }
    }
}

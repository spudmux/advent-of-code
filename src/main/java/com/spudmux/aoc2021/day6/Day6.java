package com.spudmux.aoc2021.day6;

import com.spudmux.aoc2020.ProblemInput;

import java.math.BigInteger;
import java.util.Arrays;

public class Day6 {

    private BigInteger[] fish;
    private final int days;

    public Day6(ProblemInput input, int days) {
        this.days = days;
        this.fish = new BigInteger[9];
        Arrays.fill(fish, BigInteger.ZERO);
        int[] initialFish = Arrays.stream(input.getInputAsString().split(",")).mapToInt(Integer::parseInt).toArray();
        for (int age : initialFish) {
            fish[age] = fish[age].add(BigInteger.ONE);
        }
    }

    public BigInteger getNumberOfFish() {
        System.out.println("Initial ages: " + Arrays.toString(fish));
        for (int day = 0; day < this.days; day++) {
            BigInteger age0 = fish[0];
            fish[0] = fish[1];
            fish[1] = fish[2];
            fish[2] = fish[3];
            fish[3] = fish[4];
            fish[4] = fish[5];
            fish[5] = fish[6];
            fish[6] = age0.add(fish[7]);
            fish[7] = fish[8];
            fish[8] = age0;
            System.out.println("ages on day " + (day + 1) + ": " + Arrays.toString(fish));
        }
        BigInteger totalFish = BigInteger.ZERO;
        for (BigInteger bigInteger : fish) {
            totalFish = totalFish.add(bigInteger);
        }
        return totalFish;
    }
}

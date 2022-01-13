package com.spudmux.aoc2020.day3;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TrajectoryCalculatorTest {

    @Test public void testTreeCountWithSampleInput() {
        ProblemInput input = new ProblemInput(Paths.get("day3-sample-input.txt"));

        TrajectoryCalculator calculator = new TrajectoryCalculator();
        int numberOfTrees = calculator.getNumberOfTreesEncountered(input);
        assertEquals(7, numberOfTrees);
    }

    @Test public void testTreeCountWithProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("day3-input.txt"));

        TrajectoryCalculator calculator = new TrajectoryCalculator();
        int numberOfTrees = calculator.getNumberOfTreesEncountered(input);
        assertEquals(228, numberOfTrees);
    }

    @Test public void testTreeCountWithSampleInputPartTwo() {
        ProblemInput input = new ProblemInput(Paths.get("day3-sample-input.txt"));

        TrajectoryCalculator calculator = new TrajectoryCalculator();

        assertEquals(2, calculator.getNumberOfTreesEncountered(input, 1, 1));
        assertEquals(7, calculator.getNumberOfTreesEncountered(input, 3, 1));
        assertEquals(3, calculator.getNumberOfTreesEncountered(input, 5, 1));
        assertEquals(4, calculator.getNumberOfTreesEncountered(input, 7, 1));
        assertEquals(2, calculator.getNumberOfTreesEncountered(input, 1, 2));
    }

    @Test public void testTreeCountWithProblemInputPartTwo() {
        ProblemInput input = new ProblemInput(Paths.get("day3-input.txt"));

        TrajectoryCalculator calculator = new TrajectoryCalculator();

        int slope1 = calculator.getNumberOfTreesEncountered(input, 1, 1);
        assertEquals(84, slope1);
        int slope2 = calculator.getNumberOfTreesEncountered(input, 3, 1);
        assertEquals(228, slope2);
        int slope3 = calculator.getNumberOfTreesEncountered(input, 5, 1);
        assertEquals(89, slope3);
        int slope4 = calculator.getNumberOfTreesEncountered(input, 7, 1);
        assertEquals(100, slope4);
        int slope5 = calculator.getNumberOfTreesEncountered(input, 1, 2);
        assertEquals(40, slope5);
        BigInteger productOfSlopes = BigInteger.valueOf(slope1);
        productOfSlopes = productOfSlopes.multiply(BigInteger.valueOf(slope2));
        productOfSlopes = productOfSlopes.multiply(BigInteger.valueOf(slope3));
        productOfSlopes = productOfSlopes.multiply(BigInteger.valueOf(slope4));
        productOfSlopes = productOfSlopes.multiply(BigInteger.valueOf(slope5));
        assertEquals(new BigInteger("6818112000"), productOfSlopes);
        //6,818,112,000
    }
}
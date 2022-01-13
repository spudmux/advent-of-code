package com.spudmux.aoc2020.day4;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PassportValidatorTest {

    @Test
    public void testWithSampleInput() {
        ProblemInput input = new ProblemInput(Paths.get("day4/part1-sample-input.txt"));
        PassportValidator validator = new PassportValidator(input);
        assertEquals(2, validator.getNumberOfCompletePassports());
    }

    @Test
    public void testWithProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("day4-input.txt"));
        PassportValidator validator = new PassportValidator(input);
        assertEquals(208, validator.getNumberOfCompletePassports());
    }

    @Test
    public void testPartTwoSampleInvalidPassports() {
        ProblemInput input = new ProblemInput(Paths.get("day4/part2-sample-input-invalid-passports.txt"));
        PassportValidator validator = new PassportValidator(input);
        assertEquals(0, validator.getNumberOfValidPassports());
    }

    @Test
    public void testPartTwoSampleValidPassports() {
        ProblemInput input = new ProblemInput(Paths.get("day4/part2-sample-input-valid-passports.txt"));
        PassportValidator validator = new PassportValidator(input);
        assertEquals(4, validator.getNumberOfValidPassports());
    }

    @Test
    public void testPartTwoProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("day4-input.txt"));
        PassportValidator validator = new PassportValidator(input);
        assertEquals(167, validator.getNumberOfValidPassports());
    }


}
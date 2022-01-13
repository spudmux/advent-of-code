package com.spudmux.aoc2020.day2;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PasswordValidatorTest {

    @Test
    public void testSampleInput() {
        ProblemInput input = new ProblemInput(Paths.get("day2-sample-input.txt"));
        PasswordValidator validator = new PasswordValidator();

        int numberOfValidPasswords = validator.countValidPasswordsMatchingPolicyOne(input);
        assertEquals(2, numberOfValidPasswords);
    }

    @Test
    public void testProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("day2-input.txt"));
        PasswordValidator validator = new PasswordValidator();

        int numberOfValidPasswords = validator.countValidPasswordsMatchingPolicyOne(input);
        assertEquals(383, numberOfValidPasswords);
    }

    @Test
    public void testCountValidPasswordsReturnsZeroOnEmptyInput() {
        ProblemInput mockInput = mock(ProblemInput.class);
        PasswordValidator validator = new PasswordValidator();
        when(mockInput.getInputAsListOfLines()).thenReturn(new ArrayList<String>());

        int countOfValidPasswords = validator.countValidPasswordsMatchingPolicyOne(mockInput);
        assertEquals(0, countOfValidPasswords);
        verify(mockInput).getInputAsListOfLines();
    }

    @Test
    public void testSampleInputPart2() {
        ProblemInput input = new ProblemInput(Paths.get("day2-sample-input.txt"));
        PasswordValidator validator = new PasswordValidator();

        int numberOfValidPasswords = validator.countValidPasswordsMatchingPolicyTwo(input);
        assertEquals(1, numberOfValidPasswords);
    }

    @Test
    public void testProblemInputPart2() {
        ProblemInput input = new ProblemInput(Paths.get("day2-input.txt"));
        PasswordValidator validator = new PasswordValidator();

        int numberOfValidPasswords = validator.countValidPasswordsMatchingPolicyTwo(input);
        assertEquals(272, numberOfValidPasswords);
    }
}
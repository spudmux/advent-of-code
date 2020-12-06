package com.spudmux.aoc2020.day5;

import com.spudmux.aoc2020.ProblemInput;
import com.spudmux.aoc2020.day5.BoardingPassValidator.BoardingPass;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public class BoardingPassValidatorTest {

    @Rule public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test public void testGetHighestSeatIdOnSampleProblemInput() {
        ProblemInput input = new ProblemInput("day5-sample-input.txt");

        BoardingPassValidator validator = new BoardingPassValidator();
        validator.process(input);
        softly.assertThat(validator.getHighestSeatId()).isEqualTo(820);
    }

    @Test public void testGetHighestSeatIdOnProblemInput() {
        ProblemInput input = new ProblemInput("day5-input.txt");

        BoardingPassValidator validator = new BoardingPassValidator();
        validator.process(input);
        softly.assertThat(validator.getHighestSeatId()).isEqualTo(880);
    }

    @Test public void testFindSeatOnProblemInput() {
        ProblemInput input = new ProblemInput("day5-input.txt");

        BoardingPassValidator validator = new BoardingPassValidator();
        validator.process(input);
        softly.assertThat(validator.getMySeatId()).isEqualTo(731);
    }

    @Test
    public void testBoardingPassSeatIndexCalculation() {
        BoardingPass pass = new BoardingPass("FBFBBFFRLR");
        softly.assertThat(pass.getSeatId()).isEqualTo(357);
        softly.assertThat(pass.getRow()).isEqualTo(44);
        softly.assertThat(pass.getColumn()).isEqualTo(5);

        softly.assertThat(new BoardingPass("BFFFBBFRRR").getSeatId()).isEqualTo(567);
        softly.assertThat(new BoardingPass("FFFBBBFRRR").getSeatId()).isEqualTo(119);
        softly.assertThat(new BoardingPass("BBFFBBFRLL").getSeatId()).isEqualTo(820);
    }



}
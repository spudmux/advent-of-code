package com.spudmux.aoc2020.day5;

import com.spudmux.aoc2020.ProblemInput;
import com.spudmux.aoc2020.day5.BoardingPassValidator.BoardingPass;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

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

    @Test
    public void testBoardingPassSeatIndexCalculation() {
        softly.assertThat(new BoardingPass("FBFBBFFRLR").getSeatId()).isEqualTo(357);
        softly.assertThat(new BoardingPass("BFFFBBFRRR").getSeatId()).isEqualTo(567);
        softly.assertThat(new BoardingPass("FFFBBBFRRR").getSeatId()).isEqualTo(119);
        softly.assertThat(new BoardingPass("BBFFBBFRLL").getSeatId()).isEqualTo(820);
    }



}
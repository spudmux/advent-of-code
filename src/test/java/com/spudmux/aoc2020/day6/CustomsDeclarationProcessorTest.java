package com.spudmux.aoc2020.day6;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class CustomsDeclarationProcessorTest {

    @Test public void testWithSampleProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("day6-sample-input.txt"));
        CustomsDeclarationProcessor processor = new CustomsDeclarationProcessor();

        assertThat(processor.getSumOfAnyYeses(input)).isEqualTo(11);
    }

    @Test public void testWithProblemInput() {
        ProblemInput input = new ProblemInput(Paths.get("day6-input.txt"));
        CustomsDeclarationProcessor processor = new CustomsDeclarationProcessor();

        assertThat(processor.getSumOfAnyYeses(input)).isEqualTo(6249);
    }

    @Test public void testWithSampleProblemInputPart2() {
        ProblemInput input = new ProblemInput(Paths.get("day6-sample-input.txt"));
        CustomsDeclarationProcessor processor = new CustomsDeclarationProcessor();

        assertThat(processor.getSumOfAllYeses(input)).isEqualTo(6);
    }

    @Test public void testWithProblemInputPart2() {
        ProblemInput input = new ProblemInput(Paths.get("day6-input.txt"));
        CustomsDeclarationProcessor processor = new CustomsDeclarationProcessor();

        assertThat(processor.getSumOfAllYeses(input)).isEqualTo(3103);
    }

}
package com.spudmux.aoc2020.day7;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class LuggageProcessorTest {

  @Test public void testLuggageProcessorWithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("day7-sample-input.txt"));
    LuggageProcessor luggageProcessor = new LuggageProcessor();
    luggageProcessor.process(input);
    assertThat(luggageProcessor.getNumberOfBagColoursContaining("shiny gold")).isEqualTo(4);
  }

  @Test public void testLuggageProcessorWithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("day7-input.txt"));
    LuggageProcessor luggageProcessor = new LuggageProcessor();
    luggageProcessor.process(input);
    assertThat(luggageProcessor.getNumberOfBagColoursContaining("shiny gold")).isEqualTo(119);
  }

  @Test public void testPartTwoCountingBagsInsideWithSampleInputOne() {
    ProblemInput input = new ProblemInput(Paths.get("day7-sample-input.txt"));
    LuggageProcessor luggageProcessor = new LuggageProcessor();
    luggageProcessor.process(input);
    assertThat(luggageProcessor.getCountOfBagsInside("shiny gold")).isEqualTo(32);
  }

  @Test public void testPartTwoCountingBagsInsideWithSampleInputTwo() {
    ProblemInput input = new ProblemInput(Paths.get("day7-sample-input-part-2.txt"));
    LuggageProcessor luggageProcessor = new LuggageProcessor();
    luggageProcessor.process(input);
    assertThat(luggageProcessor.getCountOfBagsInside("shiny gold")).isEqualTo(126);
  }

  @Test public void testPartTwoCountingBagsInsideWithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("day7-input.txt"));
    LuggageProcessor luggageProcessor = new LuggageProcessor();
    luggageProcessor.process(input);
    assertThat(luggageProcessor.getCountOfBagsInside("shiny gold")).isEqualTo(155802);
  }
}

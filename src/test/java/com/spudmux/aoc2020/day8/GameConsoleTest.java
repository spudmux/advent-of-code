package com.spudmux.aoc2020.day8;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GameConsoleTest {

  @Test public void testGameConsoleWithSampleInput() {
    ProblemInput input = new ProblemInput("day8-sample-input.txt");
    GameConsole gameConsole = new GameConsole();
    gameConsole.loadCode(input.getInputAsListOfLines());
    assertThat(gameConsole.findDuplicateInstructionCall()).isEqualTo(5);
  }

  @Test public void testGameConsoleWithProblemInput() {
    ProblemInput input = new ProblemInput("day8-input.txt");
    GameConsole gameConsole = new GameConsole();
    gameConsole.loadCode(input.getInputAsListOfLines());
    assertThat(gameConsole.findDuplicateInstructionCall()).isEqualTo(1600);
  }

  @Test public void testGameConsoleWithSampleInputPartTwo() {
    ProblemInput input = new ProblemInput("day8-sample-input.txt");
    GameConsole gameConsole = new GameConsole();
    gameConsole.loadCode(input.getInputAsListOfLines());
    assertThat(gameConsole.fixAndRunProgram()).isEqualTo(8);
  }

  @Test public void testGameConsoleWithProblemInputPartTwo() {
    ProblemInput input = new ProblemInput("day8-input.txt");
    GameConsole gameConsole = new GameConsole();
    gameConsole.loadCode(input.getInputAsListOfLines());
    assertThat(gameConsole.fixAndRunProgram()).isEqualTo(1543);
  }

}

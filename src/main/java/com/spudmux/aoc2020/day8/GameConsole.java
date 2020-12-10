package com.spudmux.aoc2020.day8;

import java.util.HashSet;
import java.util.List;

public class GameConsole {

    private int accumulator = 0;
    private int programCounter = 0;

    private List<String> instructions;
    private final HashSet<Integer> executedInstructions = new HashSet<>();

    public void loadCode(List<String> inputAsListOfLines) {
        this.instructions = inputAsListOfLines;
    }

    public int findDuplicateInstructionCall() {
        runProgram(instructions);
        return accumulator;
    }

    public int fixAndRunProgram() {
        for (int i = 0; i < instructions.size(); i++) {
            String ins = instructions.get(i);
            if (ins.startsWith("nop")) {
                instructions.set(i, ins.replace("nop", "jmp"));
                runProgram(instructions);
                if (programCounter == instructions.size()) {
                    return accumulator;
                }
                instructions.set(i, ins.replace("jmp", "nop"));
            } else if (ins.startsWith("jmp")) {
                instructions.set(i, ins.replace("jmp", "nop"));
                runProgram(instructions);
                if (programCounter == instructions.size()) {
                    return accumulator;
                }
                instructions.set(i, ins.replace("nop", "jmp"));
            }
        }
        return accumulator;
    }

    private void reset() {
        accumulator = 0;
        programCounter = 0;
        executedInstructions.clear();
    }

    private void  runProgram(List<String> instructions) {
        reset();
        while (programCounter < instructions.size()) {
            if (shouldTerminate()){
                return;
            }
            String opp = instructions.get(programCounter).split(" ")[0];
            String arg = instructions.get(programCounter).split(" ")[1];
            if ("acc".equals(opp)) {
                accumulator += Integer.parseInt(arg);
                programCounter++;
            } else if ("jmp".equals(opp)) {
                programCounter += Integer.parseInt(arg);
            } else if ("nop".equals(opp)) {
                programCounter++;
            }
        }
    }

    private boolean shouldTerminate() {
        if (executedInstructions.contains(programCounter)){
            return true;
        }
        executedInstructions.add(programCounter);
        return false;
    }


}

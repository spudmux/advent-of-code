package com.spudmux.aoc2021.day18;

import com.spudmux.aoc2020.ProblemInput;

import java.util.Stack;

public class Day18 {

    private final Stack<Integer> stack;

    public Day18(ProblemInput input) {
        String[] in = input.getInputAsString().split("");
        stack = new Stack<>();
        parseInput(in, 0);
    }

    private void parseInput(String[] input, int position) {
        if (position >= input.length) {
            return;
        }
        String token = input[position];
        switch (token) {
            case "[":
            case ",":
                parseInput(input, ++position);
                break;
            case "]":
                System.out.println(stack);
                parseInput(input, ++position);
                break;
            default:
                stack.push(Integer.parseInt(token));
                parseInput(input, ++position);
        }
    }


    private static class Tree {
        Node root;
    }

    private static class Node {
        Node left;
        Node right;
        int value;
    }

    public int solvePart1() {
        return 0;
    }

    public int solvePart2() {
        return 0;
    }

}

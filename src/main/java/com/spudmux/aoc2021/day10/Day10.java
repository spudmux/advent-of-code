package com.spudmux.aoc2021.day10;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.spudmux.aoc2020.ProblemInput;

import java.math.BigDecimal;
import java.util.*;

public class Day10 {

    List<String> rawLines;
    List<Stack<Character>> completionLines;
    private final BiMap<Character, Character> matching = HashBiMap.create();
    private final Map<Character, Integer> autocompleteScores = new HashMap<>();
    private final Map<Character, Integer> errorScores = new HashMap<>();

    public Day10(ProblemInput input) {
        rawLines = input.getInputAsListOfLines();
        completionLines = new ArrayList<>();
        initialiseMaps();
    }

    private void initialiseMaps() {
        matching.put(')', '(');
        matching.put('>', '<');
        matching.put('}', '{');
        matching.put(']', '[');

        autocompleteScores.put(')', 1);
        autocompleteScores.put(']', 2);
        autocompleteScores.put('}', 3);
        autocompleteScores.put('>', 4);

        errorScores.put(')', 3);
        errorScores.put(']', 57);
        errorScores.put('}', 1197);
        errorScores.put('>', 25137);
    }

    public int solvePart1() {
        List<Character> errors = new ArrayList<>();
        for (String line : rawLines) {
            Stack<Character> delimiters = new Stack<>();
            boolean noErrors = true;
            for (char c : line.toCharArray()) {
                if ('(' == c || '<' == c || '{' == c || '[' == c) {
                    delimiters.push(c);
                } else if (')' == c || '>' == c || '}' == c || ']' == c) {
                    if (delimiters.peek() == matching.get(c)) {
                        delimiters.pop();
                    } else {
                        Character expected = matching.inverse().get(delimiters.peek());
                        System.out.println("Expected " + expected + ", but found " + c + " instead");
                        errors.add(c);
                        noErrors = false;
                        break;
                    }
                }
            }
            if (noErrors) {
                Stack<Character> autoComplete = new Stack<>();
                for (Character c : delimiters) {
                    autoComplete.push(matching.inverse().get(c));
                }
                completionLines.add(autoComplete);
            }
        }
        return errors.stream().map(this::scoreError).reduce(Integer::sum).orElseGet(() -> 0);
    }

    private int scoreError(Character character) {
        return errorScores.getOrDefault(character, 0);
    }

    public BigDecimal solvePart2() {
        solvePart1();
        List<BigDecimal> lineScores = new ArrayList<>();
        for (Stack<Character> autocomplete : completionLines) {
            BigDecimal score = BigDecimal.ZERO;
            List<Character> reversedList = new ArrayList<>(autocomplete);
            Collections.reverse(reversedList);
            for (Character c : reversedList) {
                score = score.multiply(BigDecimal.valueOf(5));
                score = score.add(BigDecimal.valueOf(autocompleteScores.get(c)));
            }
            lineScores.add(score);
        }
        lineScores.sort(BigDecimal::compareTo);
        return lineScores.get((lineScores.size()-1)/2);
    }

}

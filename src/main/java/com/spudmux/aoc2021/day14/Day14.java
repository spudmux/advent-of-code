package com.spudmux.aoc2021.day14;

import com.spudmux.aoc2020.ProblemInput;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 {

    private final String template;
    private final Map<String, List<String>> rules;

    public Day14(ProblemInput input) {
        List<String> lines = input.getInputAsListOfLines();
        template = lines.get(0);
        rules = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            String[] line = lines.get(i).split(" -> ");
            String key = line[0];
            ArrayList<String> values = new ArrayList<>();
            values.add(key.charAt(0) + line[1]);
            values.add(line[1] + key.charAt(1));
            rules.put(key, values);
        }
    }

    public int solvePart1() {
        return run(10).intValue();
    }

    public BigInteger solvePart2() {
        return run(40);
    }

    private BigInteger run(int steps) {
        Map<String, Long> pairs = new HashMap<>();
        for (int i = 0; i < template.length() - 1; i++) {
            String key = template.substring(i, i + 2);
            pairs.put(key, 1L);
        }
        for (int i = 0; i < steps; i++) {
            Map<String, Long> newPairs = new HashMap<>();
            for (String parent : pairs.keySet()) {
                String childOne = rules.get(parent).get(0);
                String childTwo = rules.get(parent).get(1);
                newPairs.put(childOne, newPairs.getOrDefault(childOne, 0L) + pairs.get(parent));
                newPairs.put(childTwo, newPairs.getOrDefault(childTwo, 0L) + pairs.get(parent));
            }
            pairs = newPairs;
        }
        return subtractMinFromMax(pairs);
    }

    private BigInteger subtractMinFromMax(Map<String, Long> pairs) {
        Map<Character, Long> sums = new HashMap<>();
        sums.put(template.charAt(template.length() - 1), 1L);
        for (Map.Entry<String, Long> entry : pairs.entrySet()) {
            Character c = entry.getKey().charAt(0);
            sums.put(c, sums.getOrDefault(c, 0L) + entry.getValue());
        }
        long answer = sums.values().stream().max(Long::compare).get() - sums.values().stream().min(Long::compare).get();
        return BigInteger.valueOf(answer);
    }

}

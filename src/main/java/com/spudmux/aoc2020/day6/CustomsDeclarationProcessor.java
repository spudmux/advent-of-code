package com.spudmux.aoc2020.day6;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomsDeclarationProcessor {

    private int sumOfYeses;

    public int getSumOfAnyYeses(ProblemInput input) {
        List<String> groupsAnswers = new ArrayList<>();
        for (String line : input.getInputAsListOfLines()) {
            if ("".equals(line)) {
                String uniqueAnswers = Arrays.stream(groupsAnswers
                        .stream()
                        .reduce("", (subtotal, element) -> subtotal + element)
                        .split("")).distinct().collect(Collectors.joining());
                sumOfYeses += uniqueAnswers.length();
                groupsAnswers.clear();
                continue;
            }
            groupsAnswers.add(line);
        }
        String uniqueAnswers = Arrays.stream(groupsAnswers
                .stream()
                .reduce("", (subtotal, element) -> subtotal + element)
                .split("")).distinct().collect(Collectors.joining());
        sumOfYeses += uniqueAnswers.length();
        return sumOfYeses;
    }

    public int getSumOfAllYeses(ProblemInput input) {
        List<String> groupsAnswers = new ArrayList<>();
        for (String line : input.getInputAsListOfLines()) {
            if ("".equals(line)) {
                Set<Character> allYeses = groupsAnswers
                        .get(0)
                        .chars()
                        .mapToObj(e -> {
                            return (char) e;
                        }).collect(Collectors.toSet());
                List<Set<Character>> sets = groupsAnswers
                        .stream()
                        .map(s -> s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet()))
                        .collect(Collectors.toList());
                for (Set<Character> s : sets) {
                    allYeses.retainAll(s);
                }
                sumOfYeses += allYeses.size();
                groupsAnswers.clear();
                continue;
            }
            groupsAnswers.add(line);
        }
        Set<Character> allYeses = groupsAnswers
                .get(0)
                .chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
        groupsAnswers
                .stream()
                .map(s -> s.chars().mapToObj(e -> (char) e)
                        .collect(Collectors.toSet()))
                .map(s -> allYeses.retainAll(s));
        sumOfYeses += allYeses.size();
        return sumOfYeses;
    }
}

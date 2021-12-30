package com.spudmux.aoc2021.day12;

import com.spudmux.aoc2020.ProblemInput;

import java.util.*;

public class Day12 {

    private Map<String, List<String>> graph;
    int numberOfPaths = 0;

    public Day12(ProblemInput input) {
        List<String> lines = input.getInputAsListOfLines();
        loadGraph(lines);
    }

    private void loadGraph(List<String> lines) {
        graph = new HashMap<>();
        for (String line : lines) {
            String[] edge = line.split("-");
            assert edge.length == 2;
            if (graph.containsKey(edge[0]) && !graph.get(edge[0]).contains(edge[1])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                List<String> neighbours = new ArrayList<>();
                neighbours.add(edge[1]);
                graph.put(edge[0], neighbours);
            }
            if (graph.containsKey(edge[1]) && !graph.get(edge[1]).contains(edge[0])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                List<String> neighbours = new ArrayList<>();
                neighbours.add(edge[0]);
                graph.put(edge[1], neighbours);
            }
        }
    }

    private void search(Stack<String> path) {
        if ("end".equals(path.peek())) {
            numberOfPaths++;
        }
        for (String s : graph.getOrDefault(path.peek(), new ArrayList<>())) {
            if (!path.contains(s) || Character.isUpperCase(s.codePointAt(0))) {
                path.push(s);
                search(path);
                path.pop();
            }
        }
    }

    private void searchWithRepeats(Stack<String> path) {
        if ("end".equals(path.peek())) {
            numberOfPaths++;
            return;
        }
        for (String s : graph.getOrDefault(path.peek(), new ArrayList<>())) {
            if (Character.isUpperCase(s.codePointAt(0)) || canVisitSmallCave(s, path)) {
                path.push(s);
                searchWithRepeats(path);
                path.pop();
            }
        }
    }

    private boolean canVisitSmallCave(String s, Stack<String> path) {
        if ("start".equals(s) || !Character.isLowerCase(s.codePointAt(0))) {
            return false;
        }
        if ("end".equals(s)) {
            return true;
        }
        boolean visitedTwoSmallCaves = false;
        for (String s1 : path) {
            if (Character.isLowerCase(s1.codePointAt(0)) && path.stream().filter(s1::equals).count() >= 2) {
                visitedTwoSmallCaves = true;
                break;
            }
        }
        if (!visitedTwoSmallCaves) {
            return true;
        }
        return !path.contains(s);
    }

    public int solvePart1() {
        Stack<String> path = new Stack<>();
        path.push("start");
        search(path);
        return numberOfPaths;
    }

    public int solvePart2() {
        Stack<String> path = new Stack<>();
        path.push("start");
        searchWithRepeats(path);
        return numberOfPaths;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : graph.keySet()) {
            sb.append(s);
            sb.append(": ");
            sb.append(graph.get(s));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

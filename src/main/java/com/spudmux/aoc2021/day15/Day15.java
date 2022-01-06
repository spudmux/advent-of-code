package com.spudmux.aoc2021.day15;

import com.spudmux.aoc.Position;
import com.spudmux.aoc2020.ProblemInput;

import java.util.*;

public class Day15 {

    private int[][] grid;

    public Day15(ProblemInput input) {
        grid = input.getInputAs2DArray();
    }

    public int solvePart1() {
        return pathSearch();
    }

    private int pathSearch() {
        Set<Position> unvisited = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        Map<Position, Integer> distances = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Position position = new Position(i, j);
                unvisited.add(position);
                distances.put(position, Integer.MAX_VALUE);
            }
        }
        Position start = new Position(0, 0);
        unvisited.remove(start);
        distances.put(start, 0);
        queue.add(new Node(start, 0));

        while (!unvisited.isEmpty()) {
            Node node = queue.poll();
            List<Position> neighbours = node.position.getAdjacentPoints(0, grid.length, 0, grid[grid.length - 1].length);
            for (Position neighbour : neighbours) {
                int alt = distances.get(node.position) + grid[neighbour.getX()][neighbour.getY()];
                if (alt < distances.get(neighbour)) {
                    distances.put(neighbour, alt);
                    queue.add(new Node(neighbour, alt));
                    unvisited.remove(neighbour);
                }
            }
        }
        return distances.get(new Position(grid.length - 1, grid[grid.length - 1].length - 1));
    }

    private static class Node {
        Position position;
        int distance;

        public Node(Position position) {
            this.position = position;
        }

        public Node(Position position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }

    public int solvePart2() {
        expandGrid(5);
        return solvePart1();
    }

    private void expandGrid(int numberOfTiles) {
        int xMax = grid.length;
        int yMax = grid[grid.length - 1].length;
        int[][] newGrid = new int[xMax * numberOfTiles][yMax * numberOfTiles];
        for (int i = 0; i < newGrid.length; i++) {
            newGrid[i] = new int[newGrid[i].length];
        }
        for (int i = 0; i < numberOfTiles; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[j].length; k++) {
                    int value = grid[j][k] + i;
                    newGrid[j][(i * yMax) + k] = value <= 9 ? value : Math.abs(value - 9);
                }
            }
        }
        for (int i = 1; i < numberOfTiles; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < newGrid[j].length; k++) {
                    int value = newGrid[j][k] + i;
                    newGrid[(i * xMax) + j][k] = value <= 9 ? value : Math.abs(value - 9);
                }
            }
        }
        grid = newGrid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

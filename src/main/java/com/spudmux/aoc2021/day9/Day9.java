package com.spudmux.aoc2021.day9;

import com.spudmux.aoc2020.ProblemInput;

import java.util.*;

public class Day9 {

    int[][] heightMap;
    static int iMax, jMax;
    List<Point> lowPoints = new ArrayList<>();

    public Day9(ProblemInput input) {
        List<String> inputs = input.getInputAsListOfLines();
        heightMap = new int[inputs.size() + 2][inputs.get(0).length() + 2];
        iMax = heightMap.length;
        jMax = heightMap[0].length;
        int[] firstRow = new int[inputs.get(0).length() + 2];
        Arrays.fill(firstRow, Integer.MAX_VALUE);
        int[] lastRow = new int[inputs.get(0).length() + 2];
        Arrays.fill(lastRow, Integer.MAX_VALUE);
        heightMap[0] = firstRow;
        heightMap[heightMap.length - 1] = lastRow;
        for (int i = 1; i < inputs.size() + 1; i++) {
            int[] paddedLine = new int[inputs.get(i - 1).length() + 2];
            paddedLine[0] = Integer.MAX_VALUE;
            paddedLine[paddedLine.length - 1] = Integer.MAX_VALUE;
            int[] src = Arrays.stream(inputs.get(i - 1).split("")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(src, 0, paddedLine, 1, paddedLine.length - 2);
            heightMap[i] = paddedLine;
        }
    }

    public int sumRiskLevels() {
        List<Integer> lowPointValues = new ArrayList<>();
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j <= heightMap[i].length - 1; j++) {
                int location = heightMap[i][j];
                if (heightMap[i - 1][j] > location && heightMap[i + 1][j] > location &&
                        heightMap[i][j - 1] > location && heightMap[i][j + 1] > location) {
                    lowPointValues.add(location);
                    lowPoints.add(new Point(i, j));
                }
            }
        }
        return lowPointValues.stream().map(i -> i + 1).reduce(0, Integer::sum);
    }

    public void printArray() {
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[i].length; j++) {
                System.out.print(heightMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumBasins() {
        sumRiskLevels();
        List<Integer> basinSizes = new ArrayList<>();
        for (Point p : lowPoints) {
            Map<Point, Boolean> visited = new HashMap<>();
            Queue<Point> toExplore = new LinkedList<>();
            toExplore.add(p);
            visited.put(p, true);
            basinSizes.add(exploreBasinSize(toExplore, visited) + 1);
        }
        basinSizes.sort(Integer::compare);
        System.out.println(basinSizes);
        int n = basinSizes.size();
        return basinSizes.get(n-1) * basinSizes.get(n-2) * basinSizes.get(n-3);
    }

    private int exploreBasinSize(Queue<Point> toExplore, Map<Point, Boolean> visited) {
        if (toExplore.isEmpty()) {
            return 0;
        }
        Point p = toExplore.poll();
//        System.out.println(p.x + " " + p.y + " " + heightMap[p.x][p.y]);
        List<Point> neighbours = getNeighbours(p);
        int sum = 0;
        for (Point neighbour : neighbours) {
            if (neighbour.isInBounds() && heightMap[neighbour.x][neighbour.y] < 9
                    && !visited.getOrDefault(neighbour, false)) {
                visited.put(neighbour, true);
                toExplore.add(neighbour);
                sum++;
            }
        }
        return sum + exploreBasinSize(toExplore, visited);
    }

    private List<Point> getNeighbours(Point p) {
        List<Point> neighbours = new ArrayList<>();
        neighbours.add(new Point(p.x - 1, p.y));
        neighbours.add(new Point(p.x + 1, p.y));
        neighbours.add(new Point(p.x, p.y - 1));
        neighbours.add(new Point(p.x, p.y + 1));
        return neighbours;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean isInBounds() {
            return x > 0 && x < iMax && y > 0 && y < jMax;
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}

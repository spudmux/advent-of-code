package com.spudmux.aoc2021.day17;

import com.spudmux.aoc.Position;
import com.spudmux.aoc2020.ProblemInput;

import java.util.*;
import java.util.stream.Collectors;

public class Day17 {

    private int[] targetArea;
    private List<Probe> onTargetProbes;

    public Day17(ProblemInput input) {
        parseInput(input.getInputAsString());
    }

    private void parseInput(String input) {
        String[] splitInput = input
                .replace("..", " ")
                .replace("=", " ")
                .split("[ ,]");
        targetArea = new int[] {
                Integer.parseInt(splitInput[3]),
                Integer.parseInt(splitInput[4])+1,
                Integer.parseInt(splitInput[7]),
                Integer.parseInt(splitInput[8])+1
        };
        System.out.println(Arrays.toString(targetArea));
    }

    public int solvePart1() {
        Set<Probe> probes = new HashSet<>();
        int xMax = 270, yMax = 115;
        for (int x = 1; x < xMax; x++) {
            for (int y = -200; y < yMax; y++) {
                probes.add(new Probe(x, y));
            }
        }
        onTargetProbes = hitsTarget(probes);
        if (onTargetProbes.isEmpty()) {
            return 0;
        }
        System.out.println(onTargetProbes.size());
        Probe lastProbe = onTargetProbes.get(onTargetProbes.size() - 1);
        System.out.println(lastProbe);
        return lastProbe.maxHeight;
    }

    public List<Probe> hitsTarget(Set<Probe> probes) {
        Set<Probe> onTarget = new HashSet<>();
        while (!probes.isEmpty()) {
            for (Probe probe : probes.toArray(Probe[]::new)) {
                probe.updatePosition();
                if (probe.isInBounds(targetArea)) {
                    onTarget.add(probe);
                    probes.remove(probe);
                } else if (!probe.canReachTarget(targetArea)) {
                    probes.remove(probe);
                }
            }
        }
        return onTarget.stream().sorted(Comparator.comparingInt(probe -> probe.maxHeight)).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean hitsTarget(Probe a) {
        while (!a.isInBounds(targetArea) && a.canReachTarget(targetArea)) {
            a.updatePosition();
        }
        return a.isInBounds(targetArea);
    }

    public static class Probe {
        Position position;
        Position velocity;
        Position initialVelocity;
        int maxHeight;

        Probe(int xVelocity, int yVelocity) {
            position = new Position(0, 0);
            velocity = new Position(xVelocity, yVelocity);
            initialVelocity = new Position(xVelocity, yVelocity);
            maxHeight = position.getY();
        }

        public boolean isInBounds(int[] bounds) {
            return position.isInBounds(bounds);
        }

        public void updatePosition() {
            position.setX(position.getX() + velocity.getX());
            position.setY(position.getY() + velocity.getY());
            if (velocity.getX() > 0) {
                velocity.setX(velocity.getX() - 1);
            } else if (velocity.getX() < 0) {
                velocity.setX(velocity.getX() + 1);
            }
            velocity.setY(velocity.getY() - 1);
            if (position.getY() > maxHeight) {
                maxHeight = position.getY();
            }
        }

        public String toString() {
            return initialVelocity.toString()+", "+velocity.toString()+", "+position.toString()+" H:"+maxHeight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Probe probe = (Probe) o;
            return initialVelocity.equals(probe.initialVelocity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(initialVelocity);
        }

        public boolean canReachTarget(int[] bounds) {
            if (velocity.getX() == 0 && position.getX() < bounds[0]) {
                return false;
            }
            if (position.getX() > bounds[1]) {
                return false;
            }
            if (position.getY() < bounds[2]) {
                return false;
            }
            return true;
        }
    }

    public int solvePart2() {
        solvePart1();
        return onTargetProbes.size();
    }

}

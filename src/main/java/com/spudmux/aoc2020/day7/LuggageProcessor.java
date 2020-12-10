package com.spudmux.aoc2020.day7;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LuggageProcessor {

    List<List<Bag>> rules = new ArrayList<>();

    public void process(ProblemInput input) {
        for (String line : input.getInputAsListOfLines()) {
            String[] tokens = line.split(" ");
            Bag bag = new Bag(tokens[0] + " " + tokens[1]);
            String rawContents = line.replaceFirst("^.*bags contain (no other bags.)?", "");
            String[] additionalBags = Arrays
                    .stream(rawContents.split(","))
                    .filter(str -> str.length() != 0).toArray(String[]::new);
            List<Bag> bagRule = new ArrayList<>();
            bagRule.add(bag);
            for (String additionalBag : additionalBags) {
                tokens = additionalBag.trim().split(" ");
                Bag b = new Bag(tokens[1] + " " + tokens[2], Integer.parseInt(tokens[0]));
                bagRule.add(b);
            }
            rules.add(bagRule);
        }
    }

    public int getNumberOfBagColoursContaining(String targetBagColour) {
        HashSet<Bag> bagsContaining = (HashSet<Bag>) getBagsContaining(new Bag(targetBagColour), new HashSet<Bag>());
        return bagsContaining.size();
    }

    private Set<Bag> getBagsContaining(Bag targetBag, Set<Bag> bagsContainingTargetBag) {
        if (bagsContainingTargetBag.contains(targetBag)) {
            return bagsContainingTargetBag;
        }
        for (List<Bag> bags : rules) {
            if (bags.stream().skip(1).anyMatch(b -> b.equals(targetBag))) {
                getBagsContaining(bags.get(0), bagsContainingTargetBag);
                bagsContainingTargetBag.add(bags.get(0));
            }
        }
        return bagsContainingTargetBag;
    }

    public int getCountOfBagsInside(String outerBag) {
        int totalOfSubBags = 0;
        List<Bag> contents = rules.stream().filter(bags -> bags.get(0).equals(new Bag(outerBag))).collect(Collectors.toList()).get(0);
        return countBagsInside(new Bag(outerBag), 1)-1;
    }

    private int countBagsInside(Bag bag, int level) {
        assert rules.stream().filter(bags -> bags.get(0).equals(bag)).count() == 1;
        List<Bag> contents = rules.stream().filter(bags -> bags.get(0).equals(bag)).collect(Collectors.toList()).get(0);
        if (contents.size() == 1) {
            return bag.amount;
        }
        int totalOfSubBags = 0;
        for (Bag bag1 : contents.stream().skip(1).collect(Collectors.toList())) {
            totalOfSubBags += countBagsInside(bag1, level+4) * bag.amount;
        }
        return totalOfSubBags + bag.amount;
    }


    static class Bag {
        String name;
        int amount;

        public Bag(String name) {
            this.name = name;
            amount = 1;
        }

        public Bag(String name, int amount) {
                this.name = name;
                this.amount = amount;
            }

            @Override
            public boolean equals (Object o){
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Bag bag = (Bag) o;
                return name.equals(bag.name);
            }

            @Override
            public int hashCode () {
                return Objects.hash(name);
            }

            @Override
            public String toString () {
                return "Bag{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
}

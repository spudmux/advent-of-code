package com.spudmux.aoc2021.day8;

import com.spudmux.aoc2020.ProblemInput;

import java.util.*;

/**
 * 2 segments: 1
 * 3 segments: 7
 * 4 segments: 4
 * 5 segments: 2, 3, 5
 * 6 segments: 0, 6, 9
 * 7 segments: 8
 *
 *   0:      1:      2:      3:      4:
 *  aaaa    ....    aaaa    aaaa    ....
 * b    c  .    c  .    c  .    c  b    c
 * b    c  .    c  .    c  .    c  b    c
 *  ....    ....    dddd    dddd    dddd
 * e    f  .    f  e    .  .    f  .    f
 * e    f  .    f  e    .  .    f  .    f
 *  gggg    ....    gggg    gggg    ....
 *
 *   5:      6:      7:      8:      9:
 *  aaaa    aaaa    aaaa    aaaa    aaaa
 * b    .  b    .  .    c  b    c  b    c
 * b    .  b    .  .    c  b    c  b    c
 *  dddd    dddd    ....    dddd    dddd
 * .    f  e    f  .    f  e    f  .    f
 * .    f  e    f  .    f  e    f  .    f
 *  gggg    gggg    ....    gggg    gggg
 */
public class Day8 {

    List<String> lines;

    public Day8(ProblemInput input) {
        lines = input.getInputAsListOfLines();
    }

    public int countDigits() {
        int count = 0;
        for (String line : lines) {
            String[] inputs = line.split("\\|")[1].split("\\s+");
            for (String i : inputs) {
                if (i.length() == 2 || i.length() == 3 || i.length() == 4 || i.length() == 7) {
                    count++;
                }
            }
        }
        return count;
    }

    public int sumOutputs() {
        int count = 0;
        for (String line : lines) {
            String[] signals = line.split("\\|")[0].split("\\s+");
            String[] outputs = line.split("\\|")[1].split("\\s+");
            Entry entry = new Entry(signals, outputs);
            int result = entry.decode();
            count += result;
//            System.out.println(line);
//            System.out.println("outputMap: "+entry.signalMap);
//            System.out.println("signalMap: "+entry.digitToSegments);
        }
        return count;
    }

    private static String removeAll(String s, String s1) {
        StringBuilder sb = new StringBuilder();
        for (char c : s1.toCharArray()) {
            if (!s.contains("" + c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static class Entry {
        List<String> outputs;
        List<String> observationsLength5;
        List<String> observationsLength6;
        Map<String, String> signalMap = new HashMap<>();
        Map<Integer, String> digitToSegments = new HashMap<>();
        Map<String, Integer> segmentsToDigit = new HashMap<>();


        public Entry(String[] signals, String[] outputs) {
            this.outputs = Arrays.asList(outputs);
            this.observationsLength5 = new ArrayList<>();
            this.observationsLength6 = new ArrayList<>();
            for (String i : signals) {
                switch (i.length()) {
                    case 2:
                        digitToSegments.put(1, i);
                        segmentsToDigit.put(i, 1);
                        break;
                    case 3:
                        digitToSegments.put(7, i);
                        segmentsToDigit.put(i, 7);
                        break;
                    case 4:
                        digitToSegments.put(4, i);
                        segmentsToDigit.put(i, 4);
                        break;
                    case 5:
                        observationsLength5.add(i);
                        break;
                    case 6:
                        observationsLength6.add(i);
                        break;
                    case 7:
                        digitToSegments.put(8, i);
                        segmentsToDigit.put(i, 8);
                        break;
                }
            }
        }

        public int decode() {
            String a = Day8.removeAll(digitToSegments.get(1), digitToSegments.get(7));
            assert a.length() == 1;
            signalMap.put("a", a);
            find(9, observationsLength6, "g", 4, 7);
            find(2, observationsLength5, "e", 9);
            find(3, observationsLength5, "f", 2);
            find(5, observationsLength5, "b", 1, 2);
            find(6, observationsLength6, "e", 5);
            find(0, observationsLength6, "c", 6);
            StringBuilder outputDigits = new StringBuilder();
            for (String output : outputs) {
                for (String value : digitToSegments.values()) {
                    if (output.length() == value.length()) {
                        char[] outputChars = output.toCharArray();
                        char[] valueChars = value.toCharArray();
                        Arrays.sort(valueChars);
                        Arrays.sort(outputChars);
                        if (Arrays.equals(outputChars, valueChars)) {
                            outputDigits.append(segmentsToDigit.get(value));
                            break;
                        }
                    }
                }
            }
            return Integer.parseInt(outputDigits.toString());
        }

        private void find(int number, List<String> displays, String segmentMatch, int... remove) {
            for (String segments : displays) {
                String filteredSegments = segments;
                for (int i : remove) {
                    filteredSegments = removeAll(digitToSegments.get(i), filteredSegments);
                }
                if (filteredSegments.length() == 1) {
                    digitToSegments.put(number, segments);
                    segmentsToDigit.put(segments, number);
                    signalMap.put(segmentMatch, filteredSegments);
                    displays.remove(segments);
                    break;
                }
            }
        }
    }
}

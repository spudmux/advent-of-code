package com.spudmux.aoc2021.day16;

import com.google.common.base.Strings;
import com.spudmux.aoc2020.ProblemInput;

import java.math.BigInteger;
import java.util.*;

public class Day16 {

    Map<String, Integer> symbolLength;
    private int position = 0;
    private int sumOfVersions = 0;
    private final Character[] bitStream;
    private long result;

    public Day16(ProblemInput input) {
        System.out.println(input.getInputAsString());
        String bits = Arrays.stream(input.getInputAsListOfLines().get(0).split(""))
                .map(s -> {
                    String b = new BigInteger(s, 16).toString(2);
                    return Strings.padStart(b, 4, '0');
                })
                .reduce(String::concat).orElse("");
        System.out.println(bits);
        bitStream = bits.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
        symbolLength = new HashMap<>();
        symbolLength.put("version", 3);
        symbolLength.put("type", 3);
        symbolLength.put("lengthType", 1);
    }

    public int solvePart1() {
        result = processPackets();
        if (position < bitStream.length) {
            System.out.println("WARN: end of bit stream not parsed, position " + position + ", length " + bitStream.length);
            printRestOfStream();
        }
        return sumOfVersions;
    }

    private void printRestOfStream() {
        System.out.print("Remaining: ");
        while (position < bitStream.length) {
            System.out.print(bitStream[position++]);
        }
        System.out.println();
    }

    public long processPackets() {
        if (position >= bitStream.length) {
            throw new RuntimeException("processing passed end of bit stream. position: "
                    +position+" bit stream length: "+bitStream.length );
        }
        int version = (int) bitStringToDecimalValue(consume(symbolLength.get("version")));
        int type = (int) bitStringToDecimalValue(consume(symbolLength.get("type")));
        System.out.print("Version: " + version + ", Type: " + type);
        sumOfVersions += version;
        if (type == 4) {
            return processLiteralPacket();
        } else {
            return processOperatorPacket(type);
        }
    }

    private long processOperatorPacket(int type) {
        List<Long> results = new ArrayList<>();
        System.out.println();
        String v = bitStringToDecimalString(consume(symbolLength.get("lengthType")));
        if ("0".equals(v)) {
            int length = (int) bitStringToDecimalValue(consume(15));
            int end = position + length;
            while (position < end && position < bitStream.length) {
                results.add(processPackets());
            }
            assert end == position;
        } else if ("1".equals(v)) {
            int length = (int) bitStringToDecimalValue(consume(11));
            while (length > 0) {
                results.add(processPackets());
                length--;
            }
        }
        switch (type) {
            case 0:
                return results.stream().mapToLong(Long::longValue).sum();
            case 1:
                return results.stream().reduce((aLong, aLong2) -> aLong *= aLong2).get();
            case 2:
                return results.stream().min(Long::compare).get();
            case 3:
                return results.stream().max(Long::compare).get();
            case 5:
                return (long) (results.get(0).compareTo(results.get(1)) > 0 ? 1 : 0);
            case 6:
                return (long) (results.get(0).compareTo(results.get(1)) < 0 ? 1 : 0);
            case 7:
                return (long) (results.get(0).compareTo(results.get(1)) == 0 ? 1 : 0);
        }
        return 0;
    }

    private long processLiteralPacket() {
        StringBuilder number = new StringBuilder();
        while (!onLastBlock()) {
            number.append(consume(5).substring(1));
        }
        number.append(consume(5).substring(1));
        long value = bitStringToDecimalValue(number.toString());
        System.out.println(", literal: " + value + System.lineSeparator());
        return value;
    }

    private boolean onLastBlock() {
        return bitStream[position] == '0';
    }

    private String bitStringToDecimalString(String bits) {
        return new BigInteger(bits, 2).toString(10);
    }

    private long bitStringToDecimalValue(String bits) {
        return new BigInteger(bits, 2).longValue();
    }

    private String consume(int amount) {
        StringBuilder bytes = new StringBuilder();
        for (int i = position; i < position + amount; i++) {
            bytes.append(bitStream[i]);
        }
        position += amount;
        return bytes.toString();
    }

    public long solvePart2() {
        solvePart1();
        return result;
    }

}

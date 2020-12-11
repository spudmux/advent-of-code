package com.spudmux.aoc2020.day9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class XMASDecoder {

    private final List<String> input;
    private FixedSizeQueue<Long> history;

    public XMASDecoder(List<String> input) {
        this.input = input;
    }

    public long findFirstNumber(int preamble, int lookBack) {
        assert preamble >= lookBack;
        history = new FixedSizeQueue<>(lookBack);

        for (String line : input) {
            long number = Long.parseLong(line);
            if (preamble > 0) {
                preamble--;
                history.add(number);
                continue;
            }
            if (!isProductOf(number, history.toList())) {
                return number;
            }
            history.add(number);
        }
        return 0;
    }

    private boolean isProductOf(long number, List<Long> history) {
        for (Long l : history) {
            if (history.contains(number - l)) {
                return true;
            }
        }
        return false;
    }

    public long findEncryptionWeakness(long firstNumber) {
        long[] numbers = input.stream().map(Long::parseLong).mapToLong(Long::longValue).toArray();
        for (int i = 0; i < numbers.length; i++) {
            long sum = numbers[i];
            for (int j = i+1; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum == firstNumber) {
                    long high = Long.MIN_VALUE;
                    long low = Long.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        if (low > numbers[k]) {
                            low = numbers[k];
                        }
                        if (high < numbers[k]) {
                            high = numbers[k];
                        }
                    }
                    return high + low;
                } else if (sum > firstNumber) {
                    break;
                }
            }
        }
        return 0;
    }

    static class FixedSizeQueue<L> {
        private final Queue<L> queue = new LinkedList<>();
        private final int capacity;

        public FixedSizeQueue(int capacity) {
            this.capacity = capacity;
        }

        public void add(L element) {
            if (!queue.isEmpty() && queue.size() >= capacity) {
                queue.remove();
            }
            queue.add(element);
        }

        public Iterator<L> getIterator() {
            return queue.iterator();
        }

        public List<L> toList() {
            return new ArrayList(queue);
        }

        public int getCapacity() {
            return capacity;
        }
    }
}

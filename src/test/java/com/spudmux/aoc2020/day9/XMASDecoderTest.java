package com.spudmux.aoc2020.day9;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class XMASDecoderTest {

  @Test public void testXMASDecoderWithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("day9-sample-input.txt"));
    XMASDecoder xMASDecoder = new XMASDecoder(input.getInputAsListOfLines());
    assertThat(xMASDecoder.findFirstNumber(5, 5)).isEqualTo(127);
  }

  @Test public void testXMASDecoderWithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("day9-input.txt"));
    XMASDecoder xMASDecoder = new XMASDecoder(input.getInputAsListOfLines());
    assertThat(xMASDecoder.findFirstNumber(25, 25)).isEqualTo(26796446);
  }

  @Test public void testXMASDecoderWithSampleInputPartTwo() {
    ProblemInput input = new ProblemInput(Paths.get("day9-sample-input.txt"));
    XMASDecoder xMASDecoder = new XMASDecoder(input.getInputAsListOfLines());
    long firstNumber = xMASDecoder.findFirstNumber(5, 5);
    assertThat(firstNumber).isEqualTo(127);
    assertThat(xMASDecoder.findEncryptionWeakness(firstNumber)).isEqualTo(62);
  }

  @Test public void testXMASDecoderWithProblemInputPartTwo() {
    ProblemInput input = new ProblemInput(Paths.get("day9-input.txt"));
    XMASDecoder xMASDecoder = new XMASDecoder(input.getInputAsListOfLines());
    long firstNumber = xMASDecoder.findFirstNumber(25, 25);
    assertThat(firstNumber).isEqualTo(26796446);
    assertThat(xMASDecoder.findEncryptionWeakness(firstNumber)).isEqualTo(3353494);
  }

  @Test public void testFixedSizeQueue() {
    int capacity = 10;
    XMASDecoder.FixedSizeQueue<Integer> queue = new XMASDecoder.FixedSizeQueue<>(capacity);
    assertThat(queue.getCapacity()).isEqualTo(capacity);
    for (int i = 0; i < capacity; i++) {
      queue.add(i);
    }
    Iterator<Integer> iterator = queue.getIterator();
    for (int i = 0; i < capacity; i++) {
      assertThat(iterator.next()).isEqualTo(i);
    }
    for (int i = 0; i < capacity+5; i++) {
      queue.add(i);
    }
    iterator = queue.getIterator();
    for (int i = capacity-5; i < capacity+5; i++) {
      assertThat(iterator.next()).isEqualTo(i);
    }
  }

}

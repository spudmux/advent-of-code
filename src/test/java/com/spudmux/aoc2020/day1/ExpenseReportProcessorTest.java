package com.spudmux.aoc2020.day1;

import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExpenseReportProcessorTest {

    private final ProblemInput problemInput = new ProblemInput();

    @Test
    public void testProcessReportWithSampleInput() {
        String contents = problemInput.getInputAsString("day1/expense-report-sample.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findTwoNumbers(Arrays.asList(contents.split("\n")));
        assertEquals(514579, result);
    }

    @Test
    public void testProcessWithSimpleInput() {
        List<String> contents = Arrays.asList("2019", "1");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findTwoNumbers(contents);
        assertEquals(2019, result);
    }

    @Test
    public void testProcessReportWithRealInput() {
        String contents = problemInput.getInputAsString("day1/expense-report-input.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findTwoNumbers(Arrays.asList(contents.split("\n")));
        assertNotEquals(-1, result);
        assertEquals(437931, result);
    }

    @Test
    public void testFindThreeWithRealInput() {
        String contents = problemInput.getInputAsString("day1/expense-report-input.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findThreeNumbers(Arrays.asList(contents.split("\n")));
        assertNotEquals(-1, result);
        assertEquals(157667328, result);
    }

    @Test
    public void testFindThreeMatches() {
        String contents = problemInput.getInputAsString("day1/expense-report-sample.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findThreeNumbers(Arrays.asList(contents.split("\n")));
        assertEquals(241861950, result);
    }

    private String getString(String fileName) {
        return problemInput.getInputAsString(fileName);
    }
}
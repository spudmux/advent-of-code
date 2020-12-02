package com.spudmux.aoc2020.day1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExpenseReportProcessorTest {

    @Test
    public void testProcessReportWithSampleInput() {
        String contents = getString("day1/expense-report-sample.txt");

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
        String contents = getString("day1/expense-report-input.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findTwoNumbers(Arrays.asList(contents.split("\n")));
        assertNotEquals(-1, result);
        assertEquals(437931, result);
    }

    @Test
    public void testFindThreeWithRealInput() {
        String contents = getString("day1/expense-report-input.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findThreeNumbers(Arrays.asList(contents.split("\n")));
        assertNotEquals(-1, result);
        assertEquals(157667328, result);
    }

    @Test
    public void testFindThreeMatches() {
        String contents = getString("day1/expense-report-sample.txt");

        ExpenseReportProcessor processor = new ExpenseReportProcessor();
        int result = processor.findThreeNumbers(Arrays.asList(contents.split("\n")));
        assertEquals(241861950, result);
    }

    private String getString(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        assert inputStream != null;
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }
}
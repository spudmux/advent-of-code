package com.spudmux.aoc2020.day1;

import java.util.List;

public class ExpenseReportProcessor {

    public static void main(String[] args) {

    }


    public int findTwoNumbers(List<String> report) {
        for (String line : report) {
            int lineItem = Integer.parseInt(line);
            for (String otherLine : report) {
                int otherLineItem = Integer.parseInt(otherLine);
                if (otherLineItem + lineItem == 2020) {
                    return otherLineItem * lineItem;
                }
            }
        }
        return -1;
    }

    public int findThreeNumbers(List<String> report) {
        for (String line : report) {
            int lineItem = Integer.parseInt(line);
            for (String otherLine : report) {
                int otherLineItem = Integer.parseInt(otherLine);
                for (String yetAnotherLine : report) {
                    int yetAnohterLineItem  = Integer.parseInt(yetAnotherLine);
                    if (lineItem + otherLineItem + yetAnohterLineItem == 2020) {
                        return lineItem * otherLineItem * yetAnohterLineItem;
                    }
                }
            }
        }
        return -1;
    }
}

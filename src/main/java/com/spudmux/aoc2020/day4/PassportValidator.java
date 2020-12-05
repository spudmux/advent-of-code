package com.spudmux.aoc2020.day4;

import com.spudmux.aoc2020.ProblemInput;

import java.util.ArrayList;
import java.util.List;

public class PassportValidator {

    ProblemInput input;
    private int numberOfCompletedPassports;
    private int numberOfValidPassports;

    public PassportValidator(ProblemInput input) {
        this.input = input;
        processPassports();
    }

    public int getNumberOfCompletePassports() {
        return numberOfCompletedPassports;
    }

    private void processPassports() {
        List<String> rawPassportData = new ArrayList<>();
        numberOfCompletedPassports = 0;
        for (String line : input.getInputAsListOfLines()) {
            rawPassportData.add(line);
            if ("".equals(line)) {
                rawPassportData.remove(rawPassportData.size()-1);
                Passport passport = new Passport(rawPassportData);
                if (passport.hasAllData()) {
                    numberOfCompletedPassports++;
                }
                if (passport.hasValidData()) {
                    numberOfValidPassports++;
                }
                rawPassportData.clear();
            }

        }
        Passport passport = new Passport(rawPassportData);
        if (passport.hasAllData()) {
            numberOfCompletedPassports++;
        }
        if (passport.hasValidData()) {
            numberOfValidPassports++;
        }
    }

    public int getNumberOfValidPassports() {
        return numberOfValidPassports;
    }
}

package com.spudmux.aoc2020.day2;

import com.spudmux.aoc2020.ProblemInput;

import java.util.List;
import java.util.function.Predicate;

public class PasswordValidator {

    public int countValidPasswordsMatchingPolicyOne(ProblemInput input) {
        return (int) countPasswordsMatchingPolicy(input, pw -> {
            long numberOfOccurrences = pw.password.chars().filter(ch -> ch == pw.policyCharacter).count();
            return pw.minOccurrences <= numberOfOccurrences && numberOfOccurrences <= pw.maxOccurrences;
        });
    }

    private long countPasswordsMatchingPolicy(ProblemInput input, Predicate<PasswordEntry> passwordPolicyPredicate) {
        List<String> passwords = input.getInputAsListOfLines();
        return passwords.stream().map(PasswordEntry::new).filter(passwordPolicyPredicate).count();
    }

    public int countValidPasswordsMatchingPolicyTwo(ProblemInput input) {
        return (int) countPasswordsMatchingPolicy(input, pw -> {
            char p1Char = pw.password.toCharArray()[pw.minOccurrences - 1];
            char p2Char = pw.password.toCharArray()[pw.maxOccurrences - 1];
            return p1Char == pw.policyCharacter ^ p2Char == pw.policyCharacter;
        });
    }

    static class PasswordEntry {
        int minOccurrences;
        int maxOccurrences;
        char policyCharacter;
        String password;

        PasswordEntry(String rawEntry) {
            String[] parts = rawEntry.split(" ");
            minOccurrences = Integer.parseInt(parts[0].substring(0, parts[0].indexOf('-')));
            maxOccurrences = Integer.parseInt(parts[0].substring(parts[0].indexOf('-')+1));
            policyCharacter = parts[1].charAt(0);
            password = parts[2];
        }

        Boolean isValid() {
            long numberOfOccurrences = password.chars().filter(ch -> ch == policyCharacter).count();
            return minOccurrences <= numberOfOccurrences && numberOfOccurrences <= maxOccurrences;
        }
    }
}

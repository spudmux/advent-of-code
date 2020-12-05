package com.spudmux.aoc2020.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Passport {
    String byr, iyr, eyr, hgt, hcl, ecl, pid, cid;
    Passport() {}
    public Passport(List<String> rawPassportData) {
        List<String> pairs = new ArrayList<String>();
        for (String line : rawPassportData) {
            pairs.addAll(Arrays.asList(line.split(" ")));
        }
        for (String pair : pairs) {
            if (pair.startsWith("byr:")) {
                this.byr = pair.substring(4);
            } else if (pair.startsWith("iyr:")) {
                this.iyr = pair.substring(4);
            } else if (pair.startsWith("eyr:")) {
                this.eyr = pair.substring(4);
            } else if (pair.startsWith("hgt:")) {
                this.hgt = pair.substring(4);
            } else if (pair.startsWith("hcl:")) {
                this.hcl = pair.substring(4);
            } else if (pair.startsWith("ecl:")) {
                this.ecl = pair.substring(4);
            } else if (pair.startsWith("pid:")) {
                this.pid = pair.substring(4);
            } else if (pair.startsWith("cid:")) {
                this.cid = pair.substring(4);
            }
        }
    }

    public boolean hasAllData() {
        return byr != null &&
               iyr != null &&
               eyr != null &&
               hgt != null &&
               hcl != null &&
               ecl != null &&
               pid != null;
    }

    boolean isBirthYearValid() {
        if (byr == null) {
            return false;
        }
        try {
            int birthYear = Integer.parseInt(byr);
            return birthYear >= 1920 && birthYear <= 2002;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isIssueYearValid() {
        if (iyr == null) {
            return false;
        }
        try {
            int issueYear = Integer.parseInt(iyr);
            return issueYear >= 2010 && issueYear <= 2020;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isExpirationYearValid() {
        if (eyr == null) {
            return false;
        }
        try {
            int expirationYear = Integer.parseInt(eyr);
            return expirationYear >= 2020 && expirationYear <= 2030;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isHeightValid() {
        if (hgt == null) {
            return false;
        }
        if (hgt.endsWith("cm")) {
            int height = Integer.parseInt(hgt.replace("cm", ""));
            return height >= 150 && height <= 193;
        } else if (hgt.endsWith("in")) {
            int height = Integer.parseInt(hgt.replace("in", ""));
            return height >= 59 && height <= 76;
        } else {
            return false;
        }
    }

    public boolean isHairColourValid() {
        if (hcl == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("#[0-9a-f]{6}");
        Matcher matcher = pattern.matcher(hcl);
        return matcher.matches();
    }

    public boolean isEyeColourValid() {
        if (ecl == null) {
            return false;
        }
        return ecl.equals("amb") ||
                ecl.equals("blu") ||
                ecl.equals("brn") ||
                ecl.equals("gry") ||
                ecl.equals("grn") ||
                ecl.equals("hzl") ||
                ecl.equals("oth");
    }

    public boolean isPassportIdValid() {
        if (pid == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]{9}");
        Matcher matcher = pattern.matcher(pid);
        return matcher.matches();
    }

    public boolean hasValidData() {
        return isBirthYearValid() &&
                isExpirationYearValid() &&
                isEyeColourValid() &&
                isHairColourValid() &&
                isHeightValid() &&
                isIssueYearValid() &&
                isPassportIdValid();
    }
}

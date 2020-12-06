package com.spudmux.aoc2020.day4;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PassportTest {

    @Test
    public void testPassportIsValidWithValidInput() {
        String rawInput = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport passport = new Passport(Arrays.asList(rawInput.split("\n")));
        assertTrue(passport.hasAllData());
    }

    @Test
    public void testPassportIsInvalidWithInValidInput() {
        String rawInput = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929";

        Passport passport = new Passport(Arrays.asList(rawInput.split("\n")));
        assertFalse("Height is missing from input", passport.hasAllData());
    }

    @Test
    public void testPassesHasAllDataCheckWithMissingCID() {
        String rawInput = "hcl:#ae17e1 iyr:2013\n" +
                "eyr:2024\n" +
                "ecl:brn pid:760753108 byr:1931\n" +
                "hgt:179cm";

        Passport passport = new Passport(Arrays.asList(rawInput.split("\n")));
        assertTrue("Missing cid value shoudl report as having all data",
                passport.hasAllData());
    }

    @Test
    public void testBirthYearValidation() {
        Passport passport = new Passport();
        assertThat(passport.isHeightValid()).isFalse();
        passport.byr = "2002";
        assertTrue(passport.isBirthYearValid());
        passport.byr = "2003";
        assertFalse(passport.isBirthYearValid());
        passport.byr = "1920";
        assertTrue(passport.isBirthYearValid());
        passport.byr = "1919";
        assertFalse(passport.isBirthYearValid());
    }

    @Test
    public void testIssueYearValidation() {
        Passport passport = new Passport();
        assertThat(passport.isHeightValid()).isFalse();
        passport.iyr = "2010";
        assertThat(passport.isIssueYearValid()).isTrue();
        passport.iyr = "2009";
        assertThat(passport.isIssueYearValid()).isFalse();
        passport.iyr = "2020";
        assertThat(passport.isIssueYearValid()).isTrue();
        passport.iyr = "2021";
        assertThat(passport.isIssueYearValid()).isFalse();
    }

    @Test
    public void testExpirationYearValidation() {
        Passport passport = new Passport();
        assertThat(passport.isHeightValid()).isFalse();
        passport.eyr = "201";
        assertThat(passport.isExpirationYearValid()).isFalse();
        passport.eyr = "20400";
        assertThat(passport.isExpirationYearValid()).isFalse();
        passport.eyr = "2020";
        assertThat(passport.isExpirationYearValid()).isTrue();
        passport.eyr = "2019";
        assertThat(passport.isExpirationYearValid()).isFalse();
        passport.eyr = "2030";
        assertThat(passport.isExpirationYearValid()).isTrue();
        passport.eyr = "2031";
        assertThat(passport.isExpirationYearValid()).isFalse();
    }

    @Test
    public void testHeightValidation() {
        Passport passport = new Passport();
        assertThat(passport.isHeightValid()).isFalse();
        passport.hgt = "150cm";
        assertThat(passport.isHeightValid()).isTrue();
        passport.hgt = "149cm";
        assertThat(passport.isHeightValid()).isFalse();
        passport.hgt = "193cm";
        assertThat(passport.isHeightValid()).isTrue();
        passport.hgt = "194cm";
        assertThat(passport.isHeightValid()).isFalse();
        passport.hgt = "59in";
        assertThat(passport.isHeightValid()).isTrue();
        passport.hgt = "58in";
        assertThat(passport.isHeightValid()).isFalse();
        passport.hgt = "76in";
        assertThat(passport.isHeightValid()).isTrue();
        passport.hgt = "77in";
    }

    @Test
    public void testHairColourValidation() {
        Passport passport = new Passport();
        assertThat(passport.isHairColourValid()).isFalse();
        passport.hcl = "123456";
        assertThat(passport.isHairColourValid()).isFalse();
        passport.hcl = "#123456";
        assertThat(passport.isHairColourValid()).isTrue();
        passport.hcl = "#012349";
        assertThat(passport.isHairColourValid()).isTrue();
        passport.hcl = "#aaaaaa";
        assertThat(passport.isHairColourValid()).isTrue();
        passport.hcl = "#aabbff";
        assertThat(passport.isHairColourValid()).isTrue();
        passport.hcl = "#aabbfg";
        assertThat(passport.isHairColourValid()).isFalse();
        passport.hcl = "#aabbfz";
        assertThat(passport.isHairColourValid()).isFalse();
    }

    @Test
    public void testEyeColourValidation() {
        Passport passport = new Passport();
        assertThat(passport.isEyeColourValid()).isFalse();
        String[] validColours = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        for (String colour : validColours) {
            passport.ecl = colour;
            boolean eyeColourValid = passport.isEyeColourValid();
            assertThat(eyeColourValid).isTrue();
        }

        String[] invalidColours = {"xyz", "blue", "brown", "green", "abcd", " hzls", "OTH"};
        for (String colour : invalidColours) {
            passport.ecl = colour;
            assertThat(passport.isEyeColourValid()).isFalse();
        }
    }

    @Test
    public void testPassportIDValidation() {
        Passport passport = new Passport();
        assertThat(passport.isPassportIdValid()).isFalse();
        passport.pid = "012345678";
        assertThat(passport.isPassportIdValid()).isTrue();
        passport.pid = "0123456780";
        assertThat(passport.isPassportIdValid()).isFalse();
        passport.pid = "01234567a";
        assertThat(passport.isPassportIdValid()).isFalse();
    }

    @Test
    public void hasValidData() {
        String rawInput = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n" +
                "hcl:#623a2f";
        Passport passport = new Passport(Arrays.asList(rawInput.split("\n")));
        assertThat(passport.hasValidData()).isTrue();
    }

    @Test
    public void hasInalidData() {
        String rawInput = "hcl:dab227 iyr:2012\n" +
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277";
        Passport passport = new Passport(Arrays.asList(rawInput.split("\n")));
        assertThat(passport.hasValidData()).isFalse();
    }

}
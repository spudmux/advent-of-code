#!/bin/bash

if [ -z $1 ]; then
	echo "day number not provided as input" 
	exit 1
else
  echo "running setup for day "$1
fi

if [ -z $3 ]; then
  year=2022
  echo "defaulting year to ${year}"
fi

# Setup src files
mkdir -p src/main/java/com/spudmux/aoc"${year}"/day"${1}"

# Setup test files
mkdir -p src/test/java/com/spudmux/aoc"${year}"/day"${1}"
touch src/test/resources/aoc"${year}"/day$1-part1-sample-input.txt
touch src/test/resources/aoc"${year}"/day$1-part1-input.txt

if ! aoc_cookie=$(security find-generic-password -w -s "Advent of code - cookie"); then
  echo "could not get password, error $?"
else
  echo "Downloading problem input..."
  curl --cookie "session=${aoc_cookie}" https://adventofcode.com/"${year}"/day/${1}/input > src/test/resources/aoc"${year}"/day$1-part1-input.txt
fi

if [ ! -z $2 ]; then
  echo "creating "$2" class and test files"
  touch src/main/java/com/spudmux/aoc"${year}"/day$1/$2.java
  /bin/cat <<EOF >src/main/java/com/spudmux/aoc"${year}"/day$1/$2.java
package com.spudmux.aoc${year}.day$1;

import com.spudmux.aoc2020.ProblemInput;

public class $2 {
    public $2(ProblemInput input) {

    }

    public int solvePart1() {
        return 0;
    }

    public int solvePart2() {
        return 0;
    }

}
EOF

touch src/test/java/com/spudmux/aoc"${year}"/day$1/$2Test.java
  /bin/cat <<EOF >src/test/java/com/spudmux/aoc"${year}"/day$1/$2Test.java
package com.spudmux.aoc${year}.day$1;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class $2Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void test$2Part1WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc${year}/day$1-part1-sample-input.txt"));
    $2 $(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}') = new $2(input);
    softly.assertThat($(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}').solvePart1()).isEqualTo(-1);
  }

  @Test public void test$2Part1WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc${year}/day$1-part1-input.txt"));
    $2 $(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}') = new $2(input);
    softly.assertThat($(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}').solvePart1()).isEqualTo(-1);
  }

  @Test public void test$2Part2WithSampleInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc${year}/day$1-part1-sample-input.txt"));
    $2 $(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}') = new $2(input);
    softly.assertThat($(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}').solvePart2()).isEqualTo(-1);
  }

  @Test public void test$2Part2WithProblemInput() {
    ProblemInput input = new ProblemInput(Paths.get("aoc${year}/day$1-part1-input.txt"));
    $2 $(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}') = new $2(input);
    softly.assertThat($(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}').solvePart2()).isEqualTo(-1);
  }

}
EOF
fi
#!/bin/bash

if [ -z $1 ]; then
	echo "day number not provided as input" 
	exit 1
else
  echo "running setup for day "$1
fi

# Setup src files
mkdir -p src/main/java/com/spudmux/aoc2021/day$1

# Setup test files
mkdir -p src/test/java/com/spudmux/aoc2021/day$1
touch src/test/resources/aoc2021/day$1-part1-sample-input.txt
touch src/test/resources/aoc2021/day$1-part1-input.txt


if [ ! -z $2 ]; then
  echo "creating "$2" class and test files"
#  touch src/main/java/com/spudmux/aoc2021/day$1/$2.java
  /bin/cat <<EOF >src/main/java/com/spudmux/aoc2021/day$1/$2.java
package com.spudmux.aoc2021.day$1;

import com.spudmux.aoc2020.ProblemInput;

public class $2 {
    public $2(ProblemInput input) {

    }
}
EOF

#touch src/test/java/com/spudmux/aoc2021/day$1/$2Test.java
  /bin/cat <<EOF >src/test/java/com/spudmux/aoc2021/day$1/$2Test.java
package com.spudmux.aoc2021.day$1;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import com.spudmux.aoc2020.ProblemInput;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class $2Test {

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test public void test$2WithSampleInput() {
    ProblemInput input = new ProblemInput("aoc2021/day$1-part1-sample-input.txt");
    $2 $(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}') = new $2(input);
  }

  @Test public void test$2WithProblemInput() {
    ProblemInput input = new ProblemInput("aoc2021/day$1-part1-input.txt");
    $2 $(echo "$2" | awk '{print tolower(substr($0,1,1)) substr($0,2)}') = new $2(input);
  }

}
EOF
fi
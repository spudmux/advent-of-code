package com.spudmux.aoc;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

public class PositionTest {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void testGetAdjacentPoints() {
        Position p = new Position(1, 1);
        List<Position> neighbours = p.getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(4);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(
                        new Position(0, 1),
                        new Position(1, 0),
                        new Position(2, 1),
                        new Position(1, 2)
                );
    }

    @Test
    public void testGetAdjacentPointsWhenOnLowerBoundary() {
        Position p = new Position(0, 0);
        List<Position> neighbours = p.getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(2);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(
                        new Position(0, 1),
                        new Position(1, 0)
                );
    }

    @Test
    public void testGetAdjacentPointsWhenOnUpperBoundary() {
        Position p = new Position(9, 9);
        List<Position> neighbours = p.getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(2);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(
                        new Position(9, 8),
                        new Position(8, 9)
                );
    }

    @Test
    public void testGetAdjacentPointsWhenOutOfBounds() {
        Position p = new Position(10, 10);
        List<Position> neighbours = p.getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(0);
    }

    @Test
    public void testGetAdjacentPointsWhenOnEdges() {
        List<Position> neighbours = new Position(0, 5).getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(3);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(new Position(0, 4), new Position(0, 6), new Position(1, 5));

        neighbours = new Position(5, 0).getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(3);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(new Position(5, 1), new Position(4, 0), new Position(6, 0));

        neighbours = new Position(9, 5).getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(3);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(new Position(9, 6), new Position(9, 4), new Position(8, 5));

        neighbours = new Position(5, 9).getAdjacentPoints(0, 10, 0, 10);
        softly.assertThat(neighbours).hasSize(3);
        softly.assertThat(neighbours)
                .containsExactlyInAnyOrder(new Position(5, 8), new Position(4, 9), new Position(6, 9));
    }

}
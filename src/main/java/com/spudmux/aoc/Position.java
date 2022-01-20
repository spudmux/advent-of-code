package com.spudmux.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getX() == position.getX() && getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    /**
     * Checks if this position is withing the bounds specified in the provided array.
     *
     * Array values are treated as <code>[ x1, x2, y1, y2 ]</code>. The values
     * x1 & y1 are inclusive and x2, y2 are exclusive.
     *
     * @param bounds x1, x2, y1, y2 where x1, y1 are inclusive and x2, y2 are exclusive
     * @return true if within the bounds false otherwise.
     */
    public boolean isInBounds(int[] bounds) {
        assert bounds.length == 4;
        return isInBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
    }

    public boolean isInBounds(int xMin, int xMax, int yMin, int yMax) {
        return getX() >= xMin && getX() < xMax && getY() >= yMin && getY() < yMax;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    public List<Position> getAdjacentPoints(int xMin, int xMax, int yMin, int yMax) {
        List<Position> positions = new ArrayList<>();
        if (getX() - 1 >= xMin && getX() - 1 < xMax && getY() >= yMin && getY() < yMax) {
            positions.add(new Position(getX() - 1, getY()));
        }
        if (getX() + 1 < xMax && getX() + 1 >= xMin && getY() >= yMin && getY() < yMax) {
            positions.add(new Position(getX() + 1, getY()));
        }
        if (getY() - 1 >= yMin && getY() - 1 < yMax && getX() >= xMin && getX() < xMax) {
            positions.add(new Position(getX(), getY() - 1));
        }
        if (getY() + 1 < yMax && getY() + 1 >= yMin && getX() >= xMin && getX() < xMax) {
            positions.add(new Position(getX(), getY() + 1));
        }
        return positions;
    }
}

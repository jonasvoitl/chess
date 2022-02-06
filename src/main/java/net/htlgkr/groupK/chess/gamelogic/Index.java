package net.htlgkr.groupK.chess.gamelogic;

import java.util.Objects;

public class Index
{
    private int x;
    private int y;

    public Index(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return x == index.x && y == index.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
package net.htlgkr.groupK.chess.gamelogic;

import java.io.Serializable;
import java.util.Objects;

public class Index implements Serializable
{
    private int x;
    private int y;

    public Index() {
    }

    public Index(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

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
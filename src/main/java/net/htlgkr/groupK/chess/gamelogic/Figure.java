package net.htlgkr.groupK.chess.gamelogic;

import java.io.Serializable;
import java.util.Objects;

public abstract class Figure implements Serializable
{
    private boolean isBlue;
    private String imagePath;

    public Figure() {
    }

    public Figure(boolean isBlue, String imagePath) {
        this.isBlue = isBlue;
        this.imagePath = imagePath;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void setBlue(boolean blue) {
        isBlue = blue;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return isBlue == figure.isBlue && Objects.equals(imagePath, figure.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBlue, imagePath);
    }

    public abstract boolean checkRequestedMove(Index fromIndex, Index toIndex);
}
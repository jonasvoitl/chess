package net.htlgkr.groupK.chess.gamelogic;

public abstract class Figure
{
    private boolean isBlue;
    private String imagePath;

    public Figure(boolean isBlue, String imagePath) {
        this.isBlue = isBlue;
        this.imagePath = imagePath;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public String getImagePath() {
        return imagePath;
    }

    public abstract boolean checkRequestedMove(Index toIndex, Index fromIndex);
}
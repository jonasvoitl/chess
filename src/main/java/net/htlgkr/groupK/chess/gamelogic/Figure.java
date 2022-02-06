package net.htlgkr.groupK.chess.gamelogic;

public abstract class Figure
{
    private boolean isBlue;
    private String imagePath;
    private FigureType figureType;

    public Figure(boolean isBlue, String imagePath, FigureType figureType) {
        this.isBlue = isBlue;
        this.imagePath = imagePath;
        this.figureType = figureType;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public String getImagePath() {
        return imagePath;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public abstract boolean checkRequestedMove(Index toIndex, Index fromIndex);
}
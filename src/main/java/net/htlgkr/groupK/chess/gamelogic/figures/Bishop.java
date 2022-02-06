package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.FigureType;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Bishop extends Figure
{
    public Bishop(boolean isBlue, String imagePath, FigureType figureType) {
        super(isBlue, imagePath, figureType);
    }

    @Override
    public boolean checkRequestedMove(Index toIndex, Index fromIndex)
    {
        int moveOnXAxis = Math.abs(toIndex.getX() - fromIndex.getX());
        int moveOnYAxis = Math.abs(toIndex.getY() - fromIndex.getY());

        return moveOnXAxis == moveOnYAxis;
    }
}
package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.FigureType;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class King extends Figure
{
    public King(boolean isBlue, String imagePath, FigureType figureType) {
        super(isBlue, imagePath, figureType);
    }

    @Override
    public boolean checkRequestedMove(Index toIndex, Index fromIndex)
    {
        int moveOnXAxis = Math.abs(toIndex.getX() - fromIndex.getX());
        int moveOnYAxis = Math.abs(toIndex.getY() - fromIndex.getY());

        if(moveOnXAxis == 1 && moveOnYAxis == 0 ||
                moveOnXAxis == 0 && moveOnYAxis == 1 ||
                moveOnXAxis == 1 && moveOnYAxis == 1)
        {
            return true;
        }
        return false;
    }
}
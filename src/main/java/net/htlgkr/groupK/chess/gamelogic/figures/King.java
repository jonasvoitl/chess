package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class King extends Figure
{
    public King(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        int moveOnXAxis = Math.abs(toIndex.getY() - fromIndex.getY());
        int moveOnYAxis = Math.abs(toIndex.getX() - fromIndex.getX());

        if(moveOnXAxis == 1 && moveOnYAxis == 0 ||
                moveOnXAxis == 0 && moveOnYAxis == 1 ||
                moveOnXAxis == 1 && moveOnYAxis == 1)
        {
            return true;
        }
        return false;
    }
}
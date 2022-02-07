package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Knight extends Figure
{
    public Knight(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        int moveOnXAxis = Math.abs(toIndex.getY() - fromIndex.getY());
        int moveOnYAxis = Math.abs(toIndex.getX() - fromIndex.getX());

        if(moveOnXAxis == 2 && moveOnYAxis == 1 || moveOnXAxis == 1 && moveOnYAxis == 2)
        {
            return true;
        }
        return false;
    }
}
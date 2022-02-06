package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Knight extends Figure
{
    public Knight(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index toIndex, Index fromIndex)
    {
        int moveOnXAxis = Math.abs(toIndex.getX() - fromIndex.getX());
        int moveOnYAxis = Math.abs(toIndex.getY() - fromIndex.getY());

        if(moveOnXAxis == 2 && moveOnYAxis == 1 || moveOnXAxis == 1 && moveOnYAxis == 2)
        {
            return true;
        }
        return false;
    }
}
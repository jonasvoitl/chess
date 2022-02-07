package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Rook extends Figure
{
    public Rook(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        int moveOnXAxis = Math.abs(toIndex.getX() - fromIndex.getX());
        int moveOnYAxis = Math.abs(toIndex.getY() - fromIndex.getY());

        if(moveOnXAxis > 0 && moveOnXAxis < 8 && moveOnYAxis == 0 ||
                moveOnYAxis < 8 && moveOnYAxis > 0 && moveOnXAxis == 0)
        {
            return true;
        }
        return false;
    }
}
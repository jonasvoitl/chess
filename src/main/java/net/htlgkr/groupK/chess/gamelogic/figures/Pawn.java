package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Pawn extends Figure
{
    private boolean isFirstPawnMove = true;

    public Pawn(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);;
    }

    public void setFirstPawnMove(boolean firstPawnMove) {
        isFirstPawnMove = firstPawnMove;
    }

    @Override
    public boolean checkRequestedMove(Index toIndex, Index fromIndex)
    {
        //TODO Schräg bewegen
        int moveOnXAxis = toIndex.getX() - fromIndex.getX();
        int moveOnYAxis = toIndex.getY() - fromIndex.getY();

        if(isBlue())
        {
            if(moveOnYAxis == -1 && moveOnXAxis == 0)
            {
                isFirstPawnMove = false;
                return true;
            }
            else if (isFirstPawnMove && moveOnYAxis == -2 && moveOnXAxis == 0)
            {
                isFirstPawnMove = false;
                return true;
            }
        }
        else
        {
            if(moveOnYAxis == 1 && moveOnXAxis == 0)
            {
                isFirstPawnMove = false;
                return true;
            }
            else if (isFirstPawnMove && moveOnYAxis == 2 && moveOnXAxis == 0)
            {
                isFirstPawnMove = false;
                return true;
            }
        }
        return false;
    }
}
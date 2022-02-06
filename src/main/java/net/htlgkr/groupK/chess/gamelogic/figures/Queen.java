package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Queen extends Figure
{
    public Queen(boolean isBlue, String imagePath)
    {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex) {
        return true;
    }
}
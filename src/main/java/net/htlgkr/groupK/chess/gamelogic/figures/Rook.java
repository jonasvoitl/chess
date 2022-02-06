package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.FigureType;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Rook extends Figure
{
    public Rook(boolean isBlue, String imagePath, FigureType figureType) {
        super(isBlue, imagePath, figureType);
    }

    @Override
    public boolean checkRequestedMove(Index toIndex, Index fromIndex)
    {
        return true;
    }
}
package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;

public class Knight extends Figure
{
    public Knight(boolean isBlue, String imagePath)
    {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove()
    {
        return false;
    }
}
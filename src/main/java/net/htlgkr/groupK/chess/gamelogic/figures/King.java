package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.gamelogic.Figure;

public class King extends Figure
{
    public King(boolean isBlue, String imagePath)
    {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove()
    {
        return false;
    }
}
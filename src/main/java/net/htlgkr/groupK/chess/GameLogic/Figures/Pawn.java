package net.htlgkr.groupK.chess.GameLogic.Figures;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import net.htlgkr.groupK.chess.GameLogic.Figure;

public class Pawn extends Figure
{
    public Pawn(boolean isBlue, Label tile, ImageView figureImage)
    {
        super(isBlue, tile, figureImage);
    }

    @Override
    public boolean move(Label l)
    {
        return false;
    }
}
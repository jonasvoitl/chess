package net.htlgkr.groupK.chess.gamelogic.figures;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import net.htlgkr.groupK.chess.gamelogic.Figure;

public class Bishop extends Figure
{
    public Bishop(boolean isBlue, Label tile, ImageView figureImage)
    {
        super(isBlue, tile, figureImage);
    }

    @Override
    public boolean move(Label l)
    {
        return false;
    }
}
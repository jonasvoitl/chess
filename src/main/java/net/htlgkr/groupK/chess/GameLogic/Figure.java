package net.htlgkr.groupK.chess.GameLogic;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public abstract class Figure
{
    private boolean isBlue;
    private Label tile;
    private ImageView figureImage;

    public Figure(boolean isBlue, Label tile, ImageView figureImage)
    {
        this.isBlue = isBlue;
        this.tile = tile;
        this.figureImage = figureImage;
        tile.setGraphic(figureImage);
    }

    public boolean isBlue()
    {
        return isBlue;
    }

    public void setBlue(boolean blue)
    {
        isBlue = blue;
    }

    public Label getTile()
    {
        return tile;
    }

    public void setTile(Label tile)
    {
        this.tile = tile;
    }

    public ImageView getFigureImage()
    {
        return figureImage;
    }

    public void setFigureImage(ImageView figureImage)
    {
        this.figureImage = figureImage;
    }

    public abstract boolean move(Label l);
}
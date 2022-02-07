package net.htlgkr.groupK.chess.gamelogic;

import java.io.Serializable;

public class Frame implements Serializable {
    private Figure figure;
    private Index fromIndex;
    private Index toIndex;

    public Frame() {
    }

    public Frame(Figure figure, Index fromIndex, Index toIndex) {
        this.figure = figure;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Index getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(Index fromIndex) {
        this.fromIndex = fromIndex;
    }

    public Index getToIndex() {
        return toIndex;
    }

    public void setToIndex(Index toIndex) {
        this.toIndex = toIndex;
    }
}

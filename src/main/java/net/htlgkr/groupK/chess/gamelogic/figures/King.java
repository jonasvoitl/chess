package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class King extends Figure
{
    public King(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex) {
        int moveOnXAxis = Math.abs(toIndex.getY() - fromIndex.getY());
        int moveOnYAxis = Math.abs(toIndex.getX() - fromIndex.getX());

        boolean moveValid = false;

        if (moveOnXAxis == 1 && moveOnYAxis == 0 ||
                moveOnXAxis == 0 && moveOnYAxis == 1 ||
                moveOnXAxis == 1 && moveOnYAxis == 1) {
            moveValid = true;
        }

        if(isBlue() && moveValid) {
            if(Main.chessGameController.getTilesMap().get(toIndex) != null) {
                if(!Main.chessGameController.getTilesMap().get(toIndex).isBlue()) {
                    moveValid = true;
                }else {
                    moveValid = false;
                }
            }
        }else {
            if(Main.chessGameController.getTilesMap().get(toIndex) != null) {
                if(Main.chessGameController.getTilesMap().get(toIndex).isBlue()) {
                    moveValid = true;
                }else {
                    moveValid = false;
                }
            }
        }
        return moveValid;
    }
}
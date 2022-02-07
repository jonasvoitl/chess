package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Knight extends Figure
{
    public Knight(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        int moveOnXAxisAbs = Math.abs(toIndex.getY() - fromIndex.getY());
        int moveOnYAxisAbs = Math.abs(toIndex.getX() - fromIndex.getX());

        boolean moveValid = false;

        if(moveOnXAxisAbs == 2 && moveOnYAxisAbs == 1 || moveOnXAxisAbs == 1 && moveOnYAxisAbs == 2)
        {
            moveValid = true;
        }

        if(moveValid && Main.chessGameController.getTilesMap().get(toIndex) != null) {
            if(isBlue() && Main.chessGameController.getTilesMap().get(toIndex).isBlue()) {
                moveValid = false;
            }else if (!isBlue() && !Main.chessGameController.getTilesMap().get(toIndex).isBlue()){
                moveValid = false;
            }else {
                moveValid = true;
            }
        }
        return moveValid;
    }
}
package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Bishop extends Figure
{
    public Bishop(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        //für moveOnXAxis müssen Y Werte verwendet werden, dies ist auf die Nummierung des 2D-Arrays zurückzuführen
        int moveOnXAxis = toIndex.getY() - fromIndex.getY();
        int moveOnYAxis = toIndex.getX() - fromIndex.getX();

        int moveOnXAxisAbs = Math.abs(moveOnXAxis);
        int moveOnYAxisAbs = Math.abs(moveOnYAxis);

        boolean moveValid = moveOnXAxisAbs == moveOnYAxisAbs;

        if(moveOnXAxis > 0 && moveOnYAxis > 0) {
            for (int i = 1; i != moveOnXAxis && i != moveOnYAxis; i++) {
                if(Main.chessGameController.getTilesMap().get(new Index(fromIndex.getX()+i, fromIndex.getY()+i)) != null)  {
                    moveValid = false;
                }
            }
        }else {
            for (int i = 1; i != moveOnXAxis && i != moveOnYAxis; i--) {
                if(Main.chessGameController.getTilesMap().get(new Index(fromIndex.getX()-i, fromIndex.getY()-i)) != null)  {
                    moveValid = false;
                }
            }
        }
        return moveValid;
    }
}
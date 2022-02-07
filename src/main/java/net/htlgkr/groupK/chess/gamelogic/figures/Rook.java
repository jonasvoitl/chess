package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Rook extends Figure
{
    public Rook(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        int moveOnXAxis = toIndex.getY() - fromIndex.getY();
        int moveOnYAxis = toIndex.getX() - fromIndex.getX();

        int moveOnXAxisAbs = Math.abs(moveOnXAxis);
        int moveOnYAxisAbs = Math.abs(moveOnYAxis);

        boolean moveValid = false;

        //Dadurch, dass durch eine vorherige Überprüfung ausgeschlossen ist, dass X und Y gleichzeitig 0 sind, muss dies nicht extra
        //geprüft werden
        if(moveOnXAxisAbs > 0 && moveOnXAxisAbs < 8 && moveOnYAxisAbs == 0 ||
                moveOnYAxisAbs > 0 && moveOnYAxisAbs < 8 && moveOnXAxisAbs == 0) {
            return true;
        }
        return false;
    }
}
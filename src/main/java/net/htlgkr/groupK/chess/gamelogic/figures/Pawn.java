package net.htlgkr.groupK.chess.gamelogic.figures;

import net.htlgkr.groupK.chess.Main;
import net.htlgkr.groupK.chess.gamelogic.Figure;
import net.htlgkr.groupK.chess.gamelogic.Index;

public class Pawn extends Figure
{
    private boolean isFirstPawnMove = true;

    public Pawn(boolean isBlue, String imagePath) {
        super(isBlue, imagePath);;
    }

    public void setFirstPawnMove(boolean firstPawnMove) {
        isFirstPawnMove = firstPawnMove;
    }

    @Override
    public boolean checkRequestedMove(Index fromIndex, Index toIndex)
    {
        //für moveOnXAxis müssen Y Werte verwendet werden, dies ist auf die Nummierung des 2D-Arrays zurückzuführen
        int moveOnXAxis = toIndex.getY() - fromIndex.getY();
        int moveOnYAxis = toIndex.getX() - fromIndex.getX();

        if(isBlue())
        {
            //wenn Feld vor Bauer in y-Richtung frei ist
            if(moveOnXAxis == 0 && moveOnYAxis == -1 && Main.chessGameController.getTilesMap().get(toIndex) == null)
            {
                return true;
            }
            //wenn 2 Felder vor Bauer in y-Richtung frei sind und er den ersten Zug macht
            else if (isFirstPawnMove && moveOnXAxis == 0 && moveOnYAxis == -2 && Main.chessGameController.getTilesMap().get(toIndex) == null &&
                    Main.chessGameController.getTilesMap().get(new Index(toIndex.getX()+1, toIndex.getY())) == null)
            {
                return true;
            //Überprüfung ob Bauer jemanden schmeißen kann: schräg oben links oder schräg oben rechts muss eine gegnerische Figur stehen
            }else if(moveOnXAxis == -1 && moveOnYAxis == -1 && Main.chessGameController.getTilesMap().get(toIndex) != null &&
                    !Main.chessGameController.getTilesMap().get(toIndex).isBlue() ||
                    moveOnXAxis == 1 && moveOnYAxis == -1 && Main.chessGameController.getTilesMap().get(toIndex) != null &&
                    !Main.chessGameController.getTilesMap().get(toIndex).isBlue()) {
                return true;
            }
        }
        else
        {
            //wenn Feld vor Bauer in y-Richtung frei ist
            if(moveOnXAxis == 0 && moveOnYAxis == 1 && Main.chessGameController.getTilesMap().get(toIndex) == null)
            {
                return true;
            }
            //wenn 2 Felder vor Bauer in y-Richtung frei sind und er den ersten Zug macht
            else if (isFirstPawnMove && moveOnXAxis == 0 && moveOnYAxis == 2 && Main.chessGameController.getTilesMap().get(toIndex) == null &&
                    Main.chessGameController.getTilesMap().get(new Index(toIndex.getX()-1, toIndex.getY())) == null)
            {
                return true;
            //Überprüfung ob Bauer jemanden schmeißen kann: schräg unten links oder schräg unten rechts muss eine gegnerische Figur stehen
            }else if(moveOnXAxis == -1 && moveOnYAxis == 1 && Main.chessGameController.getTilesMap().get(toIndex) != null &&
                    Main.chessGameController.getTilesMap().get(toIndex).isBlue() ||
                    moveOnXAxis == 1 && moveOnYAxis == 1 && Main.chessGameController.getTilesMap().get(toIndex) != null &&
                    Main.chessGameController.getTilesMap().get(toIndex).isBlue()) {
                return true;
            }
        }
        return false;
    }
}
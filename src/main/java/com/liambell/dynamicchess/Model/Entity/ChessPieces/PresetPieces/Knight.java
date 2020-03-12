package com.liambell.dynamicchess.Model.Entity.ChessPieces.PresetPieces;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;

public class Knight extends Piece {

    private final String pieceName = "k";
    private String pieceAllegiance;


    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        if ((Math.abs(newPosition[1] - startPosition[1]) == 1 && Math.abs(newPosition[0] - startPosition[0]) == 2) ||
                (Math.abs(newPosition[1] - startPosition[1]) == 2 && Math.abs(newPosition[0] - startPosition[0]) == 1) && !board[newPosition[0]][newPosition[1]].getPieceAllegiance().equals(this.getPieceAllegiance())) {
            isValid = !board[newPosition[0]][newPosition[1]].getPieceAllegiance().equals(this.getPieceAllegiance());
        }
        return isValid;
    }
    public Knight(String pieceAllegiance) {
        this.setPieceAllegiance(pieceAllegiance);
    }

    @Override
    public String getPieceName() {
        return pieceName;
    }

    @Override
    public String getPieceAllegiance() {
        return pieceAllegiance;
    }

    @Override
    public void setPieceAllegiance(String pieceAllegiance) {
        this.pieceAllegiance = pieceAllegiance;
    }
}

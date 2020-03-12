package com.liambell.dynamicchess.Model.Entity.ChessPieces.PresetPieces;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;

public class King extends Piece {

    private final String pieceName = "K";
    private String pieceAllegiance;
    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        if ((Math.abs(startPosition[0] - newPosition[0]) == 1 ||
                Math.abs(startPosition[0] - newPosition[0]) == 0 ) &&
                (Math.abs(startPosition[1] - newPosition[1]) == 1 ||
                        Math.abs(startPosition[1] - newPosition[1]) == 0 ) &&
                !board[newPosition[0]][newPosition[1]].getPieceAllegiance().equals(this.getPieceAllegiance())) {
            isValid = true;
        }
        return isValid;
    }

    public King(String pieceAllegiance) {
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

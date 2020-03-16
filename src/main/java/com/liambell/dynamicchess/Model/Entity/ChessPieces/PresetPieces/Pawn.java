package com.liambell.dynamicchess.Model.Entity.ChessPieces.PresetPieces;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;

public class Pawn extends Piece {

    private final String pieceName = "P";
    private String pieceAllegiance;
    private int[][] movementRule = new int[1][1];


    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        String allegiance = board[newPosition[0]][newPosition[1]].getPieceAllegiance();
        movementRule[0][0] = 1;
        //Accounts for initial movement of two spaces
        //Movement of once forward space if it is empty
        //Moving diagonal in either direction if there is an enemy.
        if (!board[newPosition[0]][newPosition[1]].getPieceAllegiance().equals(pieceBeingMoved.getPieceAllegiance())) {
            if ((startPosition[0] == 1 && newPosition[0] == 3) ||(startPosition[0] == 6 && newPosition[0] == 4) && board[2][startPosition[1]].getPieceName().equals(" ")) {
                isValid = true;
            } else if (Math.abs(newPosition[0] - startPosition[0]) == movementRule[0][0] &&
                    board[newPosition[0]][newPosition[1]].getPieceName().equals(" ")
            ) {
                isValid = true;
            } else if (Math.abs(newPosition[0] - startPosition[0]) == 1) {
                if (!board[newPosition[0]][newPosition[1]].getPieceName().equals(" ") &&
                        !this.getPieceAllegiance().equals(allegiance)) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
    public Pawn(String pieceAllegiance) {
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

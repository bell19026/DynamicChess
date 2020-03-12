package com.liambell.dynamicchess.Model.Entity.ChessPieces;

import com.liambell.dynamicchess.Model.Interfaces.Movement;

public class Piece implements Movement {

    /*
        - Name of the piece
        - Piece Allegiance?
        - Rules
     */

    private String pieceName;
    private String pieceAllegiance;

    public String getPieceName() {
        return this.pieceName;
    }

    public String getPieceAllegiance() {
        return this.pieceAllegiance;
    }

    public void setPieceAllegiance(String pieceAllegiance) {
        this.pieceAllegiance = pieceAllegiance;
    }

    public Piece() {
        this.pieceName = "P";

    }

    public Piece(String pieceName, String pieceAllegiance) {
        this.pieceName = pieceName;
        this.pieceAllegiance = pieceAllegiance;
    }

    public Piece(String pieceAllegiance) {
        this.pieceAllegiance = pieceAllegiance;
    }


    @Override
    public boolean isValidMove(Piece[][] chessboard, Piece pieceBeingMoved, int[] startOfMovementPiecePosition, int[] endOfMovementPiecePosition) {
        return true;
    }
}

package com.liambell.dynamicchess.Model.Entity.ChessPieces;

public class Piece {

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

    public Piece(String pieceName) {
        this.pieceName = pieceName;
    }
}

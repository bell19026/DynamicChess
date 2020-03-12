package com.liambell.dynamicchess.Model.Entity.ChessPieces.PresetPieces;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;

public class EmptyPiece extends Piece {
    private final String pieceName = " ";
    private final String pieceAllegiance = "None";

    @Override
    public String getPieceName() {
        return pieceName;
    }

    @Override
    public String getPieceAllegiance() {
        return pieceAllegiance;
    }
}

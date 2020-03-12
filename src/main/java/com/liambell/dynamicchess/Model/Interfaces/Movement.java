package com.liambell.dynamicchess.Model.Interfaces;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;

public interface Movement {
    public boolean isValidMove(Piece[][] chessboard, Piece pieceBeingMoved, int[] startOfMovementPiecePosition, int[] endOfMovementPiecePosition);
}

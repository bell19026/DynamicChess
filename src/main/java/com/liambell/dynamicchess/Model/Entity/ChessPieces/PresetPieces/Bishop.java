package com.liambell.dynamicchess.Model.Entity.ChessPieces.PresetPieces;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;
import com.liambell.dynamicchess.Model.Services.MovementServices;

public class Bishop extends Piece {

    private final String pieceName = "B";
    private String pieceAllegiance;


    @Override
    public boolean isValidMove(Piece[][] board, Piece pieceBeingMoved, int[] startPosition, int[] newPosition) {
        boolean isValid = false;
        MovementServices movementService = new MovementServices();
        String direction = movementService.determineCurrentPieceMovementDirection(startPosition, newPosition);
        if ((direction.equals("Diagonal")) &&
                !board[newPosition[0]][newPosition[1]].getPieceAllegiance().equals(pieceBeingMoved.getPieceAllegiance())) {
            int[] temporaryPositionArray = movementService.getAbsolutePositionCoords(startPosition, newPosition, direction);
            isValid = movementService.isPathClearToNewPosition(temporaryPositionArray[0], temporaryPositionArray[1],
                    temporaryPositionArray[2], temporaryPositionArray[3], board, direction, pieceBeingMoved.getPieceAllegiance());
        }

        return isValid;
    }
    public Bishop(String pieceAllegiance) {
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

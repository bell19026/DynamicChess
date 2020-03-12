package com.liambell.dynamicchess.Controller;

import com.liambell.dynamicchess.Model.Entity.Board;
import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;
import com.liambell.dynamicchess.Model.Services.BoardServices;
import com.liambell.dynamicchess.Model.Services.MovementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

@RestController
public class GameController {

    @Autowired
    BoardServices boardServices;

    @Autowired
    MovementServices movementServices;
    @RequestMapping(value = "/createBoard")
    public void createBoard() {
        boardServices.setChessBoardSize(8, 8);
        boardServices._loadDefaultBoardConfiguration();
        Piece[][] chessboard = boardServices.getChessBoard();

        for (Piece[] pieces : chessboard) {
            IntStream.range(0, chessboard.length).mapToObj(j -> "[" + pieces[j].getPieceName() + "]").forEach(System.out::print);
            System.out.println();
        }

        boardServices.cloneChessboard(boardServices.getChessBoard().length, boardServices.getChessBoard().length);
    }

    @RequestMapping(value = "/movePieces")
    public void movePieces() {
        ArrayList<int[]> pieceMovementCoordinates;
        boolean continueLoop = true;
        for (int i = 0; i < 5; i++) {
            try {
                pieceMovementCoordinates = movementServices.getCoordinatesForPieceMovementAction();
                boardServices.movePiece(pieceMovementCoordinates.get(0), pieceMovementCoordinates.get(1));
                printBoard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printBoard() {
        for (Piece[] pieces : boardServices.getChessBoard()) {
            IntStream.range(0, boardServices.getChessBoard().length).mapToObj(j -> "[" + pieces[j].getPieceName() + "]").forEach(System.out::print);
            System.out.println();
        }
    }
}

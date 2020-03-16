package com.liambell.dynamicchess.Controller;

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
    public void movePieces(@RequestHeader String movementCoordinates) {
        ArrayList<int[]> pieceMovementCoordinates = new ArrayList<>();
            try {
                ArrayList<Integer> coords = new ArrayList<>();
                int[] startingCoordinates = new int[2];
                int[] endingCoordinates = new int[2];
                for(String s : movementCoordinates.split("")) {
                    coords.add(Integer.parseInt(s));
                }
                startingCoordinates[0] = coords.get(0);
                startingCoordinates[1] = coords.get(1);
                endingCoordinates[0] = coords.get(2);
                endingCoordinates[1] = coords.get(3);
                pieceMovementCoordinates.add(startingCoordinates);
                pieceMovementCoordinates.add(endingCoordinates);
                boardServices.movePiece(pieceMovementCoordinates.get(0), pieceMovementCoordinates.get(1));
                System.out.println("\n");
                printBoard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    private void printBoard() {
        for (Piece[] pieces : boardServices.getChessBoard()) {
            IntStream.range(0, boardServices.getChessBoard().length).mapToObj(j -> "[" + pieces[j].getPieceName() + "]").forEach(System.out::print);
            System.out.println();
        }
    }
}

package com.liambell.dynamicchess.Controller;

import com.liambell.dynamicchess.Model.Entity.Board;
import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;
import com.liambell.dynamicchess.Model.Services.BoardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
public class GameController {

    @Autowired
    BoardServices boardServices;

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
}

package com.liambell.dynamicchess.Model.Services;

import com.liambell.dynamicchess.Model.Entity.Board;
import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServices {
    @Autowired
    Board board;

    private Piece[][] chessBoard;

    public Piece[][] getChessBoard() {
        return this.chessBoard;
    }

    public void setChessBoardSize(int chessBoardColumn, int chessBoardRow) {
        board.setBoardSize(chessBoardColumn, chessBoardRow);
        chessBoard = new Piece[board.getBoardSize()[0]][board.getBoardSize()[1]];
    }

    public void populateChessboard() {
        for(int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = new Piece();
            }
        }
    }

    public void _loadDefaultBoardConfiguration() {
        this.chessBoard[0][0] = new Piece("R");
        this.chessBoard[0][1] = new Piece("B");
        this.chessBoard[0][2] = new Piece("k");
        this.chessBoard[0][3] = new Piece("K");
        this.chessBoard[0][4] = new Piece("Q");
        this.chessBoard[0][5] = new Piece("k");
        this.chessBoard[0][6] = new Piece("B");
        this.chessBoard[0][7] = new Piece("R");
        this.chessBoard[1][0] = new Piece("P");
        this.chessBoard[1][1] = new Piece("P");
        this.chessBoard[1][2] = new Piece("P");
        this.chessBoard[1][3] = new Piece("P");
        this.chessBoard[1][4] = new Piece("P");
        this.chessBoard[1][5] = new Piece("P");
        this.chessBoard[1][6] = new Piece("P");
        this.chessBoard[1][7] = new Piece("P");
        this.chessBoard[7][0] = new Piece("R");
        this.chessBoard[7][1] = new Piece("B");
        this.chessBoard[7][2] = new Piece("k");
        this.chessBoard[7][3] = new Piece("Q");
        this.chessBoard[7][4] = new Piece("K");
        this.chessBoard[7][5] = new Piece("k");
        this.chessBoard[7][6] = new Piece("B");
        this.chessBoard[7][7] = new Piece("R");
        this.chessBoard[6][0] = new Piece("P");
        this.chessBoard[6][1] = new Piece("P");
        this.chessBoard[6][1] = new Piece("P");
        this.chessBoard[6][2] = new Piece("P");
        this.chessBoard[6][3] = new Piece("P");
        this.chessBoard[6][4] = new Piece("P");
        this.chessBoard[6][5] = new Piece("P");
        this.chessBoard[6][6] = new Piece("P");
        this.chessBoard[6][7] = new Piece("P");

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessBoard[i][j] = new Piece(" ");
            }
        }
    }

}

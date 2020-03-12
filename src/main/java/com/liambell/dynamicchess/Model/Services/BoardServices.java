package com.liambell.dynamicchess.Model.Services;

import com.liambell.dynamicchess.Model.Entity.Board;
import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;
import com.liambell.dynamicchess.Model.Entity.ChessPieces.PresetPieces.EmptyPiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

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

    public void _loadDefaultBoardConfiguration() {
        this.chessBoard[0][0] = new Piece("R", "White");
        this.chessBoard[0][1] = new Piece("B", "White");
        this.chessBoard[0][2] = new Piece("k", "White");
        this.chessBoard[0][3] = new Piece("K", "White");
        this.chessBoard[0][4] = new Piece("Q", "White");
        this.chessBoard[0][5] = new Piece("k", "White");
        this.chessBoard[0][6] = new Piece("B", "White");
        this.chessBoard[0][7] = new Piece("R", "White");
        this.chessBoard[1][0] = new Piece("P", "White");
        this.chessBoard[1][1] = new Piece("P", "White");
        this.chessBoard[1][2] = new Piece("P", "White");
        this.chessBoard[1][3] = new Piece("P", "White");
        this.chessBoard[1][4] = new Piece("P", "White");
        this.chessBoard[1][5] = new Piece("P", "White");
        this.chessBoard[1][6] = new Piece("P", "White");
        this.chessBoard[1][7] = new Piece("P", "White");
        this.chessBoard[7][0] = new Piece("R", "White");
        this.chessBoard[7][1] = new Piece("B", "White");
        this.chessBoard[7][2] = new Piece("k", "White");
        this.chessBoard[7][3] = new Piece("Q", "White");
        this.chessBoard[7][4] = new Piece("K", "White");
        this.chessBoard[7][5] = new Piece("k", "White");
        this.chessBoard[7][6] = new Piece("B", "White");
        this.chessBoard[7][7] = new Piece("R", "White");
        this.chessBoard[6][0] = new Piece("P", "White");
        this.chessBoard[6][1] = new Piece("P", "White");
        this.chessBoard[6][1] = new Piece("P", "White");
        this.chessBoard[6][2] = new Piece("P", "White");
        this.chessBoard[6][3] = new Piece("P", "White");
        this.chessBoard[6][4] = new Piece("P", "White");
        this.chessBoard[6][5] = new Piece("P", "White");
        this.chessBoard[6][6] = new Piece("P", "White");
        this.chessBoard[6][7] = new Piece("P", "White");

        IntStream.range(2, 6).forEach(i ->
                IntStream.range(0, this.chessBoard.length).forEach(j ->
                        this.chessBoard[i][j] = new Piece(" ")));
    }

    public Piece[][] movePiece(int[] startOfMovementPosition, int[] endOfMovementPosition) {

        /*
            -Validate if the move is correct
            -Get the current allegiance
            - Clone the chessboard, change it, then copy it back
         */
        Piece piece = this.chessBoard[startOfMovementPosition[0]][startOfMovementPosition[1]];
        String opposingAllegiance = piece.getPieceAllegiance().equals("White") ? "Black" : "White";

        if (piece.isValidMove(this.chessBoard, piece, startOfMovementPosition, endOfMovementPosition)) {
            this.chessBoard[startOfMovementPosition[1]][startOfMovementPosition[0]] = new Piece(" ");
            this.chessBoard[endOfMovementPosition[1]][endOfMovementPosition[0]] = piece;
        }
        return this.chessBoard;
    }

    public Piece[][] cloneChessboard(int boardSizeY, int boardSizeX) {
        Piece[][] temporaryChessboard = new Piece[boardSizeY][boardSizeY];
        IntStream.range(0, this.chessBoard.length).forEach(i ->
                IntStream.range(0, this.chessBoard[i].length).forEach(j ->
                        temporaryChessboard[i][j] = this.chessBoard[i][j]));

        return temporaryChessboard;
    }

    public Piece[][] modifyChessboardSize(int boardSizeY, int boardSizeX) {
        return cloneChessboard(boardSizeY, boardSizeX);
    }

}

package com.liambell.dynamicchess.Model.Entity;

import org.springframework.stereotype.Component;

@Component
public class Board {

    private int boardSizeY = 1;
    private int boardSizeX = 1;

    public void setBoardSize(int boardSizeY, int boardSizeX) {
        this.boardSizeY = boardSizeY;
        this.boardSizeX = boardSizeX;
    }

    public int[] getBoardSize() {
        int[] boardSizeArray = new int[2];
        boardSizeArray[0] = boardSizeY;
        boardSizeArray[1] = boardSizeX;

        return boardSizeArray;
    }
}

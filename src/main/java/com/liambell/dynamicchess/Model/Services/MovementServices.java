package com.liambell.dynamicchess.Model.Services;

import com.liambell.dynamicchess.Model.Entity.ChessPieces.Piece;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Service
public class MovementServices {

    public ArrayList<int[]> getCoordinatesForPieceMovementAction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Y Axis Start Position: ");
        String startPositionY =   reader.readLine();
        System.out.println("Enter X Axis Start Position: ");
        String startPositionX =   reader.readLine();
        System.out.println("Enter Y Axis End Position: ");
        String newPositionY =   reader.readLine();
        System.out.println("Enter X Axis End Position: ");
        String newPositionX =   reader.readLine();
        int[] startPositions = new int[2];
        int[] newPositions = new int[2];
        startPositions[0] = Integer.parseInt(startPositionY);
        startPositions[1] = Integer.parseInt(startPositionX);
        newPositions[0] = Integer.parseInt(newPositionY);
        newPositions[1] = Integer.parseInt(newPositionX);

        ArrayList<int[]> movement = new ArrayList<>();
        movement.add(startPositions);
        movement.add(newPositions);

        return movement;
    }

    public String determineCurrentPieceMovementDirection(int[] startOfMovementPosition, int[] endOfMovementPosition) {
        String direction = "";


        if (Math.abs(startOfMovementPosition[0] - endOfMovementPosition[0]) != 0 && Math.abs(startOfMovementPosition[1] - endOfMovementPosition[1]) == 0) {
            direction = "Vertical";
        } else if (Math.abs(startOfMovementPosition[1] - endOfMovementPosition[1]) != 0 && Math.abs(startOfMovementPosition[0] - endOfMovementPosition[0]) == 0) {
            direction = "Horizontal";
        } else if (Math.abs(startOfMovementPosition[0] - endOfMovementPosition[0]) == Math.abs((startOfMovementPosition[1] - endOfMovementPosition[1]))) {
            direction = "Diagonal";
        }

        return direction;
    }


    public boolean isPathClearToNewPosition(int basePositionY, int endPositionY, int basePositionX, int endPositionX, Piece[][] board, String direction, String allegiance) {

        boolean isClearPath = false;

        iterator:
        switch (direction) {
            case "Vertical":
                for (int i = basePositionY; i <= endPositionY; i++) {
                    if (!board[i][basePositionX].getPieceAllegiance().equals(allegiance) || board[i][basePositionX].getPieceName().equals(" ")) {
                        isClearPath = true;
                    } else if (endPositionY - basePositionY != 1) {
                        isClearPath = false;
                        break iterator;
                    }
                }
                break;
            case "Horizontal":
                for (int i = basePositionX; i <= endPositionX; i++) {
                    if (!board[basePositionY][i].getPieceAllegiance().equals(allegiance) && i > 1 || board[basePositionY][i].getPieceName().equals(" ")) {
                        isClearPath = true;
                    } else if (endPositionX - basePositionX != 1) {
                        break iterator;
                    }
                }
                break;
            case "Diagonal":
                for (int i = basePositionY; i <= endPositionY; i++) {
                    for (int j = basePositionX; j <= endPositionX; j++) {
                        if (!board[i][j].getPieceName().equals(allegiance)) {
                            isClearPath = true;
                        } else {
                            break iterator;
                        }
                    }
                }
                break;
        }
        return isClearPath;
    }

    public int[] getAbsolutePositionCoords(int[] startPosition, int[] newPosition, String direction) {
        int basePositionY = 0;
        int basePositionX = 0;
        int endPositionY = 0;
        int endPositionX = 0;
        switch (direction) {

            case "Vertical":
                if (this.determineRowAndColumnDirection(startPosition[0], newPosition[0]).equals("Positive")) {
                    if (newPosition[0] - startPosition[0] > 1) {
                        basePositionY = startPosition[0] + 1;
                    } else {
                        basePositionY = startPosition[0];
                    }

                    endPositionY = newPosition[0];
                } else {
                    if (startPosition[0] - newPosition[0] > 1) {
                        basePositionY = newPosition[0] + 1;
                    } else {
                        basePositionY = newPosition[0];
                    }
                    endPositionY = startPosition[0];
                }
                basePositionX = startPosition[1];
                endPositionX = newPosition[1];
                break;
            case "Horizontal":
                if (this.determineRowAndColumnDirection(startPosition[1], newPosition[1]).equals("Positive")) {
                    if (newPosition[1] - startPosition[1] > 1) {
                        basePositionX = startPosition[1] + 1;
                    } else {
                        basePositionX = startPosition[1];
                    }
                    endPositionX = newPosition[1];
                } else {
                    if (startPosition[1] - newPosition[1] > 1) {
                        basePositionX = newPosition[1] + 1;
                    } else {
                        basePositionX = newPosition[1];
                    }
                    endPositionX = startPosition[1];
                }
                basePositionY = startPosition[0];
                endPositionY = newPosition[0];
                break;
            case "Diagonal":
                String movementDirectionY = this.determineRowAndColumnDirection(startPosition[0], newPosition[0]);
                String movementDirectionX = this.determineRowAndColumnDirection(startPosition[1], newPosition[1]);
                if (movementDirectionY.equals("Positive")) {
                    basePositionY = startPosition[0] + 1;
                    endPositionY = newPosition[0];
                } else {
                    basePositionY = newPosition[0] + 1;
                    endPositionY = startPosition[0];
                }

                if (movementDirectionX.equals("Positive")) {
                    basePositionX = startPosition[1] + 1;
                    endPositionX = newPosition[1];
                } else {
                    basePositionX = newPosition[1] + 1;
                    endPositionX = startPosition[1];
                }
                break;
        }
        int[] tempPositionHolder = new int[4];
        tempPositionHolder[0] = basePositionY;
        tempPositionHolder[1] = endPositionY;
        tempPositionHolder[2] = basePositionX;
        tempPositionHolder[3] = endPositionX;
        return tempPositionHolder;
    }

    private String determineRowAndColumnDirection(int startPosition, int newPosition) {
        return (newPosition -  startPosition >= 0) ? "Positive" : "Negative";
    }
}

package com.liambell.dynamicchess.Model.Services;

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
}

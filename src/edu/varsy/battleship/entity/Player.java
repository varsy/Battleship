package edu.varsy.battleship.entity;

import edu.varsy.battleship.business.FieldConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Battleship
 * User: vars
 * Date: 14/02/15
 * Time: 01:39
 * Created with IntelliJ IDEA.
 */
public class Player {
    private List<Ship> ownShipList = new ArrayList<Ship>();
    private FieldConsole ownField;

    public Player() {
    }

    public void addShipToField(int x, int y, int type, int direction) {
        Ship ship = new Ship(x, y, type, direction);
        ownShipList.add(ship);
        if (direction == 1) { // vertical
            for (int i = y; i < y+type; i++) {
                ownField.setCellStatus(x,i,4);
            }
        } else if (direction == 2) { // horizontal
            for (int i = x; i < x+type; i++) {
                ownField.setCellStatus(i,y,4);
            }
        }
    }

    public void setField(FieldConsole field) {
        this.ownField = field;
    }

    public int takeShot(int x, int y) {
        switch (ownField.getCellStatus(x, y)) {
            case 0:
                // miss, was empty
                ownField.setCellStatus(x, y, 2);
                return 0;
            case 1:
                // hit, was hit
                ownField.setCellStatus(x, y, 1);
                return 1;
            case 2:
                // miss, was miss
                ownField.setCellStatus(x, y, 2);
                return 1;
            case 4:
                // hit, was ship
                ownField.setCellStatus(x, y, 1);
                return 2;
            default:
                // unknown
                return 3;
        }
    }

    public int readCoords(String coord) {
        System.out.println("Please enter the " + coord + " coordinate: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try {
                String line = br.readLine();
                if (line.length() > 0) {
                    int input = Integer.parseInt(line);
                    return input;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Please type number!");
            }

            return 0;
        }


    }

}

package edu.varsy.battleship.business;

import edu.varsy.battleship.entity.Player;

import java.io.IOException;

/**
 * Project: Battleship
 * User: vars
 * Date: 14/02/15
 * Time: 01:35
 * Created with IntelliJ IDEA.
 */
public class FieldConsole implements Field{
    private static final int SIZE = 10;

    private int[][] fieldStatus = new int[SIZE][SIZE];

    private Player player;

    public void initField(Player player) {
        this.player = player;
        player.setField(this);

        // initializing empty board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                fieldStatus[i][j] = 0;
            }
        }

    }

    public int getCellStatus(int x, int y){
        return fieldStatus[x][y];
    }
    public void setCellStatus(int x, int y, int status) {
        fieldStatus[x][y] = status;
    }

    public void draw() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + i+ " ");
        }
        System.out.println();
        String symbol;
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                switch (fieldStatus[i][j]) {
                    case 1:
                        symbol = "X";
                        break;
                    case 2:
                        symbol = "~";
                        break;
                    case 3:
                        symbol = ".";
                        break;
                    case 4: // debug only, removed fog of war
                        symbol = "s";
                        break;
                    default:
                        symbol = "#";
                        break;
                }
                System.out.print(" " + symbol + " ");

            }
            System.out.println();
        }
    }

}

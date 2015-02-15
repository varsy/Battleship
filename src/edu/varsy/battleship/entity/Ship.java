package edu.varsy.battleship.entity;

/**
 * Project: Battleship
 * User: vars
 * Date: 14/02/15
 * Time: 01:04
 * Created with IntelliJ IDEA.
 */
public class Ship {

    private int type;
    private boolean isAlive = true;

    private int[] cells;

    private int startX;
    private int startY;
    private int direction;


    public Ship(int startX, int startY, int type, int direction) {
        setType(type);
        cells = new int[type];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = 1;
        }
        setPosition(startX, startY, direction);
    }

    public int getCellStatus(int cellNum) {
        return cells[cellNum];
    }

    public void setCellStatus(int cellNum, int status) {
        cells[cellNum] = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        try {
            if ((type > 0) && (type < 5)) {
                this.type = type;
            } else {
                throw new Exception("Wrong ship type.");
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void setPosition(int startX, int startY, int direction) {
        this.startX = startX;
        this.startY = startY;
        this.direction = direction;

    }
}

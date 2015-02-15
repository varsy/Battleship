package edu.varsy.battleship.business;

import edu.varsy.battleship.entity.Player;

/**
 * Project: Battleship
 * User: vars
 * Date: 14/02/15
 * Time: 18:24
 * Created with IntelliJ IDEA.
 */
public interface Field {
    public void initField(Player player);

    public int getCellStatus(int x, int y);

    public void setCellStatus(int x, int y, int status);

    public void draw();

}

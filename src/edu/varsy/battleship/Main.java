package edu.varsy.battleship;

import edu.varsy.battleship.business.FieldConsole;
import edu.varsy.battleship.entity.Player;

/**
 * Project: Battleship
 * User: vars
 * Date: 14/02/15
 * Time: 02:52
 * Created with IntelliJ IDEA.
 */
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        FieldConsole f1 = new FieldConsole();
        f1.initField(p1);



        f1.draw();

        p1.takeShot(2,2);

        f1.draw();

        p1.addShipToField(5,6,3,1);
        p1.takeShot(5,7);
        f1.draw();

        while (true) {
            int x = p1.readCoords("x");
            int y = p1.readCoords("y");

            int i = p1.takeShot(x,y);
            System.out.println(i);
            f1.draw();
        }


    }
}

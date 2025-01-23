import java.awt.Color;

public class Turtled extends Turtle {
    public static void main(String[] args) throws Exception {
        // new Turtled().circle(2);
        // new Turtled().smallerSquare(100);

    }

    public void circle(int size) {
        setzeSpeed(7);
        setzeStiftFarbe(Color.BLUE);
        setzeWinkel(90);
        for (int i = 0; i < 360; i++) {
            gehe(-size);
            drehe(-1);
        }
        start();
    }

    public void smallerSquare(int size) {
        if (size == 1)
            return;
        setzeSpeed(7);
        setzeStiftFarbe(Color.BLUE);
        for (int i = 0; i < 4; i++) {
            gehe(size);
            drehe(90);
        }
        start();
        smallerSquare((int) (size * 0.75));
    }

}

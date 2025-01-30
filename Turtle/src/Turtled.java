import java.awt.Color;

public class Turtled extends Turtle {
    public static void main(String[] args) throws Exception {
        new Turtled();

    }

    Turtled() {
        setzeSpeed(10);
//        kochkurve(1500, 5);
        pythagoBaum(100, 40, 10);
        start();
    }

    private void pythagoBaum(double laenge, double winkel, int tiefe) {
        if (tiefe == 0) {
            gehe(laenge);
            return;
        }
        double laengeAn = laenge*Math.cos(winkel*(Math.PI/180));
        double laengeGe = laenge*Math.sin(winkel*(Math.PI/180));
        for (int i = 1; i <= 7; i++) {
            gehe(laenge);
            drehe(-90);
        }
        drehe(270-winkel);
        pythagoBaum(laengeAn, winkel, tiefe-1);//gehe(laengeAn);
        drehe(90);
        pythagoBaum(laengeGe, winkel, tiefe-1);//gehe(laengeGe);
        drehe(winkel);
        gehe(laenge);
        drehe(-90);


    }

    private void kochkurve(int laenge, int tiefe) {
        if (tiefe == 0) {
            gehe(laenge);
            return;
        }
        kochkurve(laenge / 3, tiefe - 1);
        drehe(60);
        kochkurve(laenge / 3, tiefe - 1);
        drehe(-120);
        kochkurve(laenge / 3, tiefe - 1);
        drehe(60);
        kochkurve(laenge / 3, tiefe - 1);
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

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Hanoi extends JFrame {

    private ArrayList<Integer> tower0 = new ArrayList<Integer>();
    private ArrayList<Integer> tower1 = new ArrayList<Integer>();
    private ArrayList<Integer> tower2 = new ArrayList<Integer>();

    public Hanoi() {
        setVisible(true);
        setSize(1920,1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 3; i > 0; i--) {
            tower0.add(i);
        }
        hanoi(tower0.size(), tower0, tower1, tower2);

    }

    private void hanoi(int towerSize, ArrayList<Integer> from, ArrayList<Integer> to, ArrayList<Integer> help) {

        if (towerSize == 0) return;
        hanoi(towerSize-1, from, help, to);
        System.out.println("Nimm " + towerSize + " von " + from + " und lege zu " + to);
        to.add(from.remove(from.size()-1));
        repaint();
        hanoi(towerSize-1, help, to, from);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0,0,WIDTH,HEIGHT);
//        g.fillRect(640, 980, 50, 50);
        for (int i = 1; i <= tower0.size(); i++) {
            g.fillRect(640-i*10, 980-i*15, i*20, 14);
        }
        for (int i = 1; i <= tower1.size(); i++) {
            g.fillRect(2*640-i*10, 980-i*15, i*20, 14);
        }
        for (int i = 1; i <= tower2.size(); i++) {
            g.fillRect(3*640-i*10, 980-i*15, i*20, 14);
        }
    }

    public static void main(String[] args) {
        new Hanoi();
    }

}
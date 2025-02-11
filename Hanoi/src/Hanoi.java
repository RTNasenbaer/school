import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Hanoi extends JFrame {

    private ArrayList<Integer> tower0 = new ArrayList<Integer>();
    private ArrayList<Integer> tower1 = new ArrayList<Integer>();
    private ArrayList<Integer> tower2 = new ArrayList<Integer>();

    public Hanoi() throws InterruptedException {
        setVisible(true);
        setSize(1920,1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 8; i > 0; i--) {
            tower0.add(i);
        }
        hanoi(tower0.size(), tower0, tower2, tower1);
        repaint();
    }

    private void hanoi(int towerSize, ArrayList<Integer> from, ArrayList<Integer> to, ArrayList<Integer> help) throws InterruptedException {

        if (towerSize == 0) return;
        hanoi(towerSize-1, from, help, to);
        System.out.println("Nimm " + towerSize + " von " + from + " und lege zu " + to);
        to.add(from.remove(from.size()-1));
        repaint();
        Thread.sleep(50);
        hanoi(towerSize-1, help, to, from);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0,0,WIDTH,HEIGHT);
        for (int i = 0; i < tower0.size(); i++) g.fillRect(480-tower0.get(i)*10, 980-i*15, tower0.get(i)*20, 14);
        for (int i = 0; i < tower1.size(); i++) g.fillRect(2*480-tower1.get(i)*10, 980-i*15, tower1.get(i)*20, 14);
        for (int i = 0; i < tower2.size(); i++) g.fillRect(3*480-tower2.get(i)*10, 980-i*15, tower2.get(i)*20, 14);
    }

    public static void main(String[] args) throws InterruptedException {
        new Hanoi();
    }

}
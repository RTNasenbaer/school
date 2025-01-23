import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
//(c) A. Eckert, GMG, Juli 2018

public class Turtle extends JFrame {
	private static class Linie {
		final int x1;
		final int y1;
		final int x2;
		final int y2;
		final Color farbe;
		final double dicke;

		public Linie(int x1, int y1, int x2, int y2, Color farbe, double dicke) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.farbe = farbe;
			this.dicke = dicke;
		}
	}

	private double posX = 0;
	private double posY = 0;
	private double winkel = 0;
	private double stiftdicke = 1;
	private Color farbe = Color.black;
	private boolean zeichneAn = true;
	private int speed = 4;
	private ArrayList<Linie> linien = new ArrayList<Linie>();

	public Turtle() {
		this(600, 400, 0);
	}

	public Turtle(double x, double y, double richtung) {
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		reset();
		posX = x;
		posY = y;
		winkel = richtung;
	}

	public void zeichne(int bis) {
		if (bis > linien.size()) return;
		Image buffer = createImage(getSize().width, getSize().height);
		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		ArrayList<Linie> kopie = new ArrayList<Linie>(linien);
		for (int i = 0; i < bis; i++) {
			Linie l = kopie.get(i);
			g2d.setColor(l.farbe);
			g2d.setStroke(new BasicStroke((float) l.dicke, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
			g2d.drawLine(l.x1, l.y1, l.x2, l.y2);
		}
		getGraphics().drawImage(buffer, 0, 0, null);
	}

	public void start() {
		if (speed == 10) {
			zeichne(linien.size());
			return;
		}
		for (int i = 1; i <= linien.size(); i++) {
			if (speed < 6) zeichne(i);
			if (speed == 6) zeichne(i * 2);
			if (speed == 7) zeichne(i * 4);
			if (speed == 8) zeichne(i * 8);
			if (speed == 9) zeichne(i * 16);
			try {
				if (speed == 1) Thread.sleep(1000);
				if (speed == 2) Thread.sleep(500);
				if (speed == 3) Thread.sleep(200);
				if (speed == 4) Thread.sleep(100);
				if (speed == 5) Thread.sleep(50);
				if (speed >= 6) Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {}

	public void gehe(double laenge) {
		double neuX = posX + Math.cos(winkel * Math.PI / 180) * laenge;
		double neuY = posY + Math.sin(winkel * Math.PI / 180) * laenge;
		if (zeichneAn) linien.add(new Linie((int) posX, (int) posY, (int) neuX, (int) neuY, farbe, stiftdicke));
		posX = neuX;
		posY = neuY;
	}

	public void geheZu(double neuX, double neuY) {
		if (zeichneAn) linien.add(new Linie((int) posX, (int) posY, (int) neuX, (int) neuY, farbe, stiftdicke));
		posX = neuX;
		posY = neuY;
	}

	public void geheZuRelativ(double deltaX, double deltaY) {
		double neuX = posX + deltaX;
		double neuY = posY + deltaY;
		if (zeichneAn) linien.add(new Linie((int) posX, (int) posY, (int) neuX, (int) neuY, farbe, stiftdicke));
		posX = neuX;
		posY = neuY;
	}

	public void drehe(double grad) {
		winkel = (winkel + grad) % 360;
	}

	public void setzeWinkel(double grad) {
		winkel = grad;
	}

	public void reset() {
		winkel = 0;
		posX = 0;
		posY = 0;
		linien.clear();
		repaint();
	}

	public void setzeStiftFarbe(Color fa) {
		farbe = fa;
	}

	public void setzeStiftFarbe(String fa) {
		if (fa.equals("rot")) farbe = Color.RED;
		if (fa.equals("blau")) farbe = Color.BLUE;
		if (fa.equals("gruen")) farbe = Color.GREEN;
		if (fa.equals("weiss")) farbe = Color.WHITE;
		if (fa.equals("gelb")) farbe = Color.YELLOW;
		if (fa.equals("schwarz")) farbe = Color.BLACK;
		if (fa.equals("orange")) farbe = Color.ORANGE;
	}

	public void setzeStiftdicke(double dicke) {
		stiftdicke = dicke;
	}

	public void setzeSpeed(int speed) {
		if (speed < 1)
			this.speed = 1;
		else if (speed > 10)
			this.speed = 10;
		else
			this.speed = speed;
	}

	public void zeichneAn() {
		zeichneAn = true;
	}

	public void zeichneAus() {
		zeichneAn = false;
	}

	public double gibWinkel() {
		return winkel;
	}

	public double gibX() {
		return posX;
	}

	public double gibY() {
		return posY;
	}

	public Color gibFarbe() {
		return farbe;
	}
}

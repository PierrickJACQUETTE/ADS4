import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Panneau extends JPanel {

	int hauteur;
	int largeur;
	double zoom;

	public Panneau(int larg, int haut) {
		largeur = larg;
		hauteur = haut;
		setZoom(1);
		setBackground(Color.white);
	}

	public void paintLigne(Graphics g, int x1, int y1, int x2, int y2,
			int epaisseur, Couleur c, float t) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue()));
		if (t == 0) {
			g2.setStroke(new BasicStroke((int) (epaisseur * zoom)));
		} else {
			final float dash1[] = { (float) (t * zoom) };
			final BasicStroke dashed = new BasicStroke((int)(epaisseur*zoom),
					BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2.setStroke(dashed);
		}
		g2.drawLine((int) (x1 * zoom), (int) (y1 * zoom), (int) (x2 * zoom),
				(int) (y2 * zoom));
		
	}

	public void paintCercle(Graphics g, int x1, int y1, int x2, int y2,
			int epaisseur, Couleur c, float t, int rayonX, int rayonY) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue()));
		if (t == 0) {
			g2.setStroke(new BasicStroke((int)(epaisseur*zoom)));
		} else {
			final float dash1[] = { (float) (t * zoom) };
			final BasicStroke dashed = new BasicStroke((int)(epaisseur*zoom),
					BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2.setStroke(dashed);
		}
		g2.drawOval((int) ((x1 - rayonX) * zoom), (int) ((y1 - rayonY) * zoom),
				(int) (rayonX * 2 * zoom), (int) (rayonY * 2 * zoom));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color background = new Color(255, 255, 255);
		for (Couleur c : Instruction.queueBackground) {
			background = new Color(c.getRed(), c.getGreen(), c.getBlue());
		}
		for (Ligne ligne : Instruction.q) {
			Couleur couleurTrait = new Couleur(background.getRed(),
					background.getGreen(), background.getBlue());
			if (ligne.getEstCercle()) {
				if (ligne.getDessine()) {
					couleurTrait = ligne.getCouleurTrait();
					paintCercle(g, ligne.getDepart().getX(), ligne.getDepart().getY(), ligne.getArrivee().getX(),
							ligne.getArrivee().getY(), ligne.getEpaisseur(), couleurTrait,
							ligne.getTypeDeTrait(), ligne.getRayonX(), ligne.getRayonY());
				}
			} else {
				if (ligne.getDessine()) {
					couleurTrait = ligne.getCouleurTrait();
					paintLigne(g, ligne.getDepart().getX(), ligne.getDepart().getY(), ligne.getArrivee().getX(),
							ligne.getArrivee().getY(), ligne.getEpaisseur(), couleurTrait,
							ligne.getTypeDeTrait());
				}
			}
		}
		setBackground(background);
	}

	void setZoom(double zo) {
		zoom = zo;
		int w = (int) (zoom * largeur);
		int h = (int) (zoom * hauteur);
		setPreferredSize(new Dimension(w, h));
		revalidate();
		repaint();
	}
}

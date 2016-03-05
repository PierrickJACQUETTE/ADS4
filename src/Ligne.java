public class Ligne {

	private boolean b;
	private boolean estCercle;
	private int epaisseur;
	private Couleur couleurTrait;
	private int rayonX;
	private int rayonY;
	private float typeDeTrait;
	private Point depart;
	private Point arrivee;

	public Ligne(Point a, Point d, boolean bool, int e, Couleur c, float trait,
			boolean cercle, int rayonx, int rayony) {
		arrivee = a;
		depart = d;
		b = bool;
		epaisseur = e;
		couleurTrait = new Couleur(c.getRed(), c.getGreen(), c.getBlue());
		typeDeTrait = trait;
		estCercle = cercle;
		rayonX = rayonx;
		rayonY = rayony;
	}

	public Point getArrivee() {
		return arrivee;
	}

	public Point getDepart() {
		return depart;
	}

	public boolean getDessine() {
		return b;
	}

	public boolean getEstCercle() {
		return estCercle;
	}

	public int getEpaisseur() {
		return epaisseur;
	}

	public Couleur getCouleurTrait() {
		return couleurTrait;
	}

	public int getRayonX() {
		return rayonX;
	}

	public int getRayonY() {
		return rayonY;
	}

	public float getTypeDeTrait() {
		return typeDeTrait;
	}
}

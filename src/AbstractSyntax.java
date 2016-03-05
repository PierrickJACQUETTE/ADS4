import java.awt.Color;
import java.util.*;

abstract class Expression {
	abstract int eval(ValueEnvironment env) throws Exception;
}

class Int extends Expression {

	private int value;

	public Int(int i) {
		value = i;
	}

	public int eval(ValueEnvironment env) throws Exception {
		return value;
	}
}

class Var extends Expression {
	private String name;

	public Var(String s) {
		name = s;
	}

	public int eval(ValueEnvironment env) throws Exception {
		return env.getValue(name);
	}
}

class Sum extends Expression {

	private Expression left, right;

	public Sum(Expression l, Expression r) {
		left = l;
		right = r;
	}

	public int eval(ValueEnvironment env) throws Exception {
		return left.eval(env) + right.eval(env);
	}
}

class Difference extends Expression {

	private Expression left, right;

	public Difference(Expression l, Expression r) {
		left = l;
		right = r;
	}

	public int eval(ValueEnvironment env) throws Exception {
		return left.eval(env) - right.eval(env);
	}

}

class Product extends Expression {

	private Expression left, right;

	public Product(Expression l, Expression r) {
		left = l;
		right = r;
	}

	public int eval(ValueEnvironment env) throws Exception {
		return left.eval(env) * right.eval(env);
	}
}

class Division extends Expression {

	private Expression left, right;

	public Division(Expression l, Expression r) {
		left = l;
		right = r;
	}

	public int eval(ValueEnvironment env) throws Exception {
		int r = right.eval(env);
		if (r != 0) {
			return left.eval(env) / right.eval(env);
		} else {
			throw new DivisionParZero(left.eval(env), r);
		}
	}
}

class Programme {

	private Instruction first;
	private Declaration decl;

	public Programme(Instruction i, Declaration d) {
		first = i;
		decl = d;
	}

	public void run(ValueEnvironment env) throws Exception {
		if (decl != null) {
			decl.exec(env);
		}
		if (first != null) {
			initialisationInstruction();
			first.exec(env);
		}
	}

	public void initialisationInstruction() {
		Instruction.largeurFenetre = 500;
		Instruction.hauteurFenetre = 500;
		Instruction.dessine = false;
		Instruction.canevas = false;
		Instruction.direction = 0;
		Instruction.depart = new Point(0, Instruction.hauteurFenetre);
		Instruction.arrivee = new Point(0, Instruction.hauteurFenetre);
		Instruction.q = new LinkedList<Ligne>();
		Instruction.queueBackground = new LinkedList<Couleur>();
		Instruction.epaisseur = 1;
		Instruction.typeDeTrait = 0;
		Instruction.trait = new Couleur(Color.black.getRed(),
				Color.black.getGreen(), Color.black.getBlue());
	}
}

class Declaration {

	private String varName;
	private Declaration decl;

	public Declaration(String s, Declaration d) {
		varName = s;
		decl = d;
	}

	public void exec(ValueEnvironment env) throws Exception {
		for (int i = 0; i < 1; i++) {
			env.addVariable(varName);
			if (decl == null) {
				break;
			}
			decl.exec(env);
		}
	}
}

abstract class Instruction {
	abstract void exec(ValueEnvironment env) throws Exception;

	static boolean canevas;
	static boolean dessine;// true par defaut , true si pinceauBas false si
							// pinceauHaut
	static int direction;
	/*
	 * O si vers trait vers le nord 90 si vers la gauche 180 si vers le sud 270
	 * si vers la droite
	 */
	static Point depart;
	static Point arrivee;
	static Queue<Ligne> q;
	static Queue<Couleur> queueBackground;
	static int largeurFenetre;
	static int hauteurFenetre;
	static int epaisseur;
	static int redTrait;
	static int blueTrait;
	static int greenTrait;
	static float typeDeTrait;
	static Couleur trait;
}

class BasDroit extends Instruction {

	public BasDroit() {
	}

	public void exec(ValueEnvironment env) throws Exception {
		arrivee = new Point(Instruction.largeurFenetre,
				Instruction.hauteurFenetre);
		depart = new Point(Instruction.largeurFenetre,
				Instruction.hauteurFenetre);
	}
}

class HautDroit extends Instruction {

	public HautDroit() {
	}

	public void exec(ValueEnvironment env) throws Exception {
		arrivee = new Point(Instruction.largeurFenetre, 0);
		depart = new Point(Instruction.largeurFenetre, 0);
	}
}

class HautGauche extends Instruction {

	public HautGauche() {
	}

	public void exec(ValueEnvironment env) throws Exception {
		arrivee = new Point(0, 0);
		depart = new Point(0, 0);
	}
}

class Milieu extends Instruction {

	public Milieu() {
	}

	public void exec(ValueEnvironment env) throws Exception {
		arrivee = new Point(Instruction.largeurFenetre / 2,
				Instruction.hauteurFenetre / 2);
		depart = new Point(Instruction.largeurFenetre / 2,
				Instruction.hauteurFenetre / 2);
	}
}

class Home extends Instruction {

	public Home() {
	}

	public void exec(ValueEnvironment env) throws Exception {
		arrivee = new Point(0, Instruction.hauteurFenetre);
		depart = new Point(0, Instruction.hauteurFenetre);
	}
}

class Ellipse extends Instruction {
	private Expression rX;
	private Expression rY;

	public Ellipse(Expression e1, Expression e2) {
		rX = e1;
		rY = e2;
	}

	public boolean maxCanvenas(Point d, int rayonX, int rayonY) {
		if (d.getX() - rayonX > largeurFenetre || d.getX() - rayonX < 0
				|| d.getX() + rayonX > largeurFenetre || d.getX() + rayonX < 0
				|| d.getY() - rayonY > hauteurFenetre || d.getY() - rayonY < 0
				|| d.getY() + rayonY > hauteurFenetre || d.getY() + rayonY < 0) {
			return false;
		}
		return true;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int rayonX = rX.eval(env);
		int rayonY = rY.eval(env);
		if (rayonX > 0) {
			if (rayonY > 0) {
				if (maxCanvenas(new Point(depart.getX(), depart.getY()),
						rayonX, rayonY)) {
					if (dessine && !canevas) {
						canevas = true;
					}
					q.add(new Ligne(new Point(arrivee.getX(), arrivee.getY()),
							new Point(depart.getX(), depart.getY()), dessine,
							epaisseur, trait, typeDeTrait, true, rayonX, rayonY));
				} else {
					throw new CurseurEnDehorsDuCanevas(new Point(
							arrivee.getX(), arrivee.getY()), "Ellipse");
				}
			} else {
				throw new EllipseNegativeOuNull(rayonY, "y");
			}
		} else {
			throw new EllipseNegativeOuNull(rayonX, "x");
		}
	}
}

class Cercle extends Instruction {
	private Expression exp;

	public Cercle(Expression e) {
		exp = e;
	}

	public boolean maxCanvenas(Point d, int rayon) {
		if (d.getX() - rayon > largeurFenetre || d.getX() - rayon < 0
				|| d.getX() + rayon > largeurFenetre || d.getX() + rayon < 0
				|| d.getY() - rayon > hauteurFenetre || d.getY() - rayon < 0
				|| d.getY() + rayon > hauteurFenetre || d.getY() + rayon < 0) {
			return false;
		}
		return true;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int tmp = exp.eval(env);
		if (tmp > 0) {
			if (maxCanvenas(new Point(depart.getX(), depart.getY()), tmp)) {
				if (dessine && !canevas) {
					canevas = true;
				}
				q.add(new Ligne(new Point(arrivee.getX(), arrivee.getY()),
						new Point(depart.getX(), depart.getY()), dessine,
						epaisseur, trait, typeDeTrait, true, tmp, tmp));
			} else {
				throw new CurseurEnDehorsDuCanevas(new Point(arrivee.getX(),
						arrivee.getY()), "Cercle");
			}
		} else {
			throw new CercleNegatifOuNull(tmp);
		}
	}
}

class TypeDeTrait extends Instruction {
	private Expression exp;

	public TypeDeTrait(Expression e) {
		exp = e;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int tmp = exp.eval(env);
		if (tmp >= 0) {
			typeDeTrait = tmp;
		} else {
			throw new TypeDeTraitNegatif(tmp);
		}
	}
}

class CouleurBackground extends Instruction {
	private Expression rougeBackground;
	private Expression vertBackground;
	private Expression bleuBackground;

	public CouleurBackground(Expression r, Expression v, Expression b) {
		rougeBackground = r;
		vertBackground = v;
		bleuBackground = b;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int r = rougeBackground.eval(env);
		int b = bleuBackground.eval(env);
		int v = vertBackground.eval(env);
		if (r > 255 || r < 0) {
			throw new CouleurImpossible(r, "rouge", "background");
		} else if (b > 255 || b < 0) {
			throw new CouleurImpossible(b, "bleu", "background");
		} else if (v > 255 || v < 0) {
			throw new CouleurImpossible(v, "vert", "background");
		} else {
			queueBackground.add(new Couleur(r, v, b));
		}
	}
}

class CouleurTrait extends Instruction {
	private Expression rougeTrait;
	private Expression vertTrait;
	private Expression bleuTrait;

	public CouleurTrait(Expression r, Expression v, Expression b) {
		rougeTrait = r;
		vertTrait = v;
		bleuTrait = b;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int r = rougeTrait.eval(env);
		int b = bleuTrait.eval(env);
		int v = vertTrait.eval(env);
		if (r > 255 || r < 0) {
			throw new CouleurImpossible(r, "rouge", "trait");
		} else if (b > 255 || b < 0) {
			throw new CouleurImpossible(b, "bleu", "trait");
		} else if (v > 255 || v < 0) {
			throw new CouleurImpossible(v, "vert", "trait");
		} else {
			trait = new Couleur(r, v, b);
		}
	}
}

class Epaisseur extends Instruction {
	private Expression exp;

	public Epaisseur(Expression e) {
		exp = e;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int tmp = exp.eval(env);
		if (tmp >= 1) {
			epaisseur = tmp;
		} else {
			throw new EpaisseurNonVisible(tmp);
		}
	}
}

class TantQue extends Instruction {

	private Expression expression;
	private Instruction instruction;

	public TantQue(Expression e, Instruction i) {
		expression = e;
		instruction = i;
	}

	public void exec(ValueEnvironment env) throws Exception {
		while (expression.eval(env) != 0) {
			instruction.exec(env);
		}
	}
}

class Si extends Instruction {

	private Expression expression;
	private Instruction siAlors;
	private Instruction sinon;

	public Si(Expression e, Instruction si, Instruction sino) {
		expression = e;
		siAlors = si;
		sinon = sino;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int n = expression.eval(env);
		if (n == 0) {
			siAlors.exec(env);
		} else if (sinon != null) {
			sinon.exec(env);
		}

	}
}

class Bloc extends Instruction {

	private Instruction instruction;
	private Instruction bloc;

	public Bloc(Instruction i, Instruction b) {
		instruction = i;
		bloc = b;
	}

	public void exec(ValueEnvironment env) throws Exception {
		for (int i = 0; i < 1; i++) {
			instruction.exec(env);
			if (bloc == null) {
				break;
			}
			bloc.exec(env);
		}
	}
}

class Avance extends Instruction {
	private Expression exp;

	public Avance(Expression e) {
		exp = e;
	}

	public boolean maxCanvenas(Point d, Point a) {
		if (d.getX() > largeurFenetre || d.getX() < 0 || a.getY() < 0
				|| a.getY() > hauteurFenetre) {
			return false;
		}
		return true;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int tmp = exp.eval(env);
		arrivee.setX(depart.getX()
				+ (int) (Math.cos(Math.toRadians(direction + 90)) * tmp));
		arrivee.setY(depart.getY()
				- (int) (Math.sin(Math.toRadians(direction + 90)) * tmp));
		if (maxCanvenas(new Point(depart.getX(), depart.getY()), new Point(
				arrivee.getX(), arrivee.getY()))) {
			if (dessine && !canevas) {
				canevas = true;
			}
			q.add(new Ligne(new Point(arrivee.getX(), arrivee.getY()),
					new Point(depart.getX(), depart.getY()), dessine,
					epaisseur, trait, typeDeTrait, false, 0, 0));
		} else {
			throw new CurseurEnDehorsDuCanevas(new Point(arrivee.getX(),
					arrivee.getY()), "Ligne");

		}
		depart = new Point(arrivee.getX(), arrivee.getY());
	}
}

class Tourne extends Instruction {
	private Expression exp;

	public Tourne(Expression e) {
		exp = e;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int tmp = exp.eval(env);
		direction += tmp;
		if (direction >= 360) {
			while (direction - 360 >= 0) {
				direction -= 360;
			}
		}
		if (direction < 0) {
			while (direction < 0) {
				direction += 360;
			}
		}
	}
}

class Haut extends Instruction {

	public void exec(ValueEnvironment env) throws Exception {
		dessine = false;
	}
}

class Bas extends Instruction {
	public void exec(ValueEnvironment env) throws Exception {
		dessine = true;
	}
}

class Assignment extends Instruction {
	private String varName;
	private Expression exp;

	public Assignment(String s, Expression e) {
		varName = s;
		exp = e;
	}

	public void exec(ValueEnvironment env) throws Exception {
		int tmp = exp.eval(env);
		env.setVariable(varName, tmp);
	}
}

class ValueEnvironment extends HashMap<String, Integer> {

	public ValueEnvironment() {
		super();
	}

	public void addVariable(String name) throws Exception {
		if (this.containsKey(name)) {
			throw new VariableDefinitDeuxFois(name);
		}
		this.put(name, null);
	}

	public void setVariable(String name, int value) throws Exception {
		if (!this.containsKey(name)) {
			throw new VariableNonDefinit(name);
		}
		this.put(name, new Integer(value));
	}

	public int getValue(String name) throws Exception {
		if (!this.containsKey(name)) {
			throw new VariableNonDefinit(name);
		}
		Integer value = this.get(name);
		if (value == null) {
			throw new VariableNoInitialisee(name);
		}
		return value;
	}
}
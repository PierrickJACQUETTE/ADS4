class LexerException extends Exception {
	public LexerException(int line, int column) {
		super("Caractere inattendu à la ligne " + line + " column " + column
				+ ".");
	}
}

class ParserException extends Exception {
	public ParserException(String s) {
		super("'" + s + "' not expected.");
	}
}

class VariableNonDefinit extends Exception {
	public VariableNonDefinit(String nom) {
		super(" La variable du nom : " + nom + " n'est pas definit.");
	}
}

class VariableNoInitialisee extends Exception {
	public VariableNoInitialisee(String nom) {
		super("La variable du nom : " + nom + " n'est pas initialisée.");
	}
}

class VariableDefinitDeuxFois extends Exception {
	public VariableDefinitDeuxFois(String nom) {
		super("La variable du nom : " + nom + " est definie deux fois.");
	}
}

class DivisionParZero extends Exception {
	public DivisionParZero(int gauche, int droite) {
		super("La division : " + gauche + " par " + droite + " est impossible.");
	}
}

class NonMultipleDe90DansTourne extends Exception {
	public NonMultipleDe90DansTourne(int non90) {
		super(non90 + " n'est pas un multiple de 90.");
	}
}

class CurseurEnDehorsDuCanevas extends Exception {
	public CurseurEnDehorsDuCanevas(Point a, String quoi) {
		super("Le curseur sort du canevas pendant l'avancé au point ("
				+ a.getX() + "," + a.getY() + ") pendant le dessin d'un(e) "
				+ quoi);
	}
}

class EpaisseurNonVisible extends Exception {
	public EpaisseurNonVisible(int a) {
		super("L'épaisseur du trait du dessin est invisible, elle vaut : " + a
				+ ".");
	}
}

class CouleurImpossible extends Exception {
	public CouleurImpossible(int a, String name, String quoi) {
		super("Lors de la modification de la couleur du " + quoi
				+ " de l'entier : " + name + " qui vaut : " + a
				+ ", ce qui est impossible il doit être entre 0 et 255.");
	}
}

class TypeDeTraitNegatif extends Exception {
	public TypeDeTraitNegatif(int a) {
		super("Le type de trait voulu vaut : " + a
				+ ", ce qui est impossible car il est invisible.");
	}
}

class CercleNegatifOuNull extends Exception {
	public CercleNegatifOuNull(int a) {
		super("Le cercle que l'on veut tracer est invisible, il est de rayon: "
				+ a + ".");
	}
}

class EllipseNegativeOuNull extends Exception {
	public EllipseNegativeOuNull(int a, String name) {
		super("L'ellipse que l'on veut tracer est invisible, le rayon " + name
				+ "a comme valeur : " + a + ".");
	}
}
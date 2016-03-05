class Parser {

	/*
	 * programme -> declarations instruction
	 * 
	 * declarations -> Var identificateur ; declarations | e
	 * 
	 * instruction -> Avance expression | Tourne expression | BasPinceau |
	 * HautPinceau | identificateur = expression | Debut blocInstruction Fin |
	 * Si test | Tant que boucle | Epaisseur expression | CouleurTrait
	 * expression expression expression | CouleurFond expression expression
	 * expression | TypeDeTrait expression | Cercle expression | Ellipse
	 * expression expression | Home | Milieu | HautGauche | HautDroit | BasDroit
	 * 
	 * blocInstruction -> instruction ; blocInstruction | e
	 * 
	 * test -> expression Alors instruction Sinon instruction | expression Alors
	 * instruction
	 * 
	 * boucle -> expression Faire instruction
	 * 
	 * expression -> nombre expressionSuite | identificateur expressionSuite |
	 * (expression ) expressionSuite
	 * 
	 * expressionSuite -> + expression | - expression | * expression | /
	 * expression | e
	 */

	protected LookAhead1 reader;

	public Parser(LookAhead1 r) {
		reader = r;
	}

	public Programme nontermGrammaire() throws Exception {
		Programme prog = nontermProg();
		reader.eat(Sym.EOF);
		return prog;
	}

	public Programme nontermProg() throws Exception {
		if (reader.check(Sym.VAR) || reader.check(Sym.AVANCE)
				|| reader.check(Sym.TOURNE) || reader.check(Sym.BASPINCEAU)
				|| reader.check(Sym.HAUTPINCEAU)
				|| reader.check(Sym.IDENTIFICATEUR) || reader.check(Sym.DEBUT)
				|| reader.check(Sym.EOF) || reader.check(Sym.SI)
				|| reader.check(Sym.TANTQUE) || reader.check(Sym.EPAISSEUR)
				|| reader.check(Sym.COULEURTRAIT)
				|| reader.check(Sym.COULEURFOND)
				|| reader.check(Sym.TYPEDETRAIT) || reader.check(Sym.CERCLE)
				|| reader.check(Sym.ELLIPSE) || reader.check(Sym.HOME)
				|| reader.check(Sym.MILIEU) || reader.check(Sym.HAUTGAUCHE)
				|| reader.check(Sym.HAUTDROIT) || reader.check(Sym.BASDROIT)) {
			Declaration d = nontermDeclaration();
			Instruction i = nontermInstruction();
			return new Programme(i, d);
		} else {
			throw new ParserException(reader.getString());
		}
	}

	public Declaration nontermDeclaration() throws Exception {
		Declaration d = null;
		if (reader.check(Sym.VAR)) {
			reader.eat(Sym.VAR);
			String tmp = reader.getStringValue();

			reader.eat(Sym.IDENTIFICATEUR);
			reader.eat(Sym.POINTVIRGULE);
			d = new Declaration(tmp, nontermDeclaration());

		} else if (reader.check(Sym.EOF)) {
			d = new Declaration(null, null);
		}
		return d;
	}

	public Instruction nontermInstruction() throws Exception {
		Instruction i = null;
		if (reader.check(Sym.AVANCE)) {
			reader.eat(Sym.AVANCE);
			i = new Avance(nontermExpression());
		} else if (reader.check(Sym.TOURNE)) {
			reader.eat(Sym.TOURNE);
			i = new Tourne(nontermExpression());
		} else if (reader.check(Sym.BASPINCEAU)) {
			reader.eat(Sym.BASPINCEAU);
			i = new Bas();
		} else if (reader.check(Sym.HAUTPINCEAU)) {
			reader.eat(Sym.HAUTPINCEAU);
			i = new Haut();
		} else if (reader.check(Sym.IDENTIFICATEUR)) {
			String nom = reader.getStringValue();
			reader.eat(Sym.IDENTIFICATEUR);
			reader.eat(Sym.EQ);
			i = new Assignment(nom, nontermExpression());
		} else if (reader.check(Sym.DEBUT)) {
			reader.eat(Sym.DEBUT);
			i = nontermBlocInstruction();
			reader.eat(Sym.FIN);
		} else if (reader.check(Sym.SI)) {
			reader.eat(Sym.SI);
			i = nontermSi();
		} else if (reader.check(Sym.TANTQUE)) {
			reader.eat(Sym.TANTQUE);
			i = nontermWhile();
		} else if (reader.check(Sym.EPAISSEUR)) {
			reader.eat(Sym.EPAISSEUR);
			i = new Epaisseur(nontermExpression());
		} else if (reader.check(Sym.COULEURTRAIT)) {
			reader.eat(Sym.COULEURTRAIT);
			Expression red = nontermExpression();
			Expression green = nontermExpression();
			Expression blue = nontermExpression();
			i = new CouleurTrait(red, green, blue);
		} else if (reader.check(Sym.COULEURFOND)) {
			reader.eat(Sym.COULEURFOND);
			Expression red = nontermExpression();
			Expression green = nontermExpression();
			Expression blue = nontermExpression();
			i = new CouleurBackground(red, green, blue);
		} else if (reader.check(Sym.TYPEDETRAIT)) {
			reader.eat(Sym.TYPEDETRAIT);
			i = new TypeDeTrait(nontermExpression());
		} else if (reader.check(Sym.CERCLE)) {
			reader.eat(Sym.CERCLE);
			i = new Cercle(nontermExpression());
		} else if (reader.check(Sym.ELLIPSE)) {
			reader.eat(Sym.ELLIPSE);
			Expression e1 = nontermExpression();
			Expression e2 = nontermExpression();
			i = new Ellipse(e1, e2);
		} else if (reader.check(Sym.HOME)) {
			reader.eat(Sym.HOME);
			i = new Home();
		} else if (reader.check(Sym.MILIEU)) {
			reader.eat(Sym.MILIEU);
			i = new Milieu();
		} else if (reader.check(Sym.HAUTGAUCHE)) {
			reader.eat(Sym.HAUTGAUCHE);
			i = new HautGauche();
		} else if (reader.check(Sym.HAUTDROIT)) {
			reader.eat(Sym.HAUTDROIT);
			i = new HautDroit();
		} else if (reader.check(Sym.BASDROIT)) {
			reader.eat(Sym.BASDROIT);
			i = new BasDroit();
		}
		return i;
	}

	public Instruction nontermSi() throws Exception {
		Expression e = nontermExpression();
		reader.eat(Sym.ALORS);
		Instruction i1 = nontermInstruction();
		Instruction i2;
		if (reader.check(Sym.SINON)) {
			reader.eat(Sym.SINON);
			i2 = nontermInstruction();

		} else {
			i2 = null;
		}
		return new Si(e, i1, i2);
	}

	public Instruction nontermWhile() throws Exception {
		Expression e = nontermExpression();
		reader.eat(Sym.FAIRE);
		Instruction i1 = nontermInstruction();
		Instruction i = new TantQue(e, i1);
		return i;
	}

	public Instruction nontermBlocInstruction() throws Exception {
		Instruction i = null;
		if (reader.check(Sym.AVANCE) || reader.check(Sym.TOURNE)
				|| reader.check(Sym.BASPINCEAU)
				|| reader.check(Sym.HAUTPINCEAU)
				|| reader.check(Sym.IDENTIFICATEUR) || reader.check(Sym.DEBUT)
				|| reader.check(Sym.SI) || reader.check(Sym.TANTQUE)
				|| reader.check(Sym.EPAISSEUR)
				|| reader.check(Sym.COULEURTRAIT)
				|| reader.check(Sym.COULEURFOND)
				|| reader.check(Sym.TYPEDETRAIT) || reader.check(Sym.CERCLE)
				|| reader.check(Sym.ELLIPSE) || reader.check(Sym.HOME)
				|| reader.check(Sym.MILIEU) || reader.check(Sym.HAUTGAUCHE)
				|| reader.check(Sym.HAUTDROIT) || reader.check(Sym.BASDROIT)) {
			Instruction tmp = nontermInstruction();
			reader.eat(Sym.POINTVIRGULE);
			i = new Bloc(tmp, nontermBlocInstruction());
		} else if (reader.check(Sym.EOF)) {
			return null;
		}
		return i;
	}

	public Expression nontermExpression() throws Exception {
		Expression e = null;
		Expression eTmp = null;
		if (reader.check(Sym.NOMBRE)) {
			eTmp = new Int(reader.getIntValue());
			reader.eat(Sym.NOMBRE);
			e = nontermExpressionSuite(eTmp);
		} else if (reader.check(Sym.IDENTIFICATEUR)) {
			eTmp = new Var(reader.getStringValue());
			reader.eat(Sym.IDENTIFICATEUR);
			e = nontermExpressionSuite(eTmp);
		} else if (reader.check(Sym.PAROUVRANTE)) {
			reader.eat(Sym.PAROUVRANTE);
			eTmp = nontermExpression();
			reader.eat(Sym.PARFERMANTE);
			e = nontermExpressionSuite(eTmp);
		}
		return e;
	}

	public Expression nontermExpressionSuite(Expression e) throws Exception {
		if (reader.check(Sym.PLUS)) {
			reader.eat(Sym.PLUS);
			return new Sum(e, nontermExpression());
		} else if (reader.check(Sym.MINUS)) {
			reader.eat(Sym.MINUS);
			return new Difference(e, nontermExpression());
		} else if (reader.check(Sym.MUTL)) {
			reader.eat(Sym.MUTL);
			return new Product(e, nontermExpression());
		} else if (reader.check(Sym.DIV)) {
			reader.eat(Sym.DIV);
			return new Division(e, nontermExpression());
		} else {
			return e;
		}
	}
}

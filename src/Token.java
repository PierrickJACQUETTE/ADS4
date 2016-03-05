class Token {
	protected Sym symbol;

	public Token(Sym s) {
		symbol = s;
	}

	public Sym symbol() {
		return symbol;
	}

	public String toString() {
		return "Symbol : " + this.symbol;
	}
}

class IntToken extends Token {
	private int value;

	public IntToken(Sym s, int v) {
		super(s);
		value = v;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return "Symbol : " + this.symbol + " | Value : " + this.value;
	}
}

class VarToken extends Token {
	private String value;

	public VarToken(Sym s, String v) {
		super(s);
		value = v;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return "Symbol : " + this.symbol + " | Value : " + this.value;
	}
}

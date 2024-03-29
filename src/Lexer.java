/* The following code was generated by JFlex 1.4.3 on 04/05/15 19:28 */

/**
 * This class is a scanner generated by <a href="http://www.jflex.de/">JFlex</a>
 * 1.4.3 on 04/05/15 19:28 from the specification file <tt>image.flex</tt>
 */
public class Lexer {

	/** This character denotes the end of file */
	public static final int YYEOF = -1;

	/** initial size of the lookahead buffer */
	private static final int ZZ_BUFFERSIZE = 16384;

	/** lexical states */
	public static final int YYINITIAL = 0;

	/**
	 * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
	 * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l at the
	 * beginning of a line l is of the form l = 2*k, k a non negative integer
	 */
	private static final int ZZ_LEXSTATE[] = { 0, 0 };

	/**
	 * Translates characters to character classes
	 */
	private static final String ZZ_CMAP_PACKED = "\11\0\1\1\1\1\2\0\1\1\22\0\1\2\7\0\1\55\1\56"
			+ "\1\53\1\51\1\0\1\52\1\0\1\54\1\6\11\5\1\0\1\47"
			+ "\1\0\1\50\3\0\1\7\1\21\1\27\1\22\1\34\1\30\1\37"
			+ "\1\36\4\4\1\42\2\4\1\25\2\4\1\43\1\32\1\4\1\46"
			+ "\4\4\6\0\1\15\1\33\1\17\1\31\1\20\2\3\1\40\1\23"
			+ "\2\3\1\10\1\41\1\16\1\11\1\35\1\44\1\12\1\13\1\24"
			+ "\1\26\1\14\2\3\1\45\1\3\uff85\0";

	/**
	 * Translates characters to character classes
	 */
	private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

	/**
	 * Translates DFA states to action switch labels.
	 */
	private static final int[] ZZ_ACTION = zzUnpackAction();

	private static final String ZZ_ACTION_PACKED_0 = "\1\0\1\1\1\2\1\3\2\4\13\1\1\5\1\6"
			+ "\1\7\1\10\1\11\1\12\1\13\1\14\20\0\1\15"
			+ "\10\0\1\16\11\0\1\17\15\0\1\20\3\0\1\21"
			+ "\3\0\1\22\2\0\1\23\11\0\1\24\1\25\3\0"
			+ "\1\26\1\27\7\0\1\30\5\0\1\31\4\0\1\32"
			+ "\3\0\1\33\11\0\1\34\1\35\2\0\1\36\4\0"
			+ "\1\37\1\40\1\0\1\41\1\42\1\43";

	private static int[] zzUnpackAction() {
		int[] result = new int[149];
		int offset = 0;
		offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackAction(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int count = packed.charAt(i++);
			int value = packed.charAt(i++);
			do
				result[j++] = value;
			while (--count > 0);
		}
		return j;
	}

	/**
	 * Translates a state to a row index in the transition table
	 */
	private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

	private static final String ZZ_ROWMAP_PACKED_0 = "\0\0\0\57\0\57\0\136\0\215\0\57\0\274\0\353"
			+ "\0\u011a\0\u0149\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263"
			+ "\0\u0292\0\57\0\57\0\57\0\57\0\57\0\57\0\57"
			+ "\0\57\0\u02c1\0\u02f0\0\u031f\0\u034e\0\u037d\0\u03ac\0\u03db"
			+ "\0\u040a\0\u0439\0\u0468\0\u0497\0\u04c6\0\u04f5\0\u0524\0\u0553"
			+ "\0\u0582\0\u05b1\0\u05e0\0\u060f\0\u063e\0\u066d\0\u069c\0\u06cb"
			+ "\0\u06fa\0\u0729\0\57\0\u0758\0\u0787\0\u07b6\0\u07e5\0\u0814"
			+ "\0\u0843\0\u0872\0\u08a1\0\u08d0\0\57\0\u08ff\0\u092e\0\u095d"
			+ "\0\u098c\0\u09bb\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5"
			+ "\0\u0b04\0\u0b33\0\57\0\u0b62\0\u0b91\0\u0bc0\0\57\0\u0bef"
			+ "\0\u0c1e\0\u0c4d\0\57\0\u0c7c\0\u0cab\0\57\0\u0cda\0\u0d09"
			+ "\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\u0df4\0\u0e23\0\u0e52\0\57"
			+ "\0\57\0\u0e81\0\u0eb0\0\u0edf\0\57\0\57\0\u0f0e\0\u0f3d"
			+ "\0\u0f6c\0\u0f9b\0\u0fca\0\u0ff9\0\u1028\0\57\0\u1057\0\u1086"
			+ "\0\u10b5\0\u10e4\0\u1113\0\57\0\u1142\0\u1171\0\u11a0\0\u11cf"
			+ "\0\57\0\u11fe\0\u122d\0\u125c\0\57\0\u128b\0\u12ba\0\u12e9"
			+ "\0\u1318\0\u1347\0\u1376\0\u13a5\0\u13d4\0\u1403\0\57\0\57"
			+ "\0\u1432\0\u1461\0\57\0\u1490\0\u14bf\0\u14ee\0\u151d\0\57"
			+ "\0\57\0\u154c\0\57\0\57\0\57";

	private static int[] zzUnpackRowMap() {
		int[] result = new int[149];
		int offset = 0;
		offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackRowMap(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int high = packed.charAt(i++) << 16;
			result[j++] = high | packed.charAt(i++);
		}
		return j;
	}

	/**
	 * The transition table of the DFA
	 */
	private static final int[] ZZ_TRANS = zzUnpackTrans();

	private static final String ZZ_TRANS_PACKED_0 = "\1\2\2\3\1\4\1\2\1\5\1\6\1\7\11\4"
			+ "\1\10\1\11\2\4\1\2\1\4\1\12\1\13\1\4"
			+ "\1\14\1\4\1\15\1\4\1\16\1\2\2\4\1\17"
			+ "\1\20\2\4\1\21\1\22\1\23\1\24\1\25\1\26"
			+ "\1\27\1\30\1\31\62\0\44\4\15\0\2\5\60\0"
			+ "\1\32\3\0\1\33\57\0\1\34\61\0\1\35\47\0"
			+ "\1\36\6\0\1\37\53\0\1\40\5\0\1\41\44\0"
			+ "\1\42\3\0\1\43\27\0\1\44\21\0\1\45\24\0"
			+ "\1\46\32\0\1\47\3\0\1\50\64\0\1\51\56\0"
			+ "\1\52\50\0\1\53\52\0\1\54\62\0\1\55\54\0"
			+ "\1\56\76\0\1\57\51\0\1\60\42\0\1\61\67\0"
			+ "\1\62\51\0\1\63\66\0\1\64\46\0\1\65\75\0"
			+ "\1\66\31\0\1\67\63\0\1\70\102\0\1\71\43\0"
			+ "\1\72\40\0\1\73\64\0\1\74\52\0\1\75\56\0"
			+ "\1\76\62\0\1\77\62\0\1\100\2\0\1\101\57\0"
			+ "\1\102\40\0\1\103\65\0\1\104\51\0\1\105\56\0"
			+ "\1\106\70\0\1\107\52\0\1\110\61\0\1\111\56\0"
			+ "\1\112\53\0\1\113\62\0\1\114\55\0\1\115\44\0"
			+ "\1\116\60\0\1\117\62\0\1\120\51\0\1\121\67\0"
			+ "\1\122\57\0\1\123\52\0\1\124\46\0\1\125\66\0"
			+ "\1\126\54\0\1\127\42\0\1\130\76\0\1\131\71\0"
			+ "\1\132\34\0\1\133\65\0\1\134\2\0\1\135\11\0"
			+ "\1\136\37\0\1\137\54\0\1\140\60\0\1\141\47\0"
			+ "\1\142\63\0\1\143\66\0\1\144\50\0\1\145\56\0"
			+ "\1\146\102\0\1\147\32\0\1\150\51\0\1\151\56\0"
			+ "\1\152\55\0\1\153\67\0\1\154\50\0\1\155\67\0"
			+ "\1\156\53\0\1\157\52\0\1\160\51\0\1\161\72\0"
			+ "\1\162\62\0\1\163\44\0\1\164\56\0\1\165\47\0"
			+ "\1\166\63\0\1\167\66\0\1\170\54\0\1\171\52\0"
			+ "\1\172\66\0\1\173\1\0\1\174\44\0\1\175\50\0"
			+ "\1\176\72\0\1\177\53\0\1\200\52\0\1\201\56\0"
			+ "\1\202\54\0\1\203\52\0\1\204\57\0\1\205\61\0"
			+ "\1\206\53\0\1\207\70\0\1\210\52\0\1\211\76\0"
			+ "\1\212\44\0\1\213\46\0\1\214\55\0\1\215\64\0"
			+ "\1\216\50\0\1\217\61\0\1\220\67\0\1\221\50\0"
			+ "\1\222\57\0\1\223\60\0\1\224\54\0\1\225\32\0";

	private static int[] zzUnpackTrans() {
		int[] result = new int[5499];
		int offset = 0;
		offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackTrans(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int count = packed.charAt(i++);
			int value = packed.charAt(i++);
			value--;
			do
				result[j++] = value;
			while (--count > 0);
		}
		return j;
	}

	/* error codes */
	private static final int ZZ_UNKNOWN_ERROR = 0;
	private static final int ZZ_NO_MATCH = 1;
	private static final int ZZ_PUSHBACK_2BIG = 2;

	/* error messages for the codes above */
	private static final String ZZ_ERROR_MSG[] = {
			"Unkown internal scanner error", "Error: could not match input",
			"Error: pushback value was too large" };

	/**
	 * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
	 */
	private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

	private static final String ZZ_ATTRIBUTE_PACKED_0 = "\1\0\2\11\2\1\1\11\13\1\10\11\20\0\1\1"
			+ "\10\0\1\11\11\0\1\11\15\0\1\11\3\0\1\11"
			+ "\3\0\1\11\2\0\1\11\11\0\2\11\3\0\2\11"
			+ "\7\0\1\11\5\0\1\11\4\0\1\11\3\0\1\11"
			+ "\11\0\2\11\2\0\1\11\4\0\2\11\1\0\3\11";

	private static int[] zzUnpackAttribute() {
		int[] result = new int[149];
		int offset = 0;
		offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackAttribute(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int count = packed.charAt(i++);
			int value = packed.charAt(i++);
			do
				result[j++] = value;
			while (--count > 0);
		}
		return j;
	}

	/** the input device */
	private java.io.Reader zzReader;

	/** the current state of the DFA */
	private int zzState;

	/** the current lexical state */
	private int zzLexicalState = YYINITIAL;

	/**
	 * this buffer contains the current text to be matched and is the source of
	 * the yytext() string
	 */
	private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

	/** the textposition at the last accepting state */
	private int zzMarkedPos;

	/** the current text position in the buffer */
	private int zzCurrentPos;

	/** startRead marks the beginning of the yytext() string in the buffer */
	private int zzStartRead;

	/**
	 * endRead marks the last character in the buffer, that has been read from
	 * input
	 */
	private int zzEndRead;

	/** number of newlines encountered up to the start of the matched text */
	private int yyline;

	/** the number of characters up to the start of the matched text */
	private int yychar;

	/**
	 * the number of characters from the last newline up to the start of the
	 * matched text
	 */
	private int yycolumn;

	/**
	 * zzAtBOL == true <=> the scanner is currently at the beginning of a line
	 */
	private boolean zzAtBOL = true;

	/** zzAtEOF == true <=> the scanner is at the EOF */
	private boolean zzAtEOF;

	/** denotes if the user-EOF-code has already been executed */
	private boolean zzEOFDone;

	/* user code: */

	/**
	 * Creates a new scanner There is also a java.io.InputStream version of this
	 * constructor.
	 * 
	 * @param in
	 *            the java.io.Reader to read input from.
	 */
	public Lexer(java.io.Reader in) {
		this.zzReader = in;
	}

	/**
	 * Creates a new scanner. There is also java.io.Reader version of this
	 * constructor.
	 * 
	 * @param in
	 *            the java.io.Inputstream to read input from.
	 */
	public Lexer(java.io.InputStream in) {
		this(new java.io.InputStreamReader(in));
	}

	/**
	 * Unpacks the compressed character translation table.
	 * 
	 * @param packed
	 *            the packed character translation table
	 * @return the unpacked character translation table
	 */
	private static char[] zzUnpackCMap(String packed) {
		char[] map = new char[0x10000];
		int i = 0; /* index in packed string */
		int j = 0; /* index in unpacked array */
		while (i < 132) {
			int count = packed.charAt(i++);
			char value = packed.charAt(i++);
			do
				map[j++] = value;
			while (--count > 0);
		}
		return map;
	}

	/**
	 * Refills the input buffer.
	 * 
	 * @return <code>false</code>, iff there was new input.
	 * 
	 * @exception java.io.IOException
	 *                if any I/O-Error occurs
	 */
	private boolean zzRefill() throws java.io.IOException {

		/* first: make room (if you can) */
		if (zzStartRead > 0) {
			System.arraycopy(zzBuffer, zzStartRead, zzBuffer, 0, zzEndRead
					- zzStartRead);

			/* translate stored positions */
			zzEndRead -= zzStartRead;
			zzCurrentPos -= zzStartRead;
			zzMarkedPos -= zzStartRead;
			zzStartRead = 0;
		}

		/* is the buffer big enough? */
		if (zzCurrentPos >= zzBuffer.length) {
			/* if not: blow it up */
			char newBuffer[] = new char[zzCurrentPos * 2];
			System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
			zzBuffer = newBuffer;
		}

		/* finally: fill the buffer with new input */
		int numRead = zzReader.read(zzBuffer, zzEndRead, zzBuffer.length
				- zzEndRead);

		if (numRead > 0) {
			zzEndRead += numRead;
			return false;
		}
		// unlikely but not impossible: read 0 characters, but not at end of
		// stream
		if (numRead == 0) {
			int c = zzReader.read();
			if (c == -1) {
				return true;
			} else {
				zzBuffer[zzEndRead++] = (char) c;
				return false;
			}
		}

		// numRead < 0
		return true;
	}

	/**
	 * Closes the input stream.
	 */
	public final void yyclose() throws java.io.IOException {
		zzAtEOF = true; /* indicate end of file */
		zzEndRead = zzStartRead; /* invalidate buffer */

		if (zzReader != null)
			zzReader.close();
	}

	/**
	 * Resets the scanner to read from a new input stream. Does not close the
	 * old reader.
	 * 
	 * All internal variables are reset, the old input stream <b>cannot</b> be
	 * reused (internal buffer is discarded and lost). Lexical state is set to
	 * <tt>ZZ_INITIAL</tt>.
	 * 
	 * @param reader
	 *            the new input stream
	 */
	public final void yyreset(java.io.Reader reader) {
		zzReader = reader;
		zzAtBOL = true;
		zzAtEOF = false;
		zzEOFDone = false;
		zzEndRead = zzStartRead = 0;
		zzCurrentPos = zzMarkedPos = 0;
		yyline = yychar = yycolumn = 0;
		zzLexicalState = YYINITIAL;
	}

	/**
	 * Returns the current lexical state.
	 */
	public final int yystate() {
		return zzLexicalState;
	}

	/**
	 * Enters a new lexical state
	 * 
	 * @param newState
	 *            the new lexical state
	 */
	public final void yybegin(int newState) {
		zzLexicalState = newState;
	}

	/**
	 * Returns the text matched by the current regular expression.
	 */
	public final String yytext() {
		return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
	}

	/**
	 * Returns the character at position <tt>pos</tt> from the matched text.
	 * 
	 * It is equivalent to yytext().charAt(pos), but faster
	 * 
	 * @param pos
	 *            the position of the character to fetch. A value from 0 to
	 *            yylength()-1.
	 * 
	 * @return the character at position pos
	 */
	public final char yycharat(int pos) {
		return zzBuffer[zzStartRead + pos];
	}

	/**
	 * Returns the length of the matched text region.
	 */
	public final int yylength() {
		return zzMarkedPos - zzStartRead;
	}

	/**
	 * Reports an error that occured while scanning.
	 * 
	 * In a wellformed scanner (no or only correct usage of yypushback(int) and
	 * a match-all fallback rule) this method will only be called with things
	 * that "Can't Possibly Happen". If this method is called, something is
	 * seriously wrong (e.g. a JFlex bug producing a faulty scanner etc.).
	 * 
	 * Usual syntax/scanner level error handling should be done in error
	 * fallback rules.
	 * 
	 * @param errorCode
	 *            the code of the errormessage to display
	 */
	private void zzScanError(int errorCode) {
		String message;
		try {
			message = ZZ_ERROR_MSG[errorCode];
		} catch (ArrayIndexOutOfBoundsException e) {
			message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
		}

		throw new Error(message);
	}

	/**
	 * Pushes the specified amount of characters back into the input stream.
	 * 
	 * They will be read again by then next call of the scanning method
	 * 
	 * @param number
	 *            the number of characters to be read again. This number must
	 *            not be greater than yylength()!
	 */
	public void yypushback(int number) {
		if (number > yylength())
			zzScanError(ZZ_PUSHBACK_2BIG);

		zzMarkedPos -= number;
	}

	/**
	 * Resumes scanning until the next regular expression is matched, the end of
	 * input is encountered or an I/O-Error occurs.
	 * 
	 * @return the next token
	 * @exception java.io.IOException
	 *                if any I/O-Error occurs
	 */
	public Token yylex() throws java.io.IOException, LexerException {
		int zzInput;
		int zzAction;

		// cached fields:
		int zzCurrentPosL;
		int zzMarkedPosL;
		int zzEndReadL = zzEndRead;
		char[] zzBufferL = zzBuffer;
		char[] zzCMapL = ZZ_CMAP;

		int[] zzTransL = ZZ_TRANS;
		int[] zzRowMapL = ZZ_ROWMAP;
		int[] zzAttrL = ZZ_ATTRIBUTE;

		while (true) {
			zzMarkedPosL = zzMarkedPos;

			boolean zzR = false;
			for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL; zzCurrentPosL++) {
				switch (zzBufferL[zzCurrentPosL]) {
				case '\u000B':
				case '\u000C':
				case '\u0085':
				case '\u2028':
				case '\u2029':
					yyline++;
					yycolumn = 0;
					zzR = false;
					break;
				case '\r':
					yyline++;
					yycolumn = 0;
					zzR = true;
					break;
				case '\n':
					if (zzR)
						zzR = false;
					else {
						yyline++;
						yycolumn = 0;
					}
					break;
				default:
					zzR = false;
					yycolumn++;
				}
			}

			if (zzR) {
				// peek one character ahead if it is \n (if we have counted one
				// line too much)
				boolean zzPeek;
				if (zzMarkedPosL < zzEndReadL)
					zzPeek = zzBufferL[zzMarkedPosL] == '\n';
				else if (zzAtEOF)
					zzPeek = false;
				else {
					boolean eof = zzRefill();
					zzEndReadL = zzEndRead;
					zzMarkedPosL = zzMarkedPos;
					zzBufferL = zzBuffer;
					if (eof)
						zzPeek = false;
					else
						zzPeek = zzBufferL[zzMarkedPosL] == '\n';
				}
				if (zzPeek)
					yyline--;
			}
			zzAction = -1;

			zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

			zzState = ZZ_LEXSTATE[zzLexicalState];

			zzForAction: {
				while (true) {

					if (zzCurrentPosL < zzEndReadL)
						zzInput = zzBufferL[zzCurrentPosL++];
					else if (zzAtEOF) {
						zzInput = YYEOF;
						break zzForAction;
					} else {
						// store back cached positions
						zzCurrentPos = zzCurrentPosL;
						zzMarkedPos = zzMarkedPosL;
						boolean eof = zzRefill();
						// get translated positions and possibly new buffer
						zzCurrentPosL = zzCurrentPos;
						zzMarkedPosL = zzMarkedPos;
						zzBufferL = zzBuffer;
						zzEndReadL = zzEndRead;
						if (eof) {
							zzInput = YYEOF;
							break zzForAction;
						} else {
							zzInput = zzBufferL[zzCurrentPosL++];
						}
					}
					int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
					if (zzNext == -1)
						break zzForAction;
					zzState = zzNext;

					int zzAttributes = zzAttrL[zzState];
					if ((zzAttributes & 1) == 1) {
						zzAction = zzState;
						zzMarkedPosL = zzCurrentPosL;
						if ((zzAttributes & 8) == 8)
							break zzForAction;
					}

				}
			}

			// store back cached position
			zzMarkedPos = zzMarkedPosL;

			switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
			case 3: {
				return new VarToken(Sym.IDENTIFICATEUR, yytext());
			}
			case 36:
				break;
			case 34: {
				return new Token(Sym.HAUTPINCEAU);
			}
			case 37:
				break;
			case 33: {
				return new Token(Sym.TYPEDETRAIT);
			}
			case 38:
				break;
			case 22: {
				return new Token(Sym.CERCLE);
			}
			case 39:
				break;
			case 17: {
				return new Token(Sym.ALORS);
			}
			case 40:
				break;
			case 15: {
				return new Token(Sym.VAR);
			}
			case 41:
				break;
			case 14: {
				return new Token(Sym.FIN);
			}
			case 42:
				break;
			case 20: {
				return new Token(Sym.SINON);
			}
			case 43:
				break;
			case 8: {
				return new Token(Sym.MINUS);
			}
			case 44:
				break;
			case 27: {
				return new Token(Sym.TANTQUE);
			}
			case 45:
				break;
			case 11: {
				return new Token(Sym.PAROUVRANTE);
			}
			case 46:
				break;
			case 23: {
				return new Token(Sym.TOURNE);
			}
			case 47:
				break;
			case 10: {
				return new Token(Sym.DIV);
			}
			case 48:
				break;
			case 25: {
				return new Token(Sym.ELLIPSE);
			}
			case 49:
				break;
			case 28: {
				return new Token(Sym.EPAISSEUR);
			}
			case 50:
				break;
			case 26: {
				return new Token(Sym.BASDROIT);
			}
			case 51:
				break;
			case 18: {
				return new Token(Sym.DEBUT);
			}
			case 52:
				break;
			case 31: {
				return new Token(Sym.HAUTGAUCHE);
			}
			case 53:
				break;
			case 24: {
				return new Token(Sym.MILIEU);
			}
			case 54:
				break;
			case 21: {
				return new Token(Sym.AVANCE);
			}
			case 55:
				break;
			case 13: {
				return new Token(Sym.SI);
			}
			case 56:
				break;
			case 16: {
				return new Token(Sym.HOME);
			}
			case 57:
				break;
			case 35: {
				return new Token(Sym.COULEURTRAIT);
			}
			case 58:
				break;
			case 30: {
				return new Token(Sym.BASPINCEAU);
			}
			case 59:
				break;
			case 4: {
				return new IntToken(Sym.NOMBRE, Integer.parseInt(yytext()));
			}
			case 60:
				break;
			case 12: {
				return new Token(Sym.PARFERMANTE);
			}
			case 61:
				break;
			case 7: {
				return new Token(Sym.PLUS);
			}
			case 62:
				break;
			case 32: {
				return new Token(Sym.COULEURFOND);
			}
			case 63:
				break;
			case 29: {
				return new Token(Sym.HAUTDROIT);
			}
			case 64:
				break;
			case 1: {
				throw new LexerException(yyline, yycolumn);
			}
			case 65:
				break;
			case 9: {
				return new Token(Sym.MUTL);
			}
			case 66:
				break;
			case 19: {
				return new Token(Sym.FAIRE);
			}
			case 67:
				break;
			case 5: {
				return new Token(Sym.POINTVIRGULE);
			}
			case 68:
				break;
			case 6: {
				return new Token(Sym.EQ);
			}
			case 69:
				break;
			case 2: {
			}
			case 70:
				break;
			default:
				if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
					zzAtEOF = true;
					switch (zzLexicalState) {
					case YYINITIAL: {
						return new Token(Sym.EOF);
					}
					case 150:
						break;
					default:
						return null;
					}
				} else {
					zzScanError(ZZ_NO_MATCH);
				}
			}
		}
	}

}

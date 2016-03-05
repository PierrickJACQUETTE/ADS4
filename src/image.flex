%%
%public
%class Lexer
%unicode
%type Token
%line
%column

%{
	
%}

%yylexthrow{
	LexerException
%yylexthrow}

blank = "\n" | "\r" | " " | "\t"
identificateur = [a-z][a-zA-Z0-9]*
nombre = [1-9][0-9]* | 0

%%

<YYINITIAL> {
	{identificateur}	{return new VarToken(Sym.IDENTIFICATEUR, yytext());}
	{nombre}			{return new IntToken(Sym.NOMBRE, Integer.parseInt(yytext()));}
	"Alors"				{return new Token(Sym.ALORS);}
	"Avance"			{return new Token (Sym.AVANCE);}
	"BasDroit"			{return new Token(Sym.BASDROIT);}
	"BasPinceau"		{return new Token(Sym.BASPINCEAU);}
	"Cercle"			{return new Token(Sym.CERCLE);}
	"CouleurFond"		{return new Token(Sym.COULEURFOND);}
	"CouleurTrait"		{return new Token(Sym.COULEURTRAIT);}
	"Debut"				{return new Token(Sym.DEBUT);}
	"Ellipse"			{return new Token(Sym.ELLIPSE);}
	"Epaisseur"			{return new Token(Sym.EPAISSEUR);}
	"Faire"				{return new Token(Sym.FAIRE);}
	"Fin"				{return new Token(Sym.FIN);}	
	"HautDroit"			{return new Token(Sym.HAUTDROIT);}
	"HautGauche"		{return new Token(Sym.HAUTGAUCHE);}
	"HautPinceau"		{return new Token(Sym.HAUTPINCEAU);}
	"Home"				{return new Token(Sym.HOME);}
	"Milieu"			{return new Token(Sym.MILIEU);}
	"Si"				{return new Token(Sym.SI);}
	"Sinon"				{return new Token(Sym.SINON);}
	"Tant que"			{return new Token(Sym.TANTQUE);}
	"Tourne"			{return new Token(Sym.TOURNE);}
	"TypeDeTrait"		{return new Token(Sym.TYPEDETRAIT);}		
	"Var"				{return new Token(Sym.VAR);}
	";"					{return new Token(Sym.POINTVIRGULE);}
	"="					{return new Token(Sym.EQ);}
	"+"					{return new Token(Sym.PLUS);}
	"-"					{return new Token(Sym.MINUS);}
	"*"					{return new Token(Sym.MUTL);}
	"/"					{return new Token(Sym.DIV);}
	"("					{return new Token(Sym.PAROUVRANTE);}
	")"					{return new Token(Sym.PARFERMANTE);}
	{blank}	 			{}
	<<EOF>>				{return new Token(Sym.EOF);}
	[^]					{throw new LexerException(yyline, yycolumn);}
}

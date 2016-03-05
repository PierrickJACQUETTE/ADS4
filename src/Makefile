JFLAGS = -g
JC = javac
JVM= java
FILE=
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	LesExceptions.java \
	AbstractSyntax.java \
	Main.java \
	Point.java \
	Couleur.java \
	Lexer.java \
	Sym.java \
	Fenetre.java \
	Ligne.java \
	Panneau.java \
	Token.java \
	LookAhead1.java \
	Parser.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN)

clean:
	$(RM) *.class

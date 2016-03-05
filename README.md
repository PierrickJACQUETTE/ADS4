# ADS4
Interpréteur pour la création d'image

Vous venez de télécharger l'archive maintenant deux possibilités : 

- Creer un fichier avec les instructions à l'interieur
	Dans un terminal taper une fois dans le repertoire src/ : make
	puis taper : java Main cheminDuFichier/test.txt (test.txt à remplacer par le bon nom du fichier)

- Ou bien 
	Quelques exemples sont présents dans le dossier Exemple taper donc dans le répertoire courant : 
	Dans un terminal taper une fois dans le repertoire src/ : make
	puis java Main ../Exemple/projet.txt (ou un autre exemple)


PROJET CREER EN BINOME : 

FERRE Adrien && JACQUETTE Pierrick


GRAMMAIRE :

programme -> declarations instruction

declarations -> Var identificateur ; declarations | e
 
instruction -> Avance expression | Tourne expression | BasPinceau | HautPinceau | identificateur = expression |
				Debut blocInstruction Fin | Si test | Tant que boucle | Epaisseur expression |
				CouleurTrait expression expression expression | CouleurFond expression expression expression |
				TypeDeTrait expression | Cercle expression | Ellipse expression expression | Home | Milieu | 
				HautGauche | HautDroit | BasDroit
 
blocInstruction -> instruction ; blocInstruction | e
 
test -> expression Alors instruction Sinon instruction | expression Alors instruction
 
boucle -> expression Faire instruction

expression -> nombre expressionSuite | identificateur expressionSuite | (expression) expressionSuite
 
expressionSuite -> + expression | - expression | * expression | / expression | e


C'est la grammaire d'origine avec quelques améliorations :

- L'instruction Tourne peut prendre n'importe quel angle entier en degré (par exemple pour pouvoir dessiner des traits obliques)
- Il y a une instruction Si expression Alors instruction Sinon intruction 
- Il y a une instruction Si expression Alors instruction 
- Il y a une instruction Tant que expression Faire instruction
- Dans l'interface graphique il y a un zoom pour mieux voir les petits dessins 
- On peut modifier l'épaisseur du trait (un entier representant l'épaisseur) grâce à l'instruction : Epaisseur
- On peut modifier la couleur du trait (trois entiers rgb) grâce à l'instruction : CouleurTrait 
- On peut modifier la couleur du fond du dessin (trois entiers rgb) grâce à l'instruction : CouleurFond
- On peut modifier le type de trait (par exemple en pointillé) grâce à l'instruction : TypeDeTrait
- On peut tracer un cercle (en entier le rayon) grâce à l'instruction : Cercle
- On peut tracer une ellipse (deux entiers rayonX rayonY)  grâce à l'instruction : Ellipse
- On peut replacer la tortue au point de depart grâce à l'instruction Home
- On peut placer la tortue au milieu de l'interface graphique : Milieu 
- On peut placer la tortue dans chaque coin de l'interface graphique : HautGauche | HautDroit | BasDroit | Home

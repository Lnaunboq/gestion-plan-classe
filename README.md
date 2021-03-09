# gestion-plan-classe
Projet """Annuel""" de L3 Informatique

Compiler la grammaire :

	- export CLASSPATH=".:/usr/share/java/*:$CLASSPATH" (si ça marche pas dans le terminal)
	- java org.antlr.v4.Tool Parser.g4
	- javac *.java

arbre antlr :

	- java org.antlr.v4.runtime.misc.TestRig Parser start -gui
	- antlr4-grun Parser 'parsing' > test.mvap


Commandes Git :

Mettre à jour les modifications :

	- git pull

Mettre à jour les modifications :

	- git add ce_qu_il_faut_ajouter.java
	- git commit -m "commentaire"
	- git pull (il est possible qu'il faille rentrer les identifiants GitHub)

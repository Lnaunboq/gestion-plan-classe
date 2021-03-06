# gestion-plan-classe
Projet """Annuel""" de L3 Informatique

Compiler la grammaire :

	- export CLASSPATH=".:/usr/share/java/*:$CLASSPATH" (si ça marche pas dans le terminal)
	- java org.antlr.v4.Tool Calculette.g4
	- javac *.java

arbre antler :

	- java org.antlr.v4.runtime.misc.TestRig Calculette start -gui

Commande MVAP :

	- java MVaPAssembler -d testcode.mvap
	- java CBaP -d testcode.mvap.cbap

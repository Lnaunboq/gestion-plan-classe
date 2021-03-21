SET CLASSPATH=.;universite\L3\S6\LangCompil\antlr-4.9.1-complete.jar;%CLASSPATH%
DOSKEY antlr=java org.antlr.v4.Tool $*
DOSKEY compile=javac *.java
DOSKEY grun=java org.antlr.v4.gui.TestRig $*
DOSKEY antlr4-grun=java org.antlr.v4.runtime.misc.TestRig $*
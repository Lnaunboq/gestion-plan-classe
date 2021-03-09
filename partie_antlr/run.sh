export CLASSPATH=".:/usr/share/java/*:$CLASSPATH"

PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/usr/site/bin

CLASSPATH=.:/usr/share/java/stringtemplate4.jar:/usr/share/java/antlr4.jar:/usr/share/java/antlr4-runtime.jar:/usr/share/java/treelayout.jar


antlr4 Parser.g4
javac -cp $CLASSPATH *.java

antlr4-grun Parser 'parsing' > test.mvap

#java -cp "/usr/share/java/*:MVaP.jar" MVaPAssembler test.mvap

#java -jar MVaP.jar -d test.mvap.cbap
grammar Calculette;

@parser::members {

    private String evalexpr (String op) {
        if ( op.equals("*") ){
            return "MUL\n";
        } else if ( op.equals("/") ){
            return "DIV\n";
        } else {
           System.err.println("OpÃ©rateur arithmÃ©tique incorrect : '"+op+"'");
           throw new IllegalArgumentException("OpÃ©rateur arithmÃ©tique incorrect : '"+op+"'");
        }
    }

    private TablesSymboles tablesSymboles = new TablesSymboles();

    private TableSymboles tableSymboles = new TableSymboles();

    /** gÃ©nÃ©rateur de nom d'Ã©tiquettes pour les boucles */
    private int _cur_label = 1;
    private String getNewLabel() { return "B" +(_cur_label++); }



}
start:calcul EOF;

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :    (decl { $code += $decl.code; })*

        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;

decl returns [ String code ]
    :
        TYPE IDENTIFIANT finInstruction
        {
          tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text); //TYPE.text permet d'Ã©crire dans la table des symbole le type en toutes lettres
          $code = "PUSHI 0\n" ; //on dÃ©clare de la mÃªme maniÃ¨re les entiers et flottants, pour l'instant
        }
    | TYPE IDENTIFIANT '=' expression finInstruction
    {
      tablesSymboles.putVar($IDENTIFIANT.text,"int");
      $code = $expression.code; //on utilise l'Ã©valuation Ã©crite dans la partie expression, elle fait dÃ©jÃ  les pushi nÃ©cessaires
    }
    ;

instruction returns [ String code ]
    : 'read(' IDENTIFIANT ')'
        {
          AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
          $code = "READ \n STOREG " + at.adresse + "\n";
        }
    | 'write(' expression ')'
        {
          $code =  $expression.code + "WRITE \n";
        }
    | 'while' '(' condition ')' NEWLINE?/*si on va a la ligne*/ bloc
        {
            String debut =  getNewLabel();
            String fin =  getNewLabel();
            $code = "LABEL " + debut + "\n"
            + $condition.code + "\n"
            + "JUMPF " + fin + "\n"
            + $bloc.code
            + "JUMP " + debut + "\n"
            + "LABEL " + fin + "\n";
            /*voir diapo 6.0 page 17 pour inspi*/
        }
    | 'if' '(' condition ')' a=bloc //rÃ©sultats bof, revoir autocor.sh !
        {
            String debutElse =  getNewLabel();
            String finElse =  getNewLabel();
            $code = $condition.code
            + "JUMPF " + debutElse + "\n"
            + $a.code
            + "JUMP " + finElse + "\n"
            +"LABEL " + debutElse + "\n";
        }
        ('else' b=bloc {$code += $b.code;})?
        {
          $code += "JUMP " + finElse + "\n" + "LABEL " + finElse + "\n";
        }
    | expression finInstruction
        {
            $code = $expression.code;
        }
   | finInstruction
        {
            $code="";
        }
   | assignation finInstruction
        {
        		$code = $assignation.code;
        }
    ;

bloc returns  [String code] /* ECRIRE SANS ";" DANS UN BLOC GENERE UNE ERREUR */
  : {$code = "";/*on crÃ©e une chaÃ®ne vide en dÃ©but de bloc*/}
    '{' /*le bloc est ouvert*/
        (instruction { $code += $instruction.code; })*  /*on prend chaque instruction une par une,
        on l'Ã©value puis on la concatÃ¨ne dans $code avec toutes les instructions prÃ©cÃ©dantes du bloc*/
    '}' /*le bloc est terminÃ©, rien Ã  ajouter Ã  $code*/
  | instruction
    {$code = $instruction.code;}
  ;

expression returns [ String code ]
  : '(' a=expression ')' {$code = $a.code;}
  | a=expression op=('*'|'/') b=expression {$code = $a.code + $b.code + evalexpr($op.text);}
  | a=expression op='+' b=expression {$code = $a.code + $b.code + "ADD\n";}
  | a=expression op='-' b=expression {$code = $a.code + $b.code + "SUB\n";}
  | IDENTIFIANT  {
      AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
      $code = "PUSHG " + at.adresse + "\n";
    }
  | '-' ENTIER {$code = "PUSHI -" + $ENTIER.text + "\n";}
  | ENTIER {$code = "PUSHI " + $ENTIER.text + "\n";}
  ;

finInstruction : ( NEWLINE | ';' )+ ;


assignation returns [ String code ]
    : IDENTIFIANT '=' expression
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code= $expression.code + "STOREG " + at.adresse + "\n";
        }
    ;

condition returns [String code]
    : c=condition '&&' d=condition {$code = $c.code + $d.code + "MUL \n";} //si l'une des conditions est 0 (false) alors la multipication retourne 0, sinon une valeur non nulle true)
    | c=condition '||' d=condition {$code = $c.code + $d.code + "ADD \nPUSHI 1\nSUPEQ \n";} //on test si chacune des opÃ©randes et true, si l'une d'elle l'est alors lADD retourne une valeur non nulle, et donc un true
    //on n'a pas Ã©crit simplement **$a.code + $b.code + "ADD \nPUSHI 1\nEQUAL \n"** car si a = -b alors on aurait eu 0 en retour alors que les deux opÃ©randes sont non nulles.
    | a=expression '==' b=expression { $code = $a.code + $b.code + "EQUAL \n";}
    | a=expression ('!=' | '<>') b=expression { $code = $a.code + $b.code + "NEQ \n";}
    | a=expression '<' b=expression { $code = $a.code + $b.code + "INF \n";}
    | a=expression '>' b=expression { $code = $a.code + $b.code + "SUP \n";}
    | a=expression '<=' b=expression { $code = $a.code + $b.code + "INFEQ \n";}
    | a=expression '>=' b=expression { $code = $a.code + $b.code + "SUPEQ \n";}
    | '!' condition {$code = $condition.code + "PUSHI 0\nEQUAL \n";} //on effectue condition==0, si condition est false on retourne true, sinon false
    |'true'  { $code = "  PUSHI 1\n"; }
    | 'false' { $code = "  PUSHI 0\n"; }
    ;

// lexer   /*attention Ã  l'ordre de dÃ©claration !!!*/

//COMMENTAIRE : '//' ('a'..'z')?  "\n" -> skip ; Pas encore trouver comment les retirer

TYPE : 'int' | 'float' ;

PRIMITIVE : 'read' | 'write' ;

BOOLEEN : 'true' | 'false' ;

IDENTIFIANT : ('a'..'z')+ ;

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

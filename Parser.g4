grammar Parser;

@parser::members {

    /*
    private String fonctionEval (String op) {
        if ( op.equals("*") ){
            return "MUL\n";
        } else if ( op.equals("/") ){
            return "DIV\n";
        } else {
           System.err.println("OpÃ©rateur arithmÃ©tique incorrect : '"+op+"'");
           throw new IllegalArgumentException("OpÃ©rateur arithmÃ©tique incorrect : '"+op+"'");
        }
    }

    */

    /*
    private TablesSymboles tablesSymboles = new TablesSymboles();

    private TableSymboles tableSymboles = new TableSymboles();

    // générateur de nom d'Ã©tiquettes pour les boucles
    private int _cur_label = 1;
    private String getNewLabel() { return "B" +(_cur_label++); }
    */

}

start:parsing EOF;


parsing returns [String code]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); } // On affiche le résultat du parsing (juste pour vérifier)
    :   (declDispositionreturns { $code += $decl.code; })*

        NEWLINE*

        (declEleves { $code += $decl.code; })*

        NEWLINE*

        (declContrainte { $code += $decl.code; })*

        { $code += "  HALT\n"; }
    ;

declDisposition returns [ String code ]
    : 'DISPOSITION' blocDisposition
        {
          $code = $blocDisposition.code;
        }
    ;

declEleves returns [ String code ]
    : 'CLASSE' blocEleves
        {
          $code = $blocEleves.code;
        }
    ;


  declContrainte returns [ String code ]
    : 'CLASSE' blocContraintes
        {
          $code = $blocContraintes.code;
        }
    ;

blocDisposition returns [ String code ]
    : {$code = "Disposion de la salle :";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' (regleAmenagement {$code += regleAmenagement.code;})* '}'
    ;

regleAmenagement returns [ String code ]
    :
    ;


blocEleves returns [ String code ]
    : {$code = "Liste des éléves :";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' (eleve {$code += eleve.code;})* '}'
    ;

eleve returns [ String code ]
    : {$code = "";}
      (NOM {$code += NOM.text + "_";})? PRENOM //il peut ne pas y avoir de nom de famille
      {$code += PRENOM.text;
      tableEleves.putVar($code); //on ajoute l'élève dans les noms déclarés en se basant sur la string contenue dans $code
      }
    | NOM_PRENOM
      {$code = NOM_PRENOM.text;
      tableEleves.putVar($code); //on ajoute l'élève dans les noms déclarés en se basant sur la string contenue dans $code
      }
    ;

blocContraintes returns [ String code ]
    : {$code = "Liste des contraintes :";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' (contraintes {$code += contraintes.code;})* '}'
    ;

contraintes returns [ String code ]
    :
    ;

// lexer   /*attention Ã  l'ordre de dÃ©claration !!!*/

fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;

NOM : (UPPERCASE | '-')+ ; //un nom de famille tout en majuscule

PRENOM : UPPERCASE? (LOWERCASE | '-')+ ; //un prénom avec ou sans majuscule au début

//NOM_PRENOM : ('A'..'Z' | 'a'..'z' | '_' | '-')+ ; //un nom et prénom attachés et reliés par des "_"
NOM_PRENOM : (UPPERCASE | '-')+ '_' UPPERCASE? (LOWERCASE | '-')+ ; //un nom et prénom attachés et reliés par des "_"

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

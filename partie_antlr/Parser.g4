grammar Parser;

@parser::members {


    private String fonctionEval (String constraint) {
        if ( constraint.equals("D") ){
            return " devant ";
        } else if ( constraint.equals("F") ){
            return " au fond.\n";
        } else if ( constraint.equals("L") ){
            return " loin de ";
        } else if ( constraint.equals("P") ){
                return " près de ";
        } else {
           System.err.println("Contraine incorrecte : '"+constraint+"'");
           throw new IllegalArgumentException("OpÃ©rateur arithmÃ©tique incorrect : '"+constraint+"'");
        }
    }



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
    :   (declDisposition { $code += $declDisposition.code; })*

        NEWLINE*

        (declEleves { $code += $declEleves.code; })*

        NEWLINE*

        (declContrainte { $code += $declContrainte.code; })*

        { $code += "\n---fin de l\'interprétation---\n"; } // (le colorateur lexicale de Atom n'aime pas les \quotes, on remet la coloration avec ce commentaire)
    ;

declDisposition returns [ String code ]
    : 'DISPOSITION' finInstruction? blocDisposition finInstruction
        {
          $code = $blocDisposition.code;
        }
    ;

declEleves returns [ String code ]
    : 'CLASSE' finInstruction? blocEleves finInstruction
        {
          $code = $blocEleves.code;
        }
    ;


declContrainte returns [ String code ]
    : 'CONTRAINTES' finInstruction? blocContraintes finInstruction
        {
          $code = $blocContraintes.code;
        }
    ;

blocDisposition returns [ String code ]
    : {$code = "Disposion de la salle :\n";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' finInstruction? (regleAmenagement {$code += $regleAmenagement.code + "\n";} finInstruction)* finInstruction? '}'
    ;

regleAmenagement returns [ String code ]
    : 'Rangee' num=ENTIER nbr=ENTIER
      {
        $code = "La rangée numéro " + $num.text + " possède " + $nbr.text + " tables.";
        //Méthode pour déclarer à la classe une nouvelle rangée;
      }
    ;


blocEleves returns [ String code ]
    : {$code = "\nListe des élèves :\n";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' finInstruction? (eleve {$code += $eleve.code  + "\n";} finInstruction)* finInstruction? '}'
    ;

eleve returns [ String code ]
    : IDENTIFIANT
      {$code = $IDENTIFIANT.text;
      //tableEleves.putVar($code);
      }//on ajoute l'élève dans les noms déclarés en se basant sur la string contenue dans $code
    ;

blocContraintes returns [ String code ]
    : {$code = "\nListe des contraintes :\n";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' finInstruction? (contraintes {$code += $contraintes.code;} finInstruction)* finInstruction? '}'
    ;

contraintes returns [ String code ]
    : IDENTIFIANT CONTRAINTES
      {
        $code = $IDENTIFIANT.text + fonctionEval($CONTRAINTES.text) + "\n";
        //méthode pour passer la contrainte au code Java;
      }
    | eleve1=IDENTIFIANT CONTRAINTES eleve2=IDENTIFIANT
      {
        $code = $eleve1.text + fonctionEval($CONTRAINTES.text) + $eleve2.text + "\n";
        //méthode pour passer la contrainte au code Java;
      }
    ;

finInstruction : ( NEWLINE | ';' )+ ;

// lexer   /*attention Ã  l'ordre de dÃ©claration !!!*/

CONTRAINTES : ('D' | 'F' | 'L' | 'P'); //D = devant ; F = au fond ; L = loin de ; P = près de

fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;

IDENTIFIANT : (UPPERCASE | '-' | LOWERCASE)+ ; //un nom de famille tout en majuscule

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

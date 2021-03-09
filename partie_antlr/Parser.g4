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
    : {$code = "";}
      (NOM {$code += $NOM.text + "_";})? PRENOM //il peut ne pas y avoir de nom de famille
      {$code += $PRENOM.text;
      //tableEleves.putVar($code);
      }//on ajoute l'élève dans les noms déclarés en se basant sur la string contenue dans $code
    | NOM_PRENOM
      {$code = $NOM_PRENOM.text;
      //tableEleves.putVar($code);
      }//on ajoute l'élève dans les noms déclarés en se basant sur la string contenue dans $code
    ;

blocContraintes returns [ String code ]
    : {$code = "\nListe des contraintes :\n";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' finInstruction? (contraintes {$code += $contraintes.code;} finInstruction)* finInstruction? '}'
    ;

contraintes returns [ String code ]
    : {$code = "";}
      /*(NOM {$code += $NOM.text + " ";})?*/NOM PRENOM CONTRAINTES
      {
        $code += $PRENOM.text + " doit être " + $CONTRAINTES.text + "\n";
        //méthode pour passer la contrainte au code Java;
      }
    | NOM_PRENOM CONTRAINTES
      {
        $code = $NOM_PRENOM.text + " doit être " + $CONTRAINTES.text + "\n";
        //méthode pour passer la contrainte au code Java;
      }
    | {$code = "";}
      (nom1=NOM {$code += $nom1.text + " ";})? prenom1=PRENOM CONTRAINTES
      {
        $code += $prenom1.text + " doit être " + $CONTRAINTES.text + " ";
      }
      (nom2=NOM {$code += $nom2.text + " ";})? prenom2=PRENOM
      {
        $code += $prenom2.text + "\n";
      }
    | eleve1=NOM_PRENOM CONTRAINTES eleve2=NOM_PRENOM
      {
        $code = $eleve1.text + " doit être " + $CONTRAINTES.text + " " + $eleve2.text + "\n";
        //méthode pour passer la contrainte au code Java;
      }
    ;

finInstruction : ( NEWLINE | ';' )+ ;

// lexer   /*attention Ã  l'ordre de dÃ©claration !!!*/

CONTRAINTES : ('devant' | 'au fond' | 'loin de' | 'près de') ;

fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;

NOM : (UPPERCASE | '-')+ ; //un nom de famille tout en majuscule

PRENOM : UPPERCASE? (LOWERCASE | '-')+ ; //un prénom avec ou sans majuscule au début

//NOM_PRENOM : ('A'..'Z' | 'a'..'z' | '_' | '-')+ ; //un nom et prénom attachés et reliés par des "_"
NOM_PRENOM : NOM '_' PRENOM ; //un nom et prénom attachés et reliés par des "_"

NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

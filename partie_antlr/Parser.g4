grammar Parser;

@parser::members {

    private String fonctionEvalContrainteSimple (String eleve, String constraint, ConstraintBuilder constraintBuilder, Classroom classe) { //évalue la contrainte donnée par son abbréviation
      if (classe.getStudent($eleve.text) != null){ //si l'élève existe dans la classe
        if ( constraint.equals("D") ){
            constraintBuilder.build("au rang", classe.getStudent($eleve.text), 1); //on positionne la contrainte sur l'eleve au premier rang
            return eleve + "va devant ";
        } else if ( constraint.equals("F") ){
            constraintBuilder.build("au rang", classe.getStudent($eleve.text), classe.getRowNumber()-1); //on positionne la contrainte sur l'eleve au dernier rang
            return eleve + "va au fond.";
        } else if ( constraint.equals("L") ){
            return " loin de ";
        } else if ( constraint.equals("P") ){
                return " près de ";
        } else {
           System.err.println("Contraine incorrecte : '"+constraint+"'");
           throw new IllegalArgumentException("Opérateur arithmÃ©tique incorrect : '"+constraint+"'");
        }
      }
      else {
        return "L élève " + eleve + "n a pas été trouvé dans la classe.";
      }
    }

    private String fonctionEvalContrainteDouble (String eleve1, String eleve2, String constraint, ConstraintBuilder constraintBuilder, Classroom classe) {
      if (classe.getStudent($eleve1.text) != null && $eleve2.text !=null){ //si les élèves existent dans la classe
        if ( constraint.equals("L") ){
            constraintBuilder.build("loin de", classe.getStudent($eleve1.text), classe.getStudent($eleve2.text));
            return eleve1 + " loin de " + eleve2;
        } else if ( constraint.equals("P") ){
            constraintBuilder.build("a cote de", classe.getStudent($eleve1.text), classe.getStudent($eleve2.text));
            return eleve1 + " près de " + eleve2;
        } else {
           System.err.println("Contraine incorrecte : '"+constraint+"'");
           throw new IllegalArgumentException("Opérateur arithmÃ©tique incorrect : '"+constraint+"'");
        }
      }
      else {
        return "L élève " + eleve1 " ou " + eleve2 + "n a pas été trouvé dans la classe.";
      }
    }

    public Classroom classe;
    private ConstraintBuilder constraintBuilder = new ConstraintBuilder();
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
    : ENTIER 'rangées'
      {
        $code = "LA class contient " + $ENTIER.text + " rangées.";
        classe = new Classroom(Integer.parseInt($ENTIER.text)); //on transforme l'objet ENTIER en type int puis on le passe à Classroom qui a besoin de connaître son nombre de rangée pour être instanciée
      }
    |'Rangee' num=ENTIER nbr=ENTIER
      {
        $code = "La rangée numéro " + $num.text + " possède " + $nbr.text + " tables.";
        //Méthode pour déclarer à la classe une nouvelle rangée;
        classe.setNumberOfPlace(Integer.parseInt($num.text), Integer.parseInt($nbr.text));
      }
    ;


blocEleves returns [ String code ]
    : {$code = "\nListe des élèves :\n";} //on déclare une string sur laquelle on va concaténer les noms des élèves
      '{' finInstruction? (eleve {$code += $eleve.code  + "\n";} finInstruction)* finInstruction? '}'
    ;

eleve returns [ String code ]
    : IDENTIFIANT
      {$code = $IDENTIFIANT.text;
      classe.addStudent($IDENTIFIANT.text);
      }//on ajoute l'élève dans les noms déclarés en se basant sur la string contenue dans $code
    ;

blocContraintes returns [ String code ]
    : {$code = "\nListe des contraintes :\n";} //on déclare une string vide sur laquelle on va concaténer les noms des élèves
      '{' finInstruction? (contraintes {$code += $contraintes.code;} finInstruction)* finInstruction? '}'
      { System.out.println(classe.evaluate(constraintBuilder.getConstraints()));} //une fois que toutes les contraintes ont été ajoutées on lance l'algo sur les contraintes
    ;

contraintes returns [ String code ]
    : IDENTIFIANT CONTRAINTES
      {
        $code = fonctionEvalContrainteSimple($IDENTIFIANT.text, $CONTRAINTES.text, constraintBuilder, classe) + "\n"; //c'est la fonctionEval qui se charge d'ajouter la contrainte à la classe si elle est valide
      }
    | eleve1=IDENTIFIANT CONTRAINTES eleve2=IDENTIFIANT
      {
        $code = fonctionEvalContrainteDouble($eleve1.text, $eleve2.text, $CONTRAINTES.text, constraintBuilder, classe) + "\n"; //on a préféré faire deux fonctions d'évaluation qu'une surcharge en fonction du nombre d'étudiants passés
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

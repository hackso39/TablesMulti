package packTablesMulti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Launcher {

	private final static int NBR_QUESTIONS = 3;
	public static int compteurPoints = 0;
	public static int nbrReponsesDonnees = 0;

	public static void main(String[] args) {

//		lanceur1(); // genererListeDeCombinaisons
//		lanceur2();
		Lanceur3();
	}

	private static void Lanceur3() {
		int nbr = 3;
		List<Integer> lI = new ArrayList<Integer>();
		Combinaisons c = new Combinaisons(3, 2);
		Outils o = new Outils();
		lI = o.questionChoixMultiples(c, nbr);
		Collections.sort(lI);
		for (Integer i : lI) {
			System.out.println(i);
		}
	}

	private static void lanceur2() {

		Outils outils = new Outils();
		Scanner sc = new Scanner(System.in);		

		List<Combinaisons> lC = outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // M�lange des �l�ments de la liste

		for(int i = 0 ; i < NBR_QUESTIONS ; i++) {
			boolean reponseOk = false;
			System.out.println("Quel est le r�sultat de : " + lC.get(i).getNbr1() + " x " + lC.get(i).getNbr2() + " ?");
			    while(!reponseOk) {
			    	while (!sc.hasNextInt()) {
			    		sc.next();
			    	}
			    	int resultat = sc.nextInt();
			    	if(resultat == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
			    		reponseOk = true;
			    		System.out.println("BRAVO ! C'est la bonne r�ponse !!!");
			    		compteurPoints++;
			    		nbrReponsesDonnees++;
			    	} else {
			    		System.out.println("Ce n'est pas la bonne r�ponse, essaye encore !");
			    		reponseOk = false;
			    		nbrReponsesDonnees++;
			    	}
			    }
		}
		System.out.println("");
		System.out.println("--------------- R�sulats : -------------------");
		System.out.println("Nombre de r�ponses donn�es : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS + " questions pos�es, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) r�ponse(s).");
		//afficherCombinaison(lC);
	}

	private static void lanceur1() {
		
//		System.out.println("Quel est le r�sultat de : a x b ?");
//		System.out.println("R�sultat : ");
		
		Outils outils = new Outils();
		
		List<Combinaisons> lC = outils.genererListeDeCombinaisons();
		
		afficherCombinaison(lC);
	}

	private static void afficherCombinaison(List<Combinaisons> lC) {
		
		for(int i = 0 ; i < lC.size() ; i++) {
			
			if(i < 9) {  // indice de i : 0 � 8
				System.out.println((i + 1) + "   : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
			
			if(i > 8 && i < 99) { // indice de i : 9 � 99
				System.out.println((i + 1) + "  : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
			
			if(i > 98) { // indice de i : 99 � ...
				System.out.println((i + 1) + " : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
		}
	}
}
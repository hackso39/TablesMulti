package packTablesMulti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Launcher {

	private final static int NBR_QUESTIONS = 3;
	private final static int NBR_PROPOSITIONS = 3;
	public static int compteurPoints = 0;
	public static int nbrReponsesDonnees = 0;

	public static void main(String[] args) {

//		lanceur1(); // genererListeDeCombinaisons
//		lanceur2();
//		Lanceur3();
		lanceur4();
	}

	/**
	 * on propose à j une combinaison : 3 x 7
	 *		3 propositions sont établies
	 * A : 21	
	 * B : 22
	 * C : 25
	 * l'utilisateur saisit A
	 * 		on compare A à la bonne réponse
	 * 		Si : bonne réponse : Bravo (+1 pt)
 	 * 		Sinon : Mauvaise réponse
	 */
	/**
	 * Cette méthode permet de demander à l'utilisateur, suivant le nombre de questions 
	 * définies, la bonne réponse à l'opération posée, un nombre prédéfini de propositions 
	 * lui est soumis.
	 * Le résultat est indiqué en fin de partie.
	 */
	private static void lanceur4() {
		Outils outils = new Outils();
		Scanner sc = new Scanner(System.in);		

		List<Combinaisons> lC = outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // Mélange des éléments de la liste

		for(int i = 0 ; i < NBR_QUESTIONS ; i++) {
			
			
			System.out.println("Quel est le résultat de : " + lC.get(i).getNbr1() + " x " + lC.get(i).getNbr2() + " ?");
			    while (!sc.hasNextInt()) {
			    	sc.next();
			    }
			    int resultat = sc.nextInt();
			    if(resultat == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
			    	System.out.println("BRAVO ! C'est la bonne réponse !!!");
			    	compteurPoints++;
			    	nbrReponsesDonnees++;
			    } else {
			    	System.out.println("Ce n'est pas la bonne réponse, essaye encore !");
			    	nbrReponsesDonnees++;
			    }
			    
		}
		System.out.println("");
		System.out.println("--------------- Résulats : -------------------");
		System.out.println("Nombre de réponses données : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS + " questions posées, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) réponse(s).");
		//afficherCombinaison(lC);
	}



	/**
	 * Cette méthode permet d'afficher une combinaison dans un ordre aléatoire, par exemple : 3 x 7 ou 7 x 3.
	 */
	private static void Lanceur3() {
		int nbr = 3;
		List<Integer> lI = new ArrayList<Integer>();
		Combinaisons c = new Combinaisons(3, 7);
		Outils o = new Outils();
		lI = o.questionChoixMultiples(c, nbr);
		Collections.sort(lI);
		for (Integer i : lI) {
			System.out.println(i);
		}
	}
	
	/**
	 * Cette méthode permet de demander à l'utilisateur, suivant le nombre de questions 
	 * définies, la bonne réponse à l'opération posée, tant que l'utilisateur n'a pas 
	 * donné la bonne réponse, on redemande la bonne réponse.
	 * Le résultat du nombre de tentatives (échec/réussite) est indiqué en fin de partie.
	 */
	private static void lanceur2() {

		Outils outils = new Outils();
		Scanner sc = new Scanner(System.in);		

		List<Combinaisons> lC = outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // Mélange des éléments de la liste

		for(int i = 0 ; i < NBR_QUESTIONS ; i++) {
			boolean reponseOk = false;
			System.out.println("Quel est le résultat de : " + lC.get(i).getNbr1() + " x " + lC.get(i).getNbr2() + " ?");
			    while(!reponseOk) {
			    	while (!sc.hasNextInt()) {
			    		sc.next();
			    	}
			    	int resultat = sc.nextInt();
			    	if(resultat == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
			    		reponseOk = true;
			    		System.out.println("BRAVO ! C'est la bonne réponse !!!");
			    		compteurPoints++;
			    		nbrReponsesDonnees++;
			    	} else {
			    		System.out.println("Ce n'est pas la bonne réponse, essaye encore !");
			    		reponseOk = false;
			    		nbrReponsesDonnees++;
			    	}
			    }
		}
		System.out.println("");
		System.out.println("--------------- Résulats : -------------------");
		System.out.println("Nombre de réponses données : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS + " questions posées, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) réponse(s).");
		//afficherCombinaison(lC);
	}
	
	/**
	 * Cette méthode permet d'afficher la liste de toutes les combinaisons générées 
	 * par la méthode : genererListeDeCombinaisons().
	 */
	private static void lanceur1() {
		
//		System.out.println("Quel est le résultat de : a x b ?");
//		System.out.println("Résultat : ");
		
		Outils outils = new Outils();
		
		List<Combinaisons> lC = outils.genererListeDeCombinaisons();
		
		afficherCombinaison(lC);
	}

	private static void afficherCombinaison(List<Combinaisons> lC) {
		
		for(int i = 0 ; i < lC.size() ; i++) {
			
			if(i < 9) {  // indice de i : 0 à 8
				System.out.println((i + 1) + "   : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
			
			if(i > 8 && i < 99) { // indice de i : 9 à 99
				System.out.println((i + 1) + "  : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
			
			if(i > 98) { // indice de i : 99 à ...
				System.out.println((i + 1) + " : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
		}
	}
}
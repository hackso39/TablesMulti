package packTablesMulti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Launcher {
	
	private final static int MODE = 1;
	private final static int NBR_QUESTIONS = 3;
	private final static int NBR_PROPOSITIONS = 3; // Minimum = 2
	public static int compteurPoints = 0;
	public static int nbrReponsesDonnees = 0;
	
	public static void main(String[] args) {
		
		// lanceur1(); // genererListeDeCombinaisons
		// lanceur3();
		// lanceur4();
		// lanceur5();
		// lanceur6();
		// lanceur7();
		lanceur8();
	}
	@SuppressWarnings("unused")
	private static void lanceur8() {

		System.out.println("Bonjour Charl�ne !");
		StrategyQuestion strategie;
		if (MODE == 0) {
			strategie = new StrategyQuestionValeur();
		} else {
			strategie = new StrategyQuestionChoix();
		}
		
		fonctionnementDuJeu(strategie);
	}

	private static void fonctionnementDuJeu(StrategyQuestion strategie) {
		Scanner sc = new Scanner(System.in);
		
		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // M�lange des �l�ments de la liste
		for (int i = 0; i < NBR_QUESTIONS; i++) {
			
			Combinaisons combinaison = lC.get(i);
			boolean reponseJuste;
			
			reponseJuste = strategie.poserQuestion(combinaison, NBR_QUESTIONS, sc, i);
			
			nbrReponsesDonnees++;
			if (reponseJuste) {
				compteurPoints++;
			}
		}
		
		System.out.println("");
		System.out.println("--------------- R�sulats : -------------------");
		
		strategie.afficherMode();
		
		System.out.println("Nombre de r�ponses donn�es : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions pos�es, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) r�ponse(s).");
		// afficherCombinaison(lC);
	}

	@SuppressWarnings("unused")
	private static void lanceur7() {
		Scanner sc = new Scanner(System.in);

		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // M�lange des �l�ments de la liste
		for (int i = 0; i < NBR_QUESTIONS; i++) {

			Combinaisons combinaison = lC.get(i);
			boolean reponseJuste = false;

			if (MODE == 0) {

				// cas avec valeur
				System.out.println(
						"Quel est le r�sultat de : " + combinaison.getNbr1() + " x " + combinaison.getNbr2() + " ?");
				while (!reponseJuste) {
					while (!sc.hasNextInt()) {
						sc.next();
					}
					int resultat = sc.nextInt();
					if (resultat == (combinaison.getNbr1() * combinaison.getNbr2())) {
						System.out.println("BRAVO ! C'est la bonne r�ponse !!!");
						reponseJuste = true;
					} else {
						System.out.println("Ce n'est pas la bonne r�ponse, essaye encore !");
					}
				}

			} else {

				// cas avec choix
				System.out.println();
				int compteur = i + 1;
				System.out.println("Question : " + compteur + " sur : " + NBR_QUESTIONS);
				System.out
						.println("Voici la multiplication : " + combinaison.getNbr1() + " x " + combinaison.getNbr2());
				System.out.println("Parmi les propositions ci-dessous : ");

				Map<Character, Integer> reponsesPossibles = Outils.mapReponsesPossibles(combinaison, NBR_PROPOSITIONS);
				// for(int j = 0 ; j < reponsesPossibles.size() ; j++) {
				System.out.println(reponsesPossibles.entrySet());
				// }
				System.out.println("Quelle est la bonne r�ponse ?");

				char reponse = sc.next().charAt(0);
				if (reponsesPossibles
						.get(Character.toUpperCase(reponse)) == (combinaison.getNbr1() * combinaison.getNbr2())) {
					System.out.println("BRAVO ! C'est la bonne r�ponse !!!");
					reponseJuste = true;

				} else {
					System.out.println("D�sol�, ce n'est pas la bonne r�ponse !");
				}

			}

			nbrReponsesDonnees++;
			if (reponseJuste) {
				compteurPoints++;
			}

		}

		System.out.println("");
		System.out.println("--------------- R�sulats : -------------------");

		if (MODE == 0) {
			System.out.println("Vous avez jou� avec le jeux VALEUR");
		} else {
			System.out.println("Vous avez jou� avec le jeux CHOIX");
		}

		System.out.println("Nombre de r�ponses donn�es : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions pos�es, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) r�ponse(s).");
		// afficherCombinaison(lC);

	}


	private static void lanceur6() {

		int nbr = 3;
		Map<Character, Integer> mapChoixPossibles = new HashMap<Character, Integer>();
		Combinaisons c = new Combinaisons(3, 7);
		mapChoixPossibles = Outils.mapReponsesPossibles(c, nbr);

		// Solution 1 : r�cup�rer la liste des cl�s pour ensuite aller chercher
		// la valeur de chaque cl�
		Set<Character> cles = mapChoixPossibles.keySet();
		for (Character cle : cles) {
			Integer valeur = mapChoixPossibles.get(cle);
			System.out.println("key :" + cle + " value : " + valeur);
		}

		// Solution 2 : r�cuprer la liste des couples cle / valeur
		Set<Entry<Character, Integer>> listeCouples = mapChoixPossibles.entrySet();
		for (Entry<Character, Integer> couple : listeCouples) {
			System.out.println("key : " + couple.getKey() + " value : " + couple.getValue());
		}

		System.out.println(listeCouples);
	}

	/**
	 * Map contenant les propositions de r�ponses pour les questions � choix
	 * multiples.
	 */
	private static void lanceur5() {
		final int A = 65;
		Map<Character, Integer> mapPropositions = new HashMap<Character, Integer>();

		for (int i = 0; i < 4; i++) {
			char caract = (char) (A + i);
			mapPropositions.put(caract, i);
		}
		System.out.println(mapPropositions);
		System.out.println(mapPropositions.entrySet());
		System.out.println(mapPropositions.get((char) A)); // values());//
															// entrySet());
	}

	/**
	 * on propose � j une combinaison : 3 x 7 3 propositions sont �tablies A :
	 * 21 B : 22 C : 25 l'utilisateur saisit A on compare A � la bonne r�ponse
	 * Si : bonne r�ponse : Bravo (+1 pt) Sinon : Mauvaise r�ponse
	 */
	/**
	 * Cette m�thode permet de demander � l'utilisateur, suivant le nombre de
	 * questions d�finies, la bonne r�ponse � l'op�ration pos�e, un nombre
	 * pr�d�fini de propositions lui est soumis. Le r�sultat est indiqu� en fin
	 * de partie.
	 */
	private static void lanceur4() {
		Scanner sc = new Scanner(System.in);

		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // M�lange des �l�ments de la liste

		for (int i = 0; i < NBR_QUESTIONS; i++) {
			System.out.println();
			int compteur = i + 1;
			System.out.println("Question : " + compteur + " sur : " + NBR_QUESTIONS);
			System.out.println("Voici la multiplication : " + lC.get(i).getNbr1() + " x " + lC.get(i).getNbr2());
			System.out.println("Parmi les propositions ci-dessous : ");

			Map<Character, Integer> reponsesPossibles = Outils.mapReponsesPossibles(lC.get(i), NBR_PROPOSITIONS);
			// for(int j = 0 ; j < reponsesPossibles.size() ; j++) {
			System.out.println(reponsesPossibles.entrySet());
			// }
			System.out.println("Quelle est la bonne r�ponse ?");

			char reponse = sc.next().charAt(0);
			if (reponsesPossibles.get(Character.toUpperCase(reponse)) == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
				System.out.println("BRAVO ! C'est la bonne r�ponse !!!");
				compteurPoints++;
				nbrReponsesDonnees++;
			} else {
				System.out.println("D�sol�, ce n'est pas la bonne r�ponse !");
				nbrReponsesDonnees++;
			}
		}
		System.out.println("");
		System.out.println("--------------- R�sulats : -------------------");
		System.out.println("Nombre de r�ponses donn�es : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions pos�es, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) r�ponse(s).");
		// afficherCombinaison(lC);
	}

	/**
	 * Cette m�thode permet d'afficher une combinaison dans un ordre al�atoire,
	 * par exemple : 3 x 7 ou 7 x 3.
	 */
	private static void Lanceur3() {
		int nbr = 3;
		List<Integer> lI = new ArrayList<Integer>();
		Combinaisons c = new Combinaisons(3, 7);
		lI = Outils.questionChoixMultiples(c, nbr);
		Collections.sort(lI);
		for (Integer i : lI) {
			System.out.println(i);
		}
	}

	/**
	 * Cette m�thode permet de demander � l'utilisateur, suivant le nombre de
	 * questions d�finies, la bonne r�ponse � l'op�ration pos�e, tant que
	 * l'utilisateur n'a pas donn� la bonne r�ponse, on redemande la bonne
	 * r�ponse. Le r�sultat du nombre de tentatives (�chec/r�ussite) est indiqu�
	 * en fin de partie.
	 */
	private static void lanceur2() {

		Scanner sc = new Scanner(System.in);

		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // M�lange des �l�ments de la liste

		for (int i = 0; i < NBR_QUESTIONS; i++) {
			boolean reponseOk = false;
			System.out.println("Quel est le r�sultat de : " + lC.get(i).getNbr1() + " x " + lC.get(i).getNbr2() + " ?");
			while (!reponseOk) {
				while (!sc.hasNextInt()) {
					sc.next();
				}
				int resultat = sc.nextInt();
				if (resultat == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
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
		System.out.println("Nombre de r�ponses donn�es : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions pos�es, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) r�ponse(s).");
		// afficherCombinaison(lC);
	}

	/**
	 * Cette m�thode permet d'afficher la liste de toutes les combinaisons
	 * g�n�r�es par la m�thode : genererListeDeCombinaisons().
	 */
	private static void lanceur1() {

		// System.out.println("Quel est le r�sultat de : a x b ?");
		// System.out.println("R�sultat : ");

		List<Combinaisons> lC = Outils.genererListeDeCombinaisons();

		afficherCombinaison(lC);
	}

	private static void afficherCombinaison(List<Combinaisons> lC) {

		for (int i = 0; i < lC.size(); i++) {

			if (i < 9) { // indice de i : 0 � 8
				System.out.println(
						(i + 1) + "   : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}

			if (i > 8 && i < 99) { // indice de i : 9 � 99
				System.out.println(
						(i + 1) + "  : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}

			if (i > 98) { // indice de i : 99 � ...
				System.out.println(
						(i + 1) + " : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
		}
	}
}
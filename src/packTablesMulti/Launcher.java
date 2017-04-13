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

		System.out.println("Bonjour Charlène !");
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
		Collections.shuffle(lC); // Mélange des éléments de la liste
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
		System.out.println("--------------- Résulats : -------------------");
		
		strategie.afficherMode();
		
		System.out.println("Nombre de réponses données : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions posées, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) réponse(s).");
		// afficherCombinaison(lC);
	}

	@SuppressWarnings("unused")
	private static void lanceur7() {
		Scanner sc = new Scanner(System.in);

		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // Mélange des éléments de la liste
		for (int i = 0; i < NBR_QUESTIONS; i++) {

			Combinaisons combinaison = lC.get(i);
			boolean reponseJuste = false;

			if (MODE == 0) {

				// cas avec valeur
				System.out.println(
						"Quel est le résultat de : " + combinaison.getNbr1() + " x " + combinaison.getNbr2() + " ?");
				while (!reponseJuste) {
					while (!sc.hasNextInt()) {
						sc.next();
					}
					int resultat = sc.nextInt();
					if (resultat == (combinaison.getNbr1() * combinaison.getNbr2())) {
						System.out.println("BRAVO ! C'est la bonne réponse !!!");
						reponseJuste = true;
					} else {
						System.out.println("Ce n'est pas la bonne réponse, essaye encore !");
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
				System.out.println("Quelle est la bonne réponse ?");

				char reponse = sc.next().charAt(0);
				if (reponsesPossibles
						.get(Character.toUpperCase(reponse)) == (combinaison.getNbr1() * combinaison.getNbr2())) {
					System.out.println("BRAVO ! C'est la bonne réponse !!!");
					reponseJuste = true;

				} else {
					System.out.println("Désolé, ce n'est pas la bonne réponse !");
				}

			}

			nbrReponsesDonnees++;
			if (reponseJuste) {
				compteurPoints++;
			}

		}

		System.out.println("");
		System.out.println("--------------- Résulats : -------------------");

		if (MODE == 0) {
			System.out.println("Vous avez joué avec le jeux VALEUR");
		} else {
			System.out.println("Vous avez joué avec le jeux CHOIX");
		}

		System.out.println("Nombre de réponses données : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions posées, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) réponse(s).");
		// afficherCombinaison(lC);

	}


	private static void lanceur6() {

		int nbr = 3;
		Map<Character, Integer> mapChoixPossibles = new HashMap<Character, Integer>();
		Combinaisons c = new Combinaisons(3, 7);
		mapChoixPossibles = Outils.mapReponsesPossibles(c, nbr);

		// Solution 1 : récupérer la liste des clés pour ensuite aller chercher
		// la valeur de chaque clé
		Set<Character> cles = mapChoixPossibles.keySet();
		for (Character cle : cles) {
			Integer valeur = mapChoixPossibles.get(cle);
			System.out.println("key :" + cle + " value : " + valeur);
		}

		// Solution 2 : récuprer la liste des couples cle / valeur
		Set<Entry<Character, Integer>> listeCouples = mapChoixPossibles.entrySet();
		for (Entry<Character, Integer> couple : listeCouples) {
			System.out.println("key : " + couple.getKey() + " value : " + couple.getValue());
		}

		System.out.println(listeCouples);
	}

	/**
	 * Map contenant les propositions de réponses pour les questions à choix
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
	 * on propose à j une combinaison : 3 x 7 3 propositions sont établies A :
	 * 21 B : 22 C : 25 l'utilisateur saisit A on compare A à la bonne réponse
	 * Si : bonne réponse : Bravo (+1 pt) Sinon : Mauvaise réponse
	 */
	/**
	 * Cette méthode permet de demander à l'utilisateur, suivant le nombre de
	 * questions définies, la bonne réponse à l'opération posée, un nombre
	 * prédéfini de propositions lui est soumis. Le résultat est indiqué en fin
	 * de partie.
	 */
	private static void lanceur4() {
		Scanner sc = new Scanner(System.in);

		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // Mélange des éléments de la liste

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
			System.out.println("Quelle est la bonne réponse ?");

			char reponse = sc.next().charAt(0);
			if (reponsesPossibles.get(Character.toUpperCase(reponse)) == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
				System.out.println("BRAVO ! C'est la bonne réponse !!!");
				compteurPoints++;
				nbrReponsesDonnees++;
			} else {
				System.out.println("Désolé, ce n'est pas la bonne réponse !");
				nbrReponsesDonnees++;
			}
		}
		System.out.println("");
		System.out.println("--------------- Résulats : -------------------");
		System.out.println("Nombre de réponses données : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions posées, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) réponse(s).");
		// afficherCombinaison(lC);
	}

	/**
	 * Cette méthode permet d'afficher une combinaison dans un ordre aléatoire,
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
	 * Cette méthode permet de demander à l'utilisateur, suivant le nombre de
	 * questions définies, la bonne réponse à l'opération posée, tant que
	 * l'utilisateur n'a pas donné la bonne réponse, on redemande la bonne
	 * réponse. Le résultat du nombre de tentatives (échec/réussite) est indiqué
	 * en fin de partie.
	 */
	private static void lanceur2() {

		Scanner sc = new Scanner(System.in);

		List<Combinaisons> lC = Outils.genererListeDeCombinaisonsSansDoublon();
		Collections.shuffle(lC); // Mélange des éléments de la liste

		for (int i = 0; i < NBR_QUESTIONS; i++) {
			boolean reponseOk = false;
			System.out.println("Quel est le résultat de : " + lC.get(i).getNbr1() + " x " + lC.get(i).getNbr2() + " ?");
			while (!reponseOk) {
				while (!sc.hasNextInt()) {
					sc.next();
				}
				int resultat = sc.nextInt();
				if (resultat == (lC.get(i).getNbr1() * lC.get(i).getNbr2())) {
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
		System.out.println("Nombre de réponses données : " + nbrReponsesDonnees + " sur : " + NBR_QUESTIONS
				+ " questions posées, soit : " + (nbrReponsesDonnees - compteurPoints) + " mauvaise(s) réponse(s).");
		// afficherCombinaison(lC);
	}

	/**
	 * Cette méthode permet d'afficher la liste de toutes les combinaisons
	 * générées par la méthode : genererListeDeCombinaisons().
	 */
	private static void lanceur1() {

		// System.out.println("Quel est le résultat de : a x b ?");
		// System.out.println("Résultat : ");

		List<Combinaisons> lC = Outils.genererListeDeCombinaisons();

		afficherCombinaison(lC);
	}

	private static void afficherCombinaison(List<Combinaisons> lC) {

		for (int i = 0; i < lC.size(); i++) {

			if (i < 9) { // indice de i : 0 à 8
				System.out.println(
						(i + 1) + "   : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}

			if (i > 8 && i < 99) { // indice de i : 9 à 99
				System.out.println(
						(i + 1) + "  : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}

			if (i > 98) { // indice de i : 99 à ...
				System.out.println(
						(i + 1) + " : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
		}
	}
}
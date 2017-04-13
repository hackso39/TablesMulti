package packTablesMulti;

import java.util.Map;
import java.util.Scanner;

public class StrategyQuestionChoix extends StrategyQuestion {

	@Override
	public boolean poserQuestion(Combinaisons combinaison, Integer nombreQuestion, Scanner sc, int numeroQuestion) {

		boolean reponseTrouve = false;

		// cas avec choix
		System.out.println();
		int compteur = numeroQuestion + 1;
		System.out.println("Question : " + compteur + " sur : " + nombreQuestion);
		System.out.println("Voici la multiplication : " + combinaison.getNbr1() + " x " + combinaison.getNbr2());
		System.out.println("Parmi les propositions ci-dessous : ");

		Map<Character, Integer> reponsesPossibles = Outils.mapReponsesPossibles(combinaison, nombreQuestion);
		// for(int j = 0 ; j < reponsesPossibles.size() ; j++) {
		System.out.println(reponsesPossibles.entrySet());
		// }
		System.out.println("Quelle est la bonne r�ponse ?");
		
		// a revoir !
//		while (!reponsesPossibles.containsKey(sc.next().charAt(0))) {
//			sc.next();
//		}
		
		char reponse = sc.next().charAt(0);
		if (reponsesPossibles.get(Character.toUpperCase(reponse)) == (combinaison.getNbr1() * combinaison.getNbr2())) {
			System.out.println("BRAVO ! C'est la bonne r�ponse !!!");
			reponseTrouve = true;
		} else {
			System.out.println("D�sol�, ce n'est pas la bonne r�ponse !");
		}

		return reponseTrouve;
	}

	@Override
	public void afficherMode() {
		System.out.println("Vous avez jou� avec le jeux CHOIX");
	}
}

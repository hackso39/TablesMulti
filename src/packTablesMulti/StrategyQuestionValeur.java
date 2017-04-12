package packTablesMulti;

import java.util.Scanner;

public class StrategyQuestionValeur extends StrategyQuestion {

	@Override
	public boolean poserQuestion(Combinaisons combinaison, Integer nombreQuestion, Scanner sc, int numeroQuestion) {
		
		boolean reponseTrouve = false;
		
		System.out.println(
				"Quel est le r�sultat de : " + combinaison.getNbr1() + " x " + combinaison.getNbr2() + " ?");
		while (!reponseTrouve) {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			int resultat = sc.nextInt();
			if (resultat == (combinaison.getNbr1() * combinaison.getNbr2())) {
				System.out.println("BRAVO ! C'est la bonne r�ponse !!!");
				reponseTrouve = true;
			} else {
				System.out.println("Ce n'est pas la bonne r�ponse, essaye encore !");
			}
		}
		
		return reponseTrouve;
		
	}

	@Override
	public void afficherMode() {
		System.out.println("Vous avez jou� avec le jeux VALEUR");
	}
}

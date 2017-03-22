package packTablesMulti;

import java.util.List;

public class Launcher {

	public static void main(String[] args) {

//		lanceur1(); // genererListeDeCombinaisons
		lanceur2();
		
	}

	private static void lanceur2() {

		Outils outils = new Outils();
		
		List<Combinaisons> lC = outils.genererListeDeCombinaisonsSansDoublon();
		
		afficherCombinaison(lC);
	}

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
				System.out.println((i +1 )+ "   : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
			
			if(i > 8 && i < 99) { // indice de i : 9 à 99
				System.out.println((i +1 )+ "  : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
			
			if(i > 98) { // indice de i : 99 à ...
				System.out.println((i +1 )+ " : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
			}
		}
	}
}

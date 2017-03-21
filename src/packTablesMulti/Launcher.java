package packTablesMulti;

import java.util.List;

public class Launcher {

	public static void main(String[] args) {

		lanceur1();
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
			System.out.println(i + " : combinaison : (" + lC.get(i).getNbr1() + ", " + lC.get(i).getNbr2() + ")");
		}
	}

}

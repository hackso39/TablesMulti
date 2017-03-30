package packTablesMulti;

import java.util.ArrayList;
import java.util.List;

public class Outils {
	
	private static final int NBR1 = 0;
	private static final int NBR2 = 11;

//	private List<ArrayList<Integer>> listeDeListe = new ArrayList<ArrayList<Integer>>();
//	private List<Integer> liste = new ArrayList<Integer>();
	
	/**
	 * Constructeur
	 */
	public Outils() {
		super();
	}
	
//	public void genererNombresDansListe() {
//		
//		for(int i = 0 ; i < nbr2 ; i++) {
//			
//			for(int j = i ; j < nbr2 ; j++) {
//				liste.add(j);   // a revoir car quand i = 3 j ira de 3 à 10
//			}
//			listeDeListe.add((ArrayList<Integer>) liste);
//		}
//	}
	
	/**
	 * Génération de toutes les combinaisons nbr1 x nbr2
	 * Exemple de 0 x 0 à 10 x 10 (voir suivant les valeurs des contstantes nbr1 et nbr2)
	 * 
	 * @return List<Combinaisons> contient la liste de toutes les combinaisons.
	 */
	public List<Combinaisons> genererListeDeCombinaisons(){
		List<Combinaisons> lC = new ArrayList<Combinaisons>();
		
		for(int i = 0 ; i < NBR2 ; i++) {			//	i = 0
			for(int j = 0 ; j < NBR2 ; j++) {		//	j = 0
				Combinaisons c = new Combinaisons();	//	creation variable c
				c.setNbr1(i);						//	nbr1 = 0
				c.setNbr2(j);						//	nbr2 = 0
				lC.add(c);							//	lC 
			}
		}
		return lC;
	}
	
	/**
	 * Génération de toutes les combinaisons nbr1 x nbr2 sans les 
	 * doublons (Exemple : 1 x 2 présent alors que 2 x 1 n'est pas généré !)
	 * Exemple de 0 x 0 à 10 x 10 (voir suivant les valeurs des contstantes nbr1 et nbr2)
	 * 
	 * @return List<Combinaisons> contient la liste de toutes les combinaisons.
	 */
	public List<Combinaisons> genererListeDeCombinaisonsSansDoublon(){
		List<Combinaisons> lC = new ArrayList<Combinaisons>();
		
		for(int i = 0 ; i < NBR2 ; i++) {			//	i = 0
			for(int j = i ; j < NBR2 ; j++) {		//	j = 0
				Combinaisons c = new Combinaisons();	//	creation variable c
				c.setNbr1(i);						//	nbr1 = 0
				c.setNbr2(j);						//	nbr2 = 0
				lC.add(c);							//	lC 
			}
		}
		lC = permutationAleatoireNombres(lC);
		return lC;
	}
	
	/**
	 * Cette méthode permute de manière aléatoire une combinaison 
	 * (Exemple de combinaison : 3 x 7 devient après permutation : 7 x 3). Toute
	 * la liste passée en paramètre est traitée de cette manière.
	 * 
	 * @param lC contient la liste des combinaisons dans l'ordre croissant.
	 * @return List<Combinaisons> contient la liste des combinaisons 
	 * 		   permutées 
	 */
	private List<Combinaisons> permutationAleatoireNombres(List<Combinaisons> lC) {
		
		for(int i = 0 ; i <lC.size() ; i++) {
			if(Math.random() < 0.5) {
				int tempo = lC.get(i).getNbr1();
				lC.get(i).setNbr1(lC.get(i).getNbr2());
				lC.get(i).setNbr2(tempo);
			}
		}
		return lC;
	}

	/**
	 * Cette méthode permet d'avoir pour une combinaison donnée (exemple : 3 x 5), un nombre 
	 * de résultat possible suivant le paramètre : nbr. 
	 * 
	 * @param c
	 * @param nbr
	 * @return List<Integer>
	 */
	public List<Integer> questionChoixMultiples(Combinaisons c, int nbr) {
		nbr--;
		List<Integer> listeNombres = new ArrayList<Integer>();
		
		int resultat = c.getNbr1() * c.getNbr2(); 
		listeNombres.add(resultat);
		int resultPlusMoinsUn = 0;
		for(int i = 1 ; i < nbr + 1 ; i++) {
			if(Math.random() < 0.5) {
				resultPlusMoinsUn = Math.abs(resultat - i);
			} else {
				resultPlusMoinsUn = resultat + i;
			}
			listeNombres.add(resultPlusMoinsUn);
		}
		return listeNombres;
	}
	
	/**
	 * 
	 */
	
	/**
	 * getters qui retourne la valeur de NBR1
	 * @return int qui contient la valeur de la constante NBR1
	 */
	public static int getNBR1() {
		return NBR1;
	}

	/**
	 * getters qui retourne la valeur de NBR2
	 * @return int qui contient la valeur de la constante NBR2
	 */
	public static int getNBR2() {
		return NBR2;
	}
}
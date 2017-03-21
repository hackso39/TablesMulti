package packTablesMulti;

import java.util.ArrayList;
import java.util.List;

public class Outils {
	
	private static final int nbr1 = 0;
	private static final int nbr2 = 11;

//	private List<ArrayList<Integer>> listeDeListe = new ArrayList<ArrayList<Integer>>();
//	private List<Integer> liste = new ArrayList<Integer>();
	
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
	

	public List<Combinaisons> genererListeDeCombinaisons(){
		List<Combinaisons> lC = new ArrayList<Combinaisons>();
		
		for(int i = 0 ; i < nbr2 ; i++) {			//	i = 0
			for(int j = 0 ; j < nbr2 ; j++) {		//	j = 0
				Combinaisons c = new Combinaisons();	//	creation variable c
				c.setNbr1(i);						//	nbr1 = 0
				c.setNbr2(j);						//	nbr2 = 0
				lC.add(c);							//	lC 
			}
		}
		return lC;
	}
	
	public static int getNbr1() {
		return nbr1;
	}
	
	public static int getNbr2() {
		return nbr2;
	}
}


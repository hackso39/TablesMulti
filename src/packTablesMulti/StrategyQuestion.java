package packTablesMulti;

import java.util.Scanner;

public abstract class StrategyQuestion {

	public abstract boolean poserQuestion(Combinaisons combinaison, Integer nombreQuestion, Scanner sc, int numeroQuestion);
	
	public abstract void afficherMode();
	
}

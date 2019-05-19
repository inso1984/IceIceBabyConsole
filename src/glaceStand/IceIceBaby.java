package glaceStand;

public class IceIceBaby {

	public static void main(String[] args) {

		int spielen = 1;
		
		while(spielen == 1 ) {
			
		System.out.println("Willkommen bei Ice Ice Baby...\n\n"
				+ "Du hast 10 Tage (Runden) Zeit, dein Verkaufstalent als Eis-Verkäufer unter Beweis zu stellen.\n"
				+ "Entscheide Anhand der Wettervorhersage wie viele Waffeln und wie viel Liter Eis\n"
				+ "für den aktuellen Tag benötigt werden. Liegst du mit deiner Planung richtig wirst du\n"
				+ "Gewinn erwirtschaften. Liegst du falsch wirst du Verlust machen.\n\n"
				+ "----------------------------------------------------------------------------------------------");
	
		Game game = new Game();
		
		game.round();
		
		game.endResult();
		
		spielen = game.newGame();
		
		}
	}

}

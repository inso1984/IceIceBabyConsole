package glaceStand;

import java.util.Scanner;

public class Game {

	// Zähler Anzahl Runden
	private int round = 1;
	private int visitors;
	private double win;
	private double completeWin;
	private Scanner scanner = new Scanner(System.in);
	// Ablauf Runde
	public void round() {
		for (int i = 0; i < 10; i++) {
			// Textausgabe Tag x(=aktuelle Runde) als Eisverkäufer
			System.out.println("Tag Nummer " + round);

			// Textausgabe Wetter und Temperatur aus Logic-Klasse
			Logic logic = new Logic();
			visitors = logic.setAdjectives();
			logic.setTemperature();

			// Eingabe Waffeln, Eis und Preis
			System.out.println("\nWie viele Waffeln möchtest du Einkaufen?");
			
			int buyWaves = this.scanner.nextInt();
			System.out.println("\nWie viel Liter Eis möchtest du Einkaufen? Ein Liter Eis ergibt ca. 12 Kugeln.");
			int buyIce = this.scanner.nextInt();
			System.out.println("\nWie viel soll eine Kugel Eis kosten?");
			double wishedPrice = this.scanner.nextDouble();

			// Anzahl Besucher anhand des Eispreises korrigieren
			visitors = logic.checkPrice(visitors, wishedPrice);

			// Auswertung(Berechnungen) der aktuellen Runde
			win = logic.calculateRound(buyWaves, buyIce, visitors, wishedPrice);

			// Ausgabe Rundenergebnis
			System.out.println("\nDu hattest " + visitors + " Besucher.");
			System.out.println("\nDu hast " + String.format("%1.2f CHF", win) + " CHF Gewinn erzielt.");
			System.out.println(
					"\n----------------------------------------------------------------------------------------------");

			round++;
			completeWin = completeWin + win;

		}
		scanner.close();
	}

	// Ausgabe Endergebnis Spiel

	public void endResult() {
		Logic logic = new Logic();
		logic.checkWin(completeWin);
	}

	// Neues Spiel starten?
	public int newGame() {
		System.out.println("\nMöchtest du noch einemal spielen? Drücke 'j' für ja und 'n' für nein.");
		char newGame = this.scanner.next().charAt(0);

		if (newGame == 'j' || newGame == 'J') {
			return 1;
		} else {
			System.out.println("Vielen Dank und auf Wiedersehen!");
			return 0;
		}
	}

}

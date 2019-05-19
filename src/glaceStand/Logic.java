package glaceStand;

public class Logic {

	private int temperature;
	private double buyPriceWaves = 0.15;
	private double buyPriceIce = 1.50;

	public void setTemperature() {

		this.temperature = (int) (Math.random() * 19) + 20;
		System.out.println("Heute sind es " + temperature + " Grad Celsius.");

	}

	public int setAdjectives() {
				
		int number = (int) (Math.random() * 4) + 1;
		int visitors = (int) (Math.random() * 150) + 80; 

		switch (number) {

		case 1:
			if (this.temperature < 23) {
				System.out.println("Es ist stürmisch und am Nachmittag soll es regnen.");
				visitors = (int)(Math.round(visitors+visitors*0.25));
			} else if (this.temperature >= 23 && this.temperature <= 28) {
				System.out.println("Hin und wieder sind leichte Schauer zu erwarten.");
				visitors = (int)(Math.round(visitors+visitors*0.5));			
			} else {
				System.out.println("Es soll einen kurzen Schauer am Nachmittag geben.");
				visitors = (int)(Math.round(visitors+visitors*0.75));
			}
			break;
		case 2:
			if (this.temperature < 27) {
				System.out.println("Am Vormittag gibt es einen leichten Nieselregen.");
				visitors = (int)(Math.round(visitors+visitors*0.6));
			} else {
				System.out.println("Die Sonne scheint den ganzen Tag und es bleibt trocken.");
				visitors = (int)(Math.round(visitors+visitors*0.8));
			}
			break;
		case 3:
			if (this.temperature < 25) {
				System.out.println("Es ist stark bewölkt und windet sehr.");
				visitors = (int)(Math.round(visitors+visitors*0.3));
			} else if (this.temperature >= 25 && this.temperature <= 35) {
				System.out.println("Es ist ab und zu leicht bewölkt.");
				visitors = (int)(Math.round(visitors+visitors*0.7));
			} else {
				System.out.println("Heute wird es sehr heiss!");
				visitors = (int)(Math.round(visitors+visitors*1.2));	
			}
			break;
		case 4:
			if (this.temperature < 23) {
				System.out.println("Gegen Mittag soll ein starkes Gewitter aufziehen.");
				visitors = (int)(Math.round(visitors+visitors*0.15));
			} else if (this.temperature >= 23 && this.temperature <= 30) {
				System.out.println("Am Vormittag bleibt es trocken während es ab Mittag immer mal wieder regnen kann.");
				visitors = (int)(Math.round(visitors+visitors*0.4));
			} else {
				System.out.println("Der Himmel ist Wolkenfrei und die Sonne scheint den ganzen Tag.");
				visitors =(int)(Math.round(visitors+visitors*0.9));
			}
		}
		return visitors;
	}
	
	public int checkPrice(int visitors, double wishedPrice) {
		int visitorsNew = visitors;
		
		if(wishedPrice < 3.0) {
			visitorsNew = visitors;
		} else if (wishedPrice < 6.0) {
			visitorsNew = visitors/3;
		} else {
			visitorsNew = 0;
		} 
		return visitorsNew;
	}
	
	
	public float calculateRound(int boughtWaves, int boughtIce, int visitors, double wishedPrice) {
		int soldWaves;
		float soldIce;
		float win;
				
		if(boughtWaves > visitors) {
			soldWaves = visitors;
		} else {
			soldWaves = boughtWaves;
		}
		
		if(boughtIce*12 > (float) (visitors * 1.5)) {
			soldIce = (float) (visitors*1.5);
		} else {
			soldIce = boughtIce*12;
		}
		
		if(soldWaves < soldIce) {
			soldIce = (float) (soldWaves*1.5);
		}
		
		win = (float) (Math.round((soldIce*wishedPrice)-(boughtWaves*buyPriceWaves)-(boughtIce-buyPriceIce)));
		
		return win;
	}
	
	public void checkWin(double completeWin) {
		
		if(completeWin < 0) {
			System.out.println("Du hast leider " + String.format("%1.2f CHF", completeWin) + " CHF Verlust gemacht und damit verloren.");
		} else {
			System.out.println("Du hast " + String.format("%1.2f CHF", completeWin) + " CHF Gewinn erzielt. Herzlichen Glückwunsch du hast gewonnen!");
		}
		
	}
	
}

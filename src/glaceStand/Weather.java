package glaceStand;

public class Weather {

	private int temperature;
	private double fact = 0.2;

	public void setTemperature() {

		this.temperature = (int) (Math.random() * 19) + 20;
		System.out.println("Heute sind es " + temperature + " Grad Celsius.");

	}

	public double setAdjectives() {
				
		int number = (int) (Math.random() * 4) + 1;

		switch (number) {

		case 1:
			if (this.temperature < 23) {
				System.out.println("Es ist stürmisch und am Nachmittag soll es regnen.");
				fact = 0.25;
			} else if (this.temperature >= 23 && this.temperature <= 28) {
				System.out.println("Hin und wieder sind leichte Schauer zu erwarten.");
				fact = 0.5;			
			} else {
				System.out.println("Es soll einen kurzen Schauer am Nachmittag geben.");
				fact = 0.75;
			}
			break;
		case 2:
			if (this.temperature < 27) {
				System.out.println("Am Vormittag gibt es einen leichten Nieselregen.");
				fact = 0.6;
			} else {
				System.out.println("Die Sonne scheint den ganzen Tag und es bleibt trocken.");
				fact = 0.8;
			}
			break;
		case 3:
			if (this.temperature < 25) {
				System.out.println("Es ist stark bewölkt und windet sehr.");
				fact = 0.3;
			} else {
				System.out.println("Es ist ab und zu leicht bewölkt.");
				fact = 0.7;
			}
			break;
		case 4:
			if (this.temperature < 23) {
				System.out.println("Gegen Mittag soll ein starkes Gewitter aufziehen.");
				fact = 0.15;
			} else if (this.temperature >= 23 && this.temperature <= 28) {
				System.out.println("Am Vormittag bleibt es trocken während es ab Mittag immer mal wieder regnen kann.");
				fact = 0.4;
			} else {
				System.out.println("Der Himmel ist Wolkenfrei und die Sonne scheint den ganzen Tag.");
				fact = 0.9;
			}
		}
		return fact;
	}

}

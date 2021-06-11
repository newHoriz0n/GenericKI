package ki;

import java.util.HashMap;

public class Ziel {

	private HashMap<String, Umstand> umstaende;
	private HashMap<String, Double> gewichtung;

	public Ziel(HashMap<String, Umstand> umstaende, HashMap<String, Double> gewichte) {
		if (umstaende.keySet().size() != gewichte.keySet().size()) {
			throw new IllegalArgumentException("Anzahle der Einträge in umstaende und gewichte muss gleich sein!");
		}

		this.umstaende = umstaende;
		this.gewichtung = gewichte;
	}

	public double calcErfuellung(Situation aktuell) {
		double sum = 0;

		for (String eu : umstaende.keySet()) {
			sum += Math.pow(aktuell.getUmstaende().get(eu).getValue() - umstaende.get(eu).getValue(), 1)
					* gewichtung.get(eu);
		}

		return sum;
	}

	public HashMap<String, Umstand> getUmstaende() {
		return umstaende;
	}

}

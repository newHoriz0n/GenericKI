package ki;

import java.util.ArrayList;
import java.util.List;

public class ErfahrungsPool {

	private List<Erfahrung> erfahrungen;

	public ErfahrungsPool() {
		this.erfahrungen = new ArrayList<Erfahrung>();
	}

	public Erfahrung getPassendsteErfahrung(Situation aktuell) {

		Erfahrung passendste = null;
		double passung = Double.MAX_VALUE;

		for (Erfahrung e : erfahrungen) {
			double p = e.getAusgangsSituation().getAehnlichkeit(aktuell);
			if (p < passung) {
				passendste = e;
			}
		}

		return passendste;
	}

	public List<Erfahrung> getPassendeErfahrungen(Situation situation, int size, double hochstAbweichung) {

		List<Erfahrung> passende = new ArrayList<>(); // Liste der zur aktuellen Situation ähnlichsten Erfahrungen
		List<Double> passungen = new ArrayList<>(); // Liste der zugehörigen Wertigkeiten (0 ist am besten)

		for (Erfahrung e : erfahrungen) {

			// sind, und ggf. unähnlichere Löschen

			double p = e.getAusgangsSituation().getAehnlichkeit(situation); // Berechne die Ähnlichkeit der
																			// Ausgangssituation der Erfahrung zur
																			// akt. Situation
//			System.out.println(p);
			if (Math.abs(p) <= Math.abs(hochstAbweichung)) { // Wenn Erfahrung der Ähnlichkeit nach in Frage kommt...
//				System.out.println(e);

				int index = 0;

				while (index < passende.size()) {
					if (Math.abs(p) <= Math.abs(passungen.get(index))) {
						index++;
					} else {
						break;
					}
				}

				passende.add(index, e); // Setze Erfahrung auf Position
				passungen.add(index, p);

				if (passende.size() > size) {
					passende.remove(0); // Lösche letzte
					passungen.remove(0);
				}

			}

		}

		return passende;

	}

	public void addErfahrung(Erfahrung erfahrung) {
		if(!erfahrungen.contains(erfahrung)) {
			erfahrungen.add(erfahrung);
		}else {
			System.out.println("hatten wir schon");
			System.out.println(erfahrungen.size());
		}
	}

}

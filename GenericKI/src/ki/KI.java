package ki;

import java.util.List;

public class KI {

	private Model m;
	private Ziel z;

	private ErfahrungsPool ep;

	private Situation letzteErgebnisSituation;
	private Situation letzteAusgangsSituation;
	private Entscheidung letzteAktion;

	public KI(Model m) {
		this.m = m;
		this.ep = new ErfahrungsPool();
	}

	public void setZiel(Ziel z) {
		this.z = z;
	}

	public void updateKI() {

		letzteAusgangsSituation = m.getSituation();
//		System.out.println(letzteAusgangsSituation);
		calcAktion(letzteAusgangsSituation);
		m.updateModel();
		letzteErgebnisSituation = m.getSituation();
		System.out.println(letzteErgebnisSituation);

		ep.addErfahrung(new Erfahrung(letzteAusgangsSituation, letzteAktion, letzteErgebnisSituation));

	}

	private void calcAktion(Situation situation) {
		System.out.println(z.calcErfuellung(situation));
		List<Erfahrung> aehnliche = ep.getPassendeErfahrungen(situation, 3, 2);

		Erfahrung beste = null;
		double besteAbweichung = Double.MAX_VALUE; // Beste mögliche Wertung wäre 0.

		// Suche beste Aktion aus Erfahrungen zu Ähnlichen Situationen
		for (Erfahrung e : aehnliche) {
//			System.out.println(e);
			double wert = z.calcErfuellung(e.getErgebnisSituation());
//			System.out.println(wert);
			if (Math.abs(wert) < Math.abs(besteAbweichung)) {
				beste = e;
				besteAbweichung = wert;
			}
		}

		boolean bestehendeErfahrungNutzen = false;

		System.out.println(aehnliche.size());
		
		if (aehnliche.size() >= 3) {

			if (beste != null) {
			System.out.println("b: " + besteAbweichung);
				double erfuellung = z.calcErfuellung(situation);
			System.out.println("z: " + erfuellung);
				if (Math.abs(besteAbweichung) <= Math.abs(erfuellung)) {
					bestehendeErfahrungNutzen = true;
				}
			}
		}

		if (bestehendeErfahrungNutzen) {
			System.out.println("Nutze Erfahrung!");
			beste.getEntscheidung().getEntscheidungsAktion().runAktion();
			letzteAktion = beste.getEntscheidung();
		} else {
			System.out.println("Keine Erfahrungen vorhanden!");
			Entscheidung e = m.getOptionsPool().getRandomEntscheidung();
			e.getEntscheidungsAktion().runAktion();
			letzteAktion = e;
		}

	}

}

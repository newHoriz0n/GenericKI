package ki;

public class Ergebnis implements Comparable<Ergebnis> {

	private double bewertung;

	@Override
	public int compareTo(Ergebnis o) {
		if (o.bewertung < bewertung) {
			return -1;
		} else if (o.bewertung > bewertung) {
			return 1;
		}
		return 0;
	};
	
	public double getBewertung() {
		return bewertung;
	}

}

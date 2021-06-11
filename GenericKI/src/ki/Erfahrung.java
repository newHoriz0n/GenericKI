package ki;

public class Erfahrung {

	private Situation ausgangsSituation;
	private Entscheidung e;
	private Situation ergebnisSituation;

	public Erfahrung(Situation ausgangsSituation, Entscheidung e, Situation ergebnisSituation) {

		this.ausgangsSituation = ausgangsSituation;
		this.e = e;
		this.ergebnisSituation = ergebnisSituation;
	}

	public Situation getAusgangsSituation() {
		return ausgangsSituation;
	}

	public Entscheidung getEntscheidung() {
		return e;
	}

	public Situation getErgebnisSituation() {
		return ergebnisSituation;
	}

	@Override
	public String toString() {
		return ausgangsSituation + ": " + e + " -> " + ergebnisSituation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ausgangsSituation == null) ? 0 : ausgangsSituation.hashCode());
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((ergebnisSituation == null) ? 0 : ergebnisSituation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Erfahrung other = (Erfahrung) obj;
		if (ausgangsSituation == null) {
			if (other.ausgangsSituation != null)
				return false;
		} else if (!ausgangsSituation.equals(other.ausgangsSituation))
			return false;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (ergebnisSituation == null) {
			if (other.ergebnisSituation != null)
				return false;
		} else if (!ergebnisSituation.equals(other.ergebnisSituation))
			return false;
		return true;
	}

}

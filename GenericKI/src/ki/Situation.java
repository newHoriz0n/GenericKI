package ki;

import java.util.HashMap;

public class Situation {

	private HashMap<String, Umstand> umstaende;

	public Situation(HashMap<String, Umstand> umstaende) {
		this.umstaende = umstaende;
	}

	public Situation(Situation s) {
		this.umstaende = new HashMap<>(s.umstaende);
	}

	public HashMap<String, Umstand> getUmstaende() {
		return umstaende;
	}

	public double getAehnlichkeit(Situation s) {
		double sum = 0;

		for (String eu : umstaende.keySet()) {
			sum += Math.pow(s.getUmstaende().get(eu).getValue() - umstaende.get(eu).getValue(), 1);
		}

		return sum;
	}

	public String toString() {
		return umstaende.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((umstaende == null) ? 0 : umstaende.hashCode());
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
		Situation other = (Situation) obj;
		if (umstaende == null) {
			if (other.umstaende != null)
				return false;
		} else if (!umstaende.equals(other.umstaende))
			return false;
		return true;
	}

}

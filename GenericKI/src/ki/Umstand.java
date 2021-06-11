package ki;

public class Umstand {

	// TODO: generifizieren
	private double value;
	
	public Umstand(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
	public String toString() {
		return "" + value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Umstand other = (Umstand) obj;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
	
	
}

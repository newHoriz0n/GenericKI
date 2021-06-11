package ki;

public class Entscheidung {

	private String bezeichnung;
	private Aktion a;
	
	public Entscheidung(String bezeichnung, Aktion a) {
		this.bezeichnung = bezeichnung;
		this.a = a;
	}
	
	public Aktion getEntscheidungsAktion() {
		return this.a;
	}

	
	@Override
	public String toString() {
		return bezeichnung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
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
		Entscheidung other = (Entscheidung) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}
	
	
	
}

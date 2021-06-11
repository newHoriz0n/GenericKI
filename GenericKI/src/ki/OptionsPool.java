package ki;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptionsPool {

	private  List<Entscheidung> entscheidungen;
	private Random r = new Random();
	
	public OptionsPool () {
		this.entscheidungen = new ArrayList<Entscheidung>();
	}
	
	public void addEntscheidungsOption(Entscheidung e) {
		entscheidungen.add(e);
	}
	
	public List<Entscheidung> getEntscheidungen() {
		return entscheidungen;
	}
	
	public Entscheidung getRandomEntscheidung() {
		return entscheidungen.get(r.nextInt(entscheidungen.size()));
	}
	
}

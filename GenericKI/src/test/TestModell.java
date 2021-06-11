package test;

import java.util.HashMap;

import ki.Aktion;
import ki.Entscheidung;
import ki.Model;
import ki.OptionsPool;
import ki.Situation;
import ki.Umstand;

public class TestModell extends Model {

	private double richtung = 1;
	private double position = 0;
	private double speed = 0;

	public void bremsen() {
		this.speed += -1;
	}

	public void beschleunigen() {
		this.speed += 1;
	}

	public void umdrehen() {
		this.richtung *= -1;
	}

	public void stoppen() {
//		this.speed = 0;
	}

	public double getPosition() {
		return position;
	}

	@Override
	public OptionsPool loadOptionsPool() {
		OptionsPool op = new OptionsPool();
		op.addEntscheidungsOption(new Entscheidung("Bremsen", new Aktion() {

			@Override
			public void runAktion() {
				bremsen();
				System.out.println("bremsen!");
			}
		}));
		op.addEntscheidungsOption(new Entscheidung("Beschleunigen", new Aktion() {

			@Override
			public void runAktion() {
				beschleunigen();
				System.out.println("beschleunigen!");
			}
		}));
		op.addEntscheidungsOption(new Entscheidung("Umdrehen", new Aktion() {

			@Override
			public void runAktion() {
				umdrehen();
				System.out.println("umdrehen!!");
			}
		}));
//		op.addEntscheidungsOption(new Entscheidung("Stoppen", new Aktion() {
//			
//			@Override
//			public void runAktion() {
//				stoppen();
//				System.out.println("stoppen!");
//			}
//		}));
		return op;
	}

	@Override
	public Situation extractSituation() {
		HashMap<String, Umstand> umstande = new HashMap<>();
		umstande.put("Speed", new Umstand(speed));
		umstande.put("Position", new Umstand(position));
		umstande.put("Richtung", new Umstand(richtung));
		Situation s = new Situation(umstande);
		return s;
	}

	@Override
	public void update() {
		position += speed * richtung;
	}

}

package test;

import java.util.HashMap;

import ki.KI;
import ki.Umstand;
import ki.Ziel;

public class Main {

	public static void main(String [] args) {
						
		// Ziel definieren
		
		HashMap<String, Umstand> zielUmstaende = new HashMap<>();
		zielUmstaende.put("Position", new Umstand(10.0));
//		zielUmstaende.put("Speed", new Umstand(0.0));
		HashMap<String, Double> zielGewichtung = new HashMap<>();
		zielGewichtung.put("Position", 10.0);
//		zielGewichtung.put("Speed", 1.0);
		Ziel z = new Ziel(zielUmstaende, zielGewichtung);
		
		// Modell anlegen
		TestModell t = new TestModell();
		
		// KI anlegen
		KI k = new KI(t);
		k.setZiel(z);
		
		while(true) {
			
			k.updateKI();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}

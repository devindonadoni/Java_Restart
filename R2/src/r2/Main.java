package r2;

import java.util.HashMap;

import boundary.Console;
import business.Config;
import business.ConfigRepository;

public class Main {
	
	private static final String FILENAME = "config.txt";
	
	public static void main(String[] args) {
		ConfigRepository configRepo = new ConfigRepository(FILENAME); //lettura del file config.txt in una classe dedicata
		HashMap<String, String> mappa = configRepo.leggi();
		

		// 2. Inizializza il singleton Config con i valori letti
		Config cfg = Config.getInstance();
		cfg.inizializza(mappa);
		System.out.println(cfg.toString());
		
		
		

		new Console().execute();

	}

}

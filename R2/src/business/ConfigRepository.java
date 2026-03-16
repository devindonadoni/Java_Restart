package business;

import java.util.HashMap;
import java.util.List;

import util.FileUtil;

public class ConfigRepository {
	private String filename;
	
	
	public ConfigRepository(String filename) {
		super();
		this.filename = filename;
		
		/*
		String nome = list[0].substring(list[0].indexOf("=") + 1).trim();
		String sTaglio = list[1].substring(list[1].indexOf("=") + 1).trim();
		String sMateriale = list[2].substring(list[2].indexOf("=") + 1).trim();
		
		float taglio = Float.parseFloat(sTaglio);
		float materiale = Float.parseFloat(sMateriale);
		
		this.ordine = nome;
		this.costoTaglio = taglio;
		this.costoMateriale = materiale;
		*/
		 
	}
	
	public HashMap<String, String> leggi(){
		HashMap<String, String> a = new HashMap<String, String>();
		
		String nomeFile = filename;
		
		FileUtil util = new FileUtil();
		List<String> list = util.readTextFile(nomeFile);
		
		for(String item : list) {
			String[] items = item.split("=");
			a.put(items[0].trim(), items[1].trim());
		}
		
		return a;
	}
	
	
}

package business;

import java.util.HashMap;

public class Config {
	private static Config istanza;
	private String ordine;
	private float costoTaglio;
	private float costoMateriale;
	
	private Config() {}
	
	
	public static Config getInstance() {
		if(istanza == null) {
			istanza = new Config();
		}
		return istanza;
	}


	public void inizializza(HashMap<String, String> mappa) {
		this.ordine = mappa.get("file_ordine");
		this.costoTaglio = Float.parseFloat(mappa.get("costo_taglio"));
		this.costoMateriale = Float.parseFloat(mappa.get("costo_materiale"));
		
	}

	public String getPathOrdine() {
		return ordine;
	}

	public float getCostoTaglio() {
		return costoTaglio;
	}


	public float getCostoMateriale() {
		return costoMateriale;
	}


	@Override
	public String toString() {
		return "Config [ordine=" + ordine + ", costoTaglio=" + costoTaglio + ", costoMateriale=" + costoMateriale + "]";
	}
	
	
}

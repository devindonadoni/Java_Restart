package business;

import java.util.List;

public class Config {
	public String pathOrdini;
	public float costoTaglio;
	public float costoMateriale;
	
	public Config(List<String> list) {
		String path = list.get(0).substring(list.get(0).indexOf("=") + 1).trim();
		String costoTaglio = list.get(1).substring(list.get(1).indexOf("=") + 1).trim();
		String costoMateriale = list.get(2).substring(list.get(2).indexOf("=") + 1).trim();
		
		this.pathOrdini = path;
		this.costoTaglio = Float.parseFloat(costoTaglio);
		this.costoMateriale = Float.parseFloat(costoMateriale);
	}

	@Override
	public String toString() {
		return "Config [pathOrdini=" + pathOrdini + ", costoTaglio=" + costoTaglio + ", costoMateriale="
				+ costoMateriale + "]";
	}
}

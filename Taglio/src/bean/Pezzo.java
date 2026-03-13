package bean;

public class Pezzo {
	private float dimensione;
	private Forma forma;
	
	public Pezzo(String item) {
		String[] items = item.split(":");
		this.forma = Forma.valueOf(items[0].trim().toUpperCase());
		this.dimensione = Float.parseFloat(items[1]);
	}
	
	public enum Forma{
		TRIANGOLO,
		CERCHIO,
		QUADRATO,
		ESAGONO,
		PENTAGONO,
		RETTANGOLO
	}
	
	public Pezzo(float dimensione, Forma forma) {
		this.dimensione = dimensione;
		this.forma = forma;
	}

	public float getDimensione() {
		return dimensione;
	}

	public void setDimensione(float dimensione) {
		this.dimensione = dimensione;
	}

	public Forma getForma() {
		return forma;
	}

	public void setForma(Forma forma) {
		this.forma = forma;
	}
	
	
	
	
}

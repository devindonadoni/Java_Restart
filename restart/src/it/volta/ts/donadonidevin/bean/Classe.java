package it.volta.ts.donadonidevin.bean;

public class Classe {
	private String sezione;
	private int anno;
	private Classe item;
	
	public Classe(String sezione, int anno) {
		this.sezione = sezione;
		this.anno = anno;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Classe getItem() {
		return item;
	}

	public void setItem(Classe item) {
		this.item = item;
	}
	
	
}

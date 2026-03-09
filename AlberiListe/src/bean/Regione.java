package bean;

import java.util.List;

public class Regione {
	private String nome;
	private String sigla;
	private String regione;
	private String codice;
	private String capoluogo;
	private int abitanti;
	private String[] province = new String[3];
	
	public Regione(String regione) {
		String[] items = regione.split(",");
		
		this.nome = items[0].replace("\"", "");
		this.sigla = items[1].replace("\"", "");
		this.regione = items[2].replace("\"", "");
		this.codice = items[3].replace("\"", "");
		this.capoluogo = items[4].replace("\"", "");
		String sAbitanti = items[5].replace("\"", "");
		this.abitanti = Integer.parseInt(sAbitanti);
		this.province[0] = items[6].replace("\"", "");
		this.province[1] = items[7].replace("\"", "");
		this.province[2] = items[8].replace("\"", "");

	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getCapoluogo() {
		return capoluogo;
	}

	public void setCapoluogo(String capoluogo) {
		this.capoluogo = capoluogo;
	}

	public int getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(int abitanti) {
		this.abitanti = abitanti;
	}

	public String[] getProvince() {
		return province;
	}

	public void setProvince(String[] province) {
		this.province = province;
	}
	
	public String toString() {
	    return "Provincia: " + nome + " | Regione: " + regione + "  Codice: " + codice + " | " +" (Sigla: " + sigla + ", Capoluogo: " + capoluogo + " Abitanti: " + abitanti + " )" +
	    		"\n \tCitta' importanti: [" + province[0] + ", " + province[1] + ", " + province[2] + "]";
	}
}

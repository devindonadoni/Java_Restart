package business;

import java.util.List;

import bean.Regione;
import boundary.Albero;

public class Biz {
	Albero tree = new Albero();
	
	public void addToTree(List<String> list) {
		
		for(String item : list) {
			Regione regione = new Regione(item);
			
			/*
			 System.out.println(regione.getNome() + regione.getSigla() + regione.getRegione() + regione.getCodice() + regione.getCapoluogo() + regione.getAbitanti());
			for(String i : regione.getProvince()) {
				System.out.println(i);
			}
			 */
			
			tree.addToTree(regione);
		}
	}
}

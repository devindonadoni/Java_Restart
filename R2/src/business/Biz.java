package business;

import java.util.ArrayList;
import java.util.List;

import bean.Ordine;
import bean.Pezzo;
import bean.Pezzo.Forma;
import util.FileUtil;

public class Biz {
	ArrayList<Ordine> arrayListOrdini = new ArrayList<Ordine>();
	private String pathFile;
	private float costoTaglio;
	private float costoMateriale;
	
	public void fetchConfig() {
		String pathFile = Config.getInstance().getPathOrdine();
		float costoTaglio = Config.getInstance().getCostoTaglio();
		float costoMateriale = Config.getInstance().getCostoMateriale();
		
		this.pathFile = pathFile;
		this.costoTaglio = costoTaglio;
		this.costoMateriale = costoMateriale;
		
	}
	
	public void populateList() {
		fetchConfig();
		List<String> util = FileUtil.readTextFile(pathFile);
		
		ArrayList<Pezzo> arrayList = new ArrayList<Pezzo>();
		
		for(String item : util.subList(1, util.size())) {
			String[] items = item.split(":");
			
			int numeroPezzi = Integer.parseInt(items[2]);
			while(numeroPezzi != 0) {
				Pezzo newPezzo = new Pezzo(item);
				arrayList.add(newPezzo);
				numeroPezzi --;
			}
		}
		
		Ordine ordine = new Ordine(arrayList, util.get(0).substring(util.get(0).indexOf("E") + 1).trim());
		arrayListOrdini.add(ordine);
	}
	
	public void printList() {
		for(Ordine item : arrayListOrdini) {
			System.out.println("Numero Ordine" + item.getNumeroOrdine());
			for(Pezzo var : item.getListaPezzi()) {
				System.out.println(var.toString());
			}
		}
	}
	
	
	//SUMMARY PRINT ORDER PER ORDER
	public void printSummary() {
		for(Ordine ordine : arrayListOrdini) {
			mergeListSingleOrder(ordine);
		}
	}
	
	//PRINT ONLY THE GIVEN ORDER OBJECT
	public void mergeListSingleOrder(Ordine ordine) {
		Forma last = null;
		for(Pezzo toCheckPezzo : ordine.getListaPezzi()) {
			int n = 0;
			for(Pezzo pezzo : ordine.getListaPezzi()) {
				if(toCheckPezzo.getForma() == pezzo.getForma() && toCheckPezzo.getDimensione() == pezzo.getDimensione()) {
					n ++;
				}
			}
			if(last != toCheckPezzo.getForma()) {
				System.out.println(toCheckPezzo.getForma() + " " + toCheckPezzo.getDimensione() + " " + n);
			}
			last = toCheckPezzo.getForma();
		}
	}
	
	
	
}

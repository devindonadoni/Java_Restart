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
	private List<String> util; 
	
	public void fetchConfig() {
		String pathFile = Config.getInstance().getPathOrdine();
		float costoTaglio = Config.getInstance().getCostoTaglio();
		float costoMateriale = Config.getInstance().getCostoMateriale();
		List<String> util = FileUtil.readTextFile(pathFile);
		
		this.pathFile = pathFile;
		this.costoTaglio = costoTaglio;
		this.costoMateriale = costoMateriale;
		this.util = util;
	}
	
	public void populateSingleOrderList(int startIdx, int finalIdx) {		
		ArrayList<Pezzo> arrayList = new ArrayList<Pezzo>();
		
		for(String item : util.subList(startIdx + 1, finalIdx + 1)) {
			String[] items = item.split(":");
			
			int numeroPezzi = Integer.parseInt(items[2]);
			while(numeroPezzi != 0) {
				Pezzo newPezzo = new Pezzo(item);
				arrayList.add(newPezzo);
				numeroPezzi --;
			}
		}
		
		Ordine ordine = new Ordine(arrayList, util.get(startIdx).substring(util.get(startIdx).indexOf("E") + 1).trim());
		arrayListOrdini.add(ordine);
	}
	
	public void populateAllOrderList() {
		fetchConfig();
		
		int finalIndex = 0;
		System.out.println(util.size());
		while(finalIndex < util.size() - 1) {
			int i = finalIndex;
			while(!util.get(i).contains("ORDINE")) {
				i ++;
			}
			
			int startIndex = i;
			i++;
			
			try {
				while(!util.get(i).contains("ORDINE")) 
					i ++;
			}catch(IndexOutOfBoundsException e) {	
			}
			finally {
				finalIndex = i - 1;
			}
			
			populateSingleOrderList(startIndex, finalIndex);
		}
		
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
			System.out.println("========================================");
			System.out.println("\tORDINE: " + ordine.getNumeroOrdine());
			System.out.println("========================================");
			mergeListSingleOrder(ordine);
			System.out.println("----------------------------------------");
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

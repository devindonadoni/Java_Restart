package business;

import java.util.ArrayList;
import java.util.List;

import bean.Ordine;
import bean.Pezzo;
import util.FileUtil;

public class Biz {
	//************************************************
    private FormaElaborataEventListener formaElaborataListener;
    private RiepilogoEventListener riepilogoEventListener;

    public void setFormaElaborataListener(FormaElaborataEventListener l) { this.formaElaborataListener = l; }
    public void setRiepilogoEventListener(RiepilogoEventListener l) { this.riepilogoEventListener = l; }
	//************************************************

	
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
	
	
	//SUMMARY PRINT ORDER PER ORDER
	public void printSummary() {
		for(Ordine ordine : arrayListOrdini) {
			mergeListSingleOrder(ordine);
		}
	}
	
	//PRINT ONLY THE GIVEN ORDER OBJECT
	public void mergeListSingleOrder(Ordine ordine) {
		float costoTaglio = 0;
	    String ultimaFormaRilevata = ""; 
	    int i = 0;
	    int pezziTotali = 0;
	    int materialeTotale = 0;
	    int perimetroTotale = 0;
	    int costoTotale = 0;

	    for (Pezzo toCheckPezzo : ordine.getListaPezzi()) {
	        int n = 0;
	        String formaCorrente = toCheckPezzo.getForma().getNome(); 

	        for (Pezzo pezzo : ordine.getListaPezzi()) {
	            if (formaCorrente.equals(pezzo.getForma().getNome()) && 
	                toCheckPezzo.getDimensione() == pezzo.getDimensione()) {
	                n++;
	            }
	        }

	        if (!ultimaFormaRilevata.equals(formaCorrente)) {
	        	double area = toCheckPezzo.getForma().getArea(toCheckPezzo.getDimensione());
	        	double perimetro = toCheckPezzo.getForma().getPerimetro(toCheckPezzo.getDimensione());
	        	
	        	
	        	formaElaborataListener.onFormaElaborata(ordine.getNumeroOrdine(), toCheckPezzo, area, perimetro, i, i, n);
	            i++;
                pezziTotali += n;
                perimetroTotale += perimetro;
                materialeTotale += area;
	        }
	        
	        ultimaFormaRilevata = formaCorrente;
	    }
	    if (riepilogoEventListener != null) {
	        riepilogoEventListener.onRiepilogo(
	            ordine.getNumeroOrdine(), 
	            pezziTotali, 
	            materialeTotale, 
	            perimetroTotale, 
	            costoTotale
	        );
	    }
	}
	
}

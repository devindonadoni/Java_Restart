package boundary;

import java.util.ArrayList;
import java.util.List;

import bean.Ordine;
import bean.Pezzo;
import business.Biz;
import business.Config;
import util.FileUtil;

public class Console {
	
	Biz biz = new Biz();	
	
	
	public void execute() {
		
		biz.setFormaElaborataListener((num, pezzo, area, perimetro, costo, i, n) -> {
			if (i == 0) {
				System.out.println("==========================================");	
				System.out.println("---- ELABORAZIONE ORDINE #" + num + " ----");	
				System.out.println("==========================================");	
			}
			System.out.printf("[%d] %-10s | Dim: %.2f cm\n", i, pezzo.getForma().getNome(), pezzo.getDimensione());
	        System.out.printf("    Area: %.2f cm² | Perimetro: %.4f cm\n", area, perimetro);
	        System.out.printf("    Costo Unitario: %.2f €\n", costo);
	        System.out.printf("    Quantita: " + n);
	        System.out.println("\n---------------------------------------\n");
		});
		
		biz.setRiepilogoEventListener((num, totPezzi, totMat, totPerc, totCosto) -> {
	        System.out.println("\n>>>> RIEPILOGO FINALE ORDINE #" + num);
	        System.out.println("Pezzi totali:     " + totPezzi);
	        System.out.printf("Materiale usato:  %.2f cm²\n", totMat);
	        System.out.printf("Percorso laser:   %.2f cm\n", totPerc);
	        System.out.printf("COSTO TOTALE:     %.2f €\n", totCosto);
	        System.out.println("========================================\n");
	    });
		
		
		
		biz.populateAllOrderList();
		biz.printSummary();
		//biz.printList();
		
	}

}

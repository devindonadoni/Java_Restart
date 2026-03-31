package business;

import java.util.EventListener;
import bean.Pezzo;

public interface FormaElaborataEventListener extends EventListener {
    // Questo metodo verrà chiamato per ogni singolo pezzo calcolato
	
    void onFormaElaborata(String numeroOrdine, Pezzo pezzo, double area, double perimetro, 
    		double costoUnitario, int progressivo, int quantita);
}
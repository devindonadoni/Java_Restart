package business;

import java.util.EventListener;

public interface RiepilogoEventListener extends EventListener {
    // Questo verrà chiamato solo alla fine dell'ordine
    void onRiepilogo(String numeroOrdine, int pezziTotali, double materialeTotale, 
    		double perimetroTot, double costoTotale);
}
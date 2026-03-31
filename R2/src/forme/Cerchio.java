package forme;

public class Cerchio implements Forma {
    @Override
    public double getArea(float d) { return Math.round(Math.PI * Math.pow(d, 2) * 100.0) / 100.0; }
    @Override
    public double getPerimetro(float d) { return Math.round(2 * Math.PI * d * 100.0) / 100.0; }
    @Override
    public String getNome() { return "CERCHIO"; }
}
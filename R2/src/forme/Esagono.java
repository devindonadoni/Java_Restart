package forme;

public class Esagono implements Forma{
	@Override
    public double getArea(float d) { return Math.round((3 * Math.sqrt(3) / 2) * Math.pow(d, 2)* 100.0) / 100.0; }
    @Override
    public double getPerimetro(float d) { return d * 6; }
    @Override
    public String getNome() { return "ESAGONO"; }

}

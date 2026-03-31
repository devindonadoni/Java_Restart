package forme;

public class Quadrato implements Forma{
	@Override
    public double getArea(float d) { return d * d; }
    @Override
    public double getPerimetro(float d) { return 4 * d; }
    @Override
    public String getNome() { return "QUADRATO"; }
}

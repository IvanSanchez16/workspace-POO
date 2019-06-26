package figuras;

public class Forma {
	protected String Color;
	protected Punto Centro;
	protected String Forma;
	
	public Forma(String color, Punto centro, String forma) {
		Color = color;
		Centro = centro;
		Forma = forma;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public Punto getCentro() {
		return Centro;
	}

	public void moveCentro(int x,int y) {
		Centro.setX(x);
		Centro.setY(y);
	}

	public String getForma() {
		return Forma;
	}

	public void setForma(String forma) {
		Forma = forma;
	}
	
	@Override
	public String toString(){
		return ("Color: "+Color+"\tCordenadas: "+Centro+"\tForma: "+Forma);
	}
	
}

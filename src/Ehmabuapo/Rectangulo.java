package Ehmabuapo;

public class Rectangulo extends Forma {
	protected int LMayor;
	protected int LMenor;
	
	public Rectangulo(String color, Punto centro, String forma, int lMayor, int lMenor) {
		super(color, centro, forma);
		LMayor = lMayor;
		LMenor = lMenor;
		
	}

	public int getLMayor() {
		return LMayor;
	}

	public void setLMayor(int lMayor) {
		LMayor = lMayor;
	}

	public int getLMenor() {
		return LMenor;
	}

	public void setLMenor(int lMenor) {
		LMenor = lMenor;
	}
	
	public double calcularArea(){
		return LMayor*LMenor;
	}
	
	public double calcularPerimetro(){
		return ((2*LMayor)+(2*LMenor));
	}
	
	public void modificarEscala(float Escala){
		
	}
}

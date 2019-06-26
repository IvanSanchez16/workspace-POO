package unidad3;

public abstract class Control_Remoto {
	protected float Alcance;
	protected String Tipo_bateria;
	protected int Num_botones;
	
	public Control_Remoto(float alcance,String tipo_bateria,int num_botones){
		Alcance=alcance;
		Tipo_bateria=tipo_bateria;
		Num_botones=num_botones;
	}

	public float getAlcance() {
		return Alcance;
	}

	public void setAlcance(float alcance) {
		Alcance = alcance;
	}

	public String getTipo_bateria() {
		return Tipo_bateria;
	}

	public void setTipo_bateria(String tipo_bateria) {
		Tipo_bateria = tipo_bateria;
	}

	public int getNum_botones() {
		return Num_botones;
	}

	public void setNum_botones(int num_botones) {
		Num_botones = num_botones;
	}
	public abstract void EnviaSenial(Object señal);
}

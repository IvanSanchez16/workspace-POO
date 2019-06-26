package Restaurante;

public class Reservaciones {
	private String Fecha;
	private int NdPersonas;
	private Mesas M;
	
	public Reservaciones (String fecha,int ndPersonas,Mesas m) {
		Fecha=fecha;
		NdPersonas=ndPersonas;
		if(!m.isDisponibilidad()) {
		M=m;
		M.setDisponibilidad(false);
		}

	}
}

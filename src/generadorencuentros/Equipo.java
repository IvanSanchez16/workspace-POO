package generadorencuentros;

import java.util.Vector;

public class Equipo {
	Vector<Equipo> E=new Vector<Equipo>();
	Vector<Integer> H=new Vector<Integer>();
	Vector<Integer> A=new Vector<Integer>();
	private int NumeroEquipo;
	
	public Equipo(int ne) {
		NumeroEquipo=ne;
	}
	
	public void AgregarDuelo(int hora,int act,Equipo rival) {
		E.addElement(rival);
		H.addElement(hora);
		A.addElement(act);
	}
	
	public boolean VerificarRival(Equipo rival) {
		boolean aux=true;
		for(int i=0;i<E.size();i++) {
			aux=E.get(i).getNumeroEquipo()==rival.getNumeroEquipo()?false:aux;
		}
		return aux;
	}
	
	public boolean VerificarHora(int hora) {
		boolean aux=true;
		for(int i=0;i<H.size();i++) {
			aux=H.get(i)==hora?false:aux;
		}
		return aux;
	}
	
	public boolean VerificarActividad(int actividad) {
		boolean aux=true;
		for(int i=0;i<A.size();i++) {
			aux=A.get(i)==actividad?false:aux;
		}
		return aux;
	}

	public int getNumeroEquipo() {
		return NumeroEquipo;
	}
}

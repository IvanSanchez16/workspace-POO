package Restaurante;

public class Mesas {
	Administracion A=new Administracion();
	
	private int NDeMesa;
	private int Capacidad;
	private Meseros MeseroEncargado;
	private boolean Disponibilidad=true;

	public Mesas(int nDeMesa,int capacidad,Meseros meseroEncargado) {
		NDeMesa=nDeMesa;
		Capacidad = capacidad;
		MeseroEncargado=meseroEncargado;
		A.M.get(meseroEncargado.UbicarMesero(meseroEncargado.getNDeEmpleado())).AsignarMesa(nDeMesa, capacidad);
	}
	public Mesas(int nDeMesa,int capacidad) {
		NDeMesa=nDeMesa;
		Capacidad = capacidad;
	}
	public Mesas() {
		this(0,0,null);
	}

	public Meseros getMeseroEncargado() {
		return MeseroEncargado;
	}

	public void setMeseroEncargado(Meseros meseroEncargado) {
		MeseroEncargado = meseroEncargado;
	}

	public int getNDeMesa() {
		return NDeMesa;
	}

	public void setNDeMesa(int nDeMesa) {
		NDeMesa = nDeMesa;
	}

	public int getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}
	public boolean isDisponibilidad() {
		return Disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		Disponibilidad = disponibilidad;
	}
	public String DisponibilidadEscrito() {
		if(Disponibilidad) {
			return "Esta Disponible";
		}else {
			return "No esta disponible";
		}
	}
	
	
	@Override
	public String toString() {
		return ("Número de mesa: "+NDeMesa+"\t Número de comesales: "+Capacidad+"\t Mesero Encargado: "+MeseroEncargado.getNombre()+ "\t Disponibilidad: "
	+DisponibilidadEscrito());
	}
	
	
	
	
}

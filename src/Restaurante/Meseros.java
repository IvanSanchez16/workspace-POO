package Restaurante;
import java.util.Vector;
public class Meseros {
	Administracion A=new Administracion();
	
	private String Nombre;
	private int Telefono;
	private String Direccion;
	private int NDeEmpleado;
	private Vector<Mesas> MA=new Vector<Mesas>();
	private int CtrlM=0;
	
	public Meseros(String nombre, int telefono, String direccion, int nDeEmpleado) {
		Nombre = nombre;
		Telefono = telefono;
		Direccion = direccion;
		NDeEmpleado = nDeEmpleado;
	}
	public Meseros(){
		this("",0,"",0);
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public int getNDeEmpleado() {
		return NDeEmpleado;
	}

	public void setNDeEmpleado(int nDeEmpleado) {
		NDeEmpleado = nDeEmpleado;
	}
	
	public void AsignarMesa(int NDeMesa,int Capacidad) {
		MA.addElement(new Mesas(NDeMesa,Capacidad));
	}
	
	public int UbicarMesero(String nDeMesero) {
		for(int i=0;i<A.M.size();i++) {
			if(nDeMesero.equalsIgnoreCase(A.M.get(i).getNombre()))
				return i;
		}
		return 999;
	}
	public int UbicarMesero(int nDeMesero) {
		for(int i=0;i<A.M.size();i++) {
			if(nDeMesero==A.M.get(i).getNDeEmpleado())
				return i;
		}
		return 999;
	}
	public String ImprimirMesasDisponibles() {
		String g="";
		for(int i=0;i<MA.size();i++)
			g+=MA.get(i).getNDeMesa()+" ";
		return g;
	}
	
	
	@Override
	public String toString() {
		return "Nombre del mesero: "+Nombre+"\t Teléfono: "+Telefono+"\t Direccion: "+Direccion+"\t Número de empleado: "+NDeEmpleado+"\t Mesas asignadas: "+ImprimirMesasDisponibles();
	}
}

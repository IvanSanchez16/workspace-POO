package ruletarusa;

public class Persona {
	private String Nombre;
	private boolean Vivo;
	
	public Persona(String nombre,boolean vivo){
		Nombre=nombre;
		Vivo=vivo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public boolean isVivo() {
		return Vivo;
	}

	public void setVivo(boolean vivo) {
		Vivo = vivo;
	}
	
	
}

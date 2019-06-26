package pfarchivostxt;

public class Alumno {
	public static final int TAMANIO=153;
	
	private String Nombre;
	private String Carrera;
	private int Edad;
	private String Matricula;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCarrera() {
		return Carrera;
	}
	public void setCarrera(String licenciatura) {
		Carrera = licenciatura;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public static int getTamanio() {
		return TAMANIO;
	}
	@Override
	public String toString() {
		return "Alumno [Nombre=" + Nombre + ", Licenciatura=" + Carrera + ", Edad=" + Edad + ", Matricula="
				+ Matricula + "]";
	}
	
}

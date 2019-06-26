package CajaAhorrosITC;

public class Persona {
	int NIdentidad;
	String Nombre;
	String PApellido;
	String SApellido;
	long TelCasa;
	long TelMovil;
	String Domicilio;
	
	public Persona(int nIdentidad, String nombre, String pApellido, String sApellido, long telCasa, long telMovil) {
		NIdentidad = nIdentidad;
		Nombre = nombre;
		PApellido = pApellido;
		SApellido = sApellido;
		TelCasa = telCasa;
		TelMovil = telMovil;
	}
	
	public Persona(int nIdentidad, String nombre, String pApellido, String sApellido, long telCasa, long telMovil, String domicilio) {
		NIdentidad = nIdentidad;
		Nombre = nombre;
		PApellido = pApellido;
		SApellido = sApellido;
		TelCasa = telCasa;
		TelMovil = telMovil;
		Domicilio = domicilio;
	}
	
	public int getNIdentidad() {
		return NIdentidad;
	}

	public void setNIdentidad(int nIdentidad) {
		NIdentidad = nIdentidad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPApellido() {
		return PApellido;
	}

	public void setPApellido(String pApellido) {
		PApellido = pApellido;
	}

	public String getSApellido() {
		return SApellido;
	}

	public void setSApellido(String sApellido) {
		SApellido = sApellido;
	}

	public long getTelCasa() {
		return TelCasa;
	}

	public void setTelCasa(long telCasa) {
		TelCasa = telCasa;
	}

	public long getTelMovil() {
		return TelMovil;
	}

	public void setTelMovil(long telMovil) {
		TelMovil = telMovil;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Persona [NIdentidad=" + NIdentidad + ", Nombre=" + Nombre + ", PApellido=" + PApellido + ", SApellido="
				+ SApellido + ", TelCasa=" + TelCasa + ", TelMovil=" + TelMovil + "]";
	}

}

package CajaAhorrosITC;

public class ClientesAhorradores extends Persona{
	CuentaAhorro CuentaAhorro;

	public ClientesAhorradores(int nIdentidad, String nombre, String pApellido, String sApellido, long telCasa,
			long telMovil, CajaAhorrosITC.CuentaAhorro cuentaAhorro) {
		super(nIdentidad, nombre, pApellido, sApellido, telCasa, telMovil);
		CuentaAhorro = cuentaAhorro;
		
	}

	public ClientesAhorradores(int nIdentidad, String nombre, String pApellido, String sApellido, long telCasa,
			long telMovil, CajaAhorrosITC.CuentaAhorro cuentaAhorro,String domicilio) {
		super(nIdentidad, nombre, pApellido, sApellido, telCasa, telMovil,domicilio);
		CuentaAhorro = cuentaAhorro;
	}
	
	
	
}

package CajaAhorrosITC;

public class CuentaAhorro {
	Fecha FechaApertura;
	double Saldo;
	Persona Dueño;
	
	public CuentaAhorro(Fecha fechaApertura, double saldo, Persona dueño) {
		FechaApertura = fechaApertura;
		Saldo = saldo;
		Dueño = dueño;
	}
	
	public CuentaAhorro(Fecha fechaApertura, double saldo) {
		FechaApertura = fechaApertura;
		Saldo = saldo;
		Dueño = null;
	}
	
	public Fecha getFechaApertura() {
		return FechaApertura;
	}

	public void setFechaApertura(Fecha fechaApertura) {
		FechaApertura = fechaApertura;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	public Persona getDueño() {
		return Dueño;
	}

	public void setDueño(Persona dueño) {
		Dueño = dueño;
	}
	
	public void CobrarInteresMensual() {
		Saldo= Saldo*.9859;
	}
}

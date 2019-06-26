package CajaAhorrosITC;

public class CuentaAhorro {
	Fecha FechaApertura;
	double Saldo;
	Persona Due�o;
	
	public CuentaAhorro(Fecha fechaApertura, double saldo, Persona due�o) {
		FechaApertura = fechaApertura;
		Saldo = saldo;
		Due�o = due�o;
	}
	
	public CuentaAhorro(Fecha fechaApertura, double saldo) {
		FechaApertura = fechaApertura;
		Saldo = saldo;
		Due�o = null;
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

	public Persona getDue�o() {
		return Due�o;
	}

	public void setDue�o(Persona due�o) {
		Due�o = due�o;
	}
	
	public void CobrarInteresMensual() {
		Saldo= Saldo*.9859;
	}
}

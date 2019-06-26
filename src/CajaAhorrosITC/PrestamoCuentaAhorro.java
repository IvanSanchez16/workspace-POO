package CajaAhorrosITC;

public class PrestamoCuentaAhorro extends Prestamo {

	ClientesAhorradores Cliente;
	
	public PrestamoCuentaAhorro(int nPrestamo, ClientesAhorradores solicitante, double valor, Fecha fechaAutorizacion,
			Fecha fechaPago, int mesesPagos) throws ExcepcionesPrestamo {
		super(nPrestamo, valor, fechaAutorizacion, fechaPago, mesesPagos);
	}
	

	public void PagarCuentaAhorro() {
		if(Cliente.CuentaAhorro.getSaldo()<Valor)
			throw new IllegalArgumentException("El solicitante no cuenta con el saldo suficiente para realizar la transacción");
		else {
			Cliente.CuentaAhorro.setSaldo(Cliente.CuentaAhorro.getSaldo()-Valor);
			}
	}
	
	public void SumarIntereses(Fecha fecha,int NPago) {
		if(Cliente.CuentaAhorro.getSaldo()>5000)
			ValoresMensuales.set(NPago-1,(ValoresMensuales.get(NPago-1)*1.05));
		else
			ValoresMensuales.set(NPago-1,(ValoresMensuales.get(NPago-1)*1.15));
		if(!FechaPago.get(NPago-1).VerificarPlazo(fecha)) {
			ValoresMensuales.set(NPago-1, ValoresMensuales.get(NPago-1)+(FechaPago.get(NPago-1).DiferenciaDeDias(fecha)*0.05));
		}			
	}
}

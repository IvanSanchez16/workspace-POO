package CajaAhorrosITC;
import java.util.*;

public class Prestamo {
	boolean Pagado=false;
	static Fecha FechaMaximaDeAutorizacion=null;
	static double Suma;
	static double ValorMaximo;
	int NPrestamo;
	Persona Solicitante;
	double Valor;
	ArrayList<Fecha> FechaPago= new ArrayList<Fecha>(12);
	Fecha FechaAutorizacion;
	Fecha FechaTentativa;
	int MesesPagos;
	ArrayList<Double> ValoresMensuales= new ArrayList<Double>(12);
	
	public Prestamo(int nPrestamo, Persona solicitante, double valor, Fecha fechaAutorizacion, Fecha fechaPago,int mesesPagos)throws ExcepcionesPrestamo {
		if(fechaAutorizacion.Verificar20PrimerosDias())
			if(fechaAutorizacion.VerificarPlazo(FechaMaximaDeAutorizacion))
				FechaAutorizacion = fechaAutorizacion;
			else
				throw new ExcepcionesPrestamo("La fecha de autorización sobrepasa la fecha de autorización máxima");
		else
			throw new ExcepcionesPrestamo("La fecha de autorización debe existir dentro de los primeros 20 días del mes");	
		if(nPrestamo>0)
			NPrestamo = nPrestamo;
		else
			throw new ExcepcionesPrestamo("El número de prestamo debe ser mayor a 0");
		Solicitante = solicitante;
		if(valor>0)
			Valor = valor;
		else
			throw new ExcepcionesPrestamo("El valor del prestamo debe ser mayor a 0");
		FechaPago.add(fechaPago);
		LlenarFechasDePago(mesesPagos);
		LlenarValoresMensuales(mesesPagos);
		MesesPagos= mesesPagos;
		if(valor > 100000)
			FechaTentativa = FechaAutorizacion.SumarFecha(10);
		else
			FechaTentativa = FechaAutorizacion.SumarFecha(7);	
		Suma+=valor;
		if(Suma>ValorMaximo)
			throw new ExcepcionesPrestamo("Se alcanzó el límite monetario para los prestamos");
	}
	
	public Prestamo(int nPrestamo, double valor, Fecha fechaAutorizacion, Fecha fechaPago,int mesesPagos)throws ExcepcionesPrestamo {
		if(fechaAutorizacion.Verificar20PrimerosDias())
			if(fechaAutorizacion.VerificarPlazo(FechaMaximaDeAutorizacion))
				FechaAutorizacion = fechaAutorizacion;
			else
				throw new ExcepcionesPrestamo("La fecha de autorización sobrepasa la fecha de autorización máxima");
		else
			throw new ExcepcionesPrestamo("La fecha de autorización debe existir dentro de los primeros 20 días del mes");	
		if(nPrestamo>0)
			NPrestamo = nPrestamo;
		else
			throw new ExcepcionesPrestamo("El número de prestamo debe ser mayor a 0");
		if(valor>0)
			Valor = valor;
		else
			throw new ExcepcionesPrestamo("El valor del prestamo debe ser mayor a 0");
		FechaPago.add(fechaPago);
		LlenarFechasDePago(mesesPagos);
		LlenarValoresMensuales(mesesPagos);
		MesesPagos= mesesPagos;
		if(valor > 100000)
			FechaTentativa = FechaAutorizacion.SumarFecha(10);
		else
			FechaTentativa = FechaAutorizacion.SumarFecha(7);	
		Suma+=valor;
		if(Suma>ValorMaximo)
			throw new ExcepcionesPrestamo("Se alcanzó el límite monetario para los prestamos");
	}
	
	public boolean isPagado() {
		return Pagado;
	}

	public void setPagado(boolean pagado) {
		Pagado = pagado;
	}

	public static Fecha getFechaMaximaDeAutorizacion() {
		return FechaMaximaDeAutorizacion;
	}

	public static void setFechaMaximaDeAutorizacion(Fecha fechaMaximaDeAutorizacion) {
		FechaMaximaDeAutorizacion = fechaMaximaDeAutorizacion;
	}

	public static double getSuma() {
		return Suma;
	}

	public static double getValorMaximo() {
		return ValorMaximo;
	}

	public static void setValorMaximo(double valorMaximo) {
		ValorMaximo = valorMaximo;
	}

	public int getNPrestamo() {
		return NPrestamo;
	}

	public void setNPrestamo(int nPrestamo) {
		NPrestamo = nPrestamo;
	}

	public Persona getSolicitante() {
		return Solicitante;
	}

	public void setSolicitante(Persona solicitante) {
		Solicitante = solicitante;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public Fecha getFechaAutorizacion() {
		return FechaAutorizacion;
	}

	public void setFechaAutorizacion(Fecha fechaAutorizacion) {
		FechaAutorizacion = fechaAutorizacion;
	}

	public Fecha getFechaTentativa() {
		return FechaTentativa;
	}

	public void setFechaTentativa(Fecha fechaTentativa) {
		FechaTentativa = fechaTentativa;
	}
	
	private void LlenarFechasDePago(int NPagos) {
		for(int i=1;i<NPagos;i++) {
			Fecha FechaNueva= FechaPago.get(i-1).SumarFecha(30);
			FechaPago.add(FechaNueva);
		}	
	}
	
	private void LlenarValoresMensuales(int NPagos) {
		for(int i=0;i<NPagos;i++)
			ValoresMensuales.add(Valor/NPagos);
	}
	
	public void SumarIntereses(Fecha fecha,int NPago) {
			ValoresMensuales.set(NPago-1,(ValoresMensuales.get(NPago-1)*1.15));
		if(!FechaPago.get(NPago-1).VerificarPlazo(fecha)) {
			ValoresMensuales.set(NPago-1, ValoresMensuales.get(NPago-1)+(FechaPago.get(NPago-1).DiferenciaDeDias(fecha)*0.05));
		}		
	}
	
	public void LiquidarPrestamo() {
		Valor=Valor*1.02;
	}

	@Override
	public String toString() {
		return "Prestamo [Pagado=" + Pagado + ", NPrestamo=" + NPrestamo + ", Solicitante=" + Solicitante + ", Valor="
				+ Valor + ", FechaPago=" + FechaPago + ", FechaAutorizacion=" + FechaAutorizacion + ", FechaTentativa="
				+ FechaTentativa + ", MesesPagos=" + MesesPagos + ", ValoresMensuales=" + ValoresMensuales + "]";
	}
	


}

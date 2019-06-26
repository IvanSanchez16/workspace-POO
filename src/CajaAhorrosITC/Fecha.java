package CajaAhorrosITC;

public class Fecha {
	private int Dia;
	private int Mes;
	private int Año;
	private int DiasMes[]={31,((Año % 4 == 0) && ((Año % 100 != 0) || (Año % 400 == 0)))?29:28,31,30,31,30,31,31,30,31,30,31};
	
	public Fecha(int dia, int mes, int año)throws ExcepcionesFecha {
		if(dia<=31&&dia>0)
			Dia=dia;
		else 
		throw new ExcepcionesFecha("No existe dicho día");	
		if(mes<=12&&mes>0)
			Mes=mes;
		else 
			throw new ExcepcionesFecha("No existe dicho mes");	
		Año=año;
	}
	
	
	public int getDia() {
		return Dia;
	}

	public void setDia(int dia) {
		Dia = dia;
	}

	public int getMes() {
		return Mes;
	}

	public void setMes(int mes) {
		Mes = mes;
	}

	public int getAño() {
		return Año;
	}

	public void setAño(int año) {
		Año = año;
	}

	public Fecha SumarFecha(int de){
		Fecha fechanueva=null;
		int MesNuevo=Mes;
		int dif=Dia+de,aux=0;
		if(Mes>12) {
				Mes=1;
				Año++;
		}
		if((Dia+de)>DiasMes[Mes-1]){
			dif=(Dia+de)-DiasMes[Mes-1];
			aux++;
			MesNuevo=aux+Mes>12?1:Mes+aux;
		}
		try {
			fechanueva=new Fecha(dif,MesNuevo,Año);
		}catch(ExcepcionesFecha f) {
			System.out.println(f.getMessage());
		}
		return (fechanueva);
	}
	
	public boolean Verificar20PrimerosDias() {
		 return Dia<=20;
	}
	
	public boolean VerificarPlazo(Fecha fecha) {
		return fecha.getAño()>Año?false:fecha.getAño()<Año?true:fecha.getMes()>Mes?false:fecha.getMes()<Mes?true:fecha.getDia()>Dia?false:true;
	}
	
	
	public int DiferenciaDeDias(Fecha fecha) {
		int SumaDias1=Dia,dif=(fecha.getAño()-Año)*365,SumaDias2=fecha.getDia();
		for(int i=0;i<Mes-1;i++) 
			SumaDias1+=DiasMes[i];
		for(int i=0;i<fecha.getMes()-1;i++) 
			SumaDias2+=DiasMes[i];
	return dif+(SumaDias2-SumaDias1);
	}
	
	@Override
	public String toString() {
		return (Dia+"/"+Mes+"/"+Año);
	}
}

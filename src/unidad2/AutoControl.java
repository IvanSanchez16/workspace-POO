package unidad2;

public class AutoControl {
	
	private String Color;
	private float Alcance;
	private String Modelo;
	private float VelMax,GradoMax;
	private float Marcha,Direccion;
	private boolean Encendido;
	private boolean foco;
	
	
	public AutoControl(String color, float alcance, String modelo, float velMax, float gradoMax) {
		Color = color;
		Alcance = alcance;
		Modelo = modelo;
		VelMax = velMax;
		GradoMax = gradoMax;
		Marcha=0;
		Direccion=0;
		Encendido=false;
		foco=false;
	}

	public void Avanza(){
		if(Encendido && Marcha<VelMax)
			Marcha ++;
	}
	
	public void Retrocede(){
		if(Encendido && Marcha>(VelMax*-1))
			Marcha --;
	}
	public float VelActual(){
		return Marcha;
	}
	public void Power(){
		Encendido=!Encendido;
		foco=Encendido;
	}
	public void Gira(float grado){
		Direccion+=grado;
		if(!(Encendido && Direccion	<=	 GradoMax && Direccion	>=(GradoMax*-1))){
			Direccion-=grado;
		}	
	}
	public float DireccionActual(){
		return Direccion;
	}
}

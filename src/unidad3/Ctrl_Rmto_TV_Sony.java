package unidad3;

public class Ctrl_Rmto_TV_Sony extends Control_Remoto_TV {	
	private String Entrada;
	

	public Ctrl_Rmto_TV_Sony(float alcance, String tipo_bateria, int num_botones
	, boolean encender, float canal,int volumen, String entrada) {
		super(alcance, tipo_bateria, num_botones, encender, canal, volumen);
		Entrada = entrada;
	}
	
	@Override
	public void EnviaSenial(Object señal){
		
	}
	
	public String getEntrada() {
		return Entrada;
	}
	public void setEntrada(String entrada) {
		Entrada = entrada;
	}
	@Override
	public void Power() {
		if(Encendido){
			Encendido=false;
		}else{
			Encendido=true;
		}
	}
	@Override
	public void SubeCanal() {
		Canal++;
	}
	@Override
	public void BajaCanal(){
		Canal--;
	}
	@Override
	public void CambiaCanal(float ncanal){
		Canal=ncanal;
	}
	@Override
	public void SubirVolumen(){
		Volumen++;
	}
	@Override
	public void BajarVolumen(){
		Volumen--;
	}
	
}

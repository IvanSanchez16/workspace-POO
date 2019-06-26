package unidad3;

public abstract class Control_Remoto_TV extends Control_Remoto {
	protected boolean Encendido;
	protected float Canal;
	protected int Volumen;
	
	public Control_Remoto_TV(float alcance, String tipo_bateria, int num_botones
	, boolean encender, float canal,int volumen) {
		super(alcance, tipo_bateria, num_botones);
		Encendido = encender;
		Canal = canal;
		Volumen = volumen;
	}
	
	public abstract void Power();
	public abstract void SubeCanal();
	public abstract void BajaCanal();
	public abstract void CambiaCanal(float ncanal);
	public abstract void SubirVolumen();
	public abstract void BajarVolumen();
	
}

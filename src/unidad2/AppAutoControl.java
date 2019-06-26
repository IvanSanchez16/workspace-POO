package unidad2;

public class AppAutoControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoControl A1=new AutoControl("Azul",15,"X",3,45);
		A1.Power();
		A1.Avanza();
		A1.Avanza();
		A1.Avanza();
		A1.Avanza();
		A1.Gira(20);
		A1.Gira(30);
		System.out.println("Velocidad Actual: "+A1.VelActual());
		System.out.println("Direccion actual: "+A1.DireccionActual());
		A1.Retrocede();
	}

}

package ruletarusa;
import java.util.*;
public class Pistola {
	private int PA=0;
	private int PB=0;
	Random R=new Random();
	public Pistola(){
		PA=R.nextInt(6)+1;
		PB=R.nextInt(6)+1;
	}
	
	public boolean Disparar(){
		if(PA==PB)
			return true;
		siguientebala();
		return false;
	}
	private void siguientebala(){
		if(PA==6)
			PA=1;	
		else
			PA++;	
			
	}
	public void Reiniciar(){
		PA=R.nextInt(6)+1;
		PB=R.nextInt(6)+1;
	}
	@Override
	public String toString(){
		return ("Posicion actual del tambor: "+PA+"\t Bala ubicada en la posición: "+PB);
	}
}

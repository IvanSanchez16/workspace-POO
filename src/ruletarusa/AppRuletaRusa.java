package ruletarusa;
import java.util.*;

public class AppRuletaRusa {

	static Pistola A=new Pistola();
	static Persona P[]=new Persona[6];
	static Scanner S=new Scanner(System.in);
	static int c=0;
	
	public static void main(String[] args) {
		int turno=0;
		System.out.println("Cuantas personas van a jugar?");
		int per=S.nextInt();
		for(int i=0;i<per;i++){
			System.out.println("Ingrese el nombre de la persona?");
			String N=S.next();
			P[i]=new Persona(N,true);
		}
		while(true){
			c=0;
			A.Reiniciar();
			while(c==0){
				System.out.println();
				Ronda(P[turno]);
				if(turno<per-1){
					turno++;
				}else{
					turno=0;
				}
			}
			System.out.println("Jugar de nuevo");
		}
	}
	public static void Ronda(Persona p){
		System.out.println("Turno de "+p.getNombre()+"\nEscribe listo para disparar");
		String L=S.next();
		if(L.equalsIgnoreCase("Listo")){
			if(A.Disparar()){
				p.setVivo(false);
				System.out.println(p.getNombre()+" ha perdido");
				c=1;
			}
		}
	}
}

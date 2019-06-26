package unidad4;
import java.util.*;
public class Arreglos {
	
	public static void main(String[] args) {
		Scanner S=new Scanner(System.in);
		Random R=new Random();
		/*
		Programa para hacer una fecha corta a una larga
		  
		String Mes[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		System.out.println("Introduzca la fecha corta (dd-mm-aa)");
		String F=S.next();
		System.out.println("Hoy es "+F.substring(0,2)+" de "+Mes[Integer.valueOf(F.substring(3,5))-1]+" del 20"+F.substring(6));
		*/
		
		
		/*
		 Temperatura 
		int T[]=new int[7];
		int D[]=new int[7];
		String Dias[]={"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
		int P=0;
		int Menor=41;
		int dia=0;
		for(int i=0;i<T.length;i++){
			T[i]=R.nextInt(26)+15;
			P+=T[i];
			if(T[i]<Menor){
				Menor=T[i];
				dia=i;
			}
		}
		P=P/T.length;
		for(int i=0;i<T.length;i++){
			D[i]=T[i]-P;
		}
		System.out.println("La menor temperatura es: "+Menor+" y fue en: "+Dias[dia]);
		System.out.println("Promedio: "+P);
		for(int i=0;i<7;i++){
			System.out.print(T[i]+" / ");
		}
		System.out.println();
		for(int i=0;i<7;i++){
			System.out.print(D[i]+" / ");
		}
	*/
		
	/*
		//Mayor diferencia de dos números consecutivos en un vector de N numeros
		System.out.println("Tamaño del vector");
		int N=S.nextInt();
		int A[]=new int[N];
		int p=0;
		int df=(int)Math.sqrt(Math.pow((A[0]-A[1]),2));
		int df2=0;
		for(int i=0;i<N;i++){
			A[i]=R.nextInt(101);
			System.out.println(A[i]);
		}
		for(int i=1;i<N-1;i++){
			df2=(int)Math.sqrt(Math.pow((A[i]-A[i+1]),2));
			if(df2>df){
			df=df2;
			p=i;
			}
		}
		System.out.println("Diferencia mayor: "+df+"\tElementos: "+(p+1)+" y "+(p+2));
		*/
	}
}

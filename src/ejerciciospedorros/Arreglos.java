package ejerciciospedorros;

import java.util.Random;
import java.util.Scanner;

public class Arreglos {
	static Scanner S=new Scanner(System.in);
	static Random Ran=new Random();
	
	public static void main(String args[]){
		int M[][]=new int[12][3];
		int suma=0,suma2=0,aux=0;
		float pb=0;
		String Meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		for(int i=0;i<12;i++){
			for(int j=0;j<3;j++){
				M[i][j]=Ran.nextInt(4001)+1000;
				System.out.print(M[i][j]+"\t");
					pb+=j==1?M[i][j]:0;
			}
			System.out.println();
		}
		pb=pb/12;
		for(int i=0;i<12;i++){
			suma+=M[i][0];
			if(suma>suma2){
				suma2=suma;
				aux=i;
				suma=0;
			}
		}
		int men=M[0][1],pos=0;
		for(int i=1;i<12;i++){
			if(M[i][1]<men){
				men=M[i][1];
				pos=i;
			}
		}
		int men2=M[7][0],pos2=0;
		for(int j=1;j<3;j++){
			if(M[7][j]<men2){
				men=M[7][j];
				pos2=j;
			}
		}
		System.out.println("El mes que se registro mayor costo de dulces fue "+Meses[aux]);
		System.out.println("El promedio anual de los costos de producción de bebidas fue de: "+pb);
		System.out.println("En el mes que se registro menor producción de bebidas fue: "+Meses[pos]);
		System.out.println("El departamento que tuvo el menor costo de producción en Agosto fue: "+(pos2==0?"Dulces":pos2==1?"Bebidas":"Conservas"));
	}
}

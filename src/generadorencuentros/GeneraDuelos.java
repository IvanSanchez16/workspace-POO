package generadorencuentros;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class GeneraDuelos {

	final static int HORAS=3;
	static Random R=new Random();
	static Scanner S=new Scanner(System.in);
	static Vector<Equipo> Eq =new Vector<Equipo>();
	
	public static void main(String[] args) {
		System.out.println("Ingrese número de equipos");
		int aux=S.nextInt();
		System.out.println("Ingrese el número de actividades");
		int act=S.nextInt();
		int Eq1,Eq2;
		int ctrl=0,ctrl2=0,ctrl3=0;
		int M1[][]=new int[HORAS][act];
		int M2[][]=new int[HORAS][act];	
		do {
			Eq.clear();
			ctrl=0;ctrl2=0;ctrl3=0;
			
		for(int i=0;i<aux;i++)
			Eq.addElement(new Equipo(i));
		
		for(int i=0;i<HORAS;i++) {
			for(int j=0;j<act;j++) {
				ctrl2=0;
				do {
					do {
						Eq1=R.nextInt(aux);
						Eq2=R.nextInt(aux);
					}while(Eq1==Eq2);
					ctrl2++;
						if(ctrl2>=150) {
							ctrl3=1;
							i=HORAS;
							j=act;
						}
				}while((VerificarDuelo(Eq1,Eq2,j,i)==false)||(ctrl3==1 && VerificarDuelo(Eq1,Eq2,j,i)==false));
				//System.out.print(ctrl3==0?(Eq1+1)+" vs "+(Eq2+1)+"\t":"");
				if(ctrl3==0) {
				M1[i][j]=Eq1+1;M2[i][j]=Eq2+1;
				ctrl++;
				}
				Eq.get(Eq1).AgregarDuelo(i,j,Eq.get(Eq2));
				Eq.get(Eq2).AgregarDuelo(i,j,Eq.get(Eq1));
			}
			//System.out.println();
		}
		//System.out.println();
		}while(ctrl!=(HORAS*act));
		for(int i=0;i<HORAS;i++) {
			for(int j=0;j<act;j++) {
				System.out.print(M1[i][j]+" vs "+M2[i][j]+"\t");
			}
			System.out.println();
		}	
	}
	
	public static boolean VerificarDuelo(int eq1,int eq2,int act,int hora) {
		boolean aux=false;
		if(Eq.get(eq1).VerificarRival(Eq.get(eq2))==true)
			if(Eq.get(eq1).VerificarActividad(act)==true)
				if(Eq.get(eq1).VerificarHora(hora)==true)
					if(Eq.get(eq2).VerificarRival(Eq.get(eq1))==true)
						if(Eq.get(eq2).VerificarHora(hora)==true)
							if(Eq.get(eq2).VerificarActividad(act)==true)
								aux=true;
		return aux;
		
	}

}

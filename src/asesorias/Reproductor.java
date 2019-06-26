package asesorias;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Reproductor {
	static Scanner lI=new Scanner(System.in);
	static Scanner lS=new Scanner(System.in);
	static RandomAccessFile arch;
	public static void main(String[] args) {
		int opc;
		do {
			mostrarMenu();
			opc=lI.nextInt();
			switch(opc) {
			case 1:play(); break;
			case 2:{
				System.out.println("Ingresa el nombre de la canci�n");
				String n;
				do {
					n=lS.nextLine();
					if(n.length()>20) {
						System.out.println("El t�tulo ingresado es demasiado largo. Ingr�salo nuevamente");
					}
				}while(n.length()>20);
				try {
					System.out.println(buscarCancion(n).toString());
				}catch(Exception e) {
					System.out.println("La canci�n que buscas no est� registrada. Volviendo al men� principal");
				}
				cerrarArchivo();
			}; break;
			case 3:{
				System.out.println("Ingresa el nombre de la canci�n");
				String n;
				do {
					n=lS.nextLine();
					if(n.length()>20) {
						System.out.println("El t�tulo ingresado es demasiado largo. Ingr�salo nuevamente");
					}
				}while(n.length()>20);
				try {
					System.out.println(buscarCancion(n).reprod());
				}catch(Exception e) {
					System.out.println("La canci�n que intentas reproducir no est� registrada. Volviendo al men� principal");
				}
				cerrarArchivo();
			}; break;
			case 4:{
				Cancion c=crearCancion();
				registrarCancion(c);
				cerrarArchivo();
			}; break;
			case 5:{
				System.out.println("Ingresa el nombre de la canci�n que quieres dar de baja");
				String t;
				do {
					t=lS.nextLine();
					if(t.length()>20) {
						System.out.println("El t�tulo es demasiado largo como para que exista la canci�n que buscas. Ingr�salo nuevamente\n");
					}
				}while(t.length()>20);
				String t�tulo=fillString(t,20);
				darBajaCancion(t�tulo);
				cerrarArchivo();
			}; break;
			case 6:return;
			default:System.out.println("Opci�n inv�lida. Ingrese una opci�n v�lida"); break;
			}
		}
		while(true);
	}
	
	private static void mostrarMenu() {
		System.out.println("\nBienvenido. �Qu� deseas realizar?");
		System.out.println("1.\tPlay");
		System.out.println("2.\tBuscar canci�n");
		System.out.println("3.\tSeleccionar canci�n para reproducir");
		System.out.println("4.\tIngresar nueva canci�n");
		System.out.println("5.\tEliminar canci�n");
		System.out.println("6.\tSalir\n");
	}
	
	private static void play() {
		abrirArchivo();
		ArrayList<Cancion> ac=consultCanciones();
		if(ac.isEmpty()) {
			System.out.println("No tienes ninguna canci�n registrada. Volviendo al men� principal");
		}
		else {
			for(int i=0;i<ac.size();i++) {
				System.out.println(ac.get(i).reprod()+"\n");
			}
		}
		cerrarArchivo();
	}

	private static Cancion buscarCancion(String t�tulo) {
		abrirArchivo();
		fillString(t�tulo, 20);
		String t,autor;
		int duracion;
		try {
			int i=-1;
			do {
				i++;
				arch.seek(i*Cancion.LARGO);
				t=arch.readUTF().trim();
				autor=arch.readUTF().trim();
				duracion=arch.readInt();
			}while(!t�tulo.equalsIgnoreCase(t));
		}catch(Exception e) {return null;}
		try {
			if(!arch.readBoolean())
				return null;
		}catch(Exception e) {}
		return new Cancion(t,autor,duracion);
	}
		
	private static Cancion crearCancion() {
		System.out.println("Ingresa el t�tulo");
		String t;
		do {
			t=lS.nextLine();
			if(t.length()>20){
				System.out.println("El t�tulo es demasiado largo. Ingresa uno nuevo");
			}
		}while(t.length()>20);
		System.out.println("Ingresa el autor");
		String a;
		do {
			a=lS.nextLine();
			if(a.length()>20){
				System.out.println("El t�tulo es demasiado largo. Ingresa uno nuevo");
			}
		}while(a.length()>20);
		System.out.println("Ingresa la duraci�n de la canci�n en segundos");
		int d=lI.nextInt();
		Cancion c=new Cancion(t, a, d);
		return c;
	}
	
	public static boolean registrarCancion(Cancion c) {
		abrirArchivo();
		try {
			arch.seek(arch.length());
			arch.writeUTF(fillString(c.getTitl(),20));
			arch.writeUTF(fillString(c.getAutor(),20));
			arch.writeInt(c.getDur());
			arch.writeBoolean(true);
		}catch(Exception e) {return false;}
		return true;
	}
	
	public static ArrayList<Cancion> consultCanciones() {
		ArrayList<Cancion> ac=new ArrayList<Cancion>();
		try {
			long ndatos=(arch.length()/Cancion.LARGO);
			for(long i=0 ; i<ndatos ; i++) {
				arch.seek(i*Cancion.LARGO+22+22+4);
				if(arch.readBoolean()==true) {
					arch.seek(i*Cancion.LARGO);
					ac.add(new Cancion(arch.readUTF().trim(),arch.readUTF().trim(),arch.readInt()));
				}
			}
		}catch(Exception e) {}
		return ac;
	}
	
	public static void darBajaCancion(String t�tulo) {
		abrirArchivo();
		String t,autor;
		int duraci�n;
		try {
			long ndatos=arch.length()/Cancion.LARGO;
			for(long i=0;i<ndatos;i++) {
				arch.seek(i*Cancion.LARGO);
				t=arch.readUTF().trim();
				autor=arch.readUTF().trim();
				duraci�n=arch.readInt();
				if(t�tulo.equals(t)){
					arch.writeBoolean(false);
					break;
				}
			}
		}catch(Exception e) {}
	}
	
	public static void abrirArchivo() {
		try {
			arch=new RandomAccessFile("ArchCanciones.dat","rw");
		}catch(Exception e) {}
	}
	
	public static void cerrarArchivo() {
		try {
			arch.close();
		}catch(Exception e) {}
	}

	public static String fillString(String text,int t){
	  	  while (text.length()<t)
	  		  text+=" ";
	  	  return text;
	    }
}

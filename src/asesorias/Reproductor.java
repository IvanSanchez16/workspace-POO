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
				System.out.println("Ingresa el nombre de la canción");
				String n;
				do {
					n=lS.nextLine();
					if(n.length()>20) {
						System.out.println("El título ingresado es demasiado largo. Ingrésalo nuevamente");
					}
				}while(n.length()>20);
				try {
					System.out.println(buscarCancion(n).toString());
				}catch(Exception e) {
					System.out.println("La canción que buscas no está registrada. Volviendo al menú principal");
				}
				cerrarArchivo();
			}; break;
			case 3:{
				System.out.println("Ingresa el nombre de la canción");
				String n;
				do {
					n=lS.nextLine();
					if(n.length()>20) {
						System.out.println("El título ingresado es demasiado largo. Ingrésalo nuevamente");
					}
				}while(n.length()>20);
				try {
					System.out.println(buscarCancion(n).reprod());
				}catch(Exception e) {
					System.out.println("La canción que intentas reproducir no está registrada. Volviendo al menú principal");
				}
				cerrarArchivo();
			}; break;
			case 4:{
				Cancion c=crearCancion();
				registrarCancion(c);
				cerrarArchivo();
			}; break;
			case 5:{
				System.out.println("Ingresa el nombre de la canción que quieres dar de baja");
				String t;
				do {
					t=lS.nextLine();
					if(t.length()>20) {
						System.out.println("El título es demasiado largo como para que exista la canción que buscas. Ingrésalo nuevamente\n");
					}
				}while(t.length()>20);
				String título=fillString(t,20);
				darBajaCancion(título);
				cerrarArchivo();
			}; break;
			case 6:return;
			default:System.out.println("Opción inválida. Ingrese una opción válida"); break;
			}
		}
		while(true);
	}
	
	private static void mostrarMenu() {
		System.out.println("\nBienvenido. ¿Qué deseas realizar?");
		System.out.println("1.\tPlay");
		System.out.println("2.\tBuscar canción");
		System.out.println("3.\tSeleccionar canción para reproducir");
		System.out.println("4.\tIngresar nueva canción");
		System.out.println("5.\tEliminar canción");
		System.out.println("6.\tSalir\n");
	}
	
	private static void play() {
		abrirArchivo();
		ArrayList<Cancion> ac=consultCanciones();
		if(ac.isEmpty()) {
			System.out.println("No tienes ninguna canción registrada. Volviendo al menú principal");
		}
		else {
			for(int i=0;i<ac.size();i++) {
				System.out.println(ac.get(i).reprod()+"\n");
			}
		}
		cerrarArchivo();
	}

	private static Cancion buscarCancion(String título) {
		abrirArchivo();
		fillString(título, 20);
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
			}while(!título.equalsIgnoreCase(t));
		}catch(Exception e) {return null;}
		try {
			if(!arch.readBoolean())
				return null;
		}catch(Exception e) {}
		return new Cancion(t,autor,duracion);
	}
		
	private static Cancion crearCancion() {
		System.out.println("Ingresa el título");
		String t;
		do {
			t=lS.nextLine();
			if(t.length()>20){
				System.out.println("El título es demasiado largo. Ingresa uno nuevo");
			}
		}while(t.length()>20);
		System.out.println("Ingresa el autor");
		String a;
		do {
			a=lS.nextLine();
			if(a.length()>20){
				System.out.println("El título es demasiado largo. Ingresa uno nuevo");
			}
		}while(a.length()>20);
		System.out.println("Ingresa la duración de la canción en segundos");
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
	
	public static void darBajaCancion(String título) {
		abrirArchivo();
		String t,autor;
		int duración;
		try {
			long ndatos=arch.length()/Cancion.LARGO;
			for(long i=0;i<ndatos;i++) {
				arch.seek(i*Cancion.LARGO);
				t=arch.readUTF().trim();
				autor=arch.readUTF().trim();
				duración=arch.readInt();
				if(título.equals(t)){
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

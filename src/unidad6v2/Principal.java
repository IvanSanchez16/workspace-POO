package unidad6v2;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	
	public static Scanner S=new Scanner(System.in);
	static long SigReg;
	static String NArchivo="Alumnos.dat";
	
	public static void main(String[] args)throws IOException {
		int opc;
		do{
			MostrarMenu();
			opc=S.nextInt();
			switch(opc){
				case 1:
					Agregar();
				break;
				case 2:
					Modifica();
				break;
				case 3:
					Elimina();
				break;
				case 4:
					Consulta();
				break;
				case 5:
					Reporte();
				break;
				case 0:
					System.out.println("Al raio");
				break;
				default:
					System.out.println("Opción no valida");
				break;	
			}
		}while(opc!=0);
	}
	
	private static void MostrarMenu() {
		System.out.println("* * * M E N U * * *");
		System.out.println("1-. Agregar");
		System.out.println("2-. Modificar");
		System.out.println("3-. Eliminar");
		System.out.println("4-. Consulta");
		System.out.println("5-. Reporte");
		System.out.println("0-. Salir");
		System.out.print("Opción: ");
	}
	
	private static void Agregar(){
		System.out.println("* * * A G R E G A R * * *");
		try{
			Alumno alumno = PedirDatos();
			Archivo.abrir(NArchivo);
			Archivo.nuevoRegistro(alumno);
			Archivo.cerrar();
		}catch(IOException e){
			System.out.println("Error en el archivo "+e.getMessage());
		}
	}
	
	private static void Modifica() {
		System.out.println("* * * M O D I F I C A R * * *");
		System.out.print("Num de Ctrl: ");
		String nc = S.next();
		try {
			Archivo.abrir(NArchivo);
			long pos = Archivo.Busca(nc);
			if(pos >= 0) {
				MostrarDatos(Archivo.leerRegistro(pos));
				if(AlumnoCorrecto()) {
					Archivo.actualizarRegistro(pos,PedirDatos());
					System.out.println("\nDatos actualizados correctamente");
				}
			}else {
				System.out.println();
				System.out.println("Alumno no encontrado");	
			}
			Archivo.cerrar();
		}catch (IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}
	}
	
	private static void Elimina() {
		System.out.println("* * * B O R R A R * * *");
		System.out.print("Num Ctrl: ");
		String nc = S.next();
		try {
			Archivo.abrir(NArchivo);
			long pos = Archivo.Busca(nc);
			if(pos >= 0) {
				MostrarDatos(Archivo.leerRegistro(pos));
				if(AlumnoCorrecto()) {
					Archivo.eliminarRegistro(pos);
					System.out.println("\nDatos eliminados correctamente");
				}
			}else {
				System.out.println();
				System.out.println("Alumno no encontrado");
			}
			Archivo.cerrar();
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	private static void Consulta() {
		System.out.println("* * * C O N S U L T A * * *");
		System.out.print("Num Ctrl: ");
		String nc = S.next();
		try {
			Archivo.abrir(NArchivo);
			long pos = Archivo.Busca(nc);
			if(pos >= 0) {
				MostrarDatos(Archivo.leerRegistro(pos));
			}else {
				System.out.println();
				System.out.println("Alumno no encontrado");
			}
			Archivo.cerrar();
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	private static void Reporte() throws IOException{
		System.out.println("* * * L I S T A  D E  A L U M N O S * * *");
		Archivo.abrir(NArchivo);
		for(int i=0;i<Archivo.NumeroDatos();i++) {
			MostrarDatos(Archivo.leerRegistro(i));
		}
		Archivo.cerrar();
	}
	
	private static void MostrarDatos(Alumno al) {
		if(al.getEdad()!=0) {
			System.out.println();
			System.out.println("Datos del alumno");
			System.out.println("Número de control: "+al.getMatricula());
			System.out.println("Nombre del alumno: "+al.getNombre());
			System.out.println("Carrera: "+al.getCarrera());
			System.out.println("Edad del alumno: "+al.getEdad());
			System.out.println();
		}
		
	}
	
	public static Alumno PedirDatos() {
		Alumno alumno = new Alumno();
		System.out.print("Número de control: ");
		alumno.setMatricula(S.next());
		System.out.print("Nombre del alumno: ");
		alumno.setNombre(S.next());
		System.out.print("Carrera: ");
		alumno.setCarrera(S.next());
		System.out.print("Edad del alumno: ");
		alumno.setEdad(S.nextInt());
		
		return alumno;
	}
	
	public static boolean AlumnoCorrecto() {
		System.out.println("Es este el alumno (S/N)");
		char op=S.next().charAt(0);
		return op=='S' || op == 's';
	}
}

package pfarchivostxt;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	
	public static Scanner S=new Scanner(System.in);
	static long SigReg;
	static String archivo="Alumnos.txt";
	
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
	
	private static void Agregar() throws IOException {
		try {
		System.out.println();
		System.out.println("* * AGREGAR * * ");
		Archivos.Agregar(PedirDatos());
		System.out.println("Alumno agregado." + "\n");
		}catch(IOException E) {
			System.out.println(E.getMessage());
		}
	}
	
	private static void Modifica() throws IOException {
		try {
		System.out.println();
		System.out.println("* * MODIFICAR * *");
		System.out.print("Número de control: ");
		String nc1 = S.next();
		Archivos.Modificar(nc1);
		}catch(IOException E) {
			System.out.println(E.getMessage());
		}
	}
	
	private static void Elimina() {
		try {
		System.out.println();
		System.out.println("* * ELIMINAR * *");
		System.out.print("Número de control: ");
		String nc = S.next();
		Archivos.Eliminar(nc);
		}catch(IOException E) {
			System.out.println(E.getMessage());
		}
	}
	
	private static void Consulta() {
		try {
			System.out.println();
			System.out.println("* * CONSULTAR DATOS * * ");
			System.out.print("Número de control: ");
			String nc = S.next();
			System.out.println(Archivos.Consulta(nc));
		}catch(IOException E) {
			System.out.println(E.getMessage());
		}
	}
	
	private static void Reporte() {
		try {
			Archivos.Reporte();	
		}catch(IOException E) {
			System.out.println(E.getMessage());
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

package pfarchivostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {

	private static PrintWriter pw;
	private static BufferedReader br;
	private static File ArchivoE, ArchivoL;
	
	private static void AbrirArchivo(String NomA, boolean tipo) throws IOException {
		if (tipo) {
			ArchivoE = new File(NomA);
			pw = new PrintWriter(new FileWriter(ArchivoE, true));
		} else {
			ArchivoL = new File(NomA);
			br = new BufferedReader(new FileReader(ArchivoL));
		}

	}

	private static void CerrarArchivo() throws IOException {
		if (pw != null)
			pw.close();
		if (br != null)
			br.close();
	}
	
	public static void Agregar(Alumno alumno) throws IOException {
		AbrirArchivo("Alumnos.txt", true);
		pw.println(alumno.getMatricula() + "|" + alumno.getNombre() + "|" + alumno.getCarrera() + "|" + alumno.getEdad());
		CerrarArchivo();
	}
	
	public static void Modificar(String ncS)throws IOException {
		AbrirArchivo("Alumnos.txt", true);
		CerrarArchivo();
		boolean Correc = false, y = false;
		AbrirArchivo("Alumnos.txt", false);
		String linea = br.readLine();
		String nc2;
		while (linea != null) {
			int alexa1 = linea.indexOf("|");
			nc2 = linea.substring(0, alexa1);
			if (ncS.equals(nc2)) {
				System.out.println(linea);
				Correc = true;
				CerrarArchivo();
				break;
			}
			linea = br.readLine();
		}
		if (Correc) {
			if (Principal.AlumnoCorrecto()) {
				Alumno alumno = (Principal.PedirDatos());
				AbrirArchivo("Alumnos.txt", false);
				AbrirArchivo("Temp.txt", true);
				linea = br.readLine();
				while (linea != null) {
					int aux1 = linea.indexOf("|");
					nc2 = linea.substring(0, aux1);
					if (ncS.equals(nc2)) {
						pw.println(alumno.getMatricula() + "|" + alumno.getNombre() + "|" + alumno.getCarrera() + "|" + alumno.getEdad());
						y = true;
					} else {
						pw.println(linea);
					}
					linea = br.readLine();
				}
				if (y) {
					System.out.println("Alumno actualizado." + "\n");
				}
				CerrarArchivo();
				ArchivoL.delete();
				ArchivoE.renameTo(new File("Alumnos.txt"));
			} else {
				System.out.println();
			}
		} else {
			System.out.println("Alumno no encontrado." + "\n");
		}
		CerrarArchivo();
	}
	
	public static void Eliminar(String nc)throws IOException {
		AbrirArchivo("Alumnos.txt", true);
		CerrarArchivo();
		AbrirArchivo("Alumnos.txt", false);
		String linea = br.readLine();
		AbrirArchivo("Temp.txt", true);
		boolean x = false;
		while (linea != null) {
			int aux = linea.indexOf("|");
			String nc2 = linea.substring(0, aux);
			if (nc.equals(nc2)) {
				x = true;
			} else {
				pw.println(linea);
			}
			linea = br.readLine();
		}
		if (x) {
			CerrarArchivo();
			ArchivoL.delete();
			ArchivoE.renameTo(new File("Alumnos.txt"));
			System.out.println("Alumno eliminado." + "\n");
		} else {
			CerrarArchivo();
			ArchivoE.delete();
			System.out.println("Alumno no encontrado." + "\n");
		}
		CerrarArchivo();
	}
	
	public static String Consulta(String nc)throws IOException{
		String f="";
		AbrirArchivo("Alumnos.txt", true);
		CerrarArchivo();
		AbrirArchivo("Alumnos.txt", false);
		String linea = br.readLine();
		boolean Correc = false;
		while (linea != null) {
			int aux = linea.indexOf("|");
			String nc2 = linea.substring(0, aux);
			if (nc.equals(nc2)) {
				f=(linea + "\n");
				Correc = true;
			}
			linea = br.readLine();
		}
		if (!Correc) {
			f=("Alumno no encontrado." + "\n");
		}
		CerrarArchivo();
		return f;
	}
	
	public static void Reporte() throws IOException {
		System.out.println();
		AbrirArchivo("Alumnos.txt", true);
		CerrarArchivo();
		AbrirArchivo("Alumnos.txt", false);
		String linea = br.readLine();
		if (linea != null) {
			System.out.println("Listado de Alumnos: ");
			System.out.println();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			System.out.println();
		} else {
			System.out.println("No hay Alumnos registrados." + "\n");
		}
		CerrarArchivo();
	}
}

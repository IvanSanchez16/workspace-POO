package unidad6v2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Archivo {
	public static RandomAccessFile archivo;

	public static void abrir(String nombreArchivo) throws IOException{
		archivo = new RandomAccessFile(nombreArchivo,"rw");
	}
	
	public static int NumeroDatos()throws IOException{
		return (int)(archivo.length()/Alumno.TAMANIO);
	}

	public static void cerrar()throws IOException{
		if(archivo!=null)
			archivo.close();
	}
	
	public static void actualizarRegistro(long posicion,Alumno alumno)throws IOException{
		archivo.seek((posicion)*Alumno.TAMANIO);
		escribirCadena(alumno.getMatricula());
		escribirCadena(alumno.getNombre());
		escribirCadena(alumno.getCarrera());
		archivo.writeInt(alumno.getEdad());
		
	}
	
	public static void eliminarRegistro(long posicion)throws IOException{
		actualizarRegistro(posicion,new Alumno());
	}
	
	public static void nuevoRegistro(Alumno alumno)throws IOException{
		actualizarRegistro(SiguienteRegistro(),alumno);
	}
	
	public static long SiguienteRegistro()throws IOException{
		archivo.seek(0);
		int i=0;
		Alumno al;
		while(!eof()) {
			al = leerRegistro(i);
			if(al.getMatricula().trim().isEmpty())
				return i;
			i++;		
		}
		return archivo.length()==0?0:archivo.length()/Alumno.TAMANIO;
	}
	
	private static boolean eof()throws IOException {
		return !(archivo.getFilePointer() < archivo.length());
	}
	
	public static Alumno leerRegistro(long posicion)throws IllegalArgumentException,NumberFormatException,IOException{
		Alumno alumno = new Alumno();
		if(posicion < 0 || posicion > 100)
			throw new IllegalArgumentException("Fuera de rango");
		archivo.seek((posicion)*Alumno.TAMANIO);
		alumno.setMatricula(leerCadena());
		alumno.setNombre(leerCadena());
		alumno.setCarrera(leerCadena());
		alumno.setEdad(archivo.readInt());
		return alumno;
	}
	
	public static long Busca(String NumCtrl)throws IOException{
		StringBuffer bufer=null;
		String NC="";
		if(NumCtrl!=null)
			bufer = new StringBuffer(NumCtrl);
		else
			bufer = new StringBuffer(50);
		bufer.setLength(50);
		NumCtrl=bufer.toString().replace('\0',' ');
		int indice=0,pos=0;
		boolean found = false;
		do{
			archivo.seek(indice);
			NC = leerCadena();
			if(!NC.equals(NumCtrl)){
				indice+=Alumno.TAMANIO;
				pos++;
				found=false;
			}else
				found=true;
		}while(!found&&indice<archivo.length());
		return found ? pos : -1;
	}
	
	private static String leerCadena()throws IOException{
		char nombre[] = new char[50],temp;
		for(int cuenta=0;cuenta<nombre.length;cuenta++){
			temp = archivo.readChar();
			nombre[cuenta]=temp;
		}
		return new String(nombre).replace('\0',' ');
	}
	
	private static void escribirCadena(String cadena)throws IOException{
		StringBuffer bufer= null;
		if(cadena !=null)
			bufer= new StringBuffer(cadena);
		else
			bufer = new StringBuffer(50);
		bufer.setLength(50);
		archivo.writeChars(bufer.toString());
	}
}
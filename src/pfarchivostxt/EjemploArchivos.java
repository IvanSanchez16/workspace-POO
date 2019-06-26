package pfarchivostxt;

import java.io.RandomAccessFile;

public class EjemploArchivos {

	public static void main(String[] args) {
		try {
			RandomAccessFile archivo=new RandomAccessFile("MiArchivo.dat","rw");
			int int1=58;
			int int2=2147483647;
			String string1="Omar puto";
			
			System.out.println("apuntador:"+archivo.getFilePointer());
			archivo.writeInt(int1);
			System.out.println("apuntador:"+archivo.getFilePointer());
			archivo.writeInt(int2);
			System.out.println("apuntador:"+archivo.getFilePointer());
			archivo.writeUTF(string1);
			System.out.println("apuntador:"+archivo.getFilePointer());
			
			archivo.seek(0);
			System.out.println("apuntador:"+(archivo.getFilePointer()));
			System.out.println(archivo.length());
			System.out.println(archivo.readInt());
			System.out.println("apuntador:"+archivo.getFilePointer());
			System.out.println(archivo.readInt());
			System.out.println("apuntador:"+archivo.getFilePointer());
			System.out.println(archivo.readUTF());
			System.out.println("apuntador:"+archivo.getFilePointer());
			archivo.close();
			
		}catch(Exception e) {}
	}
}

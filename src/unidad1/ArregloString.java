package unidad1;
import java.util.Arrays;
public class ArregloString {

	public static void main(String[] args) {

		String A1[]= {"Juan","Jorge","Ronaldo","Angel","Leonel","Ivan"};
		String A2[]= {"Maria","Michelle","Angela","Cassandra","Daniela","Brenda"};	
		String A3[]=new String[A1.length+A2.length];
		int aux=0;
		for(int i=0;i<A1.length;i++) {
			A3[i]=A1[i];
			aux++;
		}
		for(int i=0;i<A2.length;i++) {
			A3[i+aux]=A2[i];
		}
		
		Arrays.sort(A3);
		for(int i=0;i<A3.length;i++) {
			System.out.println(A3[i]);
		}
	}

}

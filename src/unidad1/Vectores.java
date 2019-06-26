package unidad1;
import java.util.*;
public class Vectores {

	public static void main(String[] args) {
	
	String A1[]={"Angel","Erick","Ivan","Joel","Omar"};
	String A2[]={"Alejandra","Brenda","Estefanya","Lety","Valeria"};
	String A3[]=new String[A1.length+A2.length];
	int I1=0,I2=0;
	for(int i=0;i<A3.length;i++){
		
		if(I1<A1.length && I2<A2.length){
			
			if(A1[I1].compareTo(A2[I2])<0){
				A3[i]=A1[I1++];
			}else{
				A3[i]=A2[I2++];
			}
			
		}else if(I1==A1.length && I2<A2.length){
			A3[i]=A2[I2++];
			}
		if(I2==A2.length && I1<A1.length){
			A3[i]=A1[I1++];
		}
	}
	
	for(int i=0;i<A3.length;i++){
		System.out.println(A3[i]);
	}
	
}

}
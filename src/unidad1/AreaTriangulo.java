package unidad1;
import java.util.*;
public class AreaTriangulo {
	
	public static double Area_Triangulo(int L1,int L2,int L3) {
		float T=(L1+L2+L3)/2;
		double A=Math.sqrt(T*(T-L1)*(T-L2)*(T-L3));
		return A;
	}
	
	public static int Perimetro(int L1,int L2,int L3){
		int P=L1+L2+L3;
		return P;
	}
	
	public static double Area_Triangulo(int B,int Alt) {
		double A=(B*Alt)/2;
		return A;
	}
	
	public static void main(String[] args) {
		Scanner S=new Scanner(System.in);
		System.out.println("L1");
		int L1=S.nextInt();
		System.out.println("L2");
		int L2=S.nextInt();
		System.out.println("L3");
		int L3=S.nextInt();
		System.out.println("Base");
		int b=S.nextInt();
		System.out.println("Altura");
		int h=S.nextInt();
		
		System.out.println("Area es igual: "+Area_Triangulo(L1,L2,L3));
		System.out.println("Perimetro es igual: "+Perimetro(L1,L2,L3));
		System.out.println("Area es igual: "+Area_Triangulo(b,h));
	}

}

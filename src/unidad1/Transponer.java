package unidad1;
import java.util.*;
public class Transponer {

	public static void main(String[] args) {
		Scanner S=new Scanner(System.in);
		Random R=new Random();
		System.out.println("Teclee el tamaño de la matriz");
		int n=S.nextInt();
		int M[][]=new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int c=0;c<n;c++){
			M[i][c]=R.nextInt(10);
			System.out.print(M[i][c]+"\t");
			}
			System.out.println();
		}
		
		
		int g;
		for(int i=0;i<n;i++){
			for(int c=i+1;c<n;c++){
				g=M[i][c];
				M[i][c]=M[c][i];
				M[c][i]=g;
			}
		}
		System.out.println();
		for(int i=0;i<n;i++){
			for(int c=0;c<n;c++){
				System.out.print(M[i][c]+"\t");
			}
			System.out.println();
		}
	}

}

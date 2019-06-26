package Restaurante;
import java.util.Scanner;
import java.util.Vector;
public class Administracion {
	
	public static Vector<Meseros> M=new Vector<Meseros>();
	public static Vector<Mesas> T=new Vector<Mesas>();
	public static Vector<Reservaciones> R=new Vector<Reservaciones>();

 	public static void main(String[] args) {
		Scanner S=new Scanner(System.in);
		int V=1;
		while(V>0&&V<10) {
			System.out.println("Que acción desea realizar?\n"
					+ "1-. Dar de alta un mesero\n"
					+ "2-. Dar de alta una mesa\n"
					+ "3-. Modificar número de comesales de una mesa\n"
					+ "4-. Eliminar una mesa\n"
					+ "5-. Eliminar un mesero\n"
					+ "6-. Mostrar datos de las mesas\n"
					+ "7-. Mostrar datos de los meseros\n"
					+ "8-. (Llegada de cliente)\n"
					+ "9-. (Llamada para reservacion)\n");
			V=S.nextInt();
			switch(V) {
			case 1:
				System.out.println("Introduzca el nombre del mesero");
				String Nmesero=S.next();
				System.out.println("Introduzca el telefono del mesero");
				int NDeTelefono=S.nextInt();
				System.out.println("Introduzca la dirección del mesero");
				String Direccion=S.next();
				System.out.println("Introduzca el Numero del mesero");
				int NdMesero=S.nextInt();
				M.addElement(new Meseros(Nmesero,NDeTelefono,Direccion,NdMesero));
				break;
			case 2:
				System.out.println("Introduzca el numero de comesales posibles en la mesa");
				int Comesales=S.nextInt();
				System.out.println("Introduzca el nombre del mesero encargado");
				String ME=S.next();
				int ME2=999;
				for(int i=0;i<M.size();i++) {
					if(ME.equalsIgnoreCase(M.get(i).getNombre())) 
					ME2=i;
				}
				T.addElement(new Mesas(T.size()+1,Comesales,M.get(ME2)));
				break;
			case 3:
				System.out.println("Que mesa se desea modificar");
				int m=S.nextInt();
				System.out.println("Número de comesales nuevo");
				int c=S.nextInt();
				T.get(m-1).setCapacidad(c);
				break;
			case 4:
				System.out.println("Que mesa desea eliminar? (Número de mesa)");
				int bm=S.nextInt();
				T.remove(bm-1);
				break;
				
			case 5:
				System.out.println("Que mesero desea eliminar? (Número de mesero)");
				int bme=S.nextInt();
				M.remove(bme-1);
				break;
				
			case 6: 
				for(int i=0;i<T.size();i++) {
					System.out.println(T.get(i)+"\n");
				}
				break;
			case 7: 
				for(int i=0;i<M.size();i++) {
					System.out.println(M.get(i)+"\n");
				}
				break;
			case 8:
				System.out.println("Cuantas personas son?");
				int p=S.nextInt();
				System.out.println("Mesas disponibles para "+p+" personas\n"
						+ MesasDisponibles(p)
						+"\nSeleccione una");
				int ms=S.nextInt();
				T.get(ms-1).setDisponibilidad(false);
				break;
				
			case 9:
				System.out.println("Para que fecha quiere la reservacion?");
				String f=S.next();
				System.out.println("Para cuantas personas?");
				int pe=S.nextInt();
				System.out.println("Mesas disponibles para "+pe+" personas\n"
						+ MesasDisponibles(pe)
						+"\nSeleccione una");
				ms=S.nextInt();
				R.addElement(new Reservaciones(f,pe,T.get(ms-1)));
				T.get(ms-1).setDisponibilidad(false);
				break;
			default:
				
				break;
			}
		}
	}
 	public static String MesasDisponibles(int ndepersonas) {
		String g="";
		for(int i=0;i<T.size();i++) {
			if(T.get(i).getCapacidad()==ndepersonas && T.get(i).isDisponibilidad())
				g+=(T.get(i).toString()+"\n");
		}
		return g;
	}
	public static int BuscarMesa(int ndemesa) {
		int g=0;
		for(int i=0;i<T.size();i++) {
			if(T.get(i).getNDeMesa()==ndemesa)
				g=i;
		}
		return g;
	}

}

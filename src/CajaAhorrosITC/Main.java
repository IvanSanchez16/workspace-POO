package CajaAhorrosITC;
import java.util.*;

public class Main {
	static Fecha FechaActual=null;
	static Vector<Prestamo> P=new Vector<Prestamo>();
	static Vector<Persona> C=new Vector<Persona>();
	static Vector<ClientesAhorradores> CA=new Vector<ClientesAhorradores>();
	public static void main(String[] args) {
		int OPC=0;
		Calendar F= new GregorianCalendar();
		Scanner L= new Scanner(System.in);
		System.out.println("Ingrese el valor máximo de prestamos:");
		Prestamo.setValorMaximo(L.nextDouble());
		while(Prestamo.getFechaMaximaDeAutorizacion()==null)
		try {
		System.out.println("Establezca la fecha máxima para la autorización del prestamos (DD/MM/AAAA):");
		String fecha=L.next();
		Prestamo.setFechaMaximaDeAutorizacion(new Fecha(Dia(fecha),Mes(fecha),Año(fecha)));
		}catch(ExcepcionesFecha f) {
			System.out.println(f.getMessage());
		}
		while(FechaActual==null)
		try {
		FechaActual=new Fecha(F.get(Calendar.DAY_OF_MONTH),F.get(Calendar.MONTH)+1,F.get(Calendar.YEAR));
		}catch(ExcepcionesFecha f) {
			System.out.println(f.getMessage());
		}
		System.out.println(FechaActual); 
		
		while(OPC!=15) {
			MostrarMenuPrincipal();
			OPC=L.nextInt();
			switch(OPC) {
			case 1:
				char cont=' ';
				while(cont!='s' && cont!='S' && cont!='n' && cont!='N')
					try {
				System.out.println("¿El solicitante tiene cuenta de ahorros? (S=si N=no)");
				cont=L.next().charAt(0);
				if(cont=='n'||cont=='N') {
					Persona Solicitante;
					Fecha fechaAutorizacion=null,fechaPago=null;
					boolean V=false;
					while(V==false) {
						try {
							System.out.println("Ingrese número del prestamo:");
							int nPrestamo=L.nextInt();
							System.out.println("Ingrese el número de identidad del solicitante: ");
							int NI=L.nextInt();
							if(Buscar(NI)==-1)
								throw new ExcepcionesMain("Solicitante no encontrado");
							else {
							Solicitante= C.get(Buscar(NI));
							}
							System.out.println("Ingrese valor del prestamo: ");
							double valor=L.nextDouble();
							try {
							System.out.println("Establezca la fecha para la autorización del prestamos (DD/MM/AAAA):");
							String fecha=L.next();
							fechaAutorizacion=new Fecha(Dia(fecha), Mes(fecha), Año(fecha));
							System.out.println("Establezca la fecha del primer pago (DD/MM/AAAA):");
							fecha=L.next();
							fechaPago= new Fecha(Dia(fecha), Mes(fecha), Año(fecha));
							}catch(ExcepcionesFecha f) {
								System.out.println(f.getMessage());
							}
							System.out.println("Ingrese el número de pagos a realizar:");
							int mesesPagos=L.nextInt();
							try {
								Prestamo p=new Prestamo(nPrestamo,Solicitante,valor,fechaAutorizacion,fechaPago,mesesPagos);
								P.addElement(p);
							}catch(ExcepcionesPrestamo pr) {
								System.out.println(pr.getMessage());
							}
						}catch(ExcepcionesMain M) {
							System.out.println(M.getMessage());
						}
						
					}
				}else if(cont=='s'||cont=='S') {
					ClientesAhorradores Solicitante;
					Fecha fechaAutorizacion=null,fechaPago=null;
					boolean V=false;
					while(V==false) {
						try {
							System.out.println("Ingrese número del prestamo:");
							int nPrestamo=L.nextInt();
							System.out.println("Ingrese el número de identidad del solicitante: ");
							int NI=L.nextInt();
							if(Buscar(NI)==-1)
								throw new ExcepcionesMain("Solicitante no encontrado");
							else {
							Solicitante= CA.get(Buscar(NI));
							}
							System.out.println("Ingrese valor del prestamo: ");
							double valor=L.nextDouble();
							try {
							System.out.println("Establezca la fecha para la autorización del prestamos (DD/MM/AAAA):");
							String fecha=L.next();
							fechaAutorizacion=new Fecha(Dia(fecha), Mes(fecha), Año(fecha));
							System.out.println("Establezca la fecha del primer pago (DD/MM/AAAA):");
							fecha=L.next();
							fechaPago= new Fecha(Dia(fecha), Mes(fecha), Año(fecha));
							}catch(ExcepcionesFecha f) {
								System.out.println(f.getMessage());
							}
							System.out.println("Ingrese el número de pagos a realizar:");
							int mesesPagos=L.nextInt();
							try {
								PrestamoCuentaAhorro p=new PrestamoCuentaAhorro(nPrestamo,Solicitante,valor,fechaAutorizacion,fechaPago,mesesPagos);
								P.addElement(p);
							}catch(ExcepcionesPrestamo pr) {
								System.out.println(pr.getMessage());
							}
						}catch(ExcepcionesMain M) {
							System.out.println(M.getMessage());
						}
					}
				}else
					throw new ExcepcionesMain("Ingrese un carácter válido");
					}catch(ExcepcionesMain m) {
						System.out.println(m.getMessage());
					}
				
				
			break;
			
			case 2:
				Persona persona=null;
				char c=' ';
				while(c!='t' && c!='T'&& c!='r' && c!='R')
					try {
						System.out.println("¿Desea capturar todos los datos del solicitante (T) ó únicamente los datos requeridos (R)?");	
						c=L.next().charAt(0);
						if(c=='t' || c=='T') {
							while(persona==null)
							try {
							System.out.println("Ingrese número de identidad");
							int NIdentidad=L.nextInt();
							System.out.println("Ingrese nombre del cliente");
							String Nombre=L.next();
							System.out.println("Ingrese primer apellido");
							String PApellido=L.next();
							System.out.println("Ingrese segundo apellido");
							String SApellido=L.next();
							System.out.println("Ingrese teléfono de casa");
							long TelCasa=L.nextLong();
							System.out.println("Ingrese teléfono movil");
							long TelMovil=L.nextLong();
							System.out.println("Ingrese domicilio");
							String Domicilio=L.next();
							persona=new Persona(NIdentidad,Nombre,PApellido,SApellido,TelCasa,TelMovil,Domicilio);
							C.addElement(persona);
							}catch(InputMismatchException f) {
								System.out.println("Ingrese el valores correctos");
							}
						}else if(c=='r' || c=='R') {
							try {
								System.out.println("Ingrese número de identidad");
								int NIdentidad=L.nextInt();
								System.out.println("Ingrese nombre del cliente");
								String Nombre=L.next();
								System.out.println("Ingrese primer apellido");
								String PApellido=L.next();
								System.out.println("Ingrese segundo apellido");
								String SApellido=L.next();
								System.out.println("Ingrese teléfono de casa");
								long TelCasa=L.nextLong();
								System.out.println("Ingrese teléfono movil");
								long TelMovil=L.nextLong();
								persona=new Persona(NIdentidad,Nombre,PApellido,SApellido,TelCasa,TelMovil);
								C.addElement(persona);
								}catch(InputMismatchException f) {
									System.out.println("Ingrese el valores correctos");
								}
						}else
							throw new ExcepcionesMain("Ingrese un carácter válido");
					}catch(ExcepcionesMain M) {
						System.out.println(M.getMessage());
					}
			break;
			
			case 3:
				ClientesAhorradores ca=null;
				c=' ';
				while(c!='t' && c!='T'&& c!='r' && c!='R')
					try {
						System.out.println("¿Desea capturar todos los datos del solicitante (T) ó únicamente los datos requeridos (R)?");	
						c=L.next().charAt(0);
						if(c=='t' || c=='T') {
							while(ca==null)
							try {
							System.out.println("Ingrese número de identidad");
							int NIdentidad=L.nextInt();
							System.out.println("Ingrese nombre del cliente");
							String Nombre=L.next();
							System.out.println("Ingrese primer apellido");
							String PApellido=L.next();
							System.out.println("Ingrese segundo apellido");
							String SApellido=L.next();
							System.out.println("Ingrese teléfono de casa");
							long TelCasa=L.nextLong();
							System.out.println("Ingrese teléfono movil");
							long TelMovil=L.nextLong();
							System.out.println("Ingrese domicilio");
							String Domicilio=L.next();
							CuentaAhorro Ca= new CuentaAhorro(FechaActual,0);
							ca=new ClientesAhorradores(NIdentidad,Nombre,PApellido,SApellido,TelCasa,TelMovil,Ca,Domicilio);
							Ca.setDueño(ca);
							C.addElement(ca);
							}catch(InputMismatchException f) {
								System.out.println("Ingrese el valores correctos");
							}
						}else if(c=='r' || c=='R') {
							try {
								System.out.println("Ingrese número de identidad");
								int NIdentidad=L.nextInt();
								System.out.println("Ingrese nombre del cliente");
								String Nombre=L.next();
								System.out.println("Ingrese primer apellido");
								String PApellido=L.next();
								System.out.println("Ingrese segundo apellido");
								String SApellido=L.next();
								System.out.println("Ingrese teléfono de casa");
								long TelCasa=L.nextLong();
								System.out.println("Ingrese teléfono movil");
								long TelMovil=L.nextLong();
								CuentaAhorro Ca= new CuentaAhorro(FechaActual,0);
								ca=new ClientesAhorradores(NIdentidad,Nombre,PApellido,SApellido,TelCasa,TelMovil, Ca);
								Ca.setDueño(ca);
								C.addElement(ca);
								}catch(InputMismatchException f) {
									System.out.println("Ingrese el valores correctos");
								}
						}else
							throw new ExcepcionesMain("Ingrese un carácter válido");
					}catch(ExcepcionesMain M) {
						System.out.println(M.getMessage());
					}
				
			break;
			
			case 4:
				for(int i=0;i<P.size();i++) 
					System.out.println(P.get(i));
			break;	
				
			case 5:
				System.out.println(Prestamo.ValorMaximo-Prestamo.Suma);
			break;
			
			case 6:
				char ctrl=' ';
				cont=' ';
				while(cont!='s' && cont!='S' && cont!='n' && cont!='N')
					try {
						System.out.println("¿El solicitante tiene cuenta de ahorros? (S=si N=no)");
						cont=L.next().charAt(0);
						if(cont=='n'||cont=='N') {
							System.out.println("Escriba el prestamo a pagar (Número de prestamo)");
							int np=L.nextInt();
							System.out.println("Escriba el número de pago");
							int np2=L.nextInt();
							P.get(Buscar2(np)).SumarIntereses(FechaActual,np2);
							System.out.println("El total a pagar es: "+P.get(Buscar2(np)));
							while(ctrl!= 't' && ctrl!= 'T' && ctrl!= 'e' && ctrl!= 'E')
							try {
							System.out.println("¿Desea pagar con tarjeta de crédito o efectivo? (T=Tarjeta - E=Efectivo");
							ctrl=L.next().charAt(0);
							if(ctrl=='t' || ctrl=='T') {
								System.out.println("Pago realizado con éxito");
							}else if(ctrl=='e' || ctrl=='E') {
								System.out.println("Pago realizado con éxito");
							}else
								throw new ExcepcionesMain("Ingrese un carácter válido");
							}catch(ExcepcionesMain M) {
								System.out.println(M.getMessage());
							}
						}else if(cont=='s'||cont=='S') {
							while(ctrl!= 's' && ctrl!= 'S' && ctrl!= 'n' && ctrl!= 'N')
							try {
								System.out.println("¿Desea pagar con saldo de la cuenta de ahorros? (S=si - N=no)");
								ctrl=L.next().charAt(0);
								if(ctrl=='S' || ctrl=='s') {
									System.out.println("Escriba el prestamo a pagar (Número de prestamo)");
									int np=L.nextInt();
									System.out.println("Escriba el número de pago");
									int np2=L.nextInt();
									P.get(Buscar2(np)).SumarIntereses(FechaActual,np2);
									System.out.println("El total a pagar es: "+P.get(Buscar2(np)).getValor());
								}else if(ctrl=='n' || ctrl=='N') {
									
								}else
									throw new ExcepcionesMain("Ingrese un carácter válido");
							}catch(ExcepcionesMain M) {
								M.getMessage();
							}
						}else 
							throw new ExcepcionesMain("Ingrese un carácter válido");
					}catch(ExcepcionesMain M) {
						System.out.println(M.getMessage());
					}
			break;
			
			case 7:
				System.out.println("Seleccione prestamo a liquidar (Elija número de prestamo)");
				
			break;
			
			case 8:
				
			break;		
			
			case 9:
				
			break;
				
			case 10:
			
			break;
				
			case 11:
				
			break;
				
			case 12:
				
			break;	
				
			case 13:
				
			break;
				
			case 14:
			
			break;		
			
			case 15:
				System.out.println("Finalizando sistema");
			break;	
			
			default:
				System.out.println("Opción incorrecta");
			break;	
			}
		}
	}

	public static int Dia(String fecha) {
		return Integer.parseInt(fecha.substring(0, 2));
	}
	
	public static int Mes(String fecha) {
		return Integer.parseInt(fecha.substring(3, 5));
	}
	
	public static int Año(String fecha) {
		return Integer.parseInt(fecha.substring(6));
	}
	
	public static void MostrarMenuPrincipal() {
		System.out.println("* * * M E N U * * *");
		System.out.println("1.Agregar prestamo");
		System.out.println("2.Agregar cliente sin cuenta de ahorro");
		System.out.println("3.Agregar cliente con cuenta de ahorro");
		System.out.println("4.Mostrar lista de prestamos otorgados");
		System.out.println("5.Mostrar cantidad disponible a prestar");
		System.out.println("6.Pagar prestamo");
		System.out.println("7.Liquidar prestamo");
		System.out.println("8.Lista de clientes con saldo vencido");
		System.out.println("9.Consultar datos de un cliente en particular");
		System.out.println("10.Imprimir lista de todos los clientes");
		System.out.println("11.Imprimir lista de clientes que tienen ahorro");
		System.out.println("*Para clientes con cuenta de ahorro*");
		System.out.println("12.Consultar saldo");
		System.out.println("13.Retirar saldo");
		System.out.println("14.Depositar saldo");
		System.out.println("15.Salir");
		System.out.print("Opción: ");
	}

	public static int Buscar(int NI) {
		int po=-1;
		for(int i=0;i<C.size();i++) {
			if(C.get(i).getNIdentidad()==NI);
				po=i;
		}
		return po;
	}
	
	public static int Buscar2(int np) {
		int p=0;
		for(int i=0;i<P.size();i++)
			if(P.get(i).getNPrestamo()==np)
				p=i;
		return p;		
	}
}

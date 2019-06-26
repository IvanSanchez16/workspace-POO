package autos;

public class UsoVehiculo {

    /**
     * @param args
     */
    static Vehiculo[] moviles;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        genera();
/*      Vehiculo v1=new Moto();
        Coche v2 = new Coche();
        System.out.println(acelerar(100,v1));
        System.out.println(v1.frenar(25));
        System.out.println(acelerar(130,v2));
        System.out.println(v2.frenar(25));*/

    }
    static void destruyeVehiculo(Vehiculo val){
        System.out.println("Envio a desguace "+ val.toString());

    }
    static String acelerar(int cantidad,Vehiculo vei){
        return vei.acelerar(cantidad);
    }
    public  static void genera(){
        moviles=new Vehiculo[6];
        moviles[0]=new Moto();
        moviles[1]=new Coche();
        moviles[2]=new Moto();
        moviles[3]=new Moto();
        moviles[4]=new Coche();
        moviles[5]=new Moto();
        for (int a=1;a<10;a++){
            avanza();
        }

    }
    public static void avanza(){
    	Coche carro=new Coche();
        System.out.println("Avanzando");
        for (int a=0;a<6;a++){
        	System.out.println(moviles[a].getClass());
        	if(moviles[a].getClass().isInstance(carro)){
        		((Coche)moviles[a]).AbrirPuerta();
        	}
        }
    }
}
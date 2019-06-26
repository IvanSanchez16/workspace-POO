package autos;

public class Coche implements Vehiculo {
    int velocidad=0;
    
    @Override
    public String frenar(int cuanto) {
        // TODO Auto-generated method stub;
        velocidad-=cuanto;
        return "El coche ha frenado ya y va a "+velocidad+"km/hora";
    }

    @Override
    public String acelerar(int cuanto) {
        // TODO Auto-generated method stub
        String cadena="";
        velocidad+=cuanto;
        if (velocidad>VELOCIDAD_MAXIMA)
            cadena="Exceso de velocidad";
        cadena+="El coche ha acelerado y va a "+velocidad+"km/hora";
        return cadena;
    }
    public int plazas(){
        return 4;
    }
    public void AbrirPuerta(){
    	System.out.println("Abriendo puerta");
    }
}
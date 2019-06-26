package autos;

public interface Vehiculo {
    final int VELOCIDAD_MAXIMA=120;

    String frenar(int cuanto);
    String acelerar(int cuanto);
}

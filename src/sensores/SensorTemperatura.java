package sensores;

import java.util.Random;

/**
 * Sensor de temperatura. Rango válido: [-10, 50] °C.
 */
public class SensorTemperatura extends Sensor {

    public static final int MIN = -10;
    public static final int MAX = 50;
    private static final Random RND = new Random();

    public SensorTemperatura(String id, int capacidad) {
        super(id, "C", capacidad);
    }

    @Override
    public int generarLectura() {
        int valor = RND.nextInt(MAX - MIN + 11) + (MIN - 5);
        registrarLectura(valor);
        return valor;
    }

    @Override
    public boolean fueraDeRango(int valor) {
        return valor < MIN || valor > MAX;
    }
}
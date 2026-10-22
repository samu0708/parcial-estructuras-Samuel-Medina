package red;

import sensores.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nodo IoT que COMPONE sensores.
 * Los sensores se crean dentro del nodo (composición real).
 */
public class NodoIoT {

    private String id;
    private ArrayList<Sensor> sensores;

    public NodoIoT(String id) {
        this.id = id;
        this.sensores = new ArrayList<>();
    }

    /**
     * Crea y agrega un sensor del tipo indicado dentro del nodo.
     * Tipo: "TEMPERATURA", "HUMEDAD", "LUMINOSIDAD".
     * Retorna el sensor creado, o null si el tipo es inválido.
     */
    public Sensor agregarSensor(String tipo, String idSensor, int capacidad) {
        Sensor sensor;
        switch (tipo) {
            case "TEMPERATURA":
                sensor = new SensorTemperatura(idSensor, capacidad);
                break;
            case "HUMEDAD":
                sensor = new SensorHumedad(idSensor, capacidad);
                break;
            case "LUMINOSIDAD":
                sensor = new SensorLuminosidad(idSensor, capacidad);
                break;
            default:
                return null;
        }
        sensores.add(sensor);
        return sensor;
    }

    /**
     * Promedio de temperatura del nodo. Retorna 0 si no hay sensores de temperatura.
     * Pista: usar instanceof para filtrar.
     */
    public double promedioTemperatura() {
        double suma = 0;
        int contados = 0;
        for (Sensor s : sensores) {
            if (s instanceof SensorTemperatura && s.getCantidadLecturas() > 0) {
                suma += s.promedioUltimasLecturas();
                contados++;
            }
        }
        if (contados == 0) {
            return 0;
        }
        return suma / contados;
    }

    /**
     * Lista de sensores cuya última lectura está fuera de rango.
     */
    public List<Sensor> sensoresFueraDeRango() {
        List<Sensor> resultado = new ArrayList<>();
        for (Sensor s : sensores) {
            if (s.getCantidadLecturas() > 0) {
                int[] buffer = s.getUltimasLecturas();
                int posUltima = (s.getIndiceActual() - 1 + buffer.length) % buffer.length;
                if (s.fueraDeRango(buffer[posUltima])) {
                    resultado.add(s);
                }
            }
        }
        return resultado;
    }

    public String getId() { return id; }
    public ArrayList<Sensor> getSensores() { return sensores; }
}
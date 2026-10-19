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
        // TODO: implementar (polimorfismo + composición)
        return null;
    }

    /**
     * Promedio de temperatura del nodo. Retorna 0 si no hay sensores de temperatura.
     * Pista: usar instanceof para filtrar.
     */
    public double promedioTemperatura() {
        // TODO: implementar
        return 0;
    }

    /**
     * Lista de sensores cuya última lectura está fuera de rango.
     */
    public List<Sensor> sensoresFueraDeRango() {
        // TODO: implementar
        return new ArrayList<>();
    }

    public String getId() { return id; }
    public ArrayList<Sensor> getSensores() { return sensores; }
}
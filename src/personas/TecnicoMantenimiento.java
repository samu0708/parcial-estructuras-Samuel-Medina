package personas;

import red.NodoIoT;
import java.util.ArrayList;

/**
 * Técnico que se ASOCIA a varios nodos (N:M).
 */
public class TecnicoMantenimiento {

    private String nombre;
    private ArrayList<NodoIoT> nodosAsignados;

    public TecnicoMantenimiento(String nombre) {
        this.nombre = nombre;
        this.nodosAsignados = new ArrayList<>();
    }

    /** Asocia el técnico a un nodo existente. */
    public void asignarNodo(NodoIoT nodo) {
        // TODO: implementar
    }

    public String getNombre() { return nombre; }
    public ArrayList<NodoIoT> getNodosAsignados() { return nodosAsignados; }
}

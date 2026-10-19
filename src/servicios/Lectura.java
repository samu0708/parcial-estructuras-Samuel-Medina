package servicios;

/**
 * Lectura de un sensor. DEPENDE de ValidadorLectura (no lo guarda como atributo).
 */
public class Lectura {

    private int valor;
    private String unidad;
    private long timestamp;

    public Lectura(int valor, String unidad, long timestamp) {
        this.valor = valor;
        this.unidad = unidad;
        this.timestamp = timestamp;
    }

    /** Usa ValidadorLectura como dependencia puntual. */
    public boolean esValida(String tipo, ValidadorLectura validador) {
        // TODO: implementar
        return false;
    }

    public int getValor() { return valor; }
    public String getUnidad() { return unidad; }
    public long getTimestamp() { return timestamp; }
}
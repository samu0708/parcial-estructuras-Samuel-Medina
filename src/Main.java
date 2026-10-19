import red.CentroMonitoreo;
import red.NodoIoT;
import sensores.Sensor;
import servicios.Lectura;
import servicios.ValidadorLectura;

/**
 * Escenario demostrativo — TODO estudiante: completar para evidenciar
 * el funcionamiento integral del sistema.
 */
public class Main {

    public static void main(String[] args) {
        CentroMonitoreo centro = new CentroMonitoreo("Central Agricola");

        NodoIoT n1 = new NodoIoT("N1");
        n1.agregarSensor("TEMPERATURA", "T1", 10);
        n1.agregarSensor("HUMEDAD", "H1", 10);
        n1.agregarSensor("LUMINOSIDAD", "L1", 10);

        centro.agregarNodo(n1);

        for (Sensor s : n1.getSensores()) {
            s.generarLectura();
        }

        System.out.println("Reporte del centro:");
        centro.reporteTemperaturas().forEach(System.out::println);

        ValidadorLectura v = new ValidadorLectura();
        Lectura l = new Lectura(25, "C", System.currentTimeMillis());
        System.out.println("Lectura valida? " + l.esValida("TEMPERATURA", v));
    }
}
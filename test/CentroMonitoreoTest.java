import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import red.*;

public class CentroMonitoreoTest {

    @Test
    void centroAgregaNodosExistentes() {
        CentroMonitoreo c = new CentroMonitoreo("Central");
        c.agregarNodo(new NodoIoT("N1"));
        c.agregarNodo(new NodoIoT("N2"));
        assertEquals(2, c.getNodos().size());
    }

    @Test
    void reporteTemperaturasGeneraUnaLineaPorNodo() {
        CentroMonitoreo c = new CentroMonitoreo("Central");
        NodoIoT n1 = new NodoIoT("N1");
        n1.agregarSensor("TEMPERATURA", "T1", 5);
        c.agregarNodo(n1);
        assertEquals(1, c.reporteTemperaturas().size());
    }
}
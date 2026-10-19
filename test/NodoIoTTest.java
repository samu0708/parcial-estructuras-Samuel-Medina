import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import red.NodoIoT;
import sensores.*;

public class NodoIoTTest {

    @Test
    void nodoComponeSensoresPorTipo() {
        NodoIoT n = new NodoIoT("N1");
        Sensor t = n.agregarSensor("TEMPERATURA", "T1", 10);
        Sensor h = n.agregarSensor("HUMEDAD", "H1", 10);
        assertNotNull(t);
        assertNotNull(h);
        assertEquals(2, n.getSensores().size());
        assertTrue(t instanceof SensorTemperatura);
        assertTrue(h instanceof SensorHumedad);
    }

    @Test
    void tipoInvalidoRetornaNull() {
        NodoIoT n = new NodoIoT("N1");
        assertNull(n.agregarSensor("PRESION", "P1", 10));
        assertEquals(0, n.getSensores().size());
    }

    @Test
    void promedioTemperaturaSoloConsideraTemperaturas() {
        NodoIoT n = new NodoIoT("N1");
        Sensor t = n.agregarSensor("TEMPERATURA", "T1", 10);
        Sensor h = n.agregarSensor("HUMEDAD", "H1", 10);
        t.registrarLectura(20);
        t.registrarLectura(30);
        h.registrarLectura(80);
        assertEquals(25.0, n.promedioTemperatura(), 0.01);
    }

    @Test
    void sensoresFueraDeRangoDetectaCorrectamente() {
        NodoIoT n = new NodoIoT("N1");
        Sensor t = n.agregarSensor("TEMPERATURA", "T1", 10);
        t.registrarLectura(100);
        assertEquals(1, n.sensoresFueraDeRango().size());
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sensores.*;

public class SensorTest {

    @Test
    void sensorTemperaturaGeneraLecturaYRegistra() {
        Sensor s = new SensorTemperatura("T1", 10);
        s.generarLectura();
        assertEquals(1, s.getCantidadLecturas());
    }

    @Test
    void historialRespetaCapacidadBufferCircular() {
        Sensor s = new SensorHumedad("H1", 3);
        s.registrarLectura(10);
        s.registrarLectura(20);
        s.registrarLectura(30);
        s.registrarLectura(40);
        assertEquals(3, s.getUltimasLecturas().length);
        assertEquals(3, s.getCantidadLecturas());
    }

    @Test
    void promedioUltimasLecturasFunciona() {
        Sensor s = new SensorTemperatura("T2", 5);
        s.registrarLectura(20);
        s.registrarLectura(30);
        assertEquals(25.0, s.promedioUltimasLecturas(), 0.01);
    }

    @Test
    void fueraDeRangoTemperatura() {
        Sensor s = new SensorTemperatura("T3", 5);
        assertTrue(s.fueraDeRango(100));
        assertFalse(s.fueraDeRango(25));
    }

    @Test
    void fueraDeRangoHumedad() {
        Sensor s = new SensorHumedad("H2", 5);
        assertTrue(s.fueraDeRango(-1));
        assertFalse(s.fueraDeRango(50));
    }

    @Test
    void fueraDeRangoLuminosidad() {
        Sensor s = new SensorLuminosidad("L1", 5);
        assertTrue(s.fueraDeRango(5000));
        assertFalse(s.fueraDeRango(500));
    }

    @Test
    void polimorfismoEnArregloDeSensores() {
        Sensor[] sensores = {
            new SensorTemperatura("T", 5),
            new SensorHumedad("H", 5),
            new SensorLuminosidad("L", 5)
        };
        for (Sensor s : sensores) s.generarLectura();
        for (Sensor s : sensores) assertEquals(1, s.getCantidadLecturas());
    }
}
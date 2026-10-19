import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import servicios.ValidadorLectura;

public class ValidadorLecturaTest {

    @Test
    void validaTemperatura() {
        ValidadorLectura v = new ValidadorLectura();
        assertTrue(v.esValida("TEMPERATURA", 25));
        assertFalse(v.esValida("TEMPERATURA", 100));
    }

    @Test
    void validaHumedad() {
        ValidadorLectura v = new ValidadorLectura();
        assertTrue(v.esValida("HUMEDAD", 50));
        assertFalse(v.esValida("HUMEDAD", -1));
    }

    @Test
    void validaLuminosidad() {
        ValidadorLectura v = new ValidadorLectura();
        assertTrue(v.esValida("LUMINOSIDAD", 500));
        assertFalse(v.esValida("LUMINOSIDAD", 5000));
    }
}
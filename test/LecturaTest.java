import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import servicios.Lectura;
import servicios.ValidadorLectura;

public class LecturaTest {

    @Test
    void lecturaUsaValidadorParaValidarse() {
        ValidadorLectura v = new ValidadorLectura();
        Lectura lOk = new Lectura(25, "C", System.currentTimeMillis());
        Lectura lBad = new Lectura(999, "C", System.currentTimeMillis());
        assertTrue(lOk.esValida("TEMPERATURA", v));
        assertFalse(lBad.esValida("TEMPERATURA", v));
    }
}
package servicios;

import sensores.SensorHumedad;
import sensores.SensorLuminosidad;
import sensores.SensorTemperatura;

public class ValidadorLectura {

    public boolean esValida(String tipo, int valor) {
        switch (tipo) {
            case "TEMPERATURA":
                return valor >= SensorTemperatura.MIN && valor <= SensorTemperatura.MAX;
            case "HUMEDAD":
                return valor >= SensorHumedad.MIN && valor <= SensorHumedad.MAX;
            case "LUMINOSIDAD":
                return valor >= SensorLuminosidad.MIN && valor <= SensorLuminosidad.MAX;
            default:
                return false;
        }
    }
}
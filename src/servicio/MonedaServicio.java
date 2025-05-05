package servicio;

import java.util.Map;

public interface MonedaServicio {

    public void conversorMoneda (String monedaUsuario, String monedaConversion, Double cantidadConversion);

    public void listaMonedas (String monedaUsuario);
}

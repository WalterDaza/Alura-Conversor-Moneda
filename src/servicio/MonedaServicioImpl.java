package servicio;

import controlador.MonedaControlador;

import java.util.Map;

public class MonedaServicioImpl implements MonedaServicio{
    MonedaControlador consultaMoneda = new MonedaControlador();
    @Override
    public void conversorMoneda (String monedaUsuario, String monedaConversion, Double cantidadConversion) {
        Map<String, Double> resultado = consultaMoneda.buscaMoneda(monedaUsuario).conversion_rates();
        String fechaConsulta = consultaMoneda.buscaMoneda(monedaUsuario).time_last_update_utc();

        Double tasa = resultado.get(monedaConversion);

        Double conversionNeta = tasa * cantidadConversion;

        System.out.printf("| ultima actualiuzación - %s |%n", fechaConsulta);
        System.out.printf("| El valor de %.2f %s corresponde al valor final -->> %.2f %s |"
                , cantidadConversion, monedaUsuario, conversionNeta, monedaConversion);
    }

    @Override
    public void listaMonedas(String monedaUsuario) {

        Map<String, Double> resultado = consultaMoneda.buscaMoneda(monedaUsuario).conversion_rates();

        int columnas = 15;
        int contador = 0;

        for (String moneda : resultado.keySet()) {
            System.out.printf("%-10s", moneda);  // Imprime la moneda con espacio de 10 caracteres
            contador++;

            if (contador >= columnas) {
                System.out.println();
                contador =0;
            }
        }
    }
}

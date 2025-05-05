package servicio;

import controlador.MonedaControlador;
import modelo.Moneda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonedaServicioImpl implements MonedaServicio{
    MonedaControlador consultaMoneda = new MonedaControlador();

    private List<String> historialConsultas = new ArrayList<>();
    @Override
    public void conversorMoneda (String monedaUsuario, String monedaConversion, Double cantidadConversion) {
        Moneda moneda = consultaMoneda.buscaMoneda(monedaUsuario);

        if(moneda == null){
            System.out.println("| Error: Código de moneda errado, consulta la lista en la opción 1. |");
            return;
        }

        Map<String, Double> resultado = moneda.getConversion_rates();
        String fechaConsulta = moneda.getTime_last_update_utc();

        Double tasa = resultado.get(monedaConversion);

        Double conversionNeta = tasa * cantidadConversion;

        System.out.printf("| ultima actualiuzación - %s |%n", fechaConsulta);
        System.out.printf("| El valor de %.2f %s corresponde al valor final -->> %.2f %s |"
                , cantidadConversion, monedaUsuario, conversionNeta, monedaConversion);

        String registro = String.format("%s: %.2f %s → %.2f %s (Tasa: %.4f)",
                fechaConsulta, cantidadConversion, monedaUsuario, conversionNeta, monedaConversion, tasa);
        historialConsultas.add(registro);
    }

    @Override
    public void listaMonedas(String monedaUsuario) {

        Map<String, Double> resultado = consultaMoneda.buscaMoneda(monedaUsuario).getConversion_rates();

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

    @Override
    public void historial() {
        System.out.println(" -------------------------------------------------------------------");
        System.out.println("|                 Historial de conversiones:                       |");
        System.out.println(" -------------------------------------------------------------------");
        if (historialConsultas.isEmpty()) {
            System.out.println(" -------------------------------------------------------------------");
            System.out.println("|               Sin conversiones realizadas aún.                   |");
            System.out.println(" -------------------------------------------------------------------");
        } else {
            historialConsultas.forEach(System.out::println);
        }
    }
}

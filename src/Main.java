import controlador.MonedaControlador;
import modelo.Moneda;
import servicio.MonedaServicioImpl;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MonedaServicioImpl monedaServicio = new MonedaServicioImpl();

        boolean salir = true;

        while(salir){
            System.out.println("\n*******************************************************");
            System.out.println("       | Bienvenido/a al conversor de monedas |");
            System.out.println("       | ------------------------------------ |");
            System.out.println("       |              Opciones                |");
            System.out.println("       | ------------------------------------ |");
            System.out.println("       | 1. Mostrar lista de monedas          |");
            System.out.println("       | 2. Ingresar al conversor             |");
            System.out.println("       | 3. Salir                             |");
            System.out.println("       | ------------------------------------ |");
            System.out.println("       |            Ten en cuenta             |");
            System.out.println("       | ------------------------------------ |");
            System.out.println("       | La moneda bede  ingresarse en siglas |\n" +
                               "       |  de 3 letras, por ejemplo USD, EUR,  |\n" +
                               "       |     etc.). Usa la opción 1 si no     |\n" +
                               "       |         conoces las siglas.          |");
            System.out.println("*******************************************************");
            System.out.print("   >> Ingrese opción valida: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|                                                   Lista de monedas que puedes acceder:                                                       |");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                    monedaServicio.listaMonedas("AED");
                    System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println(" -------------------------------------------------------------------");
                    System.out.print("Ingresa la moneda inicial: ");
                    String monedaUsuario = scanner.nextLine().toUpperCase();

                    System.out.print("Ingresa la moneda de conversión: ");
                    String monedaConversion = scanner.nextLine().toUpperCase();

                    System.out.print("Ingrese la cantidad que desea convertir de " + monedaUsuario + " a " + monedaConversion + ": ");
                    Double cantidadConversion = scanner.nextDouble();

                    System.out.println(" -------------------------------------------------------------------");
                    monedaServicio.conversorMoneda(monedaUsuario, monedaConversion, cantidadConversion);
                    System.out.println("\n -------------------------------------------------------------------");
                    break;
                case 3:
                    salir = false;
                    System.out.println("¡Gracias por utilizar el conversor de monedas!");
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }
        }
    }
}
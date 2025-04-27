package Principal;

import servicio.ApiExchangeRateService;
import java.util.Scanner;

public class Principañ{

public static void main(String[] args) {
    ApiExchangeRateService servicio = ApiExchangeRateService();
    Scanner scanner = new Scanner(System.in);

    int opcion = 0;

    do{
        System.out.println("Bienvenido/a al Conversor de Moneda");
        System.out.println("1. USD a EUR");
        System.out.println("2. USD a MXN");
        System.out.println("3. USD a JPY");
        System.out.println("4. USD a PER");
        System.out.println("5. Salir");
        System.out.println("Elige una opcion: ");
        opcion = scanner.nextInt();

        if(opcion != 5){
            System.out.println("Ingresa el monto a convertir: ");
            double monto = scanner.nextDouble();
            servicio.convertirMoneda(opcion, monto);
        }
    }while (opcion != 5);

    System.out.println("Gracias por usar el conversor.");

    }
}
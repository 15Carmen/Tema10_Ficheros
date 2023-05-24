package ejercicio08;

import java.util.Scanner;

public class MainEj8 {

    public static void main(String[] args) {

        //Declaramos las variables
        int opc;        //Variable donde almacenaremos la opción del menú elegida por el usuario
        String fecha;   //Variable donde almacenaremos la fecha de la temperatura
        double tempMin; //Variable donde almacenaremos la temperatura mínima
        double tempMax; //Variable donde almacenaremos la temperatura máxima

        //Declaramos el scanner para poder leer por teclado
        Scanner sc = new Scanner(System.in);

        //Mientras el usuario no elija la opción 3 (salir)
        do {
            //Mostramos el menú
            Utilidades.menu();
            //Leemos la opción elegida por el usuario
            opc = sc.nextInt();
            sc.nextLine();

            //Según la opción elegida por el usuario
            switch (opc) {
                case 1 -> { //Registra nueva temperatura

                    //Leemos los datos de la temperatura
                    System.out.println("Introduce la fecha: (aaaa-mm-dd)");
                    fecha = sc.nextLine();
                    System.out.println("Introduce la temperatura mínima:");
                    tempMin = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la temperatura máxima:");
                    tempMax = sc.nextDouble();
                    sc.nextLine();

                    //Registramos la temperatura
                    Utilidades.registrarTemperaturas(fecha, tempMin, tempMax);

                }
                case 2 -> {   //Mostramos el historial de registros
                    Utilidades.mostrarHistorial();
                }
                case 3 -> { //Salimos del programa
                    System.out.println("Adiós!");
                }
            }
        } while (opc != 3);

        //Cerramos el scanner
        sc.close();

    }

}




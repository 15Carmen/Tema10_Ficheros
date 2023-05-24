package ejercicio08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEj8 {

    public static void main(String[] args) {

        //Declaramos las variables
        int opcion = 0; //Variable donde guardaremos la opción del menú seleccionada

        // Declarar la lista de registros
        //RegistroTemperaturas.registros = new ArrayList<>();
        // Cargar los registros existentes desde el archivo
        RegistroTemperaturas.cargarRegistros();

        //Mientras la opción seleccionada sea diferente de 3 (salir)
        while (opcion != 3) {
            //Mostramos el menú y leemos la opción seleccionada por el usuario
            RegistroTemperaturas.mostrarMenu();
            opcion = RegistroTemperaturas.sc.nextInt();

            //Según la opción seleccionada por el usuario
            switch (opcion) {
                //Si la opción es 1, registramos una nueva temperatura
                case 1 -> RegistroTemperaturas.registrarTemperatura();
                //Si la opción es 2, mostramos el historial de registros
                case 2 -> RegistroTemperaturas.mostrarHistorial();
                //Si la opción es 3, salimos del programa
                case 3 -> System.out.println("Adiós!");
                //Si la opción es otra, mostramos un mensaje de error
                default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        }

        // Cuando el usuario selecciona la opción 3, guardamos los registros en el archivo
        RegistroTemperaturas.guardarRegistros();
    }
}

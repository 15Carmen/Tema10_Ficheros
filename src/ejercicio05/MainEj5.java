package ejercicio05;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Diseña una aplicación que pida al usuario su nombre y edad. Estos datos deben guardarse en el fichero datos.txt.
 * Si este fichero existe, deben añadirse al final en una nueva línea, y en caso de no existir, debe crearse.
 */

/**
 * Clase principal del ejercicio 5.
 */
public class MainEj5 {
    /**
     * Método principal de la clase.
     *
     * @param args
     */

    //Declaramos un linkedhashmap para guardar los nombre de los usuarios con sus edades
    private static final LinkedHashMap<String, Integer> usuarios = new LinkedHashMap<>();

    public static void main(String[] args) {

        //Declaramos las variables
        String nombre;      //Variable donde guardaremos el nombre del usuario
        int edad;           //Variable donde guardaremos la edad del usuario
        String respuesta;   //Variable donde guardaremos si el usuario quiere seguir introduciendo nombres o no

        //Declaramos el scanner para leer los datos del usuario
        Scanner sc = new Scanner(System.in);

        //Le preguntamos al usuario si quiere introducir un usuario
        System.out.println("Quiere introducir un usuario? (S/N)");
        respuesta = sc.next();

        //Mientras que responda que si
        while (respuesta.equals("S")) {
            //Le pedimos los datos al usuario
            System.out.print("Ingrese el nombre del usuario: ");
            nombre = sc.next();

            System.out.print("Ingrese la edad del usuario: ");
            edad = sc.nextInt();
            sc.nextLine();

            //Guardamos los datos en la colección
            usuarios.put(nombre, edad);

            //Le preguntamos al usuario si quiere introducir un usuario
            System.out.println("Quiere introducir otro usuario? (S/N)");
            respuesta = sc.next();
        }

        //Escribimos los datos en el fichero
        escribirDatos();
    }

    private static void escribirDatos() {

        //Declaramos las variables
        BufferedWriter bw;   //Variable donde guardaremos el BufferedWriter
        String linea;   //Variable donde guardaremos la línea leida del archivo de texto
        String nombre;
        int edad;

        try {
            //Inicializamos el BufferedWriter
            bw = new BufferedWriter(new FileWriter("datos.txt", true));

            //Recorremos la colección de registros y guardamos cada registro en el archivo de texto
            for (Map.Entry<String, Integer> entrada : usuarios.entrySet()) {

                nombre = entrada.getKey();
                edad = entrada.getValue();

                //Guardamos en la variable linea los datos del registro separados por comas
                linea = nombre + " " + edad;
                //Escribimos la línea en el archivo de texto
                bw.write(linea);
                //Pasamos a la siguiente línea el archivo de texto
                bw.newLine();
            }
            //Limpiamos el buffer
            bw.flush();
            bw.close(); //cerramos el buffer
        } catch (IOException e) {
            System.out.println("Error al guardar los registros en el archivo.");
        }
    }

}

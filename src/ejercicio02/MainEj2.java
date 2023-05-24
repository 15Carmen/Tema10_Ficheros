package ejercicio02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * Crear con un editor el fichero de texto Enteros.txt en la carpeta del proyecto y escribe en él una serie de números
 * enteros separados por secuencias de espacios y tabuladores, incluso en líneas distintas, tal como:
 * 2	3  45		73
 *   123		4   21
 * Implementar un programa que acceda a Enteros.txt con un objeto Scanner a través de un flujo de entrada, lea los
 * números y calcule la suma y la media aritmética, mostrando los resultados por pantalla.
 */


/**
 * Clase Principal
 */
public class MainEj2 {

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
        //Declaramos las variables
        double suma = 0;    //Variable donde guardaremos la suma de los números del fichero
        double media;       //Variable donde guardaremos la media de los números del fichero
        int contador = 0;   //Variable donde guardaremos el número de números del fichero

        Scanner sc = null;
        try {
            //Creamos el objeto Scanner para leer el fichero
            sc = new Scanner(new FileReader("src/ejercicio02/Enteros.txt"));

            //Mientras haya un número en el fichero, lo sumamos a la variable suma y aumentamos el contador
            while(sc.hasNextDouble()) {
                suma += sc.nextDouble();
                contador++;
            }

            //Calculamos la media
            media = suma / contador;

            //Mostramos los resultados por pantalla
            System.out.println("La suma de los números del fichero es: " + suma);
            System.out.println("La media de los números del fichero es: " + media);



        } catch (FileNotFoundException e) { //Si el fichero no existe, mostramos un mensaje de error
            System.err.println("Fichero no encontrado.");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}

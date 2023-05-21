package ejercicio02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainEj2 {
    public static void main(String[] args) {
        //Declaramos las variables
        double suma = 0;    //Variable donde guardaremos la suma de los números del fichero
        double media;       //Variable donde guardaremos la media de los números del fichero
        int contador = 0;   //Variable donde guardaremos el número de números del fichero

        try {
            //Creamos el objeto Scanner para leer el fichero
            Scanner sc = new Scanner(new FileReader("src/ejercicio02/Enteros.txt"));

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

            //Cerramos el fichero
            sc.close();

        } catch (FileNotFoundException e) { //Si el fichero no existe, mostramos un mensaje de error
            System.err.println("Fichero no encontrado.");
        }
    }
}

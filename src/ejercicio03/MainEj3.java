package ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Crea con un editor el fichero de texto Alumnos.txt en la carpeta del proyecto y escribe en él los nombres, edades
 * y estaturas de los alumnos de un grupo, cada uno en una línea:
 * juan 22 1.77
 * luis 21 1.80
 * pedro 20 1.73
 * …
 * Implementa un programa que lea del fichero los datos, muestre los nombres y calcule la media de la edad y de las
 * estaturas, mostrándolas por pantalla.
 */
public class MainEj3 {
    public static void main(String[] args) {

        //Declaramos las variables
        String linea = null;    //Variable donde guardaremos cada línea del fichero
        String[] nombres;      //Array donde guardaremos los nombres, la edad y la altura de cada alumno
        int sumaEdad = 0;       //Variable donde guardaremos la suma de las edades de los alumnos
        int sumaAltura = 0;     //Variable donde guardaremos la suma de las alturas de los alumnos
        int contador = 0;       //Variable donde guardaremos el número de alumnos
        BufferedReader br = null;  //Objeto BufferedReader para leer el fichero

        try {
            //Creamos el objeto BufferedReader para leer el fichero
            br = new BufferedReader(new FileReader("src/ejercicio03/Alumnos.txt"));

            //Leemos la primera línea del fichero
            linea = br.readLine();

            //Mientras haya una línea en el fichero
            while (linea != null) {

                //Separamos la línea en un array de Strings
                nombres = linea.split(" ");

                //Mostramos el nombre del alumno
                System.out.println(nombres[0]);

                //Sumamos la edad y la altura del alumno a las variables correspondientes
                sumaEdad += Integer.parseInt(nombres[1]);
                sumaAltura += Double.parseDouble(nombres[2]);

                //Aumentamos el contador
                contador++;

                //Leemos la siguiente línea del fichero
                linea = br.readLine();
            }

            //Mostramos los resultados por pantalla
            System.out.println();   //Salto de línea estético
            System.out.println("La suma de las edades de los alumnos es de: " + sumaEdad + " años");
            System.out.println("La edad media del alumnado es de: " + (double) sumaEdad / contador + " años");
            System.out.println("La suma de las alturas de los alumnos es de: " + sumaAltura + " cm");
            System.out.println("La altura media del alumnado es de: " + (double) sumaAltura / contador + " cm");


        } catch (FileNotFoundException e) { //Si el fichero no existe, mostramos un mensaje de error
            System.err.println("Fichero no encontrado.");
        } catch (IOException e1) {        //Si se produce un error al leer el fichero, mostramos un mensaje de error
            System.err.println("El fichero está vacío");
        } finally {
            try {
                if (br != null) {
                    br.close();     //Cerramos el objeto BufferedReader
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el fichero");
            }
        }
    }
}

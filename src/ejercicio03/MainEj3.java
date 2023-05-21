package ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainEj3 {
    public static void main(String[] args) {

        //Declaramos las variables
        String linea = null;    //Variable donde guardaremos cada línea del fichero
        String [] nombres;      //Array donde guardaremos los nombres, la edad y la altura de cada alumno
        int sumaEdad = 0;       //Variable donde guardaremos la suma de las edades de los alumnos
        int sumaAltura = 0;     //Variable donde guardaremos la suma de las alturas de los alumnos
        int contador = 0;       //Variable donde guardaremos el número de alumnos

        try {
            //Creamos el objeto BufferedReader para leer el fichero
            BufferedReader br = new BufferedReader(new FileReader("src/ejercicio03/Alumnos.txt"));

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
            System.out.println("La media de edad de los alumnos es de: " + (double) sumaEdad / contador + " años");
            System.out.println("La suma de las alturas de los alumnos es de: " + sumaAltura + " cm");
            System.out.println("La media de altura de los alumnos es de: " + (double) sumaAltura / contador + " cm");

            //Cerramos el fichero
            br.close();

        } catch (FileNotFoundException e) { //Si el fichero no existe, mostramos un mensaje de error
            System.err.println("Fichero no encontrado.");
        } catch (IOException e1) {        //Si se produce un error al leer el fichero, mostramos un mensaje de error
            System.err.println("El fichero está vacío");
        }    }
}

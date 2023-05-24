package ejercicio06;

/*
 * Implementa un programa que lea números enteros no ordenados de un archivo, con un número por línea,
 * y los almacene en una lista. A continuación, debe guardar los números de la lista en otro fichero distinto
 * pero ordenados de forma ascendente.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase principal.
 */
public class MainEj6 {

    //Declaramos una colección de tipo TreeSet para guardar los números del fichero ordenados
    private static Set<Integer> numerosOrdenados = new TreeSet<Integer>();

    /**
     * Metodo principal de la clase.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Si leerFichero() devuelve true, es que se ha leído el fichero correctamente
        if (leerFichero()) {
            //Si escribirFichero() devuelve true, es que se ha escrito el fichero correctamente
            if (escribirFichero()) {
                System.out.println("Fichero leido y escrito correctamente.");
            }
        }

    }

    /**
     * Método que lee el fichero NumerosDesordenados.txt y guarda los números en la colección numerosOrdenados.
     * @return true si se ha leído el fichero correctamente, false en caso contrario.
     */
    private static boolean leerFichero() {
        //Declaramos las varaibles
        BufferedReader br = null;   //Variable para leer el fichero
        String linea;               //Variable para guardar cada línea leida del fichero
        boolean exito = false;      //Variable que indica si se ha leído el fichero correctamente

        try {
            //Creamos el objeto BufferedReader para leer el fichero que le indicamos
            br = new BufferedReader(new FileReader("src/ejercicio06/NumerosDesordenados.txt"));

            //Leemos la primera línea del fichero
            linea = br.readLine();

            //Mientras la línea no sea null, es decir, mientras haya una línea que leer
            while (linea != null) {
                //Añadimos el número leido a la colección
                numerosOrdenados.add(Integer.parseInt(linea));
                //Leemos la siguiente línea del fichero
                linea = br.readLine();
            }

            //Si llegamos aquí, es que se ha leído el fichero correctamente
            exito = true;

        } catch (FileNotFoundException e) { //Si el fichero no existe, mostramos un mensaje de error
            System.err.println("Error al abrir el fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {   //Si se produce un error al leer el fichero, mostramos un mensaje de error
            System.err.println("Error al leer el fichero");
            System.out.println(e.getMessage());
        } finally { //En el bloque finally cerramos el fichero
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return exito;
    }

    /**
     * Método que escribe los números de la colección numerosOrdenados en el fichero NumerosOrdenados.txt.
     * @return true si se ha escrito el fichero correctamente, false en caso contrario.
     */
    private static boolean escribirFichero() {
        //Declaramos las variables
        BufferedWriter bw = null;   //Variable para escribir en el fichero
        String linea;               //Variable para guardar cada número de la colección
        boolean exito = false;      //Variable que indica si se ha escrito el fichero correctamente

        try {
            //Creamos el objeto BufferedWriter para escribir en el fichero que le indicamos
            bw = new BufferedWriter(new FileWriter("src/ejercicio06/NumerosOrdenados.txt"));

            //Recorremos la colección y escribimos cada número en una linea del nuevo fichero
            for (Integer numero : numerosOrdenados) {
                linea = numero.toString();
                bw.write(linea);
                bw.newLine();
            }
            //Limpiamos el buffer
            bw.flush();

            //Si llegamos aquí, es que se ha escrito el fichero correctamente
            exito = true;

        } catch (IOException e) {   //Si se produce un error al escribir el fichero, mostramos un mensaje de error
            System.out.println("Error al crear el fichero");
            System.out.println(e.getMessage());
        } finally { //En el bloque finally cerramos el fichero
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return exito;
    }
}



package ejercicio04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Escribe un texto en un archivo de texto, línea a línea leídas de teclado, hasta que se introduzca la cadena “fin”.
 */

/**
 * Classe principal.
 */
public class MainEj4 {
    /**
     * Metodo principal de la classe.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Declaramos las variables
        BufferedWriter bw = null;               //Variable donde guardaremos el BufferedWriter
        String texto;                           //Variable donde guardaremos el texto introducido por el usuario

        //Declaramos el scanner para leer los datos del usuario
        Scanner sc = new Scanner(System.in);
        try {
            //Declaramos el BufferedWriter
            bw = new BufferedWriter(new FileWriter("src/ejercicio04/escribir.txt"));

            //Leemos el texto del usuario
            texto = sc.nextLine();
            //Mientras que el texto no sea "fin"
            while (!texto.equals("fin")) {
                //Escribimos el texto en el fichero
                bw.write(texto);
                //Pasamos a la siguiente línea
                bw.newLine();
                //Leemos el texto que vuelva a introducir el usuario
                texto = sc.nextLine();
            }
            //Limpiamos el buffer
            bw.flush();

        } catch (IOException e) {   //Capturamos la excepción
            System.out.println("Error al crear el fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    //Cerramos el BufferedWriter y el Scanner
                    bw.close();
                    sc.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
            }
        }
    }
}


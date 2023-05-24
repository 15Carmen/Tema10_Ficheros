package ejercicio04;

/*
 * Escribe un texto en un archivo de texto, línea a línea leídas de teclado, hasta que se introduzca la cadena “fin”.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        BufferedWriter bw = null;
        Scanner sc = new Scanner(System.in);
        String texto = "";
        try {
            bw = new BufferedWriter(new FileWriter("src/ejercicio04/escribir.txt"));

            texto = sc.nextLine();
            while (!texto.equals("fin")) {
                bw.write(texto);
                bw.newLine();
                texto = sc.nextLine();
            }

            bw.flush();

        } catch (IOException e) {
            System.out.println("Error al crear el fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


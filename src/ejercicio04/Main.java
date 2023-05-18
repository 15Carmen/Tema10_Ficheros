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
public class Main {
    /**
     * Metodo principal de la classe.
     *
     * @param args
     */
    public static void main(String[] args) {
        BufferedWriter escritura = null;
        Scanner sc = new Scanner(System.in);
        String texto = "";
        try {
            escritura = new BufferedWriter(new FileWriter("escribir.txt"));

            texto = sc.nextLine();
            while (!texto.equals("fin")) {
                escritura.write(texto);
                escritura.newLine();
                texto = sc.nextLine();
            }

            escritura.flush();

        } catch (IOException e) {
            System.out.println("Error al crear el fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                escritura.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


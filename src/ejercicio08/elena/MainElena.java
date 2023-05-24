package ejercicio08.elena;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class MainElena {
    public static void main(String[] args) {
        int opc;
        String fecha;
        double tempMin;
        double tempMax;
        double tempMinTotal = Double.MAX_VALUE;
        double tempMaxTotal = Double.MIN_VALUE;
        String linea;
        String[] datos;
        final String FICHERO = "src/ejercicio08/elena/temperaturas.txt";

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {

            do {
                menu();
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1 -> { //Registra nueva temperatura
                        bw = new BufferedWriter(new FileWriter(FICHERO, true));

                        System.out.println("Introduce la fecha: (aaaa-mm-dd)");
                        fecha = sc.nextLine();
                        System.out.println("Introduce la temperatura mínima:");
                        tempMin = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce la temperatura máxima:");
                        tempMax = sc.nextDouble();
                        sc.nextLine();

                        bw.write(fecha + "," + tempMin + "," + tempMax);
                        bw.newLine();
                        bw.flush();

                    }
                    case 2 -> {   //Mostrar historial de registros
                        br = new BufferedReader(new FileReader(FICHERO));
                        br.readLine(); //Leemos la primera línea del fichero para saltarnos la cabecera si tenemos
                        linea = br.readLine();  //Leemos la primera línea del fichero

                        while (linea != null) {
                            datos = linea.split(",");
                            System.out.println("Fecha: " + datos[0]);

                            tempMin = Double.parseDouble(datos[1]);
                            tempMax = Double.parseDouble(datos[2]);

                            System.out.println("Temperatura mínima: " + tempMin);
                            System.out.println("Temperatura máxima: " + tempMax);
                            System.out.println("--------------------------------------------------");

                            if (tempMaxTotal < tempMax) {
                                tempMaxTotal = tempMax;
                            }

                            if (tempMinTotal > tempMin) {
                                tempMinTotal = tempMin;
                            }

                            linea = br.readLine();
                        }

                        System.out.println("La temperatura máxima registrada es: " + tempMaxTotal);
                        System.out.println("La temperatura mínima registrada es: " + tempMinTotal);
                        System.out.println("--------------------------------------------------");

                        /**
                         * Si queremos leer el archivo con un scanner la estructura sería la siguiente:
                         * Debemos declarar un objeto scanner distinto al que hemos declarado para leer por teclado
                         * Scanner leerFichero = new Scanner(new File(FICHERO));
                         *
                         * while (sc.hasNextLine()){
                         *    linea = sc.nextLine();
                         *
                         * }
                         */

                    }
                }
            } while (opc != 3);


        } catch (IOException e) {   //Si no se puede abrir el fichero
            System.err.println("Error al abrir el fichero");  //Capturamos la excepción y mostramos un mensaje de error
            System.out.println(e.getLocalizedMessage());
        } finally {
            try {
                if (bw != null) {    //Si el buffer no es nulo
                    bw.close();    //Cerramos el bufferwriter
                    br.close();    //Cerramos el bufferreader
                    sc.close();    //Cerramos el scanner
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el fichero");
                System.out.println(e.getLocalizedMessage());
            }
        }

    }

    private static void menu() {
        System.out.println("""
                ==================MENU==================
                [1] Registra nueva temperatura.
                [2] Mostrar historial de registros.
                [3] Salir.
                                
                """);
    }
}

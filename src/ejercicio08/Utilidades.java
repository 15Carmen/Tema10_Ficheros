package ejercicio08;

import java.io.*;

public class Utilidades {

    /**
     * Constante que almacena la ruta del fichero.
     */
    private static final String FICHERO = "src/ejercicio08/temperaturas.txt";

    /**
     * Método que muestra el menú por pantalla.
     */
    protected static void menu() {
        System.out.println("""
                ==================MENU==================
                [1] Registra nueva temperatura.
                [2] Mostrar historial de registros.
                [3] Salir.
                                
                """);
    }

    /**
     * Método que registra una nueva temperatura en el fichero.
     * @param fecha Fecha de la temperatura.
     * @param tempMin Temperatura mínima.
     * @param tempMax Temperatura máxima.
     */
    protected static void registrarTemperaturas(String fecha, double tempMin, double tempMax) {

        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(FICHERO, true));
            bw.write(fecha + "," + tempMin + "," + tempMax);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.err.println("Error de escritura en el fichero");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el fichero");
            }
        }
    }

    /**
     * Método que lee el fichero y muestra el historial de temperaturas, así como la máxima temperatura máxima y la mínima temperatura mínima.
     */
    protected static void mostrarHistorial() {

        //Declaramos las variables
        double tempMin;                         //Variable donde almacenaremos la temperatura mínima
        double tempMax;                         //Variable donde almacenaremos la temperatura máxima
        double tempMinTotal = Double.MAX_VALUE; //Variable donde almacenaremos la temperatura mínima más baja
        double tempMaxTotal = Double.MIN_VALUE; //Variable donde almacenaremos la temperatura máxima más alta
        String linea;                           //Variable donde almacenaremos la línea leída del fichero
        String[] datos;                         //Array donde almacenaremos los datos de la línea leída del fichero

        //Declaramos el BufferedReader
        BufferedReader br = null;
        try {
            //Inicializamos el BufferedReader y le pasamos el fichero
            br = new BufferedReader(new FileReader(FICHERO));
            linea = br.readLine();  //Leemos la primera línea del fichero

            //Mientras la línea no sea nula, es decir, mientras haya líneas en el fichero, seguimos leyendo
            while (linea != null) {
                //Separamos los datos de la línea leída por comas y los almacenamos en el array
                datos = linea.split(",");
                //Mostramos los datos por pantalla
                System.out.println("Fecha: " + datos[0]);

                //Convertimos los datos de tipo String a tipo double
                tempMin = Double.parseDouble(datos[1]);
                tempMax = Double.parseDouble(datos[2]);

                //Mostramos los datos por pantalla
                System.out.println("Temperatura mínima: " + tempMin);
                System.out.println("Temperatura máxima: " + tempMax);
                System.out.println("--------------------------------------------------");

                //Si la temperatura máxima es mayor que la temperatura máxima más alta
                if (tempMaxTotal < tempMax) {
                    //Almacenamos la temperatura máxima en la variable tempMaxTotal
                    tempMaxTotal = tempMax;
                }

                //Si la temperatura mínima es menor que la temperatura mínima más baja
                if (tempMinTotal > tempMin) {
                    //Almacenamos la temperatura mínima en la variable tempMinTotal
                    tempMinTotal = tempMin;
                }

                //Leemos la siguiente línea del fichero
                linea = br.readLine();
            }

            // Una vez que dejamos de leer el fichero mostramos por pantalla la temperatura máxima más alta y la temperatura mínima más baja
            System.out.println("La temperatura máxima registrada es: " + tempMaxTotal);
            System.out.println("La temperatura mínima registrada es: " + tempMinTotal);
            System.out.println("--------------------------------------------------");

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero");
            e.getLocalizedMessage();
        } catch (IOException e) {
            System.err.println("Error de lectura en el fichero");
            e.getLocalizedMessage();
        }

    }


}

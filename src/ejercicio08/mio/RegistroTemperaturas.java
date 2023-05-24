package ejercicio08.mio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que contiene los métodos necesarios para el funcionamiento del programa, como el menú, el registro de temperaturas, etc.
 */
public class RegistroTemperaturas {

    //Declaramos el nombre del archivo de texto donde vamos a guardar los registros
    protected static final String ARCHIVO_REGISTRO = "registro_temperaturas.txt";

    //Declaramos la colección donde vamos a guardar los registros
    protected static List<Temperaturas> registros;

    //Declaramos el objeto Scanner para leer datos por teclado
    protected static Scanner sc = new Scanner(System.in);

    /**
     * Método que muestra por pantalla el menu de opciones.
     */
    protected static void mostrarMenu() {
        System.out.println("Selecciona una opción: ");
        System.out.println("1. Registrar nueva temperatura");
        System.out.println("2. Mostrar historial de registros");
        System.out.println("3. Salir");
    }

    /**
     * Método que guarda la fecha y las temperaturas máxima y mínima en la colección de registros.
     */
    protected static void registrarTemperatura() {

        //Declaramos las variables
        String fechaString; //Variable donde guardaremos la fecha en formato String
        LocalDate fecha;    //Variable donde guardaremos la fechaString parseada en formato LocalDate
        int temperaturaMaxima;  //Variable donde guardaremos la temperatura máxima
        int temperaturaMinima;  //Variable donde guardaremos la temperatura mínima

        //Le pedimos los datos al usuario
        System.out.print("Ingrese la fecha (formato: AAAA-MM-DD): ");
        fechaString = sc.next();
        //Parseamos la fechaString a LocalDate
        fecha = LocalDate.parse(fechaString);

        System.out.print("Ingrese la temperatura máxima: ");
        temperaturaMaxima = sc.nextInt();

        System.out.print("Ingrese la temperatura mínima: ");
        temperaturaMinima = sc.nextInt();

        //Creamos un nuevo registro con los datos ingresados por el usuario
        Temperaturas registro = new Temperaturas(fecha, temperaturaMaxima, temperaturaMinima);
        //Agregamos el registro a la colección de registros
        registros.add(registro);
    }

    /**
     * Método que muestra por pantalla el historial de registros.
     */
    protected static void mostrarHistorial() {

        //Declaramos las variables
        int maximaTemperaturaMaxima; //Variable donde guardaremos la máxima temperatura máxima registrada
        int minimaTemperaturaMinima; //Variable donde guardaremos la mínima temperatura mínima registrada

        //Si la colección de registros está vacía, mostramos un mensaje de error
        if (registros.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {    //Si la colección de registros no está vacía, mostramos el historial de registros

            System.out.println("=== HISTORIAL DE REGISTROS ===");

            //Recorremos la colección de registros y mostramos cada registro por pantalla
            for (Temperaturas registro : registros) {
                System.out.println(registro);
            }

            //Calculamos la máxima temperatura máxima y la mínima temperatura mínima registradas
            maximaTemperaturaMaxima = Integer.MIN_VALUE;
            minimaTemperaturaMinima = Integer.MAX_VALUE;

            //Recorremos la colección de registros y calculamos la máxima temperatura máxima y la mínima temperatura mínima registradas
            for (Temperaturas registro : registros) {
                maximaTemperaturaMaxima = Math.max(maximaTemperaturaMaxima, registro.getTemperaturaMaxima());
                minimaTemperaturaMinima = Math.min(minimaTemperaturaMinima, registro.getTemperaturaMinima());
            }

            //Mostramos por pantalla los resultados
            System.out.println("====================================");
            System.out.println("Máxima temperatura máxima registrada: " + maximaTemperaturaMaxima);
            System.out.println("Mínima temperatura mínima registrada: " + minimaTemperaturaMinima);
        }
    }

    /**
     * Método que leerá los registros existentes del archivo de texto.
     */
    protected static void cargarRegistros() {

        //Declaramos las variables
        BufferedReader br;  //Variable donde guardaremos el BufferedReader
        String linea;   //Variable donde guardaremos cada línea del archivo de texto
        String[] campos;    //Variable donde guardaremos los campos de cada línea del archivo de texto
        LocalDate fecha;    //Variable donde guardaremos la fecha
        int temperaturaMaxima;  //Variable donde guardaremos la temperatura máxima
        int temperaturaMinima;  //Variable donde guardaremos la temperatura mínima

        try {

            //Inicializamos el BufferedReader
            br = new BufferedReader(new FileReader(ARCHIVO_REGISTRO));

            //Mientras haya líneas en el archivo de texto
            while ((linea = br.readLine()) != null) {

                //Separamos los diferentes campos de la línea (fecha, temperatura máxima y temperatura mínima) por las comas
                campos = linea.split(",");

                //Guardamos las variables en sus respectivos campos
                fecha = LocalDate.parse(campos[0]);
                temperaturaMaxima = Integer.parseInt(campos[1]);
                temperaturaMinima = Integer.parseInt(campos[2]);

                //Creamos un nuevo registro con los datos del archivo de texto
                Temperaturas registro = new Temperaturas(fecha, temperaturaMaxima, temperaturaMinima);
                //Agregamos el registro a la colección de registros
                registros.add(registro);
            }

        } catch (IOException e) {  //Capturamos la excepción y lanzamos un mensaje de error
            System.err.println("Error al cargar los registros desde el archivo.");
        }
    }

    /**
     * Método que guarda los registros en el archivo de texto.
     */
    protected static void guardarRegistros() {

        //Declaramos las variables
        BufferedWriter bw;   //Variable donde guardaremos el BufferedWriter
        String linea;   //Variable donde guardaremos la línea leida del archivo de texto

        try {
            //Inicializamos el BufferedWriter
            bw = new BufferedWriter(new FileWriter(ARCHIVO_REGISTRO));

            //Recorremos la colección de registros y guardamos cada registro en el archivo de texto
            for (Temperaturas registro : registros) {

                //Guardamos en la variable linea los datos del registro separados por comas
                linea = registro.getFecha() + "," + registro.getTemperaturaMaxima() + "," + registro.getTemperaturaMinima();
                //Escribimos la línea en el archivo de texto
                bw.write(linea);
                //Pasamos a la siguiente línea el archivo de texto
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los registros en el archivo.");
        }
    }
}
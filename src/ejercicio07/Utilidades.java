package ejercicio07;

import java.io.*;
import java.util.TreeMap;

/**
 * Clase donde se encuentran todos los métodos necesarios para el funcionamiento del programa.
 */
public class Utilidades {

    //Declaramos la colección en la que vamos a guardar los contactos
    protected static final TreeMap<String, String> agenda = new TreeMap<>();
    protected static final String FILE = "src/ejercicio07/contactos.txt";

    /**
     * Método que muestra el menú por pantalla.
     */
    protected static void pintarMenu() {
        System.out.println("1. Nuevo contacto.");
        System.out.println("2. Buscar por nombre.");
        System.out.println("3. Mostrar todos.");
        System.out.println("4. Salir.");
    }

    /**
     * Método que añade un nuevo contacto a la agenda.
     *
     * @param nombre   nombre del contacto a añadir
     * @param telefono teléfono del contacto a añadir
     * @throws MaxSizeException excepción que se lanza cuando la agenda está llena
     */
    protected static void nuevoContacto(String nombre, String telefono) throws MaxSizeException, SameNameException {

        //Si la agenda tiene menos de 20 contactos y el nombre del contacto no existe en la agenda
        if (agenda.size() > 20) {
            throw new MaxSizeException();   //Lanzamos la excepción
        } else if (agenda.containsKey(nombre)) {
            throw new SameNameException();   //Lanzamos la excepción
        } else {
            agenda.put(nombre, telefono);   //Añadimos el contacto a la agenda
        }

    }

    /**
     * Método que buscará en la agenda un contacto por su nombre.
     *
     * @param nombre nombre del contacto a buscar
     */
    protected static void buscarPorNombre(String nombre) {
        for (String nombreContacto : agenda.keySet()) { //Recorremos la agenda
            if (nombreContacto.equals(nombre)) {    //Si el nombre del contacto coincide con el nombre introducido por el usuario
                System.out.println("Nombre: " + nombreContacto + " - Teléfono: " + agenda.get(nombreContacto)); //Mostramos el contacto por pantalla
            }

        }
    }

    protected static void cargarAgenda() {
        BufferedReader br = null;  //Declaramos el buffer de lectura
        String linea;   //Declaramos la variable que almacenará cada línea del archivo de texto
        String[] datos; //Declaramos el array que almacenará los datos de cada línea del archivo de texto


        try {
            br = new BufferedReader(new FileReader(FILE)); //Inicializamos el buffer de lectura
            linea = br.readLine();  //Leemos la siguiente línea del archivo de texto
            //Leemos el archivo de texto línea a línea
            while (linea != null && !linea.equals("")) {
                //Separamos los datos de la línea leída por comas y los almacenamos en el array
                datos = linea.split(" - ");
                agenda.put(datos[0], datos[1]);   //Añadimos el contacto a la agenda
                linea = br.readLine();  //Leemos la siguiente línea del archivo de texto
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo de texto");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto");
            System.out.println(e.getLocalizedMessage());
        }finally {
            try {
                if (br != null) {
                    br.close(); //Cerramos el bufferreader
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el fichero");
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    /**
     * Método que muestra todos los contactos de la agenda.
     */
    protected static void mostrarTodos() {
        for (String nombreContacto : agenda.keySet()) { //Recorremos la agenda
            System.out.println("Nombre: " + nombreContacto + " - Teléfono: " + agenda.get(nombreContacto)); //Mostramos el contacto por pantalla
        }
    }

    /**
     * Método que escribe en un archivo de texto todos los contactos de la agenda.
     */
    protected static void escribirFichero() {
        BufferedWriter bw = null;  //Declaramos el buffer de escritura
        try {
            //Inicializamos el buffer de escritura
            bw = new BufferedWriter(new FileWriter(FILE));

            //Recorremos la agenda
            for (String nombreContacto : agenda.keySet()) {
                //Escribimos en el archivo de texto el nombre y el teléfono del contacto
                bw.write(nombreContacto + " - " + agenda.get(nombreContacto));
                bw.newLine();   //Escribimos un salto de línea
            }
            bw.flush(); //Vaciamos el buffer


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bw.close();    //Cerramos el bufferwriter
        } catch (IOException e) {
            System.err.println("Error al cerrar el fichero");
            System.out.println(e.getLocalizedMessage());
        }
    }
}


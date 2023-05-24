package ejercicio07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Clase donde se encuentran todos los métodos necesarios para el funcionamiento del programa.
 */
public class Utilidades {

    //Declaramos la colección en la que vamos a guardar los contactos
    protected static TreeMap<String, String> agenda = new TreeMap<>();

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
            //Declaramos el buffer de escritura
            bw = new BufferedWriter(new FileWriter("src/ejercicio07/contactos.txt", true));

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


package ejercicio07;

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
     * @param nombre  nombre del contacto a añadir
     * @param telefono  teléfono del contacto a añadir
     * @throws MaxSizeException excepción que se lanza cuando la agenda está llena
     */
    protected static void nuevoContacto(String nombre, String telefono) throws MaxSizeException{

        //Si la agenda tiene menos de 20 contactos, añadimos el contacto
        if (agenda.size() < 20){
            agenda.put(nombre, telefono);
        } else {    //Si la agenda tiene 20 contactos, lanzamos la excepción
            throw new MaxSizeException();
        }
    }





}

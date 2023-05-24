package ejercicio07;


/*
 * Diseña una pequeña agenda, que muestre el siguiente menú:
 * Nuevo contacto.
 * Buscar por nombre.
 * Mostrar todos.
 * Salir.
 * En ella, guardaremos el nombre y el teléfono de un máximo de 20 personas.
 * La opción 1 nos permitirá introducir un nuevo contacto siempre y cuando la agenda no esté llena, comprobando que el nombre no se encuentra ya insertado.
 * La opción 2 pedirá el nombre a buscar en la agenda y mostrará el teléfono correspondiente a dicho nombre.
 * La opción 3 mostrará un listado con toda la información (nombres y teléfonos) ordenados alfabéticamente por nombre.
 * Por último, la opción 4 guarda todos los datos de la agenda en el archivo agenda.txt.
 * La próxima vez que se ejecute la aplicación, si hay datos guardados, se cargarán en memoria.
 * Consejo: utiliza una colección para el tratamiento de la agenda. ¿Cuál es la colección más adecuada en este caso?
 * -> La colección más adecuada en este caso es un TreeMap, ya que nos permite guardar los datos ordenados por clave.
 */

import java.util.Scanner;

/**
 * Clase principal.
 */
public class MainEj7 {
    /**
     * Metodo principal de la clase.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opcion; //Variable para guardar la opción elegida por el usuario
        String nombre; //Variable para guardar el nombre del contacto
        String telefono; //Variable para guardar el teléfono del contacto

        //Declaramos el scanner para leer por teclado
        Scanner sc = new Scanner(System.in);

        //Si la agenda está vacía, le añadimos los contactos que hemos guardado ya en el archivo de texto
        if(Utilidades.agenda.isEmpty()){
            Utilidades.cargarAgenda();
        }

        do {
            //Mostramos el menú
            Utilidades.pintarMenu();

            //Le pedimos al usuario que elija una opción
            System.out.println("Elige una opción:");
            opcion = sc.nextInt();

            //Según la opción elegida por el usuario
            switch (opcion) {
                case 1 -> {
                    try {
                        //Le pedimos al usuario que introduzca el nombre del contacto
                        System.out.println("Introduce el nombre del contacto:");
                        nombre = sc.next();
                        System.out.println("Introduce el teléfono del contacto:");
                        telefono = sc.next();

                        //Si el nombre del contacto no existe en la agenda
                        Utilidades.nuevoContacto(nombre, telefono); //Llamamos al método nuevoContacto de la clase Utilidades para añadir el contacto

                    } catch (MaxSizeException e) {  //Si hay más de 20 contactos, capturamos la excepción
                        System.err.println(e.toString());   //Mostramos el mensaje de error
                    } catch (SameNameException e) { //Si el nombre del contacto ya existe, capturamos la excepción
                        System.err.println(e.toString());   //Mostramos el mensaje de error
                    }

                }
                case 2 -> {
                    //Le pedimos al usuario que introduzca el nombre del contacto que desea buscar
                    System.out.println("Introduce el nombre del contacto:");
                    nombre = sc.next();
                    sc.nextLine();

                    //Llamamos al método buscarPorNombre de la clase Utilidades para buscar el contacto
                    Utilidades.buscarPorNombre(nombre);

                }
                case 3 -> {
                    System.out.println("Estos son los contactos de la agenda: "); //Mostramos un mensaje
                    Utilidades.mostrarTodos(); //Llamamos al método mostrarTodos para mostrar todos los contactos
                }
                case 4 -> {
                    Utilidades.escribirFichero(); //Llamamos al método guardarAgenda para guardar los contactos en el fichero
                    System.out.println("Adiós!"); //Mostramos un mensaje de despedida
                }
            }
        } while (opcion != 4);

        sc.close(); //Cerramos el scanner
    }
}

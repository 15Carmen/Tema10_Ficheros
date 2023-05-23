package ejercicio07;

public class MaxSizeException extends Exception{
    public String toString() {
        return "No puedes añadir más contactos. \n" +
                "El tamaño máximo de la agenda es de 20 contactos";
    }
}

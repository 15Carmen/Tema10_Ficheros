package ejercicio07;

public class SameNameException extends Exception {
    public String toString() {
        return "El contacto ya existe en la agenda";
    }
}

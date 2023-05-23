package ejercicio05;

public class Usuario {

    //Declaramos los atributos
    /**
     * Atributo que guarda el nombre del usuario
     */
    protected String nombre = "Juan";
    /**
     * Atributo que guarda la edad del usuario
     */
    protected int edad = 0;

    //Declaramos los métodos

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;

        if (edad > 0) {
            this.edad = edad;
        }
    }

    //Declaramos los getter y los setter

    /**
     * Método que devuelve el nombre del usuario
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del usuario
     *
     * @param nombre nuevo nombre de usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve la edad del usuario
     *
     * @return edad del usuario
     */
    public int getEdad() {
        return edad;
    }

    /*+
     * Método que establece la edad del usuario
     * @param edad nueva edad del usuario
     */
    public void setEdad(int edad) {
        if (edad > 0){
            this.edad = edad;
        }

    }

    //Declaramos el metodo toString

    /**
     * Método que establece como va a aparecer el nombre y la edad del usuario por pantalla
     * @return nombre y edad del usuario
     */
    @Override
    public String toString() {
        return "Nombre de usuario: " + nombre + ", Edad:" + edad;
    }
}

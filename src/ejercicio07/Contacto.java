package ejercicio07;

public class Contacto {

    //Declaramos los atributos

    /**
     * Atributo que guarda el nombre del contacto
     */
    protected String nombre = "Juan";

    /**
     * Atributo que guarda el teléfono del contacto
     */
    protected String telefono = "555555555";

    //Declaramos el constructor

    /**
     * Constructor de la clase.
     *
     * @param nombre   nombre del contacto a crear
     * @param telefono teléfono del contacto a crear
     */
    public Contacto(String nombre, String telefono) {
        if (nombre != null) {
            this.nombre = nombre;
        }

        if (telefono != null) {
            this.telefono = telefono;
        }
    }

    //Declaramos los getters y setters

    /**
     * Método que devuelve el nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que modifica el nombre del contacto.
     *
     * @param nombre nombre del contacto a modificar
     */
    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }

    /**
     * Método que devuelve el teléfono del contacto.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que modifica el teléfono del contacto.
     *
     * @param telefono teléfono del contacto a modificar
     */
    public void setTelefono(String telefono) {
        if (telefono != null){
            this.telefono = telefono;
        }
    }

    //Declaramos el método toString

    /**
     * Método que muestra estructura como se muestra el contacto por pantalla.
     * @return datos del contacto
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "; Telefono: " + telefono + "\n";
    }
}

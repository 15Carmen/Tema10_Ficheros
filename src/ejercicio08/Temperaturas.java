package ejercicio08;

import java.time.LocalDate;

class Temperaturas {

    //Declaramos los atributos

    /**
     * Atributo que guarda la fecha del dia que el usuario quiere añadir
     */
    private LocalDate fecha = LocalDate.now();

    /**
     * Atributo que guarda la temperatura máxima del dia que el usuario quiere añadir
     */
    private int temperaturaMaxima = 50;

    /**
     * Atributo que guarda la temperatura mínima del dia que el usuario quiere añadir
     */
    private int temperaturaMinima = 0;

    //Declaramos el constructor
    public Temperaturas(LocalDate fecha, int temperaturaMaxima, int temperaturaMinima) {
        this.fecha = fecha;

        //Verificamos que la temperatura máxima no sea menor a la mínima y, si lo es, mostramos un mensaje de error
        if (temperaturaMaxima>temperaturaMinima) {
            this.temperaturaMaxima = temperaturaMaxima;
            this.temperaturaMinima = temperaturaMinima;
        }else {
            System.out.println("La temperatura máxima no puede ser menor a la mínima");
        }
    }

    //Declaramos los getters
    public LocalDate getFecha() {
        return fecha;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Temperatura máxima: " + temperaturaMaxima + ", Temperatura mínima: " + temperaturaMinima;
    }
}








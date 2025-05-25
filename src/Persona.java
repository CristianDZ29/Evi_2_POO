public class Persona {// ATRIBUTOS PRIVADOS - Implementan el principio de encapsulación
    // Al ser private, solo pueden ser accedidos desde dentro de la misma clase
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    /**
     * CONSTRUCTOR - Método especial para inicializar objetos
     *
     * Permite crear una instancia de Persona con todos los datos necesarios
     * de una sola vez, garantizando que el objeto se cree en un estado válido
     *
     * @param nombre   Nombre de la persona
     * @param apellido Apellido de la persona
     * @param genero   Género de la persona (M/F)
     * @param edad     Edad de la persona
     */
    public Persona(String nombre, String apellido, String genero, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    // MÉTODOS GETTER - Proporcionan acceso controlado a los atributos privados
    // Estos métodos implementan el principio de encapsulación al controlar
    // cómo se accede a los datos internos del objeto

    /**
     * Retorna el nombre de la persona
     * @return String con el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el apellido de la persona
     * @return String con el apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Retorna el género de la persona
     * @return String con el género (M/F)
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Retorna la edad de la persona
     * @return int con la edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método toString sobrescrito para representación textual del objeto
     * Facilita la visualización de los datos de la persona
     * @return String con la información completa de la persona
     */
    @Override
    public String toString() {
        return "Persona: " + nombre + " " + apellido + ", Género: " + genero + ", Edad: " + edad;
    }
}

/**
 * Clase principal que contiene la lógica del programa y demuestra
 * el uso de la clase Persona implementando los métodos solicitados
 */


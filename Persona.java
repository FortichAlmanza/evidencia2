public class Persona {
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    public Persona(String nombre, String apellido, String genero, int edad) {
        this.nombre = formatear(nombre);
        this.apellido = formatear(apellido);
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    private String formatear(String palabra) {
        if (palabra.length() == 0) return palabra;
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
}

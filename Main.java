import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de las personas. Escriba 'salir' como nombre para terminar.");

        while (true) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Género (Masculino/Femenino): ");
            String genero = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            personas.add(new Persona(nombre, apellido, genero, edad));
            System.out.println("Persona registrada.\n");
        }

        if (personas.isEmpty()) {
            System.out.println("No se registraron personas.");
        } else {
            System.out.println("\n--- Nombres y Géneros ---");
            mostrarNombresYGeneros();

            System.out.println("\nPromedio de edades: " + calcularPromedioEdad());
            System.out.println("Cantidad de personas de género Masculino: " + contarPorGenero("Masculino"));
            System.out.println("Cantidad de personas de género Femenino: " + contarPorGenero("Femenino"));
        }
    }

    public static void mostrarNombresYGeneros() {
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre() + " | Género: " + persona.getGenero());
        }
    }

    public static double calcularPromedioEdad() {
        int suma = 0;
        for (Persona persona : personas) {
            suma += persona.getEdad();
        }
        return (double) suma / personas.size();
    }

    public static int contarPorGenero(String generoBuscado) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getGenero().equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Bienvenido. Ingrese los datos de las personas. Escriba 'salir' como nombre para terminar.");

        while (true) {
            String nombre = pedirUnaPalabra(scanner, "\nNombre: ");
            if (nombre.equalsIgnoreCase("salir")) break;

            String apellido = pedirUnaPalabra(scanner, "Apellido: ");
            String genero = pedirGenero(scanner);
            int edad = pedirEdad(scanner);

            personas.add(new Persona(nombre, apellido, genero, edad));
            System.out.println("\nPersona registrada.\n");
        }

        if (personas.isEmpty()) {
            System.out.println("\nNo se registraron personas.");
        } else {
            System.out.println("\n--- Nombres, Apellidos y Géneros ---");
            mostrarNombresYGeneros();

            System.out.println("\nPromedio de edades: " + calcularPromedioEdad());
            System.out.println("Cantidad de personas de género Masculino: " + contarPorGenero("Masculino"));
            System.out.println("Cantidad de personas de género Femenino: " + contarPorGenero("Femenino"));
        }
    }

    public static String pedirUnaPalabra(Scanner scanner, String mensaje) {
        String entrada;
        while (true) {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (!entrada.contains(" ") && !entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("\n❌ Entrada inválida. Debe ser una sola palabra sin espacios.");
        }
    }

    public static String pedirGenero(Scanner scanner) {
        String entrada;
        while (true) {
            System.out.print("Género (m/f): ");
            entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.equals("m")) return "Masculino";
            if (entrada.equals("f")) return "Femenino";
            System.out.println("\n❌ Entrada inválida. Solo se permite 'm' o 'f'.");
        }
    }

    public static int pedirEdad(Scanner scanner) {
        while (true) {
            System.out.print("Edad: ");
            String entrada = scanner.nextLine().trim();
            try {
                int edad = Integer.parseInt(entrada);
                if (edad >= 0) return edad;
                System.out.println("\n❌ La edad no puede ser negativa.");
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Entrada inválida. Debe ser un número entero.");
            }
        }
    }

    public static void mostrarNombresYGeneros() {
        for (Persona persona : personas) {
            System.out.println("\nNombre: " + persona.getNombre() +" " + persona.getApellido() + " Género: " + persona.getGenero());
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

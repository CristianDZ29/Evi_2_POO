import java.util.Scanner;

public class GestionPersonas {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("=== SISTEMA DE GESTIÓN DE PERSONAS ===");
        System.out.println("Demostración de Programación Orientada a Objetos en Java\n");


        Persona[] personas = null;

        mostrarMenuPrincipal(personas);

        scanner.close();
    }

}
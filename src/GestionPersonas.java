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
    public static void mostrarMenuPrincipal(Persona[] personas) {
        int opcion;

        do {

            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║          MENÚ PRINCIPAL                ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. Capturar datos de 5 personas        ║");
            System.out.println("║ 2. Mostrar nombres y géneros           ║");
            System.out.println("║ 3. Calcular promedio de edades         ║");
            System.out.println("║ 4. Contar personas género masculino    ║");
            System.out.println("║ 5. Contar personas género femenino     ║");
            System.out.println("║ 6. Mostrar todas las personas          ║");
            System.out.println("║ 7. Mostrar estadísticas completas      ║");
            System.out.println("║ 0. Salir del programa                  ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Seleccione una opción (0-7): ");


            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());


                switch (opcion) {
                    case 1:
                        personas = capturarPersonas();
                        System.out.println("✓ Datos capturados exitosamente!");
                        break;

                    case 2:
                        if (validarDatosExisten(personas)) {
                            mostrarNombresYGeneros(personas);
                        }
                        break;

                    case 3:
                        if (validarDatosExisten(personas)) {
                            mostrarPromedioEdades(personas);
                        }
                        break;

                    case 4:
                        if (validarDatosExisten(personas)) {
                            mostrarCantidadMasculinos(personas);
                        }
                        break;

                    case 5:
                        if (validarDatosExisten(personas)) {
                            mostrarCantidadFemeninos(personas);
                        }
                        break;

                    case 6:
                        if (validarDatosExisten(personas)) {
                            mostrarTodasLasPersonas(personas);
                        }
                        break;

                    case 7:
                        if (validarDatosExisten(personas)) {
                            mostrarEstadisticasCompletas(personas);
                        }
                        break;

                    case 0:
                        System.out.println("\n🔚 Gracias por usar el Sistema de Gestión de Personas");
                        System.out.println("¡Hasta luego!");
                        break;

                    default:
                        System.out.println("❌ Error: Opción no válida. Por favor, seleccione una opción entre 0 y 7.");
                        break;
                }


                if (opcion != 0 && opcion >= 1 && opcion <= 7) {
                    System.out.print("\nPresione Enter para continuar...");
                    scanner.nextLine();
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Por favor, ingrese un número válido.");
                opcion = -1;
            }

        } while (opcion != 0);
    }

}
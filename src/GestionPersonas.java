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
    public static boolean validarDatosExisten(Persona[] personas) {
        if (personas == null) {
            System.out.println("\n⚠️  Advertencia: No hay datos de personas capturados.");
            System.out.println("   Por favor, seleccione la opción 1 primero para capturar los datos.");
            return false;
        }
        return true;
    }
    public static void mostrarEstadisticasCompletas(Persona[] personas) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           ESTADÍSTICAS COMPLETAS");
        System.out.println("=".repeat(50));

        mostrarNombresYGeneros(personas);
        System.out.println("-".repeat(50));

        mostrarPromedioEdades(personas);
        System.out.println("-".repeat(50));

        System.out.println("--- DISTRIBUCIÓN POR GÉNERO ---");
        int masculinos = contarMasculinos(personas);
        int femeninos = contarFemeninos(personas);
        int total = personas.length;

        System.out.println("👨 Género Masculino: " + masculinos + " personas " + "% total" + (masculinos * 100.0 / total) );

        System.out.println("👩 Género Femenino: " + femeninos + " personas (" + "% total" + (femeninos * 100.0 / total) );

        System.out.println("📊 Total de personas: " + total);

        System.out.println("-".repeat(50));
        mostrarTodasLasPersonas(personas);
        System.out.println("=".repeat(50));
    }
    public static Persona[] capturarPersonas() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      📝 CAPTURA DE DATOS DE 5 PERSONAS");
        System.out.println("=".repeat(50));


        Persona[] personas = new Persona[5];


        for (int i = 0; i < 5; i++) {
            System.out.println("\n👤 Ingrese los datos de la persona " + (i + 1) + ":");
            System.out.println("-".repeat(30));


            System.out.print("📛 Nombre: ");
            String nombre = scanner.nextLine().trim();


            System.out.print("📝 Apellido: ");
            String apellido = scanner.nextLine().trim();


            String genero;
            do {
                System.out.print("⚥  Género (M/F): ");
                genero = scanner.nextLine().trim().toUpperCase();

                if (!genero.equals("M") && !genero.equals("F")) {
                    System.out.println("❌ Error: Ingrese 'M' para Masculino o 'F' para Femenino");
                }
            } while (!genero.equals("M") && !genero.equals("F"));


            int edad;
            do {
                System.out.print("🎂 Edad: ");
                try {
                    edad = Integer.parseInt(scanner.nextLine().trim());
                    if (edad < 0 || edad > 150) {
                        System.out.println("❌ Error: La edad debe estar entre 0 y 150 años");
                        edad = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: Ingrese un número válido para la edad");
                    edad = -1;
                }
            } while (edad < 0 || edad > 150);


            personas[i] = new Persona(nombre, apellido, genero, edad);

            System.out.println("✅ Persona registrada exitosamente!");
        }

        System.out.println("\n🎉 ¡Todas las personas han sido registradas correctamente!");
        return personas;
    }
    public static void mostrarNombresYGeneros(Persona[] personas) {
        System.out.println("\n📋 NOMBRES Y GÉNEROS CAPTURADOS");
        System.out.println("-".repeat(40));

        for (int i = 0; i < personas.length; i++) {

            String nombreCompleto = personas[i].getNombre() + " " + personas[i].getApellido();
            String genero = personas[i].getGenero().equals("M") ? "👨 Masculino" : "👩 Femenino";

            System.out.println((i + 1) + ". " + nombreCompleto + " - " + genero);
        }
    }
    public static double calcularPromedioEdades(Persona[] personas) {
        int sumaEdades = 0;


        for (Persona persona : personas) {
            sumaEdades += persona.getEdad();
        }


        return (double) sumaEdades / personas.length;
    }
    public static void mostrarPromedioEdades(Persona[] personas) {
        double promedio = calcularPromedioEdades(personas);
        System.out.println("\n📊 PROMEDIO DE EDADES");
        System.out.println("-".repeat(30));
        System.out.println("🎂 El promedio de edades es: %.2f años\n"+  promedio);
    }
    public static int contarMasculinos(Persona[] personas) {
        int contador = 0;


        for (Persona persona : personas) {
            if (persona.getGenero().equals("M")) {
                contador++;
            }
        }

        return contador;
    }
    public static void mostrarCantidadMasculinos(Persona[] personas) {
        int cantidad = contarMasculinos(personas);
        System.out.println("\n👨 ESTADÍSTICA - GÉNERO MASCULINO");
        System.out.println("-".repeat(35));
        System.out.println("Cantidad de personas de género Masculino: " + cantidad);
    }
    public static int contarFemeninos(Persona[] personas) {
        int contador = 0;


        for (Persona persona : personas) {
            if (persona.getGenero().equals("F")) {
                contador++;
            }
        }

        return contador;
    }
    public static void mostrarCantidadFemeninos(Persona[] personas) {
        int cantidad = contarFemeninos(personas);
        System.out.println("\n👩 ESTADÍSTICA - GÉNERO FEMENINO");
        System.out.println("-".repeat(35));
        System.out.println("Cantidad de personas de género Femenino: " + cantidad);
    }


    public static void mostrarTodasLasPersonas(Persona[] personas) {
        System.out.println("\n📄 RESUMEN DE TODAS LAS PERSONAS REGISTRADAS");
        System.out.println("=".repeat(50));
        for (int i = 0; i < personas.length; i++) {
            System.out.println((i + 1) + ". " + personas[i].toString());
        }
    }


}
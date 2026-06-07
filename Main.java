import java.util.Scanner;

/**
 * Clase Main - Punto de entrada del sistema de directorio de extensiones
 * Proporciona un menú interactivo para gestionar un inventario de extensiones
 */
public class Main {
    
    /**
     * Método principal - Controla el flujo del programa
     * Presenta un menú con opciones para insertar, listar y buscar extensiones
     * @param args - Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear instancia del árbol binario para almacenar el inventario
        ArbolInventario miArbol = new ArbolInventario();
        
        // Scanner para capturar entrada del usuario desde consola
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Bucle principal - Continúa hasta que el usuario selecciona "Salir" (opción 0)
        do {
            // Mostrar menú de opciones
            System.out.println("\n--- DIRECTORIO DE EXTENSIONES ---");
            System.out.println("1. Registrar Extensión");
            System.out.println("2. Ver Directorio (Ordenado)");
            System.out.println("3. Buscar Extensión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            // Procesar la opción seleccionada por el usuario
            switch (opcion) {

                // Opción 1: Registrar una nueva extensión
                case 1:
                    System.out.print("Ingrese número de extensión: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // Limpiar el buffer del Scanner

                    System.out.print("Nombre de la oficina: ");
                    String nombre = sc.nextLine();

                    // Insertar la extensión en el árbol
                    miArbol.insertar(id, nombre);
                    System.out.println("Registrado con éxito.");
                    break;

                // Opción 2: Mostrar todas las extensiones ordenadas por ID
                case 2:
                    System.out.println("\nLISTADO ACTUAL:");
                    miArbol.mostrar();  // Muestra en orden ascendente
                    break;

                // Opción 3: Buscar una extensión por su ID
                case 3:
                    System.out.print("ID a buscar: ");
                    int buscaId = sc.nextInt();
                    // Realizar búsqueda y mostrar resultado
                    System.out.println(miArbol.buscar(buscaId));
                    break;

                // Opción 0: Salir del programa
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                // Opción inválida
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);  // Repetir hasta seleccionar opción 0

        // Cerrar el Scanner para liberar recursos
        sc.close();
    }
}
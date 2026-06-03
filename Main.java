import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArbolInventario miArbol = new ArbolInventario();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- DIRECTORIO DE EXTENSIONES ---");
            System.out.println("1. Registrar Extensión");
            System.out.println("2. Ver Directorio (Ordenado)");
            System.out.println("3. Buscar Extensión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese número de extensión: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre de la oficina: ");
                    String nombre = sc.nextLine();

                    miArbol.insertar(id, nombre);
                    System.out.println("Registrado con éxito.");
                    break;

                case 2:
                    System.out.println("\nLISTADO ACTUAL:");
                    miArbol.mostrar();
                    break;

                case 3:
                    System.out.print("ID a buscar: ");
                    int buscaId = sc.nextInt();
                    System.out.println(miArbol.buscar(buscaId));
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
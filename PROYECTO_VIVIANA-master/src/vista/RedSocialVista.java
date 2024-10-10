package vista;

import controlador.RedSocialControlador;

import java.util.Scanner;

public class RedSocialVista {
    private Scanner scanner;

    public RedSocialVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(RedSocialControlador controlador) {
        int opcion;
        do {
            System.out.println("1. Agregar red social");
            System.out.println("2. Eliminar red social");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    agregarRedSocial(controlador);
                    break;
                case 2:
                    eliminarRedSocial(controlador);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    public void agregarRedSocial(RedSocialControlador controlador) {
        System.out.print("ID de la red social: ");
        String id = scanner.nextLine();
        System.out.print("Nombre de la red social: ");
        String nombre = scanner.nextLine();
        System.out.print("URL de la red social: ");
        String url = scanner.nextLine();
        controlador.agregarRedSocial(id, nombre, url);
    }

    public void eliminarRedSocial(RedSocialControlador controlador) {
        System.out.print("ID de la red social a eliminar: ");
        String id = scanner.nextLine();
        controlador.eliminarRedSocial(id);
    }
}

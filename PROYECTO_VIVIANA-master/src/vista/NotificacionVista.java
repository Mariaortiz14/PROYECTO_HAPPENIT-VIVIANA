package vista;

import controlador.NotificacionControlador;
import modelo.Notificacion;

import java.util.HashMap;
import java.util.Scanner;

public class NotificacionVista {
    private Scanner scanner;

    public NotificacionVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(NotificacionControlador controlador) {
        int opcion;
        do {
            System.out.println("1. Agregar notificación");
            System.out.println("2. Eliminar notificación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarNotificacion(controlador);
                    break;
                case 2:
                    eliminarNotificacion(controlador);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    public void agregarNotificacion(NotificacionControlador controlador) {
        System.out.print("ID de la notificación: ");
        String id = scanner.nextLine();
        System.out.print("ID del usuario: ");
        String usuarioId = scanner.nextLine();
        System.out.print("Mensaje: ");
        String mensaje = scanner.nextLine();
        controlador.agregarNotificacion(id, usuarioId, mensaje);
    }

    public void eliminarNotificacion(NotificacionControlador controlador) {
        System.out.print("ID de la notificación a eliminar: ");
        String id = scanner.nextLine();
        controlador.eliminarNotificacion(id);
    }
}

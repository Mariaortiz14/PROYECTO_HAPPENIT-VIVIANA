package vista;

import controlador.ComentarioControlador;
import modelo.Comentario;

import java.util.HashMap;
import java.util.Scanner;

public class ComentarioVista {
    private Scanner scanner;

    public ComentarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(ComentarioControlador controlador) {
        int opcion;
        do {
            System.out.println("1. Agregar comentario");
            System.out.println("2. Mostrar comentarios");
            System.out.println("3. Actualizar comentario");
            System.out.println("4. Eliminar comentario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarComentario(controlador);
                    break;
                case 2:
                    controlador.mostrarComentarios();
                    break;
                case 3:
                    actualizarComentario(controlador);
                    break;
                case 4:
                    eliminarComentario(controlador);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    public void agregarComentario(ComentarioControlador controlador) {
        System.out.print("ID del comentario: ");
        String id = scanner.nextLine();
        System.out.print("ID del usuario: ");
        String usuarioId = scanner.nextLine();
        System.out.print("ID del evento: ");
        String eventoId = scanner.nextLine();
        System.out.print("Comentario: ");
        String comentario = scanner.nextLine();
        controlador.agregarComentario(id, usuarioId, eventoId, comentario);
    }

    public void actualizarComentario(ComentarioControlador controlador) {
        System.out.print("ID del comentario a actualizar: ");
        String id = scanner.nextLine();
        System.out.print("Nuevo ID del usuario: ");
        String usuarioId = scanner.nextLine();
        System.out.print("Nuevo ID del evento: ");
        String eventoId = scanner.nextLine();
        System.out.print("Nuevo comentario: ");
        String comentario = scanner.nextLine();
        controlador.actualizarComentario(id, usuarioId, eventoId, comentario);
    }

    public void eliminarComentario(ComentarioControlador controlador) {
        System.out.print("ID del comentario a eliminar: ");
        String id = scanner.nextLine();
        controlador.eliminarComentario(id);
    }

    public void mostrarComentarios(HashMap<String, Comentario> comentarios) {
        System.out.println("Comentarios:");
        for (Comentario comentario : comentarios.values()) {
            System.out.println("ID: " + comentario.getId());
            System.out.println("Usuario ID: " + comentario.getUsuarioId());
            System.out.println("Evento ID: " + comentario.getEventoId());
            System.out.println("Comentario: " + comentario.getComentario());
            System.out.println();
        }
    }
}

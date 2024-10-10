package vista;

import controlador.EventoControlador;
import modelo.Evento;

import java.util.HashMap;
import java.util.Scanner;

public class EventoVista {
    private Scanner scanner;

    public EventoVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(EventoControlador controlador) {
        int opcion;
        do {
            System.out.println("1. Agregar evento");
            System.out.println("2. Mostrar eventos");
            System.out.println("3. Actualizar evento");
            System.out.println("4. Eliminar evento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    agregarEvento(controlador);
                    break;
                case 2:
                    controlador.mostrarEventos();
                    break;
                case 3:
                    actualizarEvento(controlador);
                    break;
                case 4:
                    eliminarEvento(controlador);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    public void agregarEvento(EventoControlador controlador) {
        System.out.print("ID del evento: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del evento: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        controlador.agregarEvento(id, nombre, fecha, ubicacion, descripcion);
    }

    public void actualizarEvento(EventoControlador controlador) {
        System.out.print("ID del evento a actualizar: ");
        String id = scanner.nextLine();
        System.out.print("Nuevo nombre del evento: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva fecha: ");
        String fecha = scanner.nextLine();
        System.out.print("Nueva ubicación: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = scanner.nextLine();
        controlador.actualizarEvento(id, nombre, fecha, ubicacion, descripcion);
    }

    public void eliminarEvento(EventoControlador controlador) {
        System.out.print("ID del evento a eliminar: ");
        String id = scanner.nextLine();
        controlador.eliminarEvento(id);
    }

    public void mostrarEventos(HashMap<String, Evento> eventos) {
        System.out.println("Eventos:");
        for (Evento evento : eventos.values()) {
            System.out.println("ID: " + evento.getId());
            System.out.println("Nombre: " + evento.getNombre());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Ubicación: " + evento.getUbicacion());
            System.out.println("Descripción: " + evento.getDescripcion());
            System.out.println();
        }
    }
}


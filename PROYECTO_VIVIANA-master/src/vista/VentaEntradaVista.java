package vista;

import controlador.VentaEntradaControlador;

import java.util.Scanner;

public class VentaEntradaVista {
    private Scanner scanner;

    public VentaEntradaVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(VentaEntradaControlador controlador) {
        int opcion;
        do {
            System.out.println("1. Agregar venta de entrada");
            System.out.println("2. Actualizar venta de entrada");
            System.out.println("3. Eliminar venta de entrada");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    agregarVentaEntrada(controlador);
                    break;
                case 2:
                    actualizarVentaEntrada(controlador);
                    break;
                case 3:
                    eliminarVentaEntrada(controlador);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    public void agregarVentaEntrada(VentaEntradaControlador controlador) {
        System.out.print("ID de la venta de entrada: ");
        String id = scanner.nextLine();
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("ID del evento: ");
        String idEvento = scanner.nextLine();
        System.out.print("Cantidad de entradas: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Método de pago: ");
        String metodoPago = scanner.nextLine();
        controlador.agregarVentaEntrada(id, idUsuario, idEvento, cantidad, metodoPago);
    }

    public void actualizarVentaEntrada(VentaEntradaControlador controlador) {
        System.out.print("ID de la venta de entrada a actualizar: ");
        String id = scanner.nextLine();
        System.out.print("Nuevo ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Nuevo ID del evento: ");
        String idEvento = scanner.nextLine();
        System.out.print("Nueva cantidad de entradas: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Nuevo método de pago: ");
        String metodoPago = scanner.nextLine();
        controlador.actualizarVentaEntrada(id, idUsuario, idEvento, cantidad, metodoPago);
    }

    public void eliminarVentaEntrada(VentaEntradaControlador controlador) {
        System.out.print("ID de la venta de entrada a eliminar: ");
        String id = scanner.nextLine();
        controlador.eliminarVentaEntrada(id);
    }
}


package vista;

import controlador.UsuarioControlador;

import java.util.Scanner;

public class UsuarioVista {
    private Scanner scanner;

    public UsuarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(UsuarioControlador controlador) {
        int opcion;
        do {
            System.out.println("1. Agregar usuario");
            System.out.println("2. Actualizar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    agregarUsuario(controlador);
                    break;
                case 2:
                    actualizarUsuario(controlador);
                    break;
                case 3:
                    eliminarUsuario(controlador);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    public void agregarUsuario(UsuarioControlador controlador) {
        System.out.print("ID del usuario: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo electrónico del usuario: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Contraseña del usuario: ");
        String contraseña = scanner.nextLine();
        controlador.agregarUsuario(id, nombre, correoElectronico, contraseña);
    }

    public void actualizarUsuario(UsuarioControlador controlador) {
        System.out.print("ID del usuario a actualizar: ");
        String id = scanner.nextLine();
        System.out.print("Nuevo nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo correo electrónico del usuario: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Nueva contraseña del usuario: ");
        String contraseña = scanner.nextLine();
        controlador.actualizarUsuario(id, nombre, correoElectronico, contraseña);
    }

    public void eliminarUsuario(UsuarioControlador controlador) {
        System.out.print("ID del usuario a eliminar: ");
        String id = scanner.nextLine();
        controlador.eliminarUsuario(id);
    }
}

import controlador.*;
import modelo.*;
import vista.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        CalendarioModelo calendarioModelo = new CalendarioModelo(databaseConnection);
        ComentarioModelo comentarioModelo = new ComentarioModelo(databaseConnection);
        EventoModelo eventoModelo = new EventoModelo(databaseConnection);
        NotificacionModelo notificacionModelo = new NotificacionModelo(databaseConnection.toString());
        PagoModelo pagoModelo = new PagoModelo(databaseConnection.toString());
        RedSocialModelo redSocialModelo = new RedSocialModelo(databaseConnection.toString());
        UsuarioModelo usuarioModelo = new UsuarioModelo(databaseConnection);
        VentaEntradaModelo ventaEntradaModelo = new VentaEntradaModelo(databaseConnection.toString());

        // Vistas
        CalendarioVista calendarioVista = new CalendarioVista();
        ComentarioVista comentarioVista = new ComentarioVista();
        EventoVista eventoVista = new EventoVista();
        NotificacionVista notificacionVista = new NotificacionVista();
        PagoVista pagoVista = new PagoVista();
        RedSocialVista redSocialVista = new RedSocialVista();
        UsuarioVista usuarioVista = new UsuarioVista();
        VentaEntradaVista ventaEntradaVista = new VentaEntradaVista();

        // Controladores
        CalendarioControlador calendarioControlador = new CalendarioControlador(calendarioModelo, calendarioVista);
        ComentarioControlador comentarioControlador = new ComentarioControlador(comentarioModelo, comentarioVista);
        EventoControlador eventoControlador = new EventoControlador(eventoModelo, eventoVista);
        NotificacionControlador notificacionControlador = new NotificacionControlador(notificacionModelo, notificacionVista);
        PagoControlador pagoControlador = new PagoControlador(pagoModelo, pagoVista);
        RedSocialControlador redSocialControlador = new RedSocialControlador(redSocialModelo, redSocialVista);
        UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioModelo, usuarioVista);
        VentaEntradaControlador ventaEntradaControlador = new VentaEntradaControlador(ventaEntradaModelo, ventaEntradaVista);

        int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== Gestión de Eventos ===");
            System.out.println("1. Calendario de Eventos");
            System.out.println("2. Comentarios");
            System.out.println("3. Eventos");
            System.out.println("4. Notificaciones");
            System.out.println("5. Pagos");
            System.out.println("6. Redes Sociales");
            System.out.println("7. Usuarios");
            System.out.println("8. Ventas de Entradas");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    calendarioControlador.iniciar();
                    break;
                case 2:
                    comentarioControlador.iniciar();
                    break;
                case 3:
                    eventoControlador.iniciar();
                    break;
                case 4:
                    notificacionControlador.iniciar();
                    break;
                case 5:
                    pagoControlador.iniciar();
                    break;
                case 6:
                    redSocialControlador.iniciar();
                    break;
                case 7:
                    usuarioControlador.iniciar();
                    break;
                case 8:
                    ventaEntradaControlador.iniciar();
                    break;
                case 9:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);

        databaseConnection.closeConnection();
        scanner.close();
    }
}

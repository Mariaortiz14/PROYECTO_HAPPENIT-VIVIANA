package vista;

import controlador.PagoControlador;

import java.util.Scanner;

public class PagoVista {
    private Scanner scanner;

    public PagoVista(){
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(PagoControlador controlador){
        int opcion;
        do{
            System.out.println("1. Agregar pago.");
            System.out.println("2. Eliminar pago.");
            System.out.println("3. Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    agegarPago(controlador);
                    break;
                case 2:
                    eliminarPago(controlador);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("opcion invalida, intente de nuevo");
            }
        } while (opcion !=3);
    }

    public void agegarPago (PagoControlador controlador){
        System.out.println("ID del pago:");
        String id = scanner.nextLine();
        System.out.println("ID del usuario:");
        String usuarioId = scanner.nextLine();
        System.out.println("ID del evento:");
        String eventoId = scanner.nextLine();
        System.out.println("Monto:");
        double monto = scanner.nextDouble();
        System.out.println("Metodo de pago:");
        String metodoPago = scanner.nextLine();
        System.out.println("Fecha:");
        String fecha = scanner.nextLine();
        controlador.agregarPago(id, usuarioId, eventoId, monto,metodoPago,fecha);
    }
     public void eliminarPago(PagoControlador controlador){
         System.out.println("ID del pago a eliminar:");
         String id = scanner.nextLine();
         controlador.eliminarPago(id);
     }

}

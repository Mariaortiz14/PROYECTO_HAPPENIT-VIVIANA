package controlador;

import modelo.PagoModelo;
import vista.PagoVista;

public class PagoControlador {
    private PagoModelo modelo;
    private PagoVista vista;

    public PagoControlador(PagoModelo modelo, PagoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarPago(String id, String usuarioId, String eventoId, double monto, String metodoPago, String fecha) {
        modelo.agregarPagos(id, usuarioId, eventoId, monto, metodoPago, fecha);
    }

    public void eliminarPago(String id) {
        modelo.eliminarPago(id);
    }
}

package controlador;

import modelo.VentaEntradaModelo;
import vista.VentaEntradaVista;

public class VentaEntradaControlador {
    private VentaEntradaModelo modelo;
    private VentaEntradaVista vista;

    public VentaEntradaControlador(VentaEntradaModelo modelo, VentaEntradaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarVentaEntrada(String id, String idUsuario, String idEvento, int cantidad, String metodoPago) {
        modelo.agregarVentaEntrada(id, idUsuario, idEvento, cantidad, metodoPago);
    }

    public void actualizarVentaEntrada(String id, String idUsuario, String idEvento, int cantidad, String metodoPago) {
        modelo.actualizarVentaEntrada(id, idUsuario, idEvento, cantidad, metodoPago);
    }

    public void eliminarVentaEntrada(String id) {
        modelo.eliminarVentaEntrada(id);
    }
}

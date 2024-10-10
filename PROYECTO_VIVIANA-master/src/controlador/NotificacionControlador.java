package controlador;

import modelo.NotificacionModelo;
import vista.NotificacionVista;

import java.util.HashMap;

public class NotificacionControlador {
    private NotificacionModelo modelo;
    private NotificacionVista vista;

    public NotificacionControlador(NotificacionModelo modelo, NotificacionVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarNotificacion(String id, String usuarioId, String mensaje) {
        modelo.agregarNotificacion(id, usuarioId, mensaje);
    }

    public void eliminarNotificacion(String id) {
        modelo.eliminarNotificacion(id);
    }
}

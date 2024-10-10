package controlador;

import modelo.CalendarioModelo;
import vista.CalendarioVista;

import java.util.HashMap;

public class CalendarioControlador {
    private CalendarioModelo modelo;
    private CalendarioVista vista;

    public CalendarioControlador(CalendarioModelo modelo, CalendarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarEvento(String id, String nombreEvento, String fecha, String ubicacion, String descripcion) {
        modelo.agregarEvento(id, nombreEvento, fecha, ubicacion, descripcion);
    }

    public void mostrarEventos() {
        vista.mostrarEventos(modelo.getEventos());
    }

    public void actualizarEvento(String id, String nombreEvento, String fecha, String ubicacion, String descripcion) {
        modelo.actualizarEvento(id, nombreEvento, fecha, ubicacion, descripcion);
    }

    public void eliminarEvento(String id) {
        modelo.eliminarEvento(id);
    }
}


package controlador;

import modelo.EventoModelo;
import vista.EventoVista;

import java.util.HashMap;

public class EventoControlador {
    private EventoModelo modelo;
    private EventoVista vista;

    public EventoControlador(EventoModelo modelo, EventoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarEvento(String id, String nombre, String fecha, String ubicacion, String descripcion) {
        modelo.agregarEvento(id, nombre, fecha, ubicacion, descripcion);
    }

    public void mostrarEventos() {
        vista.mostrarEventos(modelo.getEventos());
    }

    public void actualizarEvento(String id, String nombre, String fecha, String ubicacion, String descripcion) {
        modelo.actualizarEvento(id, nombre, fecha, ubicacion, descripcion);
    }

    public void eliminarEvento(String id) {
        modelo.eliminarEvento(id);
    }
}

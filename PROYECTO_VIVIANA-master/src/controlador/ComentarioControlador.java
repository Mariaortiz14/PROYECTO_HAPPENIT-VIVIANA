package controlador;

import modelo.ComentarioModelo;
import vista.ComentarioVista;

import java.util.HashMap;

public class ComentarioControlador {
    private ComentarioModelo modelo;
    private ComentarioVista vista;

    public ComentarioControlador(ComentarioModelo modelo, ComentarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarComentario(String id, String usuarioId, String eventoId, String comentario) {
        modelo.agregarComentario(id, usuarioId, eventoId, comentario);
    }

    public void mostrarComentarios() {
        vista.mostrarComentarios(modelo.getComentarios());
    }

    public void actualizarComentario(String id, String usuarioId, String eventoId, String comentario) {
        modelo.actualizarComentario(id, usuarioId, eventoId, comentario);
    }

    public void eliminarComentario(String id) {
        modelo.eliminarComentario(id);
    }
}


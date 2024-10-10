package controlador;

import modelo.UsuarioModelo;
import vista.UsuarioVista;

public class UsuarioControlador {
    private UsuarioModelo modelo;
    private UsuarioVista vista;

    public UsuarioControlador(UsuarioModelo modelo, UsuarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarUsuario(String id, String nombre, String correoElectronico, String contraseña) {
        modelo.agregarUsuario(id, nombre, correoElectronico, contraseña);
    }

    public void actualizarUsuario(String id, String nombre, String correoElectronico, String contraseña) {
        modelo.actualizarUsuario(id, nombre, correoElectronico, contraseña);
    }

    public void eliminarUsuario(String id) {
        modelo.eliminarUsuario(id);
    }
}

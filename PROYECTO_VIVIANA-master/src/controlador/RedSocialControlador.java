package controlador;

import modelo.RedSocialModelo;
import vista.RedSocialVista;

public class RedSocialControlador {
    private RedSocialModelo modelo;
    private RedSocialVista vista;

    public RedSocialControlador(RedSocialModelo modelo, RedSocialVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMenu(this);
    }

    public void agregarRedSocial(String id, String nombre, String url) {
        modelo.agregarRedSocial(id, nombre, url);
    }

    public void eliminarRedSocial(String id) {
        modelo.eliminarRedSocial(id);
    }
}

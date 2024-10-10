package modelo;

public class Notificacion {
    private String id;
    private String usuarioId;
    private String mensaje;

    public Notificacion(String id, String usuarioId, String mensaje) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}


package modelo;

public class Comentario {
    private String id;
    private String usuarioId;
    private String eventoId;
    private String comentario;

    public Comentario(String id, String usuarioId, String eventoId, String comentario) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.eventoId = eventoId;
        this.comentario = comentario;
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

    public String getEventoId() {
        return eventoId;
    }

    public void setEventoId(String eventoId) {
        this.eventoId = eventoId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}


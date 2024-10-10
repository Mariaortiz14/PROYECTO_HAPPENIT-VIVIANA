package modelo;

public class Pago {
    private String id;
    private String usuarioId;
    private String eventoId;
    private double monto;
    private String metodoPago;
    private String fecha;

    public Pago(String id, String usuarioId, String eventoId, double monto, String metodoPago, String fecha) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.eventoId = eventoId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

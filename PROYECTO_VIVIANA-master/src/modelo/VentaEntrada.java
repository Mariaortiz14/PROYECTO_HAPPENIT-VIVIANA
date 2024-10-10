package modelo;

public class VentaEntrada {
    private String id;
    private String idUsuario;
    private String idEvento;
    private int cantidad;
    private String metodoPago;

    public VentaEntrada(String id, String idUsuario, String idEvento, int cantidad, String metodoPago) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}


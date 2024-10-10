package modelo;

public class Calendario {
    private String id;
    private String nombreEvento;
    private String fecha;
    private String ubicacion;
    private String descripcion;

    public Calendario(String id, String nombreEvento, String fecha, String ubicacion, String descripcion) {
        this.id = id;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", fecha='" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", descripcion='" + descripcion ;
    }
}

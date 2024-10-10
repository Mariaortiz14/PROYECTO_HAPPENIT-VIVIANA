package modelo;

public class RedSocial {
    private String id;
    private String nombre;
    private String url;

    public RedSocial(String id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

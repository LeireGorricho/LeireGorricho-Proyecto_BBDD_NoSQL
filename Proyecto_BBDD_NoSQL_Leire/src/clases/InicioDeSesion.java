package clases;

public class InicioDeSesion {

    int id;
    int idEmpleado;
    String usuario;
    String fecha;

    public InicioDeSesion(int id, int idEmpleado, String usuario, String fecha) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

package clases;

public class Prestamo {

    int id;
    int idlibro;
    int idcliente;
    String fecha;
    int diasprestamo;

    public Prestamo(int id, int idlibro, int idcliente, String fecha, int diasprestamo) {
        this.id = id;
        this.idlibro = idlibro;
        this.idcliente = idcliente;
        this.fecha = fecha;
        this.diasprestamo = diasprestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDiasprestamo() {
        return diasprestamo;
    }

    public void setDiasprestamo(int diasprestamo) {
        this.diasprestamo = diasprestamo;
    }
}

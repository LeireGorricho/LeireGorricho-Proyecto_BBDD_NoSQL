package clases;

public class Consulta {

    String empleado;
    String fecha;
    String sentecia;

    public Consulta(String empleado, String fecha, String sentecia) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.sentecia = sentecia;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSentecia() {
        return sentecia;
    }

    public void setSentecia(String sentecia) {
        this.sentecia = sentecia;
    }
}

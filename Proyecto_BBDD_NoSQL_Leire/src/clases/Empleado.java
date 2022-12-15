package clases;

public class Empleado {

    int id;
    String usuario;
    boolean login;

    public Empleado(int id, String usuario, boolean login) {
        this.id = id;
        this.usuario = usuario;
        this.login = login;
    }

    public Empleado(boolean login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}

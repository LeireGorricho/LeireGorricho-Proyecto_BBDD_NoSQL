package clases;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;

import javax.swing.*;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConexionExist {
    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ProyectoPrueba"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = "admin"; //Clave

    public ConexionExist() {
    }

    public static Collection conectar() {
        try {
            Class cl = Class.forName(driver); //Carga del driver
            Database database = (Database) cl.getDeclaredConstructor().newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            Collection col = DatabaseManager.getCollection(URI, usu, usuPwd);
            return col;
        } catch (XMLDBException e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar la BD eXist");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error en el driver");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            JOptionPane.showMessageDialog(null, "Error al instanciar la base de datos");
        }
        return null;
    }

    public Empleado login(String usuario, String contrasena) {
        Collection col = conectar();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $user in /empleados/empleado[usuario = '" + usuario + "' and contrasena = '" + contrasena + "'] return $user");
                // recorrer los datos del recurso.
                ResourceIterator i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto.");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String campo = (String) r.getContent();
                    SAXBuilder saxBuilder = new SAXBuilder();
                    Document document = saxBuilder.build(new StringReader(campo));
                    Element root = document.getRootElement();
                    return new Empleado(Integer.parseInt(root.getAttribute("id").getValue()), root.getChildren("usuario").get(0).getText(), true);
                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento.");
            } catch (IOException | JDOMException e) {
                JOptionPane.showMessageDialog(null, "Error intentalo de nuevo mas tarde");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
        return new Empleado(false);
    }

    public List<Libro> cargarLibros() {
        Collection col = conectar();
        List<Libro> libros = new ArrayList<>();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $emp in /libros/libro return $emp");
                // recorrer los datos del recurso.
                ResourceIterator i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay libros en la biblioteca");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String campo = (String) r.getContent();
                    SAXBuilder saxBuilder = new SAXBuilder();
                    Document document = saxBuilder.build(new StringReader(campo));
                    Element root = document.getRootElement();
                    Libro libro = new Libro(Integer.parseInt(root.getAttribute("id").getValue()), root.getChildren("nombre").get(0).getText(), root.getChildren("autor").get(0).getText(), root.getChildren("genero").get(0).getText(), root.getChildren("editorial").get(0).getText(), root.getChildren("idioma").get(0).getText(), Integer.parseInt(root.getChildren("numpaginas").get(0).getText()));
                    libros.add(libro);
                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            } catch (IOException | JDOMException e) {
                JOptionPane.showMessageDialog(null, "Error, inténtalo de nuevo más tarde");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
        return libros;
    }

    public List<Cliente> cargarClientes() {
        Collection col = conectar();
        List<Cliente> clientes = new ArrayList<>();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $emp in /clientes/cliente return $emp");
                // recorrer los datos del recurso.
                ResourceIterator i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay clientes en la biblioteca");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String campo = (String) r.getContent();
                    SAXBuilder saxBuilder = new SAXBuilder();
                    Document document = saxBuilder.build(new StringReader(campo));
                    Element root = document.getRootElement();
                    Cliente cliente = new Cliente(Integer.parseInt(root.getAttribute("id").getValue()), root.getChildren("usuario").get(0).getText(), root.getChildren("contrasena").get(0).getText(), root.getChildren("nombre").get(0).getText(), root.getChildren("apellido").get(0).getText(), Integer.parseInt(root.getChildren("telefono").get(0).getText()), root.getChildren("email").get(0).getText());
                    clientes.add(cliente);
                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            } catch (IOException | JDOMException e) {
                JOptionPane.showMessageDialog(null, "Error, inténtalo de nuevo más tarde");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
        return clientes;
    }

    public List<Prestamo> cargarPrestamos() {
        Collection col = conectar();
        List<Prestamo> prestamos = new ArrayList<>();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $emp in /prestamos/prestamo return $emp");
                // recorrer los datos del recurso.
                ResourceIterator i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay préstamos en la biblioteca");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String campo = (String) r.getContent();
                    SAXBuilder saxBuilder = new SAXBuilder();
                    Document document = saxBuilder.build(new StringReader(campo));
                    Element root = document.getRootElement();
                    Prestamo prestamo = new Prestamo(Integer.parseInt(root.getAttribute("id").getValue()), Integer.parseInt(root.getAttribute("idlibro").getValue()), Integer.parseInt(root.getAttribute("idcliente").getValue()), root.getChildren("fecha").get(0).getText(), Integer.parseInt(root.getChildren("diasprestamo").get(0).getText()));
                    prestamos.add(prestamo);
                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            } catch (IOException | JDOMException e) {
                JOptionPane.showMessageDialog(null, "Error, inténtalo de nuevo más tarde");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
        return prestamos;
    }

    public void anadirLibro(Libro nuevolibro, Empleado emp) {
        Collection col = conectar();
        String textlibro = "<libro id='" + nuevolibro.getId() + "'>" +
                "<titulo>" + nuevolibro.getTitulo() + "</titulo>" +
                "<autor>" + nuevolibro.getAutor() + "</autor>" +
                "<genero>" + nuevolibro.getGenero() + "</genero>" +
                "<editorial>" + nuevolibro.getEditorial() + "</editorial>" +
                "<idioma>" + nuevolibro.getIdioma() + "</idioma>" +
                "<numpaginas>" + nuevolibro.getNumpaginas() + "</numpaginas>" +
                "</libro>";
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                String sentencia = "update insert " + textlibro + " into /libros";
                ResourceSet result = servicio.query(sentencia);
                System.out.println(result);
                registroCambios(emp, sentencia);
                //cerramos
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void anadirCliente(Cliente nuevocliente, Empleado emp) {
        Collection col = conectar();
        String textcliente = "<cliente id='" + nuevocliente.getId() + "'>" +
                "<usuario>" + nuevocliente.getUsuario() + "</usuario>" +
                "<contrasena>" + nuevocliente.getContrasena() + "</contrasena>" +
                "<nombre>" + nuevocliente.getNombre() + "</nombre>" +
                "<apellido>" + nuevocliente.getApellido() + "</apellido>" +
                "<telefono>" + nuevocliente.getTelefono() + "</telefono>" +
                "<email>" + nuevocliente.getEmail() + "</email>" +
                "</cliente>";
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                String sentencia = "update insert " + textcliente + " into /clientes";
                ResourceSet result = servicio.query(sentencia);
                System.out.println(result);
                registroCambios(emp, sentencia);
                //cerramos
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void anadirPrestamo(Prestamo nuevoprestamo, Empleado emp) {
        Collection col = conectar();
        String textprestamo = "<prestamo id='" + nuevoprestamo.getId() + "'>" +
                "<idlibro>" + nuevoprestamo.getIdlibro() + "</idlibro>" +
                "<idcliente>" + nuevoprestamo.getIdcliente() + "</idcliente>" +
                "<fecha>" + nuevoprestamo.getFecha() + "</fecha>" +
                "<diasprestamo>" + nuevoprestamo.getDiasprestamo() + "</diasprestamo>" +
                "</prestamo>";
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                String sentencia = "update insert " + textprestamo + " into /prestamos";
                ResourceSet result = servicio.query(sentencia);
                System.out.println(result);
                registroCambios(emp, sentencia);
                //cerramos
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void eliminarLibro(int id) {
        Collection col = conectar();
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para borrar un empleado --> update delete
                servicio.query("update delete /libros/libro[@id='" + id + "']");
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void eliminarCliente(int id) {
        Collection col = conectar();
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para borrar un empleado --> update delete
                servicio.query("update delete /clientes/cliente[@id='" + id + "']");
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void eliminarPrestamo(int id) {
        Collection col = conectar();
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para borrar un empleado --> update delete
                servicio.query("update delete /prestamos/prestamos[@id='" + id + "']");
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void editarLibro(Libro libro) {
        Collection col = conectar();
        String updatelibro = "<libro id='" + libro.getId() + "'>" +
                "<titulo>" + libro.getTitulo() + "</titulo>" +
                "<autor>" + libro.getAutor() + "</autor>" +
                "<genero>" + libro.getGenero() + "</genero>" +
                "<editorial>" + libro.getEditorial() + "</editorial>" +
                "<idioma>" + libro.getIdioma() + "</idioma>" +
                "<numpaginas>" + libro.getNumpaginas() + "</numpaginas>" +
                "</libro>";
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para borrar un producto --> update replace
                servicio.query("update replace /libros/libro[@id=" + libro.getId() + "] with" + updatelibro);
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void editarCliente(Cliente cliente) {
        Collection col = conectar();
        String updatecliente = "<cliente id='" + cliente.getId() + "'>" +
                "<usuario>" + cliente.getUsuario() + "</usuario>" +
                "<contrasena>" + cliente.getContrasena() + "</contraseña>" +
                "<nombre>" + cliente.getNombre() + "</nombre>" +
                "<apellido>" + cliente.getApellido() + "</apellido>" +
                "<telefono>" + cliente.getTelefono() + "</telefono>" +
                "<email>" + cliente.getEmail() + "</email>" +
                "</cliente>";
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para borrar un producto --> update replace
                servicio.query("update replace /clientes/cliente[@id=" + cliente.getId() + "] with" + updatecliente);
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public void registroLoginEmpleados(Empleado emp) {
        Collection col = conectar();
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //recuperar el id mas alto del registro para añadirle el siguiente
                ResourceSet result = servicio.query("max(/logins/login/id) + 1");
                // recorrer los datos del recurso.
                int id = 0;
                ResourceIterator i = result.getIterator();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    id = Integer.parseInt(r.getContent().toString());
                }
                String registro = "<login>" +
                        "<id>" + id + "</id>" +
                        "<idempleado>" + emp.getId() + "</idempleado>" +
                        "<usuario>" + emp.getUsuario() + "</usuario>" +
                        "<fecha>" + new Date() + "</fecha>" +
                        "</login>";

                //insertar el registro de login
                servicio.query("update insert " + registro + " into /logins");
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar los datos");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }

    public List<InicioDeSesion> cargarInicioSesiones() {
        Collection col = conectar();
        List<InicioDeSesion> logins = new ArrayList<>();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $sesion in /logins/login return $sesion");
                // recorrer los datos del recurso.
                ResourceIterator i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay registros de inicio de sesión");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String campo = (String) r.getContent();
                    SAXBuilder saxBuilder = new SAXBuilder();
                    Document document = saxBuilder.build(new StringReader(campo));
                    Element root = document.getRootElement();
                    InicioDeSesion sesion = new InicioDeSesion(Integer.parseInt(root.getChildren("id").get(0).getValue()), Integer.parseInt(root.getChildren("idempleado").get(0).getText()), root.getChildren("usuario").get(0).getText(), root.getChildren("fecha").get(0).getText());
                    logins.add(sesion);
                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            } catch (IOException | JDOMException e) {
                JOptionPane.showMessageDialog(null, "Error, inténtalo de nuevo más tarde");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
        return logins;
    }


    public List<Consulta> cargarControlConsultas() {
        Collection col = conectar();
        List<Consulta> consultas = new ArrayList<>();
        if (col != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for consult in /consultas/consulta return $consult");
                // recorrer los datos del recurso.
                ResourceIterator i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay registro de consultas");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String campo = (String) r.getContent();
                    SAXBuilder saxBuilder = new SAXBuilder();
                    Document document = saxBuilder.build(new StringReader(campo));
                    Element root = document.getRootElement();
                    Consulta consulta = new Consulta(root.getChildren("empleado").get(0).getValue(), root.getChildren("fecha").get(0).getText(), root.getChildren("sentencia").get(0).getText());
                    consultas.add(consulta);
                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento");
            } catch (IOException | JDOMException e) {
                JOptionPane.showMessageDialog(null, "Error, inténtalo de nuevo más tarde");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
        return consultas;
    }

    public void registroCambios(Empleado emp, String sentencia) {
        Collection col = conectar();
        if (col != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //recuperar el id mas alto del registro para añadirle el siguiente
                ResourceSet result = servicio.query("max(/consultas/consulta/id) + 1");
                // recorrer los datos del recurso.
                int id = 0;
                ResourceIterator i = result.getIterator();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    id = Integer.parseInt(r.getContent().toString());
                }
                String registro = "<consulta>" +
                        "<id>" + id + "</id>" +
                        "<idempleado>" + emp.getId() + "</idempleado>" +
                        "<usuario>" + emp.getUsuario() + "</usuario>" +
                        "<fecha>" + new Date() + "</fecha>" +
                        "<sentencia>" + sentencia + "</sentencia>" +
                        "</consulta>";

                //insertar el registro de login
                servicio.query("update insert " + registro + " into /consultas");
                col.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar los datos");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }
}

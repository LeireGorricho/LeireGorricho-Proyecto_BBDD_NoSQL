package xmls;

import org.w3c.dom.*;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class GenerarColeccion {

    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db"; //URI
    static String usu = "admin"; //Usuario
    static String usuPwd = ""; //Clave

    public static void generararchivos(){
        crearLibros();
        crearClientes();
        crearPrestamos();
        crearEmpleados();
        crearLoginEmpleados();
        crearRegistroConsultasEmpleados();
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.getDeclaredConstructor().newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);

            Collection parent = DatabaseManager.getCollection(URI, usu, usuPwd);
            CollectionManagementService mgt = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
            Collection col = mgt.createCollection(URI + "/ProyectoBBDDNoSQL");
            col.close();
            parent.close();
            URI = URI + "/ProyectoBBDDNoSQL";
        } catch (XMLDBException e) {
            JOptionPane.showMessageDialog(null, "Error al instanciar la base de datos");
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos");
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "No tienes permisos sobre la base de datos");
        } catch (NoSuchMethodException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar el método para conectarse a la base de datos");
        }
        xmlsColeccion();
    }

    static void crearElemento(String datoPlato, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoPlato);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }

    static void crearAtributo(String datoPlato, String valor, Element raiz, Document document) {
        Attr atribute = document.createAttribute(datoPlato);
        Text text = document.createTextNode(valor);
        raiz.setAttributeNode(atribute);
        atribute.appendChild(text);
    }

    public static void crearLibros() {
        try {
            //creamos el documento con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "libros", null);
            document.setXmlVersion("1.0");

            //Creamos cada elemento
            Element libro = document.createElement("libro");
            document.getDocumentElement().appendChild(libro);
            crearAtributo("id", "1", libro, document);
            crearElemento("titulo", "El principito", libro, document);
            crearElemento("autor", "Antoine de Saint Exupery", libro, document);
            crearElemento("genero", "Infantil", libro, document);
            crearElemento("editorial", "Salamandra", libro, document);
            crearElemento("idioma", "Castellano", libro, document);
            crearElemento("numpaginas", "96", libro, document);

            Element libro2 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro2);
            crearAtributo("id", "2", libro2, document);
            crearElemento("titulo", "Ciudad en la niebla", libro2, document);
            crearElemento("autor", "Agustin de Foxa", libro2, document);
            crearElemento("genero", "Poesia", libro2, document);
            crearElemento("editorial", "Renacimiento", libro2, document);
            crearElemento("idioma", "Castellano", libro2, document);
            crearElemento("numpaginas", "280", libro2, document);

            Element libro3 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro3);
            crearAtributo("id", "3", libro3, document);
            crearElemento("titulo", "La celestina", libro3, document);
            crearElemento("autor", "Fernando de Rojas", libro3, document);
            crearElemento("genero", "Novela, Tragicomedia", libro3, document);
            crearElemento("editorial", "Catedra", libro3, document);
            crearElemento("idioma", "Castellano", libro3, document);
            crearElemento("numpaginas", "368", libro3, document);

            Element libro4 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro4);
            crearAtributo("id", "4", libro4, document);
            crearElemento("titulo", "La casa de Bernarda Alba", libro4, document);
            crearElemento("autor", "Federico Garcia Lorca", libro4, document);
            crearElemento("genero", "Teatro", libro4, document);
            crearElemento("editorial", "Catedra", libro4, document);
            crearElemento("idioma", "Castellano", libro4, document);
            crearElemento("numpaginas", "288", libro4, document);

            Element libro5 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro5);
            crearAtributo("id", "5", libro5, document);
            crearElemento("titulo", "Orgullo y prejuicio", libro5, document);
            crearElemento("autor", "Jane Austen", libro5, document);
            crearElemento("genero", "Novela contemporanea", libro5, document);
            crearElemento("editorial", "Ediciones Invisibles", libro5, document);
            crearElemento("idioma", "Castellano, Ingles", libro5, document);
            crearElemento("numpaginas", "440", libro5, document);

            Element libro6 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro6);
            crearAtributo("id", "6", libro6, document);
            crearElemento("titulo", "Harry Potter y la piedra filosofal", libro6, document);
            crearElemento("autor", "J.K Rowling", libro6, document);
            crearElemento("genero", "Fantasía", libro6, document);
            crearElemento("editorial", "Salamandra", libro6, document);
            crearElemento("idioma", "Castellano, Inglés", libro6, document);
            crearElemento("numpaginas", "250", libro6, document);

            Element libro7 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro7);
            crearAtributo("id", "7", libro7, document);
            crearElemento("titulo", "Harry Potter y la cámara secreta", libro7, document);
            crearElemento("autor", "J.K Rowling", libro7, document);
            crearElemento("genero", "Fantasía", libro7, document);
            crearElemento("editorial", "Salamandra", libro7, document);
            crearElemento("idioma", "Castellano, Inglés", libro7, document);
            crearElemento("numpaginas", "250", libro7, document);

            Element libro8 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro8);
            crearAtributo("id", "8", libro8, document);
            crearElemento("titulo", "Harry Potter y el prisionero de Azkaban", libro8, document);
            crearElemento("autor", "J.K Rowling", libro8, document);
            crearElemento("genero", "Fantasía", libro8, document);
            crearElemento("editorial", "Salamandra", libro8, document);
            crearElemento("idioma", "Castellano, Inglés", libro8, document);
            crearElemento("numpaginas", "250", libro8, document);

            Element libro9 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro9);
            crearAtributo("id", "9", libro9, document);
            crearElemento("titulo", "Harry Potter y el cáliz de fuego", libro9, document);
            crearElemento("autor", "J.K Rowling", libro9, document);
            crearElemento("genero", "Fantasía", libro9, document);
            crearElemento("editorial", "Salamandra", libro9, document);
            crearElemento("idioma", "Castellano, Inglés", libro9, document);
            crearElemento("numpaginas", "250", libro9, document);

            Element libro10 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro10);
            crearAtributo("id", "10", libro10, document);
            crearElemento("titulo", "Harry Potter y la Orden del Fénix", libro10, document);
            crearElemento("autor", "J.K Rowling", libro10, document);
            crearElemento("genero", "Fantasía", libro10, document);
            crearElemento("editorial", "Salamandra", libro10, document);
            crearElemento("idioma", "Castellano, Inglés", libro10, document);
            crearElemento("numpaginas", "250", libro10, document);

            Element libro11 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro11);
            crearAtributo("id", "11", libro11, document);
            crearElemento("titulo", "Harry Potter y el misterio del príncipe", libro11, document);
            crearElemento("autor", "J.K Rowling", libro11, document);
            crearElemento("genero", "Fantasía", libro11, document);
            crearElemento("editorial", "Salamandra", libro11, document);
            crearElemento("idioma", "Castellano, Inglés", libro11, document);
            crearElemento("numpaginas", "250", libro11, document);

            Element libro12 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro12);
            crearAtributo("id", "12", libro12, document);
            crearElemento("titulo", "Harry Potter y las reliquias de la muerte", libro12, document);
            crearElemento("autor", "J.K Rowling", libro12, document);
            crearElemento("genero", "Fantasía", libro12, document);
            crearElemento("editorial", "Salamandra", libro12, document);
            crearElemento("idioma", "Castellano, Inglés", libro12, document);
            crearElemento("numpaginas", "250", libro12, document);

            Element libro13 = document.createElement("libro");
            document.getDocumentElement().appendChild(libro13);
            crearAtributo("id", "13", libro13, document);
            crearElemento("titulo", "Animales fantásticos y donde encontrarlos", libro13, document);
            crearElemento("autor", "J.K Rowling", libro13, document);
            crearElemento("genero", "Fantasía", libro13, document);
            crearElemento("editorial", "Salamandra", libro13, document);
            crearElemento("idioma", "Castellano", libro13, document);
            crearElemento("numpaginas", "160", libro13, document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("./src/xmls/libros.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void crearClientes() {
        try {
            //creamos el documento con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "clientes", null);
            document.setXmlVersion("1.0");

            //Creamos cada elemento
            Element cliente = document.createElement("cliente");
            document.getDocumentElement().appendChild(cliente);
            crearAtributo("id", "1", cliente, document);
            crearElemento("usuario", "pepe", cliente, document);
            crearElemento("contrasena", "12345", cliente, document);
            crearElemento("nombre", "Pepe", cliente, document);
            crearElemento("apellido", "Garcia", cliente, document);
            crearElemento("telefono", "612345789", cliente, document);
            crearElemento("email", "pepegarcia@gmail.com", cliente, document);

            Element cliente2 = document.createElement("cliente");
            document.getDocumentElement().appendChild(cliente2);
            crearAtributo("id", "2", cliente2, document);
            crearElemento("usuario", "elena", cliente2, document);
            crearElemento("contrasena", "12345", cliente2, document);
            crearElemento("nombre", "Elena", cliente2, document);
            crearElemento("apellido", "Perez", cliente2, document);
            crearElemento("telefono", "612345789", cliente2, document);
            crearElemento("email", "elenaperez@gmail.com", cliente2, document);

            Element cliente3 = document.createElement("cliente");
            document.getDocumentElement().appendChild(cliente3);
            crearAtributo("id", "3", cliente3, document);
            crearElemento("usuario", "maria", cliente3, document);
            crearElemento("contrasena", "12345", cliente3, document);
            crearElemento("nombre", "Maria", cliente3, document);
            crearElemento("apellido", "Garcia", cliente3, document);
            crearElemento("telefono", "612345789", cliente3, document);
            crearElemento("email", "mariagarcia@gmail.com", cliente3, document);

            Element cliente4 = document.createElement("cliente");
            document.getDocumentElement().appendChild(cliente4);
            crearAtributo("id", "4", cliente4, document);
            crearElemento("usuario", "manuel", cliente4, document);
            crearElemento("contrasena", "12345", cliente4, document);
            crearElemento("nombre", "Manuel", cliente4, document);
            crearElemento("apellido", "Martinez", cliente4, document);
            crearElemento("telefono", "612345789", cliente4, document);
            crearElemento("email", "manuelmartinez@gmail.com", cliente4, document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./src/xmls/clientes.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearEmpleados() {
        try {
            //creamos el documento con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "empleados", null);
            document.setXmlVersion("1.0");

            //Creamos cada elemento
            Element empleado = document.createElement("empleado");
            document.getDocumentElement().appendChild(empleado);
            crearAtributo("id", "1", empleado, document);
            crearElemento("usuario", "admin", empleado, document);
            crearElemento("contrasena", "12345", empleado, document);

            Element empleado2 = document.createElement("empleado");
            document.getDocumentElement().appendChild(empleado2);
            crearAtributo("id", "2", empleado2, document);
            crearElemento("usuario", "pepa", empleado2, document);
            crearElemento("contrasena", "12345", empleado2, document);

            Element empleado3 = document.createElement("empleado");
            document.getDocumentElement().appendChild(empleado3);
            crearAtributo("id", "3", empleado3, document);
            crearElemento("usuario", "empleado", empleado3, document);
            crearElemento("contrasena", "12345", empleado3, document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./src/xmls/empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearPrestamos() {
        try {
            //creamos el documento con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "prestamos", null);
            document.setXmlVersion("1.0");

            //Creamos cada elemento
            Element prestamo = document.createElement("prestamo");
            document.getDocumentElement().appendChild(prestamo);
            crearAtributo("id", "1", prestamo, document);
            crearElemento("idlibro", "3", prestamo, document);
            crearElemento("idcliente", "2", prestamo, document);
            crearElemento("fecha", new Date().toString(), prestamo, document);
            crearElemento("diasprestamo", "15", prestamo, document);

            Element prestamo2 = document.createElement("prestamo");
            document.getDocumentElement().appendChild(prestamo2);
            crearAtributo("id", "2", prestamo2, document);
            crearElemento("idlibro", "1", prestamo2, document);
            crearElemento("idcliente", "1", prestamo2, document);
            crearElemento("fecha", new Date().toString(), prestamo2, document);
            crearElemento("diasprestamo", "7", prestamo2, document);

            Element prestamo3 = document.createElement("prestamo");
            document.getDocumentElement().appendChild(prestamo3);
            crearAtributo("id", "3", prestamo3, document);
            crearElemento("idlibro", "2", prestamo3, document);
            crearElemento("idcliente", "5", prestamo3, document);
            crearElemento("fecha", new Date().toString(), prestamo3, document);
            crearElemento("diasprestamo", "15", prestamo3, document);

            Element prestamo4 = document.createElement("prestamo");
            document.getDocumentElement().appendChild(prestamo4);
            crearAtributo("id", "4", prestamo4, document);
            crearElemento("idlibro", "4", prestamo4, document);
            crearElemento("idcliente", "4", prestamo4, document);
            crearElemento("fecha", new Date().toString(), prestamo4, document);
            crearElemento("diasprestamo", "30", prestamo4, document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./src/xmls/prestamos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearLoginEmpleados() {
        try {
            //creamos el documento con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "logins", null);
            document.setXmlVersion("1.0");

            Element login = document.createElement("login");
            document.getDocumentElement().appendChild(login);
            crearElemento("id", "1", login, document);
            crearElemento("idempleado", "1", login, document);
            crearElemento("usuario", "admin", login, document);
            crearElemento("fecha", new Date().toString(), login, document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./src/xmls/logins.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearRegistroConsultasEmpleados() {
        try {
            //creamos el documento con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "consultas", null);
            document.setXmlVersion("1.0");

            //Creamos cada elemento
            Element registro = document.createElement("consulta");
            document.getDocumentElement().appendChild(registro);
            crearElemento("id", "1", registro, document);
            crearElemento("idempleado", "1", registro, document);
            crearElemento("usuario", "admin", registro, document);
            crearElemento("fecha", new Date().toString(), registro, document);
            crearElemento("sentencia", " ", registro, document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./src/xmls/consultas.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    static void xmlsColeccion() {
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.getDeclaredConstructor().newInstance();
            DatabaseManager.registerDatabase(database);
            Collection col = DatabaseManager.getCollection(URI, usu, usuPwd);
            if (col != null) {
                col.storeResource(crearResource("libros.xml", "./src/xmls/libros.xml", col));
                col.storeResource(crearResource("clientes.xml", "./src/xmls/clientes.xml", col));
                col.storeResource(crearResource("prestamos.xml", "./src/xmls/prestamos.xml", col));
                col.storeResource(crearResource("empleados.xml", "./src/xmls/empleados.xml", col));
                col.storeResource(crearResource("consultas.xml", "./src/xmls/consultas.xml", col));
                col.storeResource(crearResource("logins.xml", "./src/xmls/logins.xml", col));
                col.close();
            } else {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos");
            }
        } catch (XMLDBException e) {
            JOptionPane.showMessageDialog(null, "Error al instanciar la BD");
            e.printStackTrace();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos");
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "No tienes permisos sobre la base de datos");
        } catch (NoSuchMethodException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar el método para conectarse a la base de datos");
        }
    }

    static XMLResource crearResource(String xmlNombre, String ruta, Collection col) {
        XMLResource res = null;
        try {
            res = (XMLResource) col.createResource(xmlNombre, "XMLResource");
            File f = new File(ruta);
            res.setContent(f);

        } catch (XMLDBException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos");
        }
        return res;
    }
}

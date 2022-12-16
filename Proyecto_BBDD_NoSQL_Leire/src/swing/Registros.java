/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import clases.ConexionExist;
import clases.Consulta;
import clases.InicioDeSesion;
import scrollbar.ScrollBarCustom;
import table.TableHeader;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leiii
 */
public class Registros extends javax.swing.JPanel {

    String[] nombreColumnasConsultas = {"Usuario", "Fecha", "Sentencia"};
    String[] nombreColumnasLogins = {"ID Empleado", "Usuario", "Fecha"};
    List<Consulta> consultas = new ArrayList<Consulta>();
    List<InicioDeSesion> logins = new ArrayList<InicioDeSesion>();
    ConexionExist conexion = new ConexionExist();

    /**
     * Creates new form Registros
     */
    public Registros() {
        initComponents();

        //tabla de consultas
        tabla_consultas.setShowHorizontalLines(true);
        tabla_consultas.setGridColor(new Color(230,230,230));
        tabla_consultas.setRowHeight(30);
        tabla_consultas.getTableHeader().setReorderingAllowed(true);
        tabla_consultas.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                if(column==nombreColumnasConsultas.length){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        modificarTablaSesion();
        modificarTablaConsultas();

        //tabla de logs
        tabla_logins.setShowHorizontalLines(true);
        tabla_logins.setGridColor(new Color(230,230,230));
        tabla_logins.setRowHeight(30);
        tabla_logins.getTableHeader().setReorderingAllowed(true);
        tabla_logins.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                if(column==nombreColumnasLogins.length){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
    }

    public void cargarDatosLogins() {
        logins.clear();
        logins = conexion.cargarInicioSesiones();
    }

    public void cargarDatosConsultas() {
        consultas.clear();
        consultas = conexion.cargarControlConsultas();
    }

    public void modificarTablaSesion() {
        cargarDatosLogins();
        //Nombre de las columnas y cargamos los datos al array que se le van a enviar al la tabla para cargar los datos
        int cantidad = logins.size();
        String[][] d = new String[cantidad][3];
        for (int i = 0; i < logins.size(); i++) {
            d[i][0] = String.valueOf(logins.get(i).getIdEmpleado());
            d[i][1] = String.valueOf(logins.get(i).getUsuario());
            d[i][2] = String.valueOf(logins.get(i).getFecha());
        }
        //se carga el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(d, nombreColumnasLogins) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;
        tabla_logins.setModel(modelo);
        /*tableSesion.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        tableSesion.setRowSorter(sorter);*/
    }

    public void modificarTablaConsultas() {
        cargarDatosConsultas();
        //Nombre de las columnas y cargamos los datos al array que se le van a enviar al la tabla para cargar los datos
        int cantidad = consultas.size();
        String[][] d = new String[cantidad][3];
        for (int i = 0; i < consultas.size(); i++) {
            d[i][0] = String.valueOf(consultas.get(i).getEmpleado());
            d[i][1] = String.valueOf(consultas.get(i).getFecha());
            d[i][2] = String.valueOf(consultas.get(i).getSentecia());
        }
        //se carga el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(d, nombreColumnasConsultas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;
        tabla_consultas.setModel(modelo);
        /*tableSesion.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        tableSesion.setRowSorter(sorter);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_consultas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_logins = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("REGISTRO DE CONSULTAS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("REGISTRO DE INCIOS DE SESIÓN");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        tabla_consultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_consultas.setSelectionBackground(new java.awt.Color(161, 154, 224));
        jScrollPane1.setViewportView(tabla_consultas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 640, 200));

        tabla_logins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_logins.setSelectionBackground(new java.awt.Color(161, 154, 224));
        jScrollPane2.setViewportView(tabla_logins);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 640, 200));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_consultas;
    private javax.swing.JTable tabla_logins;
    // End of variables declaration//GEN-END:variables
}

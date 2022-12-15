/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.ConexionExist;
import clases.Empleado;
import clases.Libro;
import scrollbar.ScrollBarCustom;
import table.TableHeader;

/**
 *
 * @author leiii
 */
public class Libros extends javax.swing.JPanel {
    
    String[] nombreColumnas = {"ID", "Título", "Autor", "Editorial"};
    JPanel panelPagina;
    List<Libro> libros = new ArrayList<Libro>();
    ConexionExist conexion = new ConexionExist();
    Empleado emp;

    /**
     * Creates new form Libros
     */
    public Libros(JPanel panelPagina, Empleado emp) {
        initComponents();
        
        this.panelPagina = panelPagina;
        this.emp = emp;
        
        tabla_libros.setShowHorizontalLines(true);
        tabla_libros.setGridColor(new Color(230,230,230));
        tabla_libros.setRowHeight(25);
        tabla_libros.getTableHeader().setReorderingAllowed(true);
        tabla_libros.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                if(column==nombreColumnas.length){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
       });
       jScrollPane1.getViewport().setBackground(Color.WHITE);
       jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
       fixtable(jScrollPane1);
       modificarTabla();
    }

    public void fixtable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    public void cargarDatos() {
        libros.clear();
        libros = conexion.cargarLibros();
    }

    public void modificarTabla() {
        cargarDatos();
        //Nombre de las columnas y cargamos los datos al array que se le van a enviar al la tabla para cargar los datos
        int cantidad = libros.size();
        String[][] d = new String[cantidad][4];
        for (int i = 0; i < libros.size(); i++) {
            d[i][0] = String.valueOf(libros.get(i).getId());
            d[i][1] = String.valueOf(libros.get(i).getTitulo());
            d[i][2] = String.valueOf(libros.get(i).getAutor());
            d[i][3] = String.valueOf(libros.get(i).getEditorial());
        }
        //se carga el modelo de la tabla
        tabla_libros.setModel(new DefaultTableModel(d, nombreColumnas));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_libros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonVer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonNuevo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        botonModificar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_libros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_libros);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 69, 560, 470));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("LIBROS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        botonVer.setBackground(new java.awt.Color(91, 78, 202));
        botonVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonVerMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa25x25.png"))); // NOI18N

        javax.swing.GroupLayout botonVerLayout = new javax.swing.GroupLayout(botonVer);
        botonVer.setLayout(botonVerLayout);
        botonVerLayout.setHorizontalGroup(
            botonVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonVerLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        botonVerLayout.setVerticalGroup(
            botonVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonVerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(botonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 60, -1));

        botonNuevo.setBackground(new java.awt.Color(91, 78, 202));
        botonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonNuevoMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N

        javax.swing.GroupLayout botonNuevoLayout = new javax.swing.GroupLayout(botonNuevo);
        botonNuevo.setLayout(botonNuevoLayout);
        botonNuevoLayout.setHorizontalGroup(
            botonNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonNuevoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        botonNuevoLayout.setVerticalGroup(
            botonNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(botonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 60, -1));

        botonEliminar.setBackground(new java.awt.Color(91, 78, 202));
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonEliminarMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minus.png"))); // NOI18N

        javax.swing.GroupLayout botonEliminarLayout = new javax.swing.GroupLayout(botonEliminar);
        botonEliminar.setLayout(botonEliminarLayout);
        botonEliminarLayout.setHorizontalGroup(
            botonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonEliminarLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(16, 16, 16))
        );
        botonEliminarLayout.setVerticalGroup(
            botonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 60, -1));

        botonModificar.setBackground(new java.awt.Color(91, 78, 202));
        botonModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonModificarMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N

        javax.swing.GroupLayout botonModificarLayout = new javax.swing.GroupLayout(botonModificar);
        botonModificar.setLayout(botonModificarLayout);
        botonModificarLayout.setHorizontalGroup(
            botonModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        botonModificarLayout.setVerticalGroup(
            botonModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 60, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerMousePressed
        if (tabla_libros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Para ver más información debes seleccionar un libro de la tabla");
        } else {
            cargarDatos();
            VerLibro frame = new VerLibro(panelPagina, emp);
            frame.setSize(700,550);
            frame.setLocation(0,0);
            panelPagina.removeAll();
            panelPagina.add(frame, BorderLayout.CENTER);
            panelPagina.revalidate();
            panelPagina.repaint();
        }
    }//GEN-LAST:event_botonVerMousePressed

    private void botonNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevoMousePressed
        cargarDatos();
        NuevoLibro frame = new NuevoLibro(panelPagina, emp);
        frame.setSize(700,550);
        frame.setLocation(0,0);
        panelPagina.removeAll();
        panelPagina.add(frame, BorderLayout.CENTER);
        panelPagina.revalidate();
        panelPagina.repaint();
    }//GEN-LAST:event_botonNuevoMousePressed

    private void botonEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMousePressed
        if (tabla_libros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Para eliminar debes seleccionar un libro de la tabla");
        } else {
            //Obtencion del id del objeto seleccionaod en la tabla
            int id = Integer.parseInt(tabla_libros.getValueAt(tabla_libros.getSelectedRow(), 0).toString());
            conexion.eliminarLibro(id);
        }
        modificarTabla();
    }//GEN-LAST:event_botonEliminarMousePressed

    private void botonModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarMousePressed
        if (tabla_libros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Para editar debes seleccionar un libro de la tabla");
        } else {
            int id = Integer.parseInt(tabla_libros.getValueAt(tabla_libros.getSelectedRow(), 0).toString());
            libros.clear();
            libros = conexion.cargarLibros();
            EditarLibro frame = new EditarLibro(panelPagina, libros, emp, id);
            frame.setSize(700,550);
            frame.setLocation(0,0);
            panelPagina.removeAll();
            panelPagina.add(frame, BorderLayout.CENTER);
            panelPagina.revalidate();
            panelPagina.repaint();
        }


    }//GEN-LAST:event_botonModificarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonEliminar;
    private javax.swing.JPanel botonModificar;
    private javax.swing.JPanel botonNuevo;
    private javax.swing.JPanel botonVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_libros;
    // End of variables declaration//GEN-END:variables
}

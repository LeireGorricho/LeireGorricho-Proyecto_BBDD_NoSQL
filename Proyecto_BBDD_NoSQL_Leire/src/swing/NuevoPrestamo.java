/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import clases.*;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author leiii
 */
public class NuevoPrestamo extends javax.swing.JPanel {

    JPanel panelPagina;
    List<Prestamo> prestamos;
    ConexionExist conexion = new ConexionExist();
    Empleado emp;
    List<Libro> libros = new ArrayList<Libro>();
    List<Cliente> clientes = new ArrayList<Cliente>();


    /**
     * Creates new form NuevoPrestamo
     */
    public NuevoPrestamo(JPanel panelPagina, Empleado emp) {
        initComponents();
        
        this.panelPagina = panelPagina;
        this.emp = emp;

        libros = conexion.cargarLibros();
        for (int i = 0; i < libros.size(); i++) {
            libro.addItem(String.valueOf(libros.get(i).getId()));
        }

        clientes = conexion.cargarClientes();
        for (int i = 0; i < clientes.size(); i++) {
            cliente.addItem(String.valueOf(clientes.get(i).getId()));
        }

        fecha.setText(String.valueOf(new Date()));
        diasPrestamo.addItem("7");
        diasPrestamo.addItem("15");
        diasPrestamo.addItem("30");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonAnadir = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        fecha = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        botonCancelar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        libro = new javax.swing.JComboBox<>();
        cliente = new javax.swing.JComboBox<>();
        diasPrestamo = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(91, 78, 202));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVO PR??STAMO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 700, 40));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Libro:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cliente:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Fecha:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Dias de pr??stamo:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        botonAnadir.setBackground(new java.awt.Color(161, 154, 224));
        botonAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonAnadirMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("A??adir Pr??stamo");

        javax.swing.GroupLayout botonAnadirLayout = new javax.swing.GroupLayout(botonAnadir);
        botonAnadir.setLayout(botonAnadirLayout);
        botonAnadirLayout.setHorizontalGroup(
            botonAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        botonAnadirLayout.setVerticalGroup(
            botonAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(botonAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 150, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 260, 20));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 260, 10));

        fecha.setEditable(false);
        fecha.setBackground(new java.awt.Color(255, 255, 255));
        fecha.setForeground(new java.awt.Color(102, 102, 102));
        fecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fecha.setBorder(null);
        add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 260, -1));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 260, 10));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 260, 10));

        botonCancelar.setBackground(new java.awt.Color(161, 154, 224));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonCancelarMousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cancelar");

        javax.swing.GroupLayout botonCancelarLayout = new javax.swing.GroupLayout(botonCancelar);
        botonCancelar.setLayout(botonCancelarLayout);
        botonCancelarLayout.setHorizontalGroup(
            botonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonCancelarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel9)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        botonCancelarLayout.setVerticalGroup(
            botonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 150, 30));

        add(libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 260, -1));

        add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 260, -1));

        add(diasPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 260, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnadirMousePressed
        try {
            if (Integer.parseInt(libro.getSelectedItem().toString()) == -1 || Integer.parseInt(cliente.getSelectedItem().toString()) == -1 || Integer.parseInt(diasPrestamo.getSelectedItem().toString()) == -1){
                JOptionPane.showMessageDialog(null, "Comprueba que todos los datos est??n rellenados");
            } else {
                int id;
                prestamos = conexion.cargarPrestamos();
                if (prestamos.size() == 0) {
                    id = 1;
                } else {
                    id = prestamos.get(prestamos.size() - 1).getId() + 1;
                }
                Prestamo nuevoprestamo = new Prestamo(id, Integer.parseInt(libro.getSelectedItem().toString()), Integer.parseInt(cliente.getSelectedItem().toString()), fecha.getText(), Integer.parseInt(diasPrestamo.getSelectedItem().toString()));
                conexion.anadirPrestamo(nuevoprestamo, emp);
                JOptionPane.showMessageDialog(null, "El pr??stamo se ha a??adido correctamente");
                Prestamos frame = new Prestamos(panelPagina, emp);
                frame.setSize(700,550);
                frame.setLocation(0,0);
                panelPagina.removeAll();
                panelPagina.add(frame, BorderLayout.CENTER);
                panelPagina.revalidate();
                panelPagina.repaint();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Comprueba que has rellenado todos los datos y que estos son correctos");
        }
    }//GEN-LAST:event_botonAnadirMousePressed

    private void botonCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMousePressed
        Prestamos frame = new Prestamos(panelPagina, emp);
        frame.setSize(700,550);
        frame.setLocation(0,0);
        panelPagina.removeAll();
        panelPagina.add(frame, BorderLayout.CENTER);
        panelPagina.revalidate();
        panelPagina.repaint();
    }//GEN-LAST:event_botonCancelarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonAnadir;
    private javax.swing.JPanel botonCancelar;
    private javax.swing.JComboBox<String> cliente;
    private javax.swing.JComboBox<String> diasPrestamo;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<String> libro;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import clases.ConexionExist;
import clases.Empleado;
import clases.Libro;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author leiii
 */
public class EditarLibro extends javax.swing.JPanel {

    JPanel panelPagina;

    ConexionExist conexion = new ConexionExist();
    Empleado emp;
    int id;
            
    /**
     * Creates new form EditarLibro
     */
    public EditarLibro(JPanel panelPagina, List<Libro> libros, Empleado emp, int id) {
        initComponents();
        
        this.panelPagina = panelPagina;
        this.emp = emp;
        this.id = id;

        for (Libro libro : libros) {
            if (libro.getId() == id) {
                titulo.setText(libro.getTitulo());
                autor.setText(libro.getAutor());
                genero.setText(libro.getGenero());
                editorial.setText(libro.getEditorial());
                idioma.setText(libro.getIdioma());
                numPaginas.setText(String.valueOf(libro.getNumpaginas()));
            }
        }
        if (titulo.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ha surgido un problema al cargar los datos");
        }
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
        botonEditar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        autor = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        genero = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        editorial = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        idioma = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        numPaginas = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        botonCancelar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(91, 78, 202));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR LIBRO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 700, 40));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("T??tulo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Autor:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("G??nero:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Editorial:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        botonEditar.setBackground(new java.awt.Color(161, 154, 224));
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonEditarMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modificar Libro");

        javax.swing.GroupLayout botonEditarLayout = new javax.swing.GroupLayout(botonEditar);
        botonEditar.setLayout(botonEditarLayout);
        botonEditarLayout.setHorizontalGroup(
            botonEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonEditarLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(16, 16, 16))
        );
        botonEditarLayout.setVerticalGroup(
            botonEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(botonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 150, 30));

        titulo.setForeground(new java.awt.Color(102, 102, 102));
        titulo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        titulo.setBorder(null);
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 260, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 20));

        autor.setForeground(new java.awt.Color(102, 102, 102));
        autor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        autor.setBorder(null);
        add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 260, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 260, 10));

        genero.setForeground(new java.awt.Color(102, 102, 102));
        genero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        genero.setBorder(null);
        add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 260, -1));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 260, 10));

        editorial.setForeground(new java.awt.Color(102, 102, 102));
        editorial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editorial.setBorder(null);
        add(editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 260, -1));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 260, 10));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Idioma:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        idioma.setForeground(new java.awt.Color(102, 102, 102));
        idioma.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        idioma.setBorder(null);
        add(idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 260, -1));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 260, 10));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("N??mero de p??ginas:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        numPaginas.setForeground(new java.awt.Color(102, 102, 102));
        numPaginas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numPaginas.setBorder(null);
        add(numPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 260, -1));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 260, 10));

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

        add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 150, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMousePressed
        Libros frame = new Libros(panelPagina, emp);
        frame.setSize(700,550);
        frame.setLocation(0,0);
        panelPagina.removeAll();
        panelPagina.add(frame, BorderLayout.CENTER);
        panelPagina.revalidate();
        panelPagina.repaint();
    }//GEN-LAST:event_botonCancelarMousePressed

    private void botonEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMousePressed
        try {
            int numeropaginas = Integer.parseInt(numPaginas.getText());
            if (titulo.getText().isBlank() || autor.getText().isBlank() || genero.getText().isBlank() || editorial.getText().isBlank() || idioma.getText().isBlank() || numPaginas.getText().isBlank()){
                JOptionPane.showMessageDialog(null, "Compruebe que todos los datos est??n rellenados");
            } else {
                Libro updateLibro = new Libro(id, titulo.getText(), autor.getText(), genero.getText(), editorial.getText(), idioma.getText(), numeropaginas);
                conexion.editarLibro(updateLibro, emp);
                JOptionPane.showMessageDialog(null, "El libro se ha editado correctamente");
                Libros frame = new Libros(panelPagina, emp);
                frame.setSize(700,550);
                frame.setLocation(0,0);
                panelPagina.removeAll();
                panelPagina.add(frame, BorderLayout.CENTER);
                panelPagina.revalidate();
                panelPagina.repaint();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Introduce valores correctos");
        }
    }//GEN-LAST:event_botonEditarMousePressed
                                       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autor;
    private javax.swing.JPanel botonCancelar;
    private javax.swing.JPanel botonEditar;
    private javax.swing.JTextField editorial;
    private javax.swing.JTextField genero;
    private javax.swing.JTextField idioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField numPaginas;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.DoctorControlador;
import OdontoSysControlador.UsuarioControlador;
import OdontoSysModelo.Doctor;
import OdontoSysModelo.Usuario;
import OdontoSysVista.UsuarioVista;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DetalleUsuarioAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form DetalleUsuario
     */
    public DetalleUsuarioAdministrador() {
        initComponents();
        if(llamado == "Insertar"){
            jLabel1.setText("Insertar Usuario");
            jButtonModificar.setVisible(false);
            jButtonEliminar.setVisible(false);
        }else{
            inicializar();
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
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPassw = new javax.swing.JTextField();
        jButtonAtras = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldObserv = new javax.swing.JTextField();
        jComboBoxRol = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Detalle de Usuario");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Rol:");

        jTextFieldNombre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldPassw.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jButtonAtras.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonAtras.setText("Atrás");
        jButtonAtras.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/modificar.png"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/borrar.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Observaciones:");

        jTextFieldObserv.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jComboBoxRol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secretaria", "Doctor", "Administrador" }));
        jComboBoxRol.setSelectedIndex(2);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Perfil del Usuario:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Usuario");
        jLabel7.setToolTipText("");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Insertar");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Modificar");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Modificar");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Insertar");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Servicio");

        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("Eliminar");

        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxRol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldPassw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldObserv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonModificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAtras)
                            .addGap(36, 36, 36))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox16)
                        .addComponent(jCheckBox15)
                        .addComponent(jCheckBox5)
                        .addComponent(jCheckBox4))
                    .addGap(0, 375, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldObserv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox15)
                .addGap(38, 38, 38)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        int i = 0;
        if(llamado == "Insertar"){
            if(jComboBoxRol.getSelectedIndex() == 1){    //Rol Doctor seleccionado
                obtenerDoctor();                         //Abre una ventana para seleccionar un doctor registrado
            }
            obtenerNuevo();
            i = UsuarioVista.InsertarUsuario(nuevo);    //Validación de datos
            if(i > 0){                                  //Validación exitosa
                JOptionPane.showMessageDialog(null, "Usuario Registrado Correctamente", "Insertar Usuario", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }
        }else{
            obtenerModificacion();
            i = UsuarioControlador.ModificarUser(user);
            if(i != 0){
                JOptionPane.showMessageDialog(null, "Usuario Modificado Correctamente", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
            JOptionPane.showMessageDialog(null, "Usuario No Actualizado", "Usuario Controlador", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        limpiar();
        llamado = "";
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        jTextFieldNombre.setEditable(true);
        jTextFieldObserv.setEditable(true);
        jTextFieldPassw.setEditable(true);
        jComboBoxRol.setEnabled(true);
        jButtonGuardar.setVisible(true);
        jButtonModificar.setVisible(false);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar usuario "+user.getNombre()+"?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            int i = UsuarioControlador.EliminarUsuario(user);
            if(i == 0){
                JOptionPane.showMessageDialog(null, "Usuario Inactivado Correctamente", "Inactivar Usuario", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
            JOptionPane.showMessageDialog(null, "No se pudo inactivar Usuario", "Usuario Controlador", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetalleUsuarioAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleUsuarioAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleUsuarioAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleUsuarioAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleUsuarioAdministrador().setVisible(true);
            }
        });
    }

    //Variables
    public static Usuario user;
    public static String llamado;
    Usuario nuevo = new Usuario();
    Doctor elDoctor = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox jComboBoxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldObserv;
    private javax.swing.JTextField jTextFieldPassw;
    // End of variables declaration//GEN-END:variables

    private void obtenerNuevo() {
        nuevo.setNombre(jTextFieldNombre.getText());
        nuevo.setPassw(jTextFieldPassw.getText());
        nuevo.setRol(jComboBoxRol.getSelectedItem().toString());
System.out.println("Rol nuevo "+nuevo.getRol());
        nuevo.setObservacion(jTextFieldObserv.getText());
        nuevo.setEstado("Activo");
        nuevo.setDoctor(elDoctor);  //Si el rol escogido no fue Doctor, seteará 0
    }

    private void limpiar() {
        jTextFieldNombre.setText("");
        jTextFieldObserv.setText("");
        jTextFieldPassw.setText("");
        jButtonEliminar.setVisible(false);
    }

    private void inicializar() {
        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setText(user.getNombre());
        jTextFieldObserv.setEditable(false);
        jTextFieldObserv.setText(user.getObservacion());
        jTextFieldPassw.setEditable(false);
        jTextFieldPassw.setText(user.getPassw());
        jComboBoxRol.setEnabled(false);
        System.out.println("Rol: "+user.getRol());
        if(user.getRol().compareTo("Secretaria") == 0){
            jComboBoxRol.setSelectedIndex(0);
        }else if(user.getRol().compareTo("Doctor") == 0){
            jComboBoxRol.setSelectedIndex(1);
        }else if(user.getRol().compareTo("Administrador") == 0){
            jComboBoxRol.setSelectedIndex(2);
        }
        jButtonGuardar.setVisible(false);
    }

    private void obtenerModificacion() {
        user.setNombre(jTextFieldNombre.getText());
        user.setPassw(jTextFieldPassw.getText());
        user.setRol(jComboBoxRol.getSelectedItem().toString());
        user.setObservacion(jTextFieldObserv.getText());
    }

    private void obtenerDoctor() {
        Doctor doc = null;
        while(doc == null){
            ObtenerDoctor jDialog= new ObtenerDoctor(null, true);
            jDialog.setVisible(true); 
            doc = new Doctor();
            doc = jDialog.getReturnStatus();
            elDoctor = doc;
        }
    }
}

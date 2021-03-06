/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.UsuarioControlador;
import OdontoSysModelo.Usuario;
import OdontoSysPantalla.Inicio;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ObtenerUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ObtenerUsuarios
     */
    public ObtenerUsuarios() {
        initComponents();
        inicializarTabla();        
        realizarConsulta();
        
        
        jTableUsuarios.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int fila = jTableUsuarios.rowAtPoint(e.getPoint());
                if (fila > -1){
                    DetalleUsuarioDoctor.user = lista.get(fila);  //Pasa a DetalleUsuarioDoctor el user seleccionado
                    DetalleUsuarioDoctor jFrame= new DetalleUsuarioDoctor();
                    jFrame.setVisible(true); //Abre Form Usuario
                    ocultarFrame();
                }
            }
            
        });
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonMenu = new javax.swing.JButton();
        jButtonInsertarUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Usuarios de OdontoSys");

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Id", "Usuario", "Rol"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        jButtonMenu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/accesos.png"))); // NOI18N
        jButtonMenu.setText("Volver al Menú Principal");
        jButtonMenu.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonInsertarUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonInsertarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agregar.png"))); // NOI18N
        jButtonInsertarUser.setText("Insertar Usuario");
        jButtonInsertarUser.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonInsertarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonInsertarUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jButtonMenu)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMenu)
                    .addComponent(jButtonInsertarUser))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        this.setVisible(false);
                
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonInsertarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarUserActionPerformed
        DetalleUsuarioDoctor.llamado = "Insertar";
        DetalleUsuarioDoctor jFrame = new DetalleUsuarioDoctor();
        jFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonInsertarUserActionPerformed

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
            java.util.logging.Logger.getLogger(ObtenerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObtenerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObtenerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObtenerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObtenerUsuarios().setVisible(true);
            }
        });
    }
    //Variables
    DefaultTableModel tabla = new DefaultTableModel();
    ArrayList<Usuario> lista = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertarUser;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabla() {
        tabla.addColumn("Id");
        tabla.addColumn("Usuario");
        tabla.addColumn("Rol");
        jTableUsuarios.setModel(tabla);
    }

    private void realizarConsulta() {
        lista = UsuarioControlador.BuscarUsuarios();
        for(Usuario nuevo : lista){
                
                String[] rowData = new String[3];
                rowData[0] = String.valueOf(nuevo.getIdusuario());
                rowData[1] = nuevo.getNombre();
                rowData[2] = String.valueOf(nuevo.getRol());
                
                tabla.addRow(rowData);
            }
        jTableUsuarios.setModel(tabla);
    }
    
    private void ocultarFrame() {
        this.setVisible(false);
    }
    
}

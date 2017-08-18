
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysPantallaAuxiliares.ObtenerPaciente;
import OdontoSysControlador.FacturaControlador;
import OdontoSysControlador.NotaControlador;
import OdontoSysControlador.PacienteControlador;
import OdontoSysControlador.ReciboControlador;
import OdontoSysModelo.Factura;
import OdontoSysModelo.NotaCredito;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Recibo;
import OdontoSysModelo.Usuario;
import OdontoSysPantallaAuxiliares.obtenerFechas;
import OdontoSysUtil.Configuraciones;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class EstadoDeCuentaPaciente extends javax.swing.JFrame {

    /**
     * Creates new form EstadoDeCuenta
     */
    public EstadoDeCuentaPaciente() {
        initComponents();
        
        if(idPaciente > 0){
            jButtonBuscarPaciente.setVisible(false);
            setearDatos();
            crearTabla();
        }else{
            jButtonRealizarPago.setVisible(false);
            jButtonVolver.setText("Volver a Menú Principal");
            crearTabla();
            jButtonGenerarReporte.setVisible(false);
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
        jTextFieldPaciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstadoCuenta = new javax.swing.JTable();
        jButtonVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldSaldo = new javax.swing.JFormattedTextField();
        jButtonRealizarPago = new javax.swing.JButton();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jButtonGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Estado de Cuenta");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Paciente:");

        jTextFieldPaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTableEstadoCuenta.setModel(tabla);
        jTableEstadoCuenta.setEnabled(false);
        jScrollPane1.setViewportView(jTableEstadoCuenta);

        jButtonVolver.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Saldo:");

        jFormattedTextFieldSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        jFormattedTextFieldSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldSaldoActionPerformed(evt);
            }
        });

        jButtonRealizarPago.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonRealizarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/dinero.png"))); // NOI18N
        jButtonRealizarPago.setText("Realizar un Pago");
        jButtonRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarPagoActionPerformed(evt);
            }
        });

        jButtonBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPacienteActionPerformed(evt);
            }
        });

        jButtonGenerarReporte.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/hoja.png"))); // NOI18N
        jButtonGenerarReporte.setText("Generar Reporte");
        jButtonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscarPaciente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonRealizarPago)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGenerarReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVolver))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jFormattedTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(253, 253, 253))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVolver)
                    .addComponent(jButtonRealizarPago)
                    .addComponent(jButtonGenerarReporte))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        idPaciente = 0;
        limpiar();
        this.setVisible(false);      
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarPagoActionPerformed
        Recibos.pac = pac;
        Recibos.user = user;
        Recibos.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRealizarPagoActionPerformed

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        limpiar();
        ObtenerPaciente jDialog= new ObtenerPaciente(null, true);
        jDialog.setVisible(true);
        pac = jDialog.getReturnStatus();
        if(pac != null){
            String paciente = pac.getNombres() +" "+ pac.getApellidos();
            jTextFieldPaciente.setText(paciente);
            idPaciente = pac.getIdPaciente();
            jButtonGenerarReporte.setVisible(true);
            setearDatos();
        }
        
    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

    private void jFormattedTextFieldSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldSaldoActionPerformed

    private void jButtonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarReporteActionPerformed
        obtenerFechas.llamado = "EstadoCuenta";
        obtenerFechas jFrame = new obtenerFechas(null, true);
        jFrame.setVisible(true);
        
        Date[] fechas = jFrame.getReturnStatus();
        int saldo = PacienteControlador.calcularSaldo(fechas[0], pac.getIdPaciente());
        String reporte="reportes/estado_cuenta_paciente";
        
        int idPaciente = pac.getIdPaciente();
        
        Map parametros = new HashMap();
        parametros.put("id_paciente", idPaciente);
        parametros.put("fecha_ini", fechas[0]);
        parametros.put("fecha_fin", fechas[1]);
        parametros.put("saldo_ini", saldo);
        
        Configuraciones.imprimirReporteHB(reporte, parametros);
    }//GEN-LAST:event_jButtonGenerarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(EstadoDeCuentaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadoDeCuentaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadoDeCuentaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadoDeCuentaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadoDeCuentaPaciente().setVisible(true);
            }
        });
    }
    //Variables Globales
    public static int idPaciente = 0;
    public static Usuario user;
    Paciente pac = null;
    ArrayList<Factura> facturas;
    ArrayList<Recibo> recibos;
    ArrayList<NotaCredito> notas;
    int idFacturaActual;
    DefaultTableModel tabla = new DefaultTableModel();
    int debe = 0;
    int haber = 0;
    int saldo = 0;
    DecimalFormat formateador = new DecimalFormat("###,###");
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonGenerarReporte;
    private javax.swing.JButton jButtonRealizarPago;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstadoCuenta;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables

    private void recuperarFacturas() {
        facturas = new ArrayList();
        facturas = FacturaControlador.ConsultarFactura(idPaciente);
        if(facturas != null){
            for (Factura fila : facturas){
                Object[] f = new Object[4];
                f[0] = formatoFecha.format(fila.getFecha());
                f[1] = "Factura Nro "+fila.getNroFactura();
                f[2] = fila.getMontoTotal();
                f[3] = null;
                tabla.addRow(new Object[]{f[0], f[1], formateador.format(f[2]), null});
                debe = Integer.parseInt(f[2].toString()) + debe;                
                idFacturaActual = fila.getIdfactura();
                recuperarRecibos(idFacturaActual);
                recuperarNotas(idFacturaActual);
            }
            jTableEstadoCuenta.setModel(tabla);
        }else{
            JOptionPane.showMessageDialog(rootPane, "No se encontraron registros pendientes por el paciente", "Consultar Factura", WIDTH);
        }
    }
    
    private void recuperarRecibos(int nro) {
        recibos = new ArrayList();
        recibos = ReciboControlador.ConsultarRecibo(nro);
        if(recibos != null){
            for (Recibo r : recibos){
                tabla.addRow(new Object[]{formatoFecha.format(r.getFecha()), "Recibo por Factura Nro "+ nro, null, formateador.format(r.getMonto())});
                haber = r.getMonto() + haber;
            }
        jTableEstadoCuenta.setModel(tabla);
        }   
    }

    private void setearDatos() {
        pac = PacienteControlador.BuscarID(idPaciente);
        jTextFieldPaciente.setText(pac.getNombres() + " " + pac.getApellidos());
        recuperarFacturas();
        saldo = saldo + debe - haber;
        jFormattedTextFieldSaldo.setText(String.valueOf(formateador.format(saldo)));
        jButtonRealizarPago.setVisible(true);
        if(saldo == 0){
            jButtonRealizarPago.setVisible(false);
        }else{
            jButtonRealizarPago.setVisible(true);
        }
    }

    private void crearTabla() {
        tabla.addColumn("Fecha");
        tabla.addColumn("Descripción");
        tabla.addColumn("Debe");
        tabla.addColumn("Haber");
        jTableEstadoCuenta.setModel(tabla);
    }

    private void limpiar() {
        jTextFieldPaciente.setText("");
        jFormattedTextFieldSaldo.setText("");
        saldo = 0;
        debe = 0;
        haber = 0;
        if(tabla.getRowCount() > 0){
            int a = tabla.getRowCount() - 1;
            int y;
            for(y=a; y>=0; y--){
                tabla.removeRow(y);
            }
            jTableEstadoCuenta.setModel(tabla);
        }
    }

    private void recuperarNotas(int idfactura) {        
        notas = new ArrayList();
        notas = NotaControlador.ConsultarNotas(idfactura);
        if(notas != null){
            for(NotaCredito n : notas){
                Object[] f = new Object[4];
                f[0] = formatoFecha.format(n.getFecha());
                f[1] = "Nota Credito Cod "+n.getIdnotaCredito();
                f[2] = null;
                f[3] = n.getTotal();
                tabla.addRow(new Object[]{f[0], f[1], null, formateador.format(f[3])});
                haber = n.getTotal() + haber;
            }
        }
    }

}

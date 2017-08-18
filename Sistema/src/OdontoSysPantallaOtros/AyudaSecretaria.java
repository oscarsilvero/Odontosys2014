/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontosysPantallaOtros;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 *
 * @author user
 */
public class AyudaSecretaria extends javax.swing.JDialog {
    private String DatosPersonales = "El botón Pacientes abre una ventana genérica de pacientes. Con un clic en el"
                                    +"botón Buscar Paciente, solicita el número de cédula del mismo. Con esta consulta"            
                                    +"se obtienen los datos personales del paciente, teléfonos, email y dirección,"
                                    +"como también se recuperan el estado de cuenta, los convenios y las citas asociadas"
                                    +"al paciente. Una vez recuperado el paciente, el sistema habilita el botón Modificar"
                                    +"y Eliminar. El borrado es lógico,el paciente no se visualizará en consultas, pero "
                                    +"quedarán sus transacciones en el sistema (facturas, recibos, notas, etc).\n"
                                    +"El botón Insertar Paciente habilita los campos para el registro de un nuevo paciente.";
    
    private String Convenios =       "Con la consulta hecha del paciente, aquí se listan todas las empresas con las "
                                    +"que el paciente tiene un convenio. (Un paciente puede estar asociado a más de una "
                                    +"empresa). Con un click sobre una de las empresas obtenidas, se podrá visualizar el"
                                    +"registro del convenio con los porcentajes que cubre la empresa para cada servicio, "
                                    +"permitiendo también la modificación o la eliminación del convenio.\n"            
                                    +"El botón Insertar Convenio abre una ventana para el registro de un nuevo convenio "
                                    +"entre una Empresa y el paciente de la consulta actual, en todos los servicios que se "
                                    +"ofrecen a la fecha (Servicios con estado 'Activo'). Por cada servicio, se permite un"
                                    +"ingreso numérico que representa el porcentaje que la empresa cubrirá sobre el monto"
                                    +"total del servicio, por defecto es 0 (cero)."  ;
    
    private String FacturacionOrdenP ="A partir de una consulta hecha, si el paciente posee por lo menos una Orden de"
                                     +"Servicio pendiente de facturar, se podrá visualizar el botón Orden de Servicio"
                                     +"Pendiente. Este botón despliega una lista de las órdenes pendientes (con estado "
                                     +"'Pendiente'), y con un click sobre una de ellas, se abre la Orden, mostrando los datos"
                                     +"asociados a la misma y el monto total, sobre el cual se generará la factura.\n"
                                     +"Para generar la factura, dar un click sobre el botón Facturar, abriéndose así el "
                                     +"modelo de la factura, con casi todos los datos cargados, quedando por cargar el Timbrado"
                                     +" y el número de factura.\n"
                                     +"Si el paciente posee algún convenio que cubra el/los servicios que se facturan, el"
                                     +"sistema calcula el porcentaje de descuento a aplicarse sobre cada servicio en la "
                                     +"factura.\n"
                                     +"Una vez guardada la factura, se crean registros del porcentaje a descontarse por"
                                     +"empresa por servicio, con estado 'Pendiente' y se cambia el estado de la Orden de "
                                     +"Servicio a 'Facturada'.\n"
                                     +"La Factura puede ser de Tipo 'Contado' o 'Crédito'. En el primer caso, su estado es"
                                     +"'Cancelado' y su saldo es 0 (cero). En el segundo caso, el estado es 'Pendiente' y su"
                                     +"saldo es igual al total que se le cobra al paciente.";
    
    private String HistoricoAgenda = "A partir de la consulta de un paciente, se obtiene el histórico de citas del "
                                    +"mismo, con informaciones de cada cita agendada, a modo de histórico.";
    
    private String Agenda = "La consulta obtiene una lista de las citas con estado 'Pendiente'. Al insertar se"
                                     +"registra una cita con fecha a partir de hoy y se asocia a un paciente, un Doctor y"
                                     +"un Servicio. Un paciente no puede tener dos citas el mismo día, y un doctor no puede"
                                     +"tener dos citas a la misma hora. Las horas son validadas entre las 07:00 y las 20:00 hs.";
    
    private String EstadoCuenta =     "Con la consulta hecha del paciente, el sistema lista por orden de ingreso, todas"
                                    +"las facturas con estado 'Pendiente', los recibos y las notas asociadas a la misma. \n"
                                    +"Al pie de la tabla, se visualiza el total del saldo deudor del paciente.";
    
    private String Recibo =           "A partir de una consulta hecha, si el paciente posee saldo deudor mayor a 0, el"
                                     +"sistema habilita el botón Realizar un Pago, el cual abre una ventana que permite la"
                                     +"carga de un recibo. Éste debe estar asociado a una factura, la cual se escoge a través"
                                     +"del botón situado al lado del campo Factura. Aquí se despliegan todas las facturas del"            
                                     +"paciente con saldo mayor a 0 (cero).\n"                        
                                     +"El recibo puede tener más de una forma de pago. Estos montos se cargan con el botón "
                                     +"Añadir Forma de Pago, el cual solicitará escoger una de las cuatro formas de pago"
                                     +"disponibles (Efectivo, Tarjeta Crédito, Tarjeta Débito, Cheque) y luego solicitará"
                                     +"ingresar el monto. En caso de que se haya ingresado mal el monto o la forma de pago,"
                                     +"con un click sobre la fila que contiene el error, se habilitará un botón que permite"
                                     +"la eliminación de la fila seleccionada.\n"
                                     +"El monto total del recibo no puede exceder al saldo de la factura asociada. Al guardar"
                                     +"el recibo, se descuenta el saldo de dicha factura asociada, y si este saldo queda 0"
                                     +"(cero), el estado de la factura asociada cambia a 'Cancelado'.";
   
    private String NotaCredito =  "A partir de una consulta hecha, se habilita el botón Preparar Nota de Crédito, el cual"
                                     +"registra una nota de crédito hecha a un paciente asociada a una factura. Ésta factura"
                                     +"se escoge con un click en el botón situado al lado del campo Factura. Aquí se despliegan"
                                     +"todas las facturas del paciente. En caso que la factura asociada sea de tipo 'Crédito',"
                                     +"al guardar la nota se descuenta el saldo de la misma, y si dicho saldo queda 0 (cero),"
                                     +"el estado de la factura asociada cambia a 'Cancelado'.  El monto total de la nota no"
                                     +"puede exceder al saldo de la factura asociada.\n"
                                     +"Se debe ingresar el motivo de la nota, para lo cual, con un click sobre el botón Ingresar"
                                     +"Motivo, se solicita este motivo, y luego el monto que corresponde. En caso de que se haya"
                                     +"ingresado mal el monto o el motivo, con un click sobre la fila que contiene el error, se"
                                     +"habilitará un botón que permite la eliminación de la fila seleccionada.";
    
    private String Datos =        "El botón Empresas abre una ventana genérica de empresas. Con un clic en el botón Buscar"
                                    +"Empresa, se despliega una ventana con todas las empresas registradas. Con esta consulta"
                                    +"se obtienen los datos de la empresa, teléfonos, email y dirección, además del nombre y"
                                    +"teléfono de un contacto de la empresa. La consulta también recupera el estado de cuenta,"
                                    +"los convenios y los pendientes de facturar a la empresa. Una vez recuperado la empresa,"
                                    +"el sistema habilita el botón Modificar y Eliminar. El borrado es lógico, la empresa no "
                                    +"se visualizará en consultas, pero quedarán sus transacciones en el sistema (facturas,"
                                    +"recibos, notas, etc).\n"
                                    +"El botón Insertar habilita los campos para el registro de una nueva empresa.";

    private String ConsultaConvenios ="Con la consulta hecha de la empresa, el sistema despliega a todos los pacientes "
                                     +"asociados a la empresa. Con un click sobre uno de los pacientes obtenidos, se podrá"
                                     +"visualizar el registro del convenio con los porcentajes que cubre la empresa para cada "
                                     +"servicio, permitiendo también la modificación o la eliminación del convenio.";
    
    private String FacturarPendiente ="Con la consulta hecha de la empresa, el sistema despliega los registros con estado "
                                     +"'Pendiente' que se han generado al facturar a un paciente asociado a la empresa.\n"
                                     +"Con un click en el botón Facturar, se generará una factura con todos estos registros"
                                     +"pendientes, quedando por ingresar el timbrado y el número de factura.\n"
                                     +"La Factura puede de ser de tipo Contado o Crédito.";
    
    private String EstadoCuente = "Lista por orden de ingreso, las facturas con estado 'Pendiente', los recibos"
            +                     "y las notas asociadas a la misma. Al final, el saldo deudor de la empresa."; 
    
    private String Factura =  "Obtiene todos los registros con estado 'Pendiente' hasta la fecha, y genera una"
                             +"factura con los mismos. Al guardar dicha factura, los registros pasan a estado"
                             +"'Facturado'. La Factura puede ser de Tipo 'Contado' o 'Crédito'. En el primer caso,"
                             +"su estado es 'Cancelado' y su saldo es 0 (cero). En el segundo caso, el estado es"
                             +"'Pendiente' y su saldo es igual al total que se le cobra a la empresa."; 
    
    private String ReciboE =  "Registra el ingreso de dinero de una empresa en pago a una factura asociada. Puede"
                             +"tener más de una forma de pago. El monto total del recibo no puede exceder al saldo"
                             +"de la factura asociada. Al guardar el recibo, se descuenta el saldo de la factura"
                             +"asociada, y si dicho saldo queda 0 (cero), el estado de la factura asociada cambia a"
                             +"'Cancelado'.";
    
    private String NotaCreditoE = "Registra una nota de crédito hecha a una empresa asociada a una factura. En caso que"
                             +"la factura asociada sea de tipo 'Crédito', al guardar la nota se descuenta el saldo de"
                             +"la misma, y si dicho saldo queda 0 (cero), el estado de la factura asociada cambia a"
                             +"'Cancelado'.  El monto total de la nota no puede exceder al saldo de la factura asociada.";   
    
    private String ReporteEstado = "A partir de una consulta hecha, en la sección Estado de Cuenta, se habilita también un "
            + "botón Generar Reporte, cuya finalidad es listar todos los movimientos que afecten el estado de cuenta del "
            + "paciente en un determinado rago de fechas.\n"
            + "Con un click sobre este botón se solicitará el rango de fechas";
    
    
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form AyudaSecretaria
     * @param parent el padre
     * @param modal si es modal o no
     */
    public AyudaSecretaria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        
        
        jTextAreaDoctor.setLineWrap(true);
        jTextAreaDoctor.setWrapStyleWord(true);
        
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPaneRolSecretaria = new javax.swing.JTabbedPane();
        jPanelPaciente = new javax.swing.JPanel();
        jComboBoxPaciente = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanelDoctor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDoctor = new javax.swing.JTextArea();
        jPanelEmpresa = new javax.swing.JPanel();
        jComboBoxEmpresa = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanelAgenda = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDoctor1 = new javax.swing.JTextArea();
        jPanelReporte = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaDoctor2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ayuda Secretaria");
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Accesos segun el Rol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jTabbedPaneRolSecretaria.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanelPaciente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jComboBoxPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Datos Personales", "Estado de Cuenta", "Convenios", "Agenda", "Facturacion de Orden Pendiente", "Recibo", "Nota de Credito", "Reporte de Estado de Cuenta" }));
        jComboBoxPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPacienteItemStateChanged(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText(DatosPersonales);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanelPacienteLayout = new javax.swing.GroupLayout(jPanelPaciente);
        jPanelPaciente.setLayout(jPanelPacienteLayout);
        jPanelPacienteLayout.setHorizontalGroup(
            jPanelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPacienteLayout.setVerticalGroup(
            jPanelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneRolSecretaria.addTab("Paciente", new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/persona.png")), jPanelPaciente); // NOI18N

        jPanelDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextAreaDoctor.setEditable(false);
        jTextAreaDoctor.setBackground(new java.awt.Color(204, 204, 255));
        jTextAreaDoctor.setColumns(20);
        jTextAreaDoctor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextAreaDoctor.setRows(5);
        jTextAreaDoctor.setText("El botón Doctores del menú Inicio abre la ventana genérica de doctores. La consulta se realiza a través del botón Consultar Doctor, el cual solicita el número de cédula del mismo. Esta consulta obtiene todos los datos del doctor, y habilita los botones Modificar y Eliminar. El borrado es lógico, el doctor no se visualizará en consultas, pero quedarán sus transacciones en el sistema (citas, odontogramas, diagnósticos realizados). Para que el doctor pueda registrarse como usuario del sistema, debe estar previamente registrado. El botón Ingresar Doctor habilita los campos para la carga de sus datos.");
        jScrollPane2.setViewportView(jTextAreaDoctor);

        javax.swing.GroupLayout jPanelDoctorLayout = new javax.swing.GroupLayout(jPanelDoctor);
        jPanelDoctor.setLayout(jPanelDoctorLayout);
        jPanelDoctorLayout.setHorizontalGroup(
            jPanelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDoctorLayout.setVerticalGroup(
            jPanelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoctorLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jTabbedPaneRolSecretaria.addTab("Doctor", new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/doctor.png")), jPanelDoctor); // NOI18N

        jPanelEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jComboBoxEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Datos", "Pendientes de Facturar; Consulta Convenios", "Estado de Cuenta", "Factura", "Recibo", "Nota de Credito" }));
        jComboBoxEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEmpresaItemStateChanged(evt);
            }
        });

        jTextArea3.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText(Datos);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanelEmpresaLayout = new javax.swing.GroupLayout(jPanelEmpresa);
        jPanelEmpresa.setLayout(jPanelEmpresaLayout);
        jPanelEmpresaLayout.setHorizontalGroup(
            jPanelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(jPanelEmpresaLayout.createSequentialGroup()
                        .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelEmpresaLayout.setVerticalGroup(
            jPanelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneRolSecretaria.addTab("Empresa", new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/grafico.png")), jPanelEmpresa); // NOI18N

        jTextAreaDoctor1.setEditable(false);
        jTextAreaDoctor1.setBackground(new java.awt.Color(204, 204, 255));
        jTextAreaDoctor1.setColumns(20);
        jTextAreaDoctor1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextAreaDoctor1.setRows(5);
        jTextAreaDoctor1.setText("El botón Agenda del menú Inicio abre una ventana que lista todas las citas programadas pendientes para el mes actual.  En caso que se necesite buscar una cita de otro mes, basta cambiar este dato en la parte superior de la ventana y dar un click al botón buscar. Con un click sobre el cualquier registro obtenido, se podrá visualizar el detalle de la cita, permitiendo modificar la misma o eliminarla. El botón Insertar Cita permite registrar una nueva cita. Debe escogerse una fecha (no anterior a la fecha actual), una hora (entre las 07:00 y las 20:00 hs), un Paciente (con un click sobre el botón Buscar al costado del campo Paciente, se recuperan los pacientes activos, escoger uno), un Motivo (con un click sobre el botón Buscar al costado del campo Motivo se recuperan los servicios activos, escoger uno), y un Doctor (con un click sobre el botón Buscar al costado del campo Doctor se recuperan los doctores activos, escoger uno). La cita se inserta por defecto con estado 'Pendiente'. Los estados posibles son 'Pendiente', 'Realizado' y 'Cancelado'.");
        jScrollPane4.setViewportView(jTextAreaDoctor1);

        javax.swing.GroupLayout jPanelAgendaLayout = new javax.swing.GroupLayout(jPanelAgenda);
        jPanelAgenda.setLayout(jPanelAgendaLayout);
        jPanelAgendaLayout.setHorizontalGroup(
            jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAgendaLayout.setVerticalGroup(
            jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jTabbedPaneRolSecretaria.addTab("Agenda", new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agenda.png")), jPanelAgenda); // NOI18N

        jTextAreaDoctor2.setEditable(false);
        jTextAreaDoctor2.setBackground(new java.awt.Color(204, 204, 255));
        jTextAreaDoctor2.setColumns(20);
        jTextAreaDoctor2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextAreaDoctor2.setRows(5);
        jTextAreaDoctor2.setText("El botón Reporte de Servicios del menú Inicio tiene como finalidad listar todos los servicios realizados en un mes determinado, haciendo una sumatoria de la cantidad de servicios hechos por día durante el mes elegido. Con un click sobre este botón, se abrirá una ventana que solicita el ingreso de una fecha, de la cual se obtiene el mes que el reporte tomará como base.");
        jScrollPane5.setViewportView(jTextAreaDoctor2);

        javax.swing.GroupLayout jPanelReporteLayout = new javax.swing.GroupLayout(jPanelReporte);
        jPanelReporte.setLayout(jPanelReporteLayout);
        jPanelReporteLayout.setHorizontalGroup(
            jPanelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelReporteLayout.setVerticalGroup(
            jPanelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReporteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jTabbedPaneRolSecretaria.addTab("Reporte", new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/orden.png")), jPanelReporte); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPaneRolSecretaria)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneRolSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jComboBoxPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPacienteItemStateChanged
        // TODO add your handling code here:
        int seleccion = jComboBoxPaciente.getSelectedIndex();
        
        switch(seleccion){
            case 0:
                jTextArea1.setText(DatosPersonales);
            break;
            case 1:
                jTextArea1.setText(EstadoCuenta);
            break;
            case 2:
                jTextArea1.setText(Convenios);
            break;
            case 3:
                jTextArea1.setText(HistoricoAgenda);
            break;
            case 4:
                jTextArea1.setText(FacturacionOrdenP);
            break;
            case 5:
                jTextArea1.setText(Recibo);
            break;    
            case 6:
                jTextArea1.setText(NotaCredito);
            break;   
            case 7:
                jTextArea1.setText(ReporteEstado);
            break; 
        
        }     
        
    }//GEN-LAST:event_jComboBoxPacienteItemStateChanged

    private void jComboBoxEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEmpresaItemStateChanged
        // TODO add your handling code here:
        int index = jComboBoxEmpresa.getSelectedIndex();
        switch(index){
            case 0:
                jTextArea3.setText(Datos);
            break;
            case 1:
                jTextArea3.setText(FacturarPendiente);
            break;
            case 2:
                jTextArea3.setText(ConsultaConvenios);
            break;
            case 3:
                jTextArea3.setText(EstadoCuente);
            break;
            case 4:
                jTextArea3.setText(Factura);
            break;
            case 5:
                jTextArea3.setText(ReciboE);
            break;    
            case 6:
                jTextArea3.setText(NotaCreditoE);
            break;   
        }
    }//GEN-LAST:event_jComboBoxEmpresaItemStateChanged
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(AyudaSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AyudaSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AyudaSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AyudaSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AyudaSecretaria dialog = new AyudaSecretaria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxEmpresa;
    private javax.swing.JComboBox jComboBoxPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAgenda;
    private javax.swing.JPanel jPanelDoctor;
    private javax.swing.JPanel jPanelEmpresa;
    private javax.swing.JPanel jPanelPaciente;
    private javax.swing.JPanel jPanelReporte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneRolSecretaria;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextAreaDoctor;
    private javax.swing.JTextArea jTextAreaDoctor1;
    private javax.swing.JTextArea jTextAreaDoctor2;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
    
}

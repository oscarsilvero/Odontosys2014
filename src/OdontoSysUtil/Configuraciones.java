/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysUtil;

import java.io.File;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tito
 */
public class Configuraciones {
    
     public static DefaultTableModel limpiarModelo(DefaultTableModel modelo) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        return modelo;
    }

    public static void imprimirReporteHB(String reporte, Map parametros) {
        
        String reporteJr  = reporte+".jasper";
        String reportePdf = reporte+".pdf"; 
        
        try {
            File f = new File(reporteJr);
            Conexion.conectar();
            JasperReport jr = (JasperReport)JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporteJr, parametros, Conexion.getCon());
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(reportePdf));
            exporter.exportReport();
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }         
}

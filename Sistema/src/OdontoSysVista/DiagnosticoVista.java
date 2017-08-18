/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.DiagnosticoControlador;
import OdontoSysModelo.Diagnostico;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DiagnosticoVista {
    
    public static int InsertarNuevo (Diagnostico nuevo) {
        int f = nuevo.getFecha().compareTo(new Date());
        int e = nuevo.getEmpresa().trim().compareTo("");
        int h = nuevo.getResumenHallazgos().trim().compareTo("");
        int t = nuevo.getPlanTratamiento().trim().compareTo("");
        
        if((nuevo.getTipo() == "Externo") && (e == 0)){     //Si empresa está vacío siendo tipo Externo
            JOptionPane.showMessageDialog(null,"Favor ingrese la empresa que realizó el diagnóstico", "Validar Diagnóstico", WIDTH );
            return -1;
        }
        if(nuevo.getTipo() == "Interno" && nuevo.getOdontograma() == null){   //Si odontograma está vacío siendo Interno
            JOptionPane.showMessageDialog(null,"Favor ingrese un odontograma", "Validar Diagnóstico", WIDTH );
            return -1;
        }
        if(f<=0){
            if(h != 0 && t != 0){
                return DiagnosticoControlador.insertarDiagnostico(nuevo);
            }else{
                JOptionPane.showMessageDialog(null,"Favor complete todos los campos obligatorios", "Validar Diagnóstico", WIDTH );
                return -1;
            }
        }else{
            JOptionPane.showMessageDialog(null,"No puede ingresar fechas posteriores a hoy", "Validar Diagnóstico", WIDTH );
            return -1;
        }        
    }
    
}

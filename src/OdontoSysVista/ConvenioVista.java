/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Convenio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class ConvenioVista {
    
    public static boolean validarConvenio(ArrayList<Convenio> c){
        for(Convenio conv : c){
            if((conv.getEmpresa()== null) || (conv.getPaciente() == null) || (String.valueOf(conv.getServicio()) == null)){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos");
                return false;
            }
            
            if(conv.getPorcentaje()<0 || conv.getPorcentaje() > 100){
                JOptionPane.showMessageDialog(null, "El porcentaje debe estar entre 0 y 100");
                return false;
            }
            
            int emp = conv.getEmpresa().getNombre().trim().compareTo("");//n == 0 si existe cadena vacía
            int ser = conv.getServicio().getIdservicio();
            int pac = conv.getPaciente().getNroCi();
        
            if(emp!=0 && ser>0 && pac>0 ){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos");
                return false;
            } 
        }
        return true;
    }
    
}

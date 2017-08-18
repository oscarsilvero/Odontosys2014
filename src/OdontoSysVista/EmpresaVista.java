/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Empresa;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class EmpresaVista {
    
    public static boolean validarEmpresa(Empresa empresa){
        if((empresa.getDireccion() == null) || (empresa.getNombre() == null) || (empresa.getNombreContacto() == null) || (String.valueOf(empresa.getRuc()) == null) || (empresa.getTelefono() == null)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos");
            return false;
        }
        int nom = empresa.getNombre().trim().compareTo("");//n == 0 si existe cadena vacìa en nombre *
        int ruc = empresa.getRuc();//igual a * para apellido
        int tel = empresa.getTelefono().trim().compareTo("");
        int dir = empresa.getDireccion().trim().compareTo(""); 
        int ncon = empresa.getNombreContacto().trim().compareTo("");
        
        if(nom!=0 && ruc>0 && tel!=0 && dir!=0 && ncon!=0){
            return true;
        }else{
            return false;
        } 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Factura;
import OdontoSysModelo.FacturaEmpresa;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class FacturaVista {
    
    public static boolean validarFactura (Factura factura){
        
        if((String.valueOf(factura.getNroFactura()) == null) || (String.valueOf(factura.getTimbrado()) == null)){
            JOptionPane.showMessageDialog(null, "favor complete todos los campos ");
            return true;
        }else{        
            return false;
        }
    }
    
        public static int validarFacturaEmpresa (FacturaEmpresa factura){
        String tim = factura.getTimbrado();
        String nro = factura.getNroFactura();
        if((String.valueOf(tim) == null) || (String.valueOf(nro) == null)){
            JOptionPane.showMessageDialog(null, "favor complete todos los campos ");
            return -1;
        }else{        
            return 0;
        }
    }

        
}

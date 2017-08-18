/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.ServicioControlador;
import OdontoSysModelo.Servicio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tito
 */
public class ServicioVista {

    
    public static ArrayList<Servicio> BuscarServicio(String descripcion) {
        ArrayList<Servicio> lisServicio;     
        lisServicio = ServicioControlador.BuscarPorNombre(descripcion);
        
        return lisServicio;  
    }
    
    public static boolean validarServicio(Servicio serv){
        if((serv.getDescripcion() == null) || (String.valueOf(serv.getPrecio()) == null)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos");
            return false;
        }
        int desc = serv.getDescripcion().trim().compareTo("");//n == 0 si existe cadena vacía
        int prec = serv.getPrecio();
        
        if(desc!=0 && prec>0){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos");
            return false;
        } 
    }
    
}

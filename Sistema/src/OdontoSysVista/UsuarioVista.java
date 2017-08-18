/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.UsuarioControlador;
import OdontoSysModelo.Usuario;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class UsuarioVista {
    
    public static int InsertarUsuario(Usuario nuevo) {
        String r = nuevo.getRol();
        int n = nuevo.getNombre().trim().compareTo("");
        int c = nuevo.getPassw().trim().compareTo(""); 
        
        if(r == "Doctor" && nuevo.getDoctor().getIdDoctor() == null){
            JOptionPane.showMessageDialog(null, "Favor ingrese un Doctor", "Validación de Usuario", WIDTH);
            return -1;
        }    
        if(n!=0 && c!=0){
                return UsuarioControlador.InsertarUsuario(nuevo);
        }else{
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de Usuario", WIDTH);
            return -1;
        }    
    }
      
    
}

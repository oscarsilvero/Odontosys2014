/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.PacienteControlador;
import OdontoSysModelo.Paciente;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PacienteVista {

    /**
     *
     * @param nrocedula
     * @return paciente
     */
    public static Paciente BuscarCedula(String nrocedula){
        
        
        //uso Trim() para borrar espacios en blanco inicial y final
       // String numeroString = jTextFieldCedula.getText();
        nrocedula = nrocedula.trim();
        //si esta vacio el NumeroString
        if(nrocedula.isEmpty()){
            //proceso cadena vacia
            System.out.println("escriibi algo");
            return null;
        }
         
        int cedula = Integer.parseInt(nrocedula);
        Paciente paciente = PacienteControlador.BuscarCedula(cedula);
        
        
        return paciente;
    }

    public static int insertarPaciente(Paciente nuevoPaciente) {
        int n = nuevoPaciente.getNombres().trim().compareTo("");//n == 0 si existe cadena en nombre *
        int a = nuevoPaciente.getApellidos().trim().compareTo("");//igual a * para apellido
        int f = nuevoPaciente.getFechaNac().compareTo(new Date());
        int s = (nuevoPaciente.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (nuevoPaciente.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int d = nuevoPaciente.getDireccion().trim().compareTo("");
        int c = nuevoPaciente.getCiudad().trim().compareTo("");
        int lb = nuevoPaciente.getTelCel().trim().compareTo("");
        int cel = nuevoPaciente.getTelCel().trim().compareTo("");
        
        if(n!=0 && a!=0 && f<0 && s == 0 && d!=0 && c!=0 && lb!=0 && cel!=0){
            return PacienteControlador.insertarPaciente(nuevoPaciente);
        }else{
            return -1;
        }               
    }

    public static int UpDatePaciente(Paciente nuevoPaciente) {
        int n = nuevoPaciente.getNombres().trim().compareTo("");
        int a = nuevoPaciente.getApellidos().trim().compareTo("");
        int f = nuevoPaciente.getFechaNac().compareTo(new Date());
        int s = (nuevoPaciente.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (nuevoPaciente.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int d = nuevoPaciente.getDireccion().trim().compareTo("");
        int c = nuevoPaciente.getCiudad().trim().compareTo("");
        int lb = nuevoPaciente.getTelCel().trim().compareTo("");
        int cel = nuevoPaciente.getTelCel().trim().compareTo("");
        
        if(n!=0 && a!=0 && f<0 && s == 0 && d!=0 && c!=0 && lb!=0 && cel!=0){
            return PacienteControlador.UpDatePaciente(nuevoPaciente);
        }else{
            return -1;
        }
    }    
    
    public static int UpDateHojaClinica(Paciente nuevoPaciente) {
        int p = nuevoPaciente.getPeso();
        int e = nuevoPaciente.getEnfermedades().trim().compareTo("");
        int m = nuevoPaciente.getMedicamentos().compareTo("");
        int a = nuevoPaciente.getAlergias().compareTo(""); 
        int c = nuevoPaciente.getCirugias().trim().compareTo("");
        
        if(p > 0){
            if(e!=0 && m!=0 && a!=0 && c!=0){
                return PacienteControlador.UpDatePaciente(nuevoPaciente);
            }else{
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Paciente", WIDTH);
                return -1;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Peso debe ser mayor a 0", "Validación de datos Paciente", WIDTH);
            return -1;
        }        
    }    
    
}

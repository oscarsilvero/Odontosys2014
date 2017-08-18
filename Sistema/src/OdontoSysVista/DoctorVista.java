/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Doctor;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DoctorVista {
    public static int validarDoctor(Doctor doctor) {
        if((doctor.getNombre() == null) || (doctor.getApellido()) == null || (String.valueOf(doctor.getNroCi()) == null) || (doctor.getSexo() == null) || (doctor.getFechaNac() == null) || (doctor.getTeLb() == null) || (doctor.getTelCel() == null) || (doctor.getDireccion() == null) || (doctor.getCiudad() == null) || (doctor.getEmail() == null) || (doctor.getRegProf() == null)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Doctor", WIDTH);
            return -1;
        }
        int nom = doctor.getNombre().trim().compareTo("");//n == 0 si existe cadena en nombre *
        int ape = doctor.getApellido().trim().compareTo("");//igual a * para apellido
        int ci = doctor.getNroCi();
        int s = (doctor.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (doctor.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int tel = doctor.getTeLb().trim().compareTo("");
        int cel = doctor.getTelCel().trim().compareTo("");
        int dir = doctor.getDireccion().trim().compareTo("");
        int ciud = doctor.getCiudad().trim().compareTo("");
        int email = doctor.getEmail().trim().compareTo("");
        int reg = doctor.getRegProf().trim().compareTo("");
        
        if(nom!=0 && ape!=0 && ci>0 && s == 0 && tel!=0 && cel!=0 && dir!=0 && ciud!=0 && email!=0 && reg!=0){
            Date hoy = new Date();
            if(doctor.getFechaNac().before(hoy)){              // Fecha es antes de hoy
                return 0;
            }else{
                JOptionPane.showMessageDialog(null, "Fecha de Nacimiento debe ser antes de hoy", "Validación de datos Doctor", WIDTH);
                return -1;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Doctor", WIDTH);
            return -1;
        }               
    }
}

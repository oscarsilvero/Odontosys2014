/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.AgendaControlador;
import OdontoSysModelo.Agenda;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AgendaVista {
    public static int validarAgenda (Agenda agenda){
        //Validar fecha     
        int fecha;
        int hora;
        if(agenda.getFecha() == null){
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha");
            return -1;
        }else{
            
        Date fhoy = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = f.format(fhoy);        
        String fec = f.format(agenda.getFecha());
        Date comp = new Date();
        try{
            comp = f.parse(fec);
            fhoy = f.parse(hoy);
        }catch(Exception e){
            System.out.println("Ex "+e.getMessage());
        }
        
        
        
            if(comp.before(fhoy) == true){                                          //La fecha es anterior a Hoy
                    JOptionPane.showMessageDialog(null, "No puede ingresar fechas anteriores a hoy");
                    return -1;
            }else{
                if(agenda.getHora().replace(":", "").trim().compareTo("") == 0){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una hora");
                    return -1;
                }else{
                    hora= Integer.parseInt(agenda.getHora().replace(":", "")); 
                    if(hora < 700 || hora > 2000){                   //La hora no está en el rango de 07:00 y 20:00 hs
                        JOptionPane.showMessageDialog(null, "hora debe estar en el rango de 07:00 y 20:00 hs");
                        return -1;
                    }else{ 
                        String pac = agenda.getPaciente().getNombres();
                        if(pac == null){
                            JOptionPane.showMessageDialog(null, "Favor seleccione un paciente");
                            return -1;
                        }else{
                            int mot = agenda.getServicio().getDescripcion().trim().compareTo("");
                            if(mot == 0){
                                JOptionPane.showMessageDialog(null, "Favor seleccione un motivo de consulta");
                                return -1;
                            }else {
                                String doc = agenda.getDoctor().getApellido();
                                if(doc == null){
                                    JOptionPane.showMessageDialog(null, "Favor seleccione un doctor");
                                    return -1;
                                }else{
                                    int disp = AgendaControlador.ExisteDisp(agenda.getFecha(), agenda.getDoctor().getIdDoctor(), agenda.getHora());
                                    System.out.println("ExisteDisp: "+disp);
                                    if(disp == 0){
                                        int cita = AgendaControlador.ExisteCita(agenda.getFecha(), agenda.getPaciente().getIdPaciente());
                                        System.out.println("Cita: "+cita);
                                        if(cita == 0){
                                            return 0;
                                        }else{
                                            JOptionPane.showMessageDialog(null, "El Paciente ya posee una cita en la misma fecha");
                                        return -1;
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "El Doctor ya posee una cita a la misma hora");
                                        return -1;
                                    }
                                }
                            }
                        }
                    }
                }
            
                }
            
            }
            
        }
    }



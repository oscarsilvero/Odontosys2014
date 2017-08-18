/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Agenda;
import OdontoSysModelo.Paciente;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class AgendaControlador {
    
    public static ArrayList<Agenda> ConsultarAgenda(int mes, int anho){
        Session sesion;
        Transaction tr = null;
        ArrayList<Agenda> datos = new ArrayList();
        Agenda agenda = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Agenda WHERE MONTH(fecha) = "+mes+" AND YEAR(fecha) = "+anho+ " AND estado = 'Pendiente' ORDER BY fecha ASC";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    agenda = new Agenda();
                    agenda = (Agenda) it.next();
                    datos.add(agenda);
                }while(it.hasNext());
            }else{
               return null;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Agenda Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static Agenda BuscarAgenda(int idAgenda){
        Session sesion;
        Transaction tr = null;
        Agenda a =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();

            String hql = "FROM Agenda A WHERE A.idAgenda = "+String.valueOf(idAgenda);
            Query query = sesion.createQuery(hql); 

            Iterator it = query.iterate();

            if(it.hasNext()){
             a = (Agenda)it.next();
            }else{
               return null;
            }
        }catch(HibernateException ex){
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Agenda Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return a;
    }    

    public static int InsertarCita(Agenda nuevo) {
        int i = 0;
        
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            
            i = (int)sesion.save(nuevo);

            sesion.getTransaction().commit();
        }catch(HibernateException ex){
            
        }
        
        return i;
    }
    
    public static int UpDateAgenda(Agenda agenda) {
       int i = 0;
        try{ 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        i = agenda.getIdAgenda();
        session.merge(agenda);
        tr.commit();      
        session.close();       
        
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "UpDate Agenda", WIDTH );
       }        
       return i; 
    }
    
    public static ArrayList<Agenda> ConsultarAgendaDoctor(String fecha, int idDoctor) {
        ArrayList<Agenda> lista = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM Agenda WHERE fecha = '"+fecha+"' AND doctor = "+idDoctor+" AND estado = 'Pendiente' ORDER BY hora ASC";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    Agenda nuevo = (Agenda) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());       
            }else{
                lista = null;
            }
        } catch (HibernateException ex) {
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Agenda Controlador", WIDTH );
       }        
        return lista;
    }
    
    public static int ExisteDisp(Date fecha, int idDoctor, String hora){
        Session sesion;
        Transaction tr = null;
        int e = -1;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String fec = f.format(fecha);
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Agenda WHERE fecha = '"+fec+"' AND doctor = "+idDoctor+" AND hora = '"+hora+"'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                e = -1;
            }else{
                e = 0;
            }
        }catch(HibernateException ex){
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Agenda Controlador", JOptionPane.INFORMATION_MESSAGE);
        }      
        return e;
    }
    
    public static int ExisteCita(Date fecha, int idPaciente){
        Session sesion;
        Transaction tr = null;
        int e = -1;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String fec = f.format(fecha);
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Agenda WHERE fecha = '"+fec+"' AND paciente = "+idPaciente;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                e = -1;
            }else{
                e = 0;
            }
        }catch(HibernateException ex){
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Agenda Controlador", JOptionPane.INFORMATION_MESSAGE);
        }      
        return e;
    }

    public static ArrayList<Agenda> HistoricoCitasPaciente(Paciente pacienteActual) {
        ArrayList<Agenda> lista = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM Agenda WHERE paciente = "+pacienteActual.getIdPaciente()+" ORDER BY fecha DESC";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    Agenda nuevo = (Agenda) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());       
            }else{
                lista = null;
            }
        } catch (HibernateException ex) {
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Agenda Controlador", WIDTH );
       }        
        return lista;
    }

    public static int CancelarCita(Agenda agenda) {
        try{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hqlUpdate = "UPDATE Agenda SET estado = 'Cancelado' WHERE idAgenda = "+agenda.getIdAgenda();
        Query updatedEntities = session.createQuery( hqlUpdate );
        updatedEntities.executeUpdate();
        tx.commit();
        session.close();        
        } catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No se pudo cancelar la cita", "Agenda Controlador", WIDTH );
            return 1;
        }
        return 0;
    }
}

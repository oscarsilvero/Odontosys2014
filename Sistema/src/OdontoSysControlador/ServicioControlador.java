/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Servicio;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
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
public class ServicioControlador {
    
    public static Servicio BuscarServicio(int idServicio){
        Session sesion;
        Transaction tr = null;
        Servicio s = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();

            String hql = "FROM Servicio WHERE idservicio = "+ idServicio;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();

            if(it.hasNext()) {
                s = (Servicio) it.next();
            }            
        } catch(HibernateException ex){
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
         }
        return s;
    }
    
    public static ArrayList<Servicio> BuscarPorNombre(String descripcion) {
        Session sesion;
        Transaction tr = null;
        Servicio S = null;
        ArrayList lisServicio = new ArrayList();
        
        
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql;
            if(descripcion.compareTo("") == 0){
                hql = "FROM Servicio WHERE estado = 'Activo'"; 
            }else{
                hql = "FROM Servicio where descripcion like '%"+ descripcion.trim() +"%' AND estado = 'Activo'";
            }
            
             
            Query query = sesion.createQuery(hql); 

            Iterator it = query.iterate();

            while(it.hasNext()){
                S = (Servicio)it.next();
                lisServicio.add(S);
            }
            
        }catch(HibernateException ex){
               //JOptionPane.showInputDialog ( null, "ocurrio HibernateException al construir session" , "PacienteControlador" , JOptionPane.INFORMATION_MESSAGE );
               JOptionPane.showMessageDialog(null, "Error al conectarse on Base de Datos", "servicoControlador", JOptionPane.INFORMATION_MESSAGE);
 
        }
        
        return lisServicio;
    }
    
    public static Servicio insertarServicio(Servicio serv) {          
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.getTransaction();
         try{        
                tx.begin();
                session.save(serv);
                session.refresh(serv);
                tx.commit();
        }catch(HibernateException ex){
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
         
         return serv;
    }
    
    public static boolean modificarServicio(Servicio serv) {
        boolean i = false;
        try{ 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();        
        session.merge(serv);
        tr.commit();      
        session.close();       
        i = true;
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Servicio", WIDTH );
       }        
       return i; 
    }
    
    public static int eliminarServicio(Servicio serv) {
        int i = 0;
        try{         
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "UPDATE Servicio SET estado = 'Inactivo'";
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
            tx.commit();
            session.close();
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Servicio", WIDTH );
       }        
       return i; 
    }    
    
}

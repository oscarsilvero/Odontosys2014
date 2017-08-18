package OdontoSysControlador;

import OdontoSysModelo.Doctor;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class DoctorControlador {
    public static Doctor BuscarCedula(String cedula){
        Session sesion;
        Transaction tr = null;
        Doctor d = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Doctor D WHERE D.nroCi = "+cedula+" AND D.estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             d = (Doctor)it.next();
            }else{
               return null;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "DoctorControlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return d;
    }
    
    public static Doctor BuscarID(int idDoctor){
        Session sesion;
        Transaction tr = null;
        Doctor d = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Doctor WHERE idDoctor = "+ idDoctor+" AND estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             d = (Doctor)it.next();
            }else{
               return null;
            }
            sesion.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Doctor Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return d;
    }
    
    public static int insertarDoctor(Doctor nuevoDoctor) {
        int i = 0;
        Session sesion;
        Doctor aux;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            aux = BuscarCedula(String.valueOf(nuevoDoctor.getNroCi()));                    
            if(aux == null){                
                i = (int)sesion.save(nuevoDoctor);
            }else{                
                nuevoDoctor.setIdDoctor(aux.getIdDoctor());
                i = UpDateDoctor(nuevoDoctor);
            } 
            sesion.getTransaction().commit();
        }catch(HibernateException ex){
                    }        
        return i;
    }
    
     public static int UpDateDoctor(Doctor doctorActual) {
       int i = 0;
        try{ 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        i = doctorActual.getIdDoctor();
        session.merge(doctorActual);
        tr.commit();      
        session.close();       
        
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "UpDate Doctor", WIDTH );
       }
        
       return i; 
    }
     
     public static int Eliminar(Doctor doctorActual) {
        int i = 0;
        try{         
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "UPDATE Doctor SET estado = 'Inactivo'";
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
            tx.commit();
            session.close();
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Doctor", WIDTH );
       }        
       return i; 
    }
 
     public static ArrayList<Doctor> ConsultarDoctor(){
        Session sesion;
        Transaction tr = null;
        ArrayList<Doctor> datos = null;
        Doctor doc = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Doctor WHERE estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                datos = new ArrayList();
                do{
                    doc = (Doctor) it.next();
                    datos.add(doc);
                }while(it.hasNext());
            }
                        
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Doctor Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        
        return datos;
    }
     
     public static int BuscarRegistro(String reg){
        Session sesion;
        Transaction tr = null;
        int d = 1;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Doctor WHERE regProf = '"+reg+"'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                d = 0;
            }else{
                d = 1;
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "DoctorControlador", JOptionPane.INFORMATION_MESSAGE);
                   }
         System.out.println("d: "+d);
        return d;
    }
     
}

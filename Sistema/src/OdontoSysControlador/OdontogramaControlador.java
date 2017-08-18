/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.DetalleHallazgo;
import OdontoSysModelo.Hallazgo;
import OdontoSysModelo.Odontograma;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Tratamiento;
import OdontoSysUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tito
 */
public class OdontogramaControlador {
    public static Odontograma insertarOdontograma(Odontograma elOdontograma){
        int idOdontograma = 0;
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();

            idOdontograma = (int)sesion.save(elOdontograma);
            sesion.refresh(elOdontograma);

            sesion.getTransaction().commit();
        }catch(HibernateException ex){
            
        }
        
        return elOdontograma;
    }
    
    public static Odontograma BuscarID(int idOdont){
        Session sesion;
        Transaction tr = null;
        Odontograma o =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Odontograma WHERE idOdontograma = "+ idOdont;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             o = (Odontograma)it.next();
            }else{
               return null;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Odontograma Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return o;
    }

    public static ArrayList<Odontograma> HistoricoPaciente(Paciente pac) {
        Session sesion;
        Transaction tr = null;
        ArrayList<Odontograma> lis = new ArrayList();
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "FROM Odontograma WHERE paciente = "+pac.getIdPaciente();
            
            Query query = sesion.createQuery(hql); 
            Iterator<Odontograma> it = query.iterate();
            if(it.hasNext()){
                while(it.hasNext()){
                    lis.add(it.next());
                }
            }else{
                return null;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Odontograma Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }

    public static ArrayList<DetalleHallazgo> BuscarHallazgos(Odontograma odon) {
        Session sesion;
        Transaction tr = null;
        ArrayList<DetalleHallazgo> det = new ArrayList();
        DetalleHallazgo hal = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM DetalleHallazgo WHERE odontograma = "+odon.getIdodontograma();
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    hal = (DetalleHallazgo) it.next();
                    det.add(hal);
                }while(it.hasNext());
            }else{
               return null;
            }
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Buscar Hallazgos", JOptionPane.INFORMATION_MESSAGE);
        }
        return det;
    }

    public static ArrayList<Tratamiento> BuscarTratamientos(Odontograma odon) {
        Session sesion;
        Transaction tr = null;
        ArrayList<Tratamiento> trat = new ArrayList();
        Tratamiento hal = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Tratamiento WHERE odontograma = "+odon.getIdodontograma();
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    hal = (Tratamiento) it.next();
                    trat.add(hal);
                }while(it.hasNext());
            }else{
               return null;
            }
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Buscar Tratamientos", JOptionPane.INFORMATION_MESSAGE);
        }
        return trat;
    }
    
}

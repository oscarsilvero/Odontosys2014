/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Diagnostico;
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
public class DiagnosticoControlador {
    
    public static ArrayList<Diagnostico> ConsultarDiagnosticos(int idPaciente) {
        ArrayList<Diagnostico> lista = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM Diagnostico WHERE paciente = "+idPaciente+" ORDER BY fecha ASC";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    Diagnostico nuevo = (Diagnostico) it.next();
                    lista.add(nuevo);
                }while(it.hasNext());      
            }else{
                lista = null;
            }
        } catch (HibernateException ex) {
           JOptionPane.showMessageDialog(null,"No se pudo conectar a la Base de Datos", "Diagnostico Controlador", WIDTH );
       }        
        return lista;
    }
    
    public static Diagnostico BuscarID(int idDiagnostico){
        Session sesion;
        Transaction tr = null;
        Diagnostico d =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Diagnostico WHERE idDiagnostico = "+ idDiagnostico;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             d = (Diagnostico)it.next();
            }else{
               return null;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Diagnostico Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return d;
    }
    
    public static int insertarDiagnostico(Diagnostico nuevo) {
        int i = 0;
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            i = (int)sesion.save(nuevo);
            sesion.getTransaction().commit();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Diagnóstico", WIDTH );
       }        
        return i;
    }
}
